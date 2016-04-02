package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import servicios.AdminUnidadService;
import clasesDelSistema.AdministradorUnidad;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Administrador Unidad 
 */

@SuppressWarnings("serial")
public class AdminUnidadAction extends ActionSupport{
	private String pass, newPass, perfil;
	@SuppressWarnings("unused")
	private AdministradorUnidad user;
	private AdminUnidadService serv = new AdminUnidadService();
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public AdministradorUnidad getUser() {
		return (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
	}

	public void setUser(AdministradorUnidad user) {
		this.user = (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
	}
	
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
		return "success";
	}

	public String cambiarPass(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		//hay que validar q pass y new pass son iguales
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "adminunidad-cambiopass";
	}
	
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getUser());
		return "adminunidad-modificado";
	}
}
