package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.SocioService;
import clasesDelSistema.SocioNormal;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Socio Normal 
 */

@ManagedBean(name="socioBean")
@SessionScoped
public class SocioBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
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
	public LoginBean getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}
	public SocioNormal getUser() {
		return (SocioNormal)this.getLoginbean().getUser();
	}
	public void setUser(SocioNormal user) {
		this.user = (SocioNormal)this.getLoginbean().getUser();
	}
	public SocioService getServ() {
		return serv;
	}
	public void setServ(SocioService serv) {
		this.serv = serv;
	}
	
	
	
	public String cambiarPass(){
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "socio-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "socio-modificado";
	}
	
	
}
