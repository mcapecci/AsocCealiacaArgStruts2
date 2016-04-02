package clasesDelSistema;

import javax.persistence.*;

@Entity @DiscriminatorValue("socioVirtual")
public class SocioVirtual extends Socio {
	 
	@ManyToOne(optional = false) @JoinColumn(name = "CentralId")
	private Central central;
	
	
	/* Constructor sin argumentos */

	public SocioVirtual() {
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
