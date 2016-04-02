package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("socioNormal")
public class SocioNormal extends Socio {
	
	@ManyToOne(optional = false) @JoinColumn(name="entidadId")
	private Entidad entidad;
	
	
	/* Constructor sin argumentos */

	public SocioNormal() {
		super();
	}
	
	/* Metodos Getters y Setters */
	
	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
}
