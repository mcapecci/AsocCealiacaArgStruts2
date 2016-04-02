package managedBean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.SocioVirtualService;
import clasesDelSistema.AvisoDePago;
import clasesDelSistema.SocioVirtual;

/** Este bean realiza las funciones específicas de 
 *  un usuario con perfil Socio Virtual 
 */

@ManagedBean(name="socioVirtualBean")
@SessionScoped
public class SocioVirtualBean {
	private String pass, newPass;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	@SuppressWarnings("unused")
	private SocioVirtual user;
	private SocioVirtualService serv = new SocioVirtualService();
	private Date fechaPago, periodo;
	private float importe;
	

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
	public SocioVirtual getUser() {
		return (SocioVirtual)this.getLoginbean().getUser();
	}
	public void setUser(SocioVirtual user) {
		this.user = (SocioVirtual)this.getLoginbean().getUser();
	}
	public SocioVirtualService getServ() {
		return serv;
	}
	public void setServ(SocioVirtualService serv) {
		this.serv = serv;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	
	public String cambiarPass(){
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "socioVirtual-cambiopass";
	}
	
	public String modificar(){
		serv.modificar(this.getUser());
		return "socioVirtual-modificado";
	}
	
	public String registrarAviso(){
		AvisoDePago unAviso = new AvisoDePago();
		Date today = new Date();
		unAviso.setFechaAviso(today);
		unAviso.setFechaPago(this.getFechaPago());
		unAviso.setImporte(this.getImporte());
		unAviso.setPeriodo(this.getPeriodo());
		unAviso.setSocio(this.getUser());
		serv.registrarAviso(unAviso);
		return "aviso-registrado";
	}
}
