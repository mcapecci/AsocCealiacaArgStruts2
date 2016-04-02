package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("adminCentral")
public class AdministradorCentral extends Usuario {
	
	@ManyToOne(optional = false) @JoinColumn(name = "centralId")
	private Central central;
	
	
	/* Constructor sin argumentos */

	public AdministradorCentral() {
		super();
	}
	
	/* Metodos Getters y Setters */

	public Central getCentral() {
		return central;
	}

	public void setCentral(Central central) {
		this.central = central;
	}	
	
}
