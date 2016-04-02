package managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import servicios.OpC_SocioUService;

import clasesDelSistema.Entidad;
import clasesDelSistema.OperadorCentral;
import clasesDelSistema.SocioNormal;

/** Este bean realiza las funciones referidas a un Socio Normal
 *  (ese socio perteneciente a una unidad)
 *  desde un usuario con perfil Operador Central
 */
@ManagedBean(name="opC_SocioUBean")
@SessionScoped
public class OpC_SocioUBean {
	
	@SuppressWarnings("unused")
	private List<SocioNormal> all;
	@SuppressWarnings("unused")
	private Entidad entidad;
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginbean;
	
	private OpC_SocioUService serv = new OpC_SocioUService();
	
	/* getters y setters */	
	public LoginBean getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}
	public Entidad getEntidad() {
		return ((OperadorCentral)this.getLoginbean().getUser()).getCentral();
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = ((OperadorCentral)this.getLoginbean().getUser()).getCentral();
	}	
	public List<SocioNormal> getAll() {
		return serv.getAllUnidades(this.getEntidad().getId());
		
	}
	public void setAll(List<SocioNormal> all) {
		all = serv.getAllUnidades(this.getEntidad().getId());
	}
	
	
	

}
