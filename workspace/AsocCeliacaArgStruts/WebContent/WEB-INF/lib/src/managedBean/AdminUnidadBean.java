package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.AdminUnidadService;
import clasesDelSistema.AdministradorUnidad;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Administrador Unidad 
 */

@ManagedBean(name="adminUnidadBean")
@SessionScoped
public class AdminUnidadBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	@SuppressWarnings("unused")
	private AdministradorUnidad user;
	private AdminUnidadService serv = new AdminUnidadService();
	
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
	
	public AdministradorUnidad getUser() {
		return (AdministradorUnidad) this.getLoginbean().getUser();
	}

	public void setUser(AdministradorUnidad user) {
		this.user = (AdministradorUnidad) this.getLoginbean().getUser();
	}

	public String cambiarPass(){
		//hay que validar q pass y new pass son iguales
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "adminunidad-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "adminunidad-modificado";
	}
}
