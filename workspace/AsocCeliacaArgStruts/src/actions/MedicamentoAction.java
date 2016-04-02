package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.MedicamentoService;
import clasesDelSistema.Medicamento;

/** Este bean realiza las funciones referidas a un Medicamento
 */

@SuppressWarnings("serial")
public class MedicamentoAction extends ActionSupport{
	private String nombre;
	private String descripcion;
	private float precio;
	private List<Medicamento> all;
	private Medicamento selected;
	private long idSelected;
	private MedicamentoService serv= new MedicamentoService();
	private String perfil;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public List<Medicamento> getAll() {
		return serv.getAll();
	}
	public void setAll(List<Medicamento> all) {
		this.all = serv.getAll();
	}
	public Medicamento getSelected() {
		return selected;
	}
	public void setSelected(Medicamento selected) {
		this.selected = selected;
	}
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	public MedicamentoService getServ() {
		return serv;
	}
	public void setServ(MedicamentoService serv) {
		this.serv = serv;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	/* metodos para medicamento */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "success";
	}
	
	public String editar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "medicamento-editar";
	}
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getSelected());
		return "medicamento-modificado";
	}
	
	public String eliminar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.eliminar(this.getIdSelected());
		return "medicamento-eliminado";
	}
	
	public String registrar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.registrar(this.getNombre(), this.getDescripcion(), this.getPrecio());
		this.reset();
		return "medicamento-registrado";
	}
	
	private void reset() {
		this.setDescripcion(null);
		this.setPrecio(0);
		this.setNombre(null);
		
	}
	
}
