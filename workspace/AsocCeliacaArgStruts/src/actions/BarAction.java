package actions;

import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.BarService;

import clasesDelSistema.Bar;

/** Este Action realiza las funciones referidas a un Bar
 */

@SuppressWarnings("serial")
public class BarAction extends ActionSupport{
	private String perfil;
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
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	/* metodos para el bar */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "success";
	}
	
	public String editar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "bar-editar";
	}
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.modificar(this.getSelected());
		return "bar-modificado";
	}
	
	public String eliminar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.eliminar(this.getIdSelected());
		return "bar-eliminado";
	}
	
	public String registrar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
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
