package actions;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.ProductoService;

import clasesDelSistema.Producto;

/** Este action realiza las funciones referidas a un Producto
 */


@SuppressWarnings("serial")
public class ProductoAction extends ActionSupport{
	
	private String perfil;
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
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
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
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "success";
	}
	
	public String editar(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "producto-editar";
	}
	
	public String verMas(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "producto-verMas";
	}
	
	public String modificar(){
		System.out.print(selected);
		serv.modificar(this.getSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "producto-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "producto-eliminado";
	}
	
	public String registrar(){
		serv.registrar(this.getNombre(), this.getDescripcion(), this.getRnpa(),	this.getEmpresa(),
						this.getRne(), this.getFecha(), this.getFechaCertLdg(), this.getComentario());
		this.reset();
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
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
