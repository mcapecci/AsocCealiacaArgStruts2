package managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.BarService;

import clasesDelSistema.Bar;

/** Este bean realiza las funciones referidas a un Bar
 */

@ManagedBean(name="barBean")
@SessionScoped
public class BarBean {
	private String nombre;
	private String descripcion;
	private String direccion;
	private List<Bar> all;
	private Bar selected;
	private long idSelected;
	private BarService serv= new BarService();
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Bar> getAll() {
		return serv.getAll();
	}
	public void setAll(List<Bar> all) {
		this.all = serv.getAll();
	}
	public Bar getSelected() {
		return selected;
	}
	public void setSelected(Bar selected) {
		this.selected = selected;
	}
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	public BarService getServ() {
		return serv;
	}
	public void setServ(BarService serv) {
		this.serv = serv;
	}	
	
	
	/* metodos para el bar */
	
	public String editar(){
		return "bar-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		return "bar-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		return "bar-eliminado";
	}
	
	public String registrar(){
		serv.registrar(this.getNombre(), this.getDescripcion(), this.getDireccion());
		this.reset();
		return "bar-registrado";
	}
	
	private void reset() {
		this.setDescripcion(null);
		this.setDireccion(null);
		this.setNombre(null);
		
	}
	
	
}
