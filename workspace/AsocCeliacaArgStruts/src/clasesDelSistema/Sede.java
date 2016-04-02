package clasesDelSistema;

import java.util.List;
import javax.persistence.*;

@Entity
public class Sede extends Entidad{
	
	@ManyToOne(optional=false) @JoinColumn(name="tiposede_id")
	private TipoSede tipoSede;
	@OneToMany(mappedBy="sede", cascade = CascadeType.ALL)
	private List<AdministradorUnidad> administradores;
	@OneToMany(mappedBy="sede", cascade = CascadeType.ALL)
	private List<OperadorUnidad> operadores;
		
	
	/* Constructor sin argumentos */	

	public Sede() {
		super();
	}

	/* Metodos Getters y Setters */
	
	public TipoSede getTipoSede() {
		return tipoSede;
	}
	
	public void setTipoSede(TipoSede tipoSede) {
		this.tipoSede = tipoSede;
	}	
	
	public List<AdministradorUnidad> getAdministradores() {
		return administradores;
	}
	
	public void setAdministradores(List<AdministradorUnidad> administradores) {
		this.administradores = administradores;
	}
	
	public List<OperadorUnidad> getOperadores() {
		return operadores;
	}
	
	public void setOperadores(List<OperadorUnidad> operadores) {
		this.operadores = operadores;
	}
	
}