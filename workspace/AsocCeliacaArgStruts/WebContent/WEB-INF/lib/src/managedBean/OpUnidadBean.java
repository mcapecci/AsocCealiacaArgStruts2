package managedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.OpUnidadService;

import clasesDelSistema.OperadorUnidad;

/** Este bean realiza las funciones específicas de
 *  un usuario con perfil Operador de Unidad 
 */

@ManagedBean(name="opUnidadBean")
@SessionScoped
public class OpUnidadBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	@SuppressWarnings("unused")
	private OperadorUnidad user;
	private OpUnidadService serv = new OpUnidadService();
	
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
	
	
	public OperadorUnidad getUser() {
		return (OperadorUnidad) this.getLoginbean().getUser();
	}

	public void setUser(OperadorUnidad user) {
		this.user = (OperadorUnidad) this.getLoginbean().getUser();
	}

	public String cambiarPass(){
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "opunidad-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "opunidad-modificado";
	}


}
