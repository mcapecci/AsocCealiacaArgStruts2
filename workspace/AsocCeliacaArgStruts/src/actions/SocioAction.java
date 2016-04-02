package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.SocioService;
import clasesDelSistema.SocioNormal;

/** Este bean realiza las funciones especÃ­ficas de
 *  un usuario con perfil Socio Normal 
 */

@SuppressWarnings("serial")
public class SocioAction extends ActionSupport{
	private String pass, newPass, perfil;
	@SuppressWarnings("unused")
	private SocioNormal user;
	private SocioService serv = new SocioService();

	

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
	public SocioNormal getUser() {
		return (SocioNormal)ActionContext.getContext().getSession().get("user");
	}
	public void setUser(SocioNormal user) {
		this.user = (SocioNormal)ActionContext.getContext().getSession().get("user");
	}
	public SocioService getServ() {
		return serv;
	}
	public void setServ(SocioService serv) {
		this.serv = serv;
	}
	
	/* métodos Socio Normal */
	public String execute(){
		this.setPerfil((String)ActionContext.getContext().getSession().get("perfil"));
		this.user = (SocioNormal)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String cambiarPass(){
		this.setPerfil((String)ActionContext.getContext().getSession().get("perfil"));
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "socio-cambiopass";
	}
	
	public String modificar(){
		this.setPerfil((String)ActionContext.getContext().getSession().get("perfil"));
		serv.modificar(this.getUser());
		return "socio-modificado";
	}	
	
}
