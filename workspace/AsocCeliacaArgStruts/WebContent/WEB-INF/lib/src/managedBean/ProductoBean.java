package managedBean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.ProductoService;

import clasesDelSistema.Producto;

/** Este bean realiza las funciones referidas a un Producto
 */

@ManagedBean(name="productoBean")
@SessionScoped
public class ProductoBean {
	
	private String nombre;
	private String descripcion;
	private String rnpa;
	private String empresa;
	private String rne;
	private Date fecha;
	private Date fechaCertLdg;
	private String comentario;
	private List<Producto> all;
	private Producto selected;
	private long idSelected;
	private ProductoService serv= new ProductoService();
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
	public String getRnpa() {
		return rnpa;
	}
	public void setRnpa(String rnpa) {
		this.rnpa = rnpa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRne() {
		return rne;
	}
	public void setRne(String rne) {
		this.rne = rne;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFechaCertLdg() {
		return fechaCertLdg;
	}
	public void setFechaCertLdg(Date fechaCertLdg) {
		this.fechaCertLdg = fechaCertLdg;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public List<Producto> getAll() {
		return serv.getAll();
	}
	public void setAll(List<Producto> all) {
		this.all = serv.getAll();
	}
	public Producto getSelected() {
		return selected;
	}
	public void setSelected(Producto selected) {
		this.selected = selected;
	}
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	public ProductoService getServ() {
		return serv;
	}
	public void setServ(ProductoService serv) {
		this.serv = serv;
	}
	
	/* metodos para un producto*/
	
	public String editar(){
		return "producto-editar";
	}
	
	public String verMas(){
		return "producto-verMas";
	}
	
	public String modificar(){
		serv.modificar(this.getSelected());
		return "producto-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		return "producto-eliminado";
	}
	
	public String registrar(){
		serv.registrar(this.getNombre(), this.getDescripcion(), this.getRnpa(),	this.getEmpresa(),
						this.getRne(), this.getFecha(), this.getFechaCertLdg(), this.getComentario());
		this.reset();
		return "producto-registrado";
	}
	
	private void reset() {
		 this.setNombre(null);
		 this.setDescripcion(null);
		 this.setRnpa(null);
		 this.setEmpresa(null);
		 this.setRne(null);
		 this.setFecha(null);
		 this.setFechaCertLdg(null);
		 this.setComentario(null);
		
	}

}
