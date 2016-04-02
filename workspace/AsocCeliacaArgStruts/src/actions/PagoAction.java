package actions;

import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.PagoService;

import clasesDelSistema.Pago;
import clasesDelSistema.Usuario;

@SuppressWarnings("serial")
public class PagoAction extends ActionSupport{
	private Long idSelected;
	private float importe;
	private Date fechaPago;
	private Date periodo;
	private Pago selected;
	@SuppressWarnings("unused")
	private List<Pago> all;
	private PagoService serv = new PagoService();
	private Usuario userLogin;

	public Long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(Long idSelected) {
		this.idSelected = idSelected;
	}
	
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public Pago getSelected() {
		return selected;
	}
	public void setSelected(Pago selected) {
		this.selected = selected;
	}
	public PagoService getServ() {
		return serv;
	}
	public void setServ(PagoService serv) {
		this.serv = serv;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	public Usuario getUserLogin() {
		this.userLogin = (Usuario)ActionContext.getContext().getSession().get("user");
		return userLogin;
	}
	public void setUserLogin(Usuario user) {
		this.userLogin = (Usuario)ActionContext.getContext().getSession().get("user");
	}
	
	

}
