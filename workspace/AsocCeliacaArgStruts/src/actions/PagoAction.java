package actions;

import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.PagoService;
import servicios.SocioService;
import clasesDelSistema.Pago;
import clasesDelSistema.Socio;

@SuppressWarnings("serial")
public class PagoAction extends ActionSupport{
	private Long idSelected;
	private float importe;
	private Date fechaPago;
	private Date periodo;
	private Pago selected;
	private List<Pago> all;
	private PagoService serv = new PagoService();
	/* Socio seleccionado */
	/*
	private Socio socio;
	private SocioService servSocio = new SocioService();
	*/
	/* Perfil usuario logueado */
	/*
	private String perfil;
	*/

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
		return all;
	}
	public void setAll(List<Pago> all) {
		this.all = all;
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
	/*
	public Socio getSocio() {
		return servSocio.buscar(idSelected);
	}
	public void setSocio(Socio socio) {
		this.socio = servSocio.buscar(idSelected);
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}	
	*/
	/* metodos pago */
	/*
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "success";
	}
	*/

}
