package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import clasesDelSistema.AdministradorCentral;
import servicios.AdminCentralService;

/** Este Action realiza las funciones específicas de un
 *  usuario con perfil Administrador Central 
 */

@SuppressWarnings("serial")
public class AdminCentralAction extends ActionSupport{
	private String pass, newPass, perfil;
	@SuppressWarnings("unused")
	private AdministradorCentral user;
	private AdminCentralService serv = new AdminCentralService();
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	public AdministradorCentral getUser() {
		return (AdministradorCentral)ActionContext.getContext().getSession().get("user");
	}

	public void setUser(AdministradorCentral user) {
		this.user = (AdministradorCentral)ActionContext.getContext().getSession().get("user");
	}

	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (AdministradorCentral)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String cambiarPass(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "admincentral-cambiopass";
	}
	
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getUser());
		return "admincentral-modificado";
	}
	


}
