package clasesDelSistema;

import javax.persistence.Entity;

@Entity
public class Bar extends Elemento {
	
	private String direccion;
	
	
	/* Constructor sin argumentos */	

	public Bar() {
		super();
	}

	/* Metodos Getters y Setters */

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
