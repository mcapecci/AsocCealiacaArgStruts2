package actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.OpCentralService;

import clasesDelSistema.OperadorCentral;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Operador Central 
 */

@ManagedBean(name="opCentralBean")
@SessionScoped
public class OpCentralBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginAction loginbean;
	@SuppressWarnings("unused")
	private OperadorCentral user;
	private OpCentralService serv = new OpCentralService();
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LoginAction getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginAction loginbean) {
		this.loginbean = loginbean;
	}	
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	
	public OperadorCentral getUser() {
		return (OperadorCentral) this.getLoginbean().getUser();
	}

	public void setUser(OperadorCentral user) {
		this.user = (OperadorCentral) this.getLoginbean().getUser();
	}

	public String cambiarPass(){
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "opcentral-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "opcentral-modificado";
	}
	

}
