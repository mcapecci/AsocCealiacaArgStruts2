package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("opCentral")
public class OperadorCentral extends Usuario {
	
	@ManyToOne(optional = false) @JoinColumn(name = "centralId")
	private Central central;
	
	
	/* Constructor sin argumentos */

	public OperadorCentral() {
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
