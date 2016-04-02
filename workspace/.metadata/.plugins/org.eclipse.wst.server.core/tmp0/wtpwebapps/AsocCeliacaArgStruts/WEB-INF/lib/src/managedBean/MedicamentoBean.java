package managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.MedicamentoService;
import clasesDelSistema.Medicamento;

/** Este bean realiza las funciones referidas a un Medicamento
 */

@ManagedBean(name="medicamentoBean")
@SessionScoped
public class MedicamentoBean {
	private String nombre;
	private String descripcion;
	private float precio;
	private List<Medicamento> all;
	private Medicamento selected;
	private long idSelected;
	private MedicamentoService serv= new MedicamentoService();
	
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
	
	
	public String editar(){
		return "medicamento-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		return "medicamento-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		return "medicamento-eliminado";
	}
	
	public String registrar(){
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
