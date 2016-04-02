package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.AdminOpUnidadService;
import clasesDelSistema.AdministradorUnidad;
import clasesDelSistema.Entidad;
import clasesDelSistema.OperadorUnidad;
import clasesDelSistema.Sede;

/** Este bean realiza las funciones referidas a un Operador de Unidad
 *  desde un usuario con perfil Administrador Unidad 
 */

@SuppressWarnings("serial")
public class AdminOpUnidadAction extends ActionSupport{
	private long id;
	private String perfil;
	@SuppressWarnings("unused")
	private Entidad entidad;
	private String nomyap;
	private String email;
	private String telefono;
	private String direccion;
	private String username;
	private String password;
	
	private AdministradorUnidad user;
	@SuppressWarnings("unused")
	private List<OperadorUnidad> all;
	private OperadorUnidad selected;
	private long idSelected;
	private AdminOpUnidadService serv = new AdminOpUnidadService();
	
	/* getters y setters */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getNomyap() {
		return nomyap;
	}
	public void setNomyap(String nomyap) {
		this.nomyap = nomyap;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Entidad getEntidad() {
		return (Entidad)this.getUsuario().getSede();
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = this.getUsuario().getSede();
	}	
	public AdministradorUnidad getUsuario() {
		return (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
	}
	public void setUsuario(AdministradorUnidad user) {
		this.user = (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
	}
		
	public List<OperadorUnidad> getAll() {
		return serv.getAll(this.getEntidad().getId());
	}
	public void setAll(List<OperadorUnidad> all) {
		this.all = serv.getAll(this.getEntidad().getId());
	}
	public OperadorUnidad getSelected() {
		return selected;
	}
	public void setSelected(OperadorUnidad selected) {
		this.selected = selected;
	}
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	
	
	/* metodos opUnidad */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (AdministradorUnidad)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String editar(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opunidad-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opunidad-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opunidad-eliminado";
	}
	
	public String registrar(){
		serv.registrar("opUnidad", (Sede) this.getEntidad(), this.getNomyap(), this.getTelefono(), this.getDireccion(), this.getEmail(), this.getUsername(), this.getPassword());
		// todos los valores en null para el proximo operador!!!!!!!!
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opunidad-registrado";
	}
}
