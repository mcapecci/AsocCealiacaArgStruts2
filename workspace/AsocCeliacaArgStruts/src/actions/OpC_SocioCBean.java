package actions;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import servicios.OpC_SocioCService;

import clasesDelSistema.Central;
import clasesDelSistema.Entidad;
import clasesDelSistema.OperadorCentral;
import clasesDelSistema.Pago;
import clasesDelSistema.SocioNormal;

/** Este bean realiza las funciones referidas a un Socio Normal
 *  (ese socio perteneciente a la central)
 *  desde un usuario con perfil Operador Central
 */

@ManagedBean(name="opC_SocioCBean")
@SessionScoped
public class OpC_SocioCBean {
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
	private Date fechaPago;
	private float importe;
	private Date periodo;
	@ManagedProperty(value="#{loginBean}")
	private LoginAction loginbean;
	@SuppressWarnings("unused")
	private List<SocioNormal> all;
	private SocioNormal selected;
	private long idSelectedUser;
	private OpC_SocioCService serv = new OpC_SocioCService();
	
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
	public LoginAction getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginAction loginbean) {
		this.loginbean = loginbean;
	}
	public List<SocioNormal> getAll() {
		return serv.getAll(this.getEntidad().getId());
	}

	public void setAll(List<SocioNormal> all) {
		all = serv.getAll(this.getEntidad().getId());
	}
	
	public SocioNormal getSelected() {
		return selected;
	}
	public void setSelected(SocioNormal selected) {
		this.selected = selected;
	}
	
	public long getIdSelectedUser() {
		return idSelectedUser;
	}
	public void setIdSelectedUser(long idSelectedUser) {
		this.idSelectedUser = idSelectedUser;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	
	/* metodos opCentral */
	public String editar(){
		return "socioNormal-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		return "socioNormal-modificado";
	}
	
	public String eliminar(){
		serv.eliminar(this.getIdSelectedUser());
		return "socioNormal-eliminado";
	}
	
	public String registrar(){
		serv.registrar("socioNormal", (Central) this.getEntidad(), this.getNomyap(), this.getDni(), this.getOcupacion(), this.getDireccion(), this.getTelefono(), 
				this.getFechaNacimiento(), this.getFechaIngreso(), this.getFechaDiagnostico(),this.getEmail(), this.getPresentadoPor(), this.getUsername(), this.getPassword());
		this.resetUser();
		return "socioNormal-registrado";
	}
	
	public String verPagos(){
		return "socioNormal-verPagos";
	}
	
	public List<Pago> getPagos() {
		return serv.getPagos(this.getSelected().getId());
	}
	
	public String registrar_pago(){
		serv.registrar_pago(this.getFechaPago(), this.getImporte(), this.getPeriodo(), this.getSelected());
		this.resetPago();
		return "socioNormal-pago_registrado";
	}
	
	private void resetPago() {
		this.setFechaPago(null);
		this.setImporte(0);
		this.setPeriodo(null);		
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
