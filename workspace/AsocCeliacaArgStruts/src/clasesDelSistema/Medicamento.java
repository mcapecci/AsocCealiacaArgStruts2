package clasesDelSistema;

import javax.persistence.*;

@Entity
public class Medicamento extends Elemento {
	
	private float precio;

	/* Constructor sin argumentos */	

	public Medicamento() {
		super();
	}

	/* Metodos Getters y Setters */
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
