package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import clasesDelSistema.AdministradorCentral;
import clasesDelSistema.Central;
import clasesDelSistema.Entidad;
import clasesDelSistema.OperadorCentral;
import servicios.AdminOpCentralService;

/** Este action realiza las funciones referidas a un Operador Central
 *  desde un usuario con perfil Administrador Central 
 */

@SuppressWarnings("serial")
public class AdminOpCentralAction extends ActionSupport{
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
	
	private AdministradorCentral user;
	@SuppressWarnings("unused")
	private List<OperadorCentral> all;
	private OperadorCentral selected;
	private long idSelected;
	private AdminOpCentralService serv = new AdminOpCentralService();
	
	
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
		return (Entidad)this.getUsuario().getCentral();
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = this.getUsuario().getCentral();
	}	
	public AdministradorCentral getUsuario() {
		return (AdministradorCentral)ActionContext.getContext().getSession().get("user");
	}
	public void setUsuario(AdministradorCentral user) {
		this.user = (AdministradorCentral)ActionContext.getContext().getSession().get("user");
	}
	public List<OperadorCentral> getAll() {
		return serv.getAll(this.getEntidad().getId());
	}

	public void setAll(List<OperadorCentral> all) {
		all = serv.getAll(this.getEntidad().getId());
	}
	
	public OperadorCentral getSelected() {
		return selected;
	}
	public void setSelected(OperadorCentral selected) {
		this.selected = selected;
	}
	
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	
	
	/* metodos opCentral */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.user = (AdministradorCentral)ActionContext.getContext().getSession().get("user");
		return "success";
	}
	
	public String editar(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opcentral-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opcentral-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opcentral-eliminado";
	}
	
	public String registrar(){
		serv.registrar("OpCentral", (Central) this.getEntidad(), this.getNomyap(), this.getTelefono(), this.getDireccion(), this.getEmail(), this.getUsername(), this.getPassword());
		this.resetUser();
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "opcentral-registrado";
	}
	private void resetUser() {
		this.setNomyap(null);
		this.setEmail(null);
		this.setTelefono(null);
		this.setDireccion(null);
		this.setUsername(null);
		this.setPassword(null);		
	}
	
	
	

}
