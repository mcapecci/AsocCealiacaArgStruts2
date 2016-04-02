package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("opUnidad")
public class OperadorUnidad extends Usuario {
	
	@ManyToOne(optional = false) @JoinColumn(name = "sedeId")
	private Sede sede;
	
	
	/* Constructor sin argumentos */

	public OperadorUnidad() {
		super();
	}
	
	/* Metodos Getters y Setters */

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}	
	
}
