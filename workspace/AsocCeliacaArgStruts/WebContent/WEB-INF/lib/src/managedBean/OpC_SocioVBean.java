package managedBean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import servicios.OpC_SocioVService;

import clasesDelSistema.AvisoDePago;
import clasesDelSistema.Central;
import clasesDelSistema.Entidad;
import clasesDelSistema.OperadorCentral;
import clasesDelSistema.Pago;
import clasesDelSistema.SocioVirtual;

/** Este bean realiza las funciones referidas a un Socio Virtual
 *  desde un usuario con perfil Operador Central
 */

@ManagedBean(name="opC_SocioVBean")
@SessionScoped
public class OpC_SocioVBean {
	private long id;
	private String perfil;
	@SuppressWarnings("unused")
	private Entidad entidad;
	private String nomyap;
	private String dni;
	private String email;
	private String telefono;
	private String direccion;
	private String username;
	private String password;
	private String ocupacion;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaDiagnostico;
	private String presentadoPor;
	private List<AvisoDePago> avisos;
	private AvisoDePago avisoSelected;
	
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	@SuppressWarnings("unused")
	private List<SocioVirtual> all;
	private SocioVirtual selected;
	private long idSelectedUser;
	private OpC_SocioVService serv = new OpC_SocioVService();
	
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}
	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}
	public String getPresentadoPor() {
		return presentadoPor;
	}
	public void setPresentadoPor(String presentadoPor) {
		this.presentadoPor = presentadoPor;
	}
	public Entidad getEntidad() {
		return ((OperadorCentral)this.getLoginbean().getUser()).getCentral();
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = ((OperadorCentral)this.getLoginbean().getUser()).getCentral();
	}	
	public LoginBean getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}
	public List<SocioVirtual> getAll() {
		return serv.getAll(this.getEntidad().getId());
	}

	public void setAll(List<SocioVirtual> all) {
		all = serv.getAll(this.getEntidad().getId());
	}
	
	public SocioVirtual getSelected() {
		return selected;
	}
	public void setSelected(SocioVirtual selected) {
		this.selected = selected;
	}
	
	public long getIdSelectedUser() {
		return idSelectedUser;
	}
	public void setIdSelectedUser(long idSelectedUser) {
		this.idSelectedUser = idSelectedUser;
	}
	
	public List<AvisoDePago> getAvisos() {
		return serv.getAvisos();
	}
	public void setAvisos(List<AvisoDePago> all) {
		all = serv.getAvisos();
	}
	
	
	public AvisoDePago getAvisoSelected() {
		return avisoSelected;
	}
	public void setAvisoSelected(AvisoDePago avisoSelected) {
		this.avisoSelected = avisoSelected;
	}
	
	
	/* metodos opCentral */
	public String editar(){
		return "socioVirtual-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		return "socioVirtual-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelectedUser());
		return "socioVirtual-eliminado";
	}
	
	public String registrar(){
		serv.registrar("socioVirtual", (Central) this.getEntidad(), this.getNomyap(), this.getDni(), this.getOcupacion(), this.getDireccion(), this.getTelefono(), 
				this.getFechaNacimiento(), this.getFechaIngreso(), this.getFechaDiagnostico(),this.getEmail(), this.getPresentadoPor(), this.getUsername(), this.getPassword());
		this.resetUser();
		return "socioVirtual-registrado";
	}
	
	public String verPagos(){
		return "socioVirtual-verPagos";
	}
	
	public List<Pago> getPagos() {
		return serv.getPagos(this.getSelected().getId());
	}
	
	public void cargarPago(){
		Pago pago = new Pago();
		pago.setFechaPago(this.getAvisoSelected().getFechaPago());
		pago.setImporte(this.getAvisoSelected().getImporte());
		pago.setPeriodo(this.getAvisoSelected().getPeriodo());
		pago.setSocio(this.getAvisoSelected().getSocio());
		serv.cargarPagoYEliminarAviso(pago, this.getAvisoSelected());				
	}
	
	public String editarAviso(){
		return "socioVirtual-editarAviso";
	}
	public String modificarAviso(){
		serv.modificarAviso(this.getAvisoSelected());
		return "socioVirtual-avisoModificado";
	}
	public void eliminarAviso(){
		serv.eliminarAviso(this.getAvisoSelected());				
	}
	private void resetUser() {
		this.setNomyap(null);
		this.setDni(null);
		this.setOcupacion(null);
		this.setDireccion(null);
		this.setTelefono(null); 
		this.setFechaNacimiento(null);
		this.setFechaIngreso(null); 
		this.setFechaDiagnostico(null);
		this.setPresentadoPor(null);
		this.setEmail(null);
		this.setTelefono(null);
		this.setDireccion(null);
		this.setUsername(null);
		this.setPassword(null);		
	}
}
