package managedBean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.PagoService;

import clasesDelSistema.Pago;

@ManagedBean(name="pagoBean")
@SessionScoped
public class PagoBean {
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	private Long idSelected;
	private float importe;
	private Date fechaPago;
	private Date periodo;
	private Pago selected;
	@SuppressWarnings("unused")
	private List<Pago> all;
	private PagoService serv = new PagoService();

	
	public LoginBean getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}
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
	public List<Pago> getAll() {
		return serv.getAll(this.getLoginbean().getId());
	}
	public void setAll(List<Pago> all) {
		this.all = serv.getAll(this.getLoginbean().getId());
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
	
	

}
