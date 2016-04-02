package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("adminUnidad")
public class AdministradorUnidad extends Usuario {
	
	@ManyToOne(optional = false) @JoinColumn(name = "sedeId")
	private Sede sede;
	
	
	/* Constructor sin argumentos */

	public AdministradorUnidad() {
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
