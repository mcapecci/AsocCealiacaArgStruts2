package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.OpUnidadService;
import clasesDelSistema.OperadorUnidad;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Operador de Unidad 
 */

@SuppressWarnings("serial")
public class OpUnidadAction extends ActionSupport{
	private String pass, newPass, perfil;
	@SuppressWarnings("unused")
	private OperadorUnidad user;
	private OpUnidadService serv = new OpUnidadService();
	
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
	
	public OperadorUnidad getUser() {
		return (OperadorUnidad)ActionContext.getContext().getSession().get("user");
	}

	public void setUser(OperadorUnidad user) {
		this.user = (OperadorUnidad)ActionContext.getContext().getSession().get("user");
	}

	/* métodos op unidad*/
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (OperadorUnidad)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String cambiarPass(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "opunidad-cambiopass";
	}
	
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getUser());
		return "opunidad-modificado";
	}


}
