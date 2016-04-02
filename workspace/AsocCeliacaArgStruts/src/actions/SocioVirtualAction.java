package actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.SocioVirtualService;
import clasesDelSistema.AvisoDePago;
import clasesDelSistema.SocioVirtual;

/** Este bean realiza las funciones específicas de 
 *  un usuario con perfil Socio Virtual 
 */

@SuppressWarnings("serial")
public class SocioVirtualAction extends ActionSupport{
	private String pass, newPass, perfil;
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
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public SocioVirtual getUser() {
		return (SocioVirtual)ActionContext.getContext().getSession().get("user");
	}
	public void setUser(SocioVirtual user) {
		this.user = (SocioVirtual)ActionContext.getContext().getSession().get("user");
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
	
	/* métodos Socio Virtual */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (SocioVirtual)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String cambiarPass(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.getUser().setPassword(this.getPass());
		serv.cambiarPass(getUser());
		return "socioVirtual-cambiopass";
	}
	
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getUser());
		return "socioVirtual-modificado";
	}
	
	public String registrarAviso(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
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
