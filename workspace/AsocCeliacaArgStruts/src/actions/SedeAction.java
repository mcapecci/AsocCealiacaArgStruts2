package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import servicios.SedeService;

import clasesDelSistema.TipoSede;
import clasesDelSistema.Sede;

/** Este Action realiza las funciones referidas a una Sede,
 *  independientemente del tipo de sede (filial, delegacion, grupo referencia, i. beneficiaria).
 */

@SuppressWarnings("serial")
public class SedeAction extends ActionSupport{
	private String perfil;
	private String nombre;
	private String telefono;
	private float valorCuota;
	private String direccion;
	private String localidad;	
	private String provincia;
	private long idTipo;
	private TipoSede tipoSede;
	private List<Sede> allFiliales;
	private List<Sede> allDelegaciones;
	private List<Sede> allGrupoRef;
	private List<Sede> allIBeneficiarias;
	private List<TipoSede> allTypes;
	private Sede selected;
	private long idSelected;
	private SedeService serv = new SedeService();
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public float getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(float valorCuota) {
		this.valorCuota = valorCuota;
	}
	public long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}
	public TipoSede getTipoSede() {
		return tipoSede;
	}
	public void setTipoSede(TipoSede tipoSede) {
		this.tipoSede = tipoSede;
	}
	
	public List<Sede> getAllDelegaciones() {
		return serv.getAll("Delegacion");
	}
	public void setAllDelegaciones(List<Sede> allDelegaciones) {
		this.allFiliales = serv.getAll("Delegacion");
	}
	public List<Sede> getAllGrupoRef() {
		return serv.getAll("Grupo de Referencia");
	}
	public void setAllGrupoRef(List<Sede> allGrupoRef) {
		this.allFiliales = serv.getAll("Grupo de Referencia");
	}
	public List<Sede> getAllIBeneficiarias() {
		return serv.getAll("Institucion Beneficiaria");
	}
	public void setAllIBeneficiarias(List<Sede> allIBeneficiarias) {
		this.allFiliales = serv.getAll("Institucion Beneficiaria");
	}	
	public List<Sede> getAllFiliales() {
		return serv.getAll("Filial");
	}
	public void setAllFiliales(List<Sede> allFiliales) {
		this.allFiliales = serv.getAll("Filial");
	}
	public List<TipoSede> getAllTypes() {
		return serv.getAllTypes();
	}
	public void setAllTypes(List<TipoSede> allFiliales) {
		this.allTypes = serv.getAllTypes();
	}
	
	public Sede getSelected(){
		return selected;
	}
	public void setSelected(Sede selected){
		this.selected = selected;
	}
	public long getIdSelected() {
		return idSelected;
	}
	public void setIdSelected(long idSelected) {
		this.idSelected = idSelected;
	}
	public SedeService getServ() {
		return serv;
	}
	public void setServ(SedeService serv) {
		this.serv = serv;
	}
	
	
	/* metodos para la sede */
	public String execute(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "success";
	}
	
	public String editar(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return "sede-editar";
	}
	
	public String cancelarEdicion(){
		this.selected = serv.buscar(this.getIdSelected());
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		return this.getSelected().getTipoSede().getNombre();
	}
	
	public String modificar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		String sede = this.getSelected().getTipoSede().getNombre();
		serv.modificar(this.getSelected());
		this.resetSelected();
		return sede;
	}
	
	
	public String eliminar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		serv.eliminar(this.getIdSelected());
		return "sede-eliminado";
	}
	
	public String registrar(){
		this.perfil = (String)ActionContext.getContext().getSession().get("perfil");
		this.setTipoSede(serv.getTipoSedebyID(this.getIdTipo()));
		String sede = this.getTipoSede().getNombre();
		serv.registrar(this.getDireccion(), this.getLocalidad(), this.getNombre(), this.getProvincia(), this.getTelefono(), this.getTipoSede(), this.getValorCuota());
		this.reset();
		return sede;
	}
	
	private void reset() {
		this.setDireccion(null);
		this.setLocalidad(null);
		this.setNombre(null);
		this.setProvincia(null);
		this.setTelefono(null);
		this.setValorCuota(0);
		this.setTipoSede(null);
	}
	
	private void resetSelected() {
		this.getSelected().setDireccion(null);
		this.getSelected().setLocalidad(null);
		this.getSelected().setNombre(null);
		this.getSelected().setProvincia(null);
		this.getSelected().setTelefono(null);
		this.getSelected().setValorCuota((float) 0);
		this.getSelected().setTipoSede(null);
	}
}
