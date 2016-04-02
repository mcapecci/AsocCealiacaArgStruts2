package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import clasesDelSistema.AdministradorCentral;
import servicios.AdminCentralService;

/** Este bean realiza las funciones específicas de un
 *  usuario con perfil Administrador Central 
 */

@ManagedBean(name="adminCentralBean")
@SessionScoped
public class AdminCentralBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	@SuppressWarnings("unused")
	private AdministradorCentral user;
	private AdminCentralService serv = new AdminCentralService();
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LoginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}	
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	
	public AdministradorCentral getUser() {
		return (AdministradorCentral) this.getLoginbean().getUser();
	}

	public void setUser(AdministradorCentral user) {
		this.user = (AdministradorCentral) this.getLoginbean().getUser();
	}

	public String cambiarPass(){
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "admincentral-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "admincentral-modificado";
	}
	


}
