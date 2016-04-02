package managedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.SedeService;

import clasesDelSistema.Bar;
import clasesDelSistema.TipoSede;
import clasesDelSistema.Sede;

/** Este bean realiza las funciones referidas a una Sede,
 *  independientemente del tipo de sede que sea.
 */

@ManagedBean(name="sedeBean")
@SessionScoped
public class SedeBean {
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
	
	public String editar(){
		return "sede-editar";
	}
	public String modificar(){
		serv.modificar(this.getSelected());
		String resultado = "modificado";
		if (this.getSelected().getTipoSede().getNombre().equals("Filial")){
			resultado = "filial-modificado";
		}else{
			if(this.getSelected().getTipoSede().getNombre().equals("Delegacion")){
				resultado = "delegacion-modificado";
			}else{
				if(this.getSelected().getTipoSede().getNombre().equals("Grupo de Referencia")){
					resultado = "gruporef-modificado";
				}else{
					if(this.getSelected().getTipoSede().getNombre().equals("Institucion Beneficiaria")){
						resultado = "ibeneficiaria-modificado";
					}
				}
			}
		}
		this.resetSelected();
		return resultado;
	}
	
	
	public String eliminar(){
		serv.eliminar(this.getIdSelected());
		return "sede-eliminado";
	}
	
	public String registrar(){
		this.setTipoSede(serv.getTipoSedebyID(this.getIdTipo()));
		serv.registrar(this.getDireccion(), this.getLocalidad(), this.getNombre(), this.getProvincia(), this.getTelefono(), this.getTipoSede(), this.getValorCuota());
		String resultado = "registrado";
		if (this.getTipoSede().getNombre().equals("Filial")){
			resultado = "filial-registrado";
		}else{
			if(this.getTipoSede().getNombre().equals("Delegacion")){
				resultado = "delegacion-registrado";
			}else{
				if(this.getTipoSede().getNombre().equals("Grupo de Referencia")){
					resultado = "gruporef-registrado";
				}else{
					if(this.getTipoSede().getNombre().equals("Institucion Beneficiaria")){
						resultado = "ibeneficiaria-registrado";
					}
				}
			}
		}
		this.reset();
		return resultado;
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
