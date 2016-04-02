package clasesDelSistema;

import java.util.List;
import javax.persistence.*;

@Entity
public class Central extends Entidad{
	
	@OneToMany(mappedBy="central", cascade = CascadeType.ALL)
	private List<SocioVirtual> sociosVirtuales;
	@OneToMany(mappedBy="central", cascade = CascadeType.ALL)
	private List<AdministradorCentral> administradores;
	@OneToMany(mappedBy="central", cascade = CascadeType.ALL)
	private List<OperadorCentral> operadores;
	
	
	/* Constructor sin argumentos */	

	public Central() {
		super();
	}

	/* Metodos Getters y Setters */
	
	public List<SocioVirtual> getSociosVirtuales() {
		return sociosVirtuales;
	}
	
	public void setSociosVirtuales(List<SocioVirtual> sociosVirtuales) {
		this.sociosVirtuales = sociosVirtuales;
	}
	
	public List<AdministradorCentral> getAdministradores() {
		return administradores;
	}
	
	public void setAdministradores(List<AdministradorCentral> administradores) {
		this.administradores = administradores;
	}
	
	public List<OperadorCentral> getOperadores() {
		return operadores;
	}
	
	public void setOperadores(List<OperadorCentral> operadores) {
		this.operadores = operadores;
	}	
	
	
}
