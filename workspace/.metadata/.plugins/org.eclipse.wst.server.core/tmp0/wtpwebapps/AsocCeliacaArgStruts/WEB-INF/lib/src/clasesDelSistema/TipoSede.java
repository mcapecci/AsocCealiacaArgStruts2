package clasesDelSistema;

import javax.persistence.*;

@Entity
public class TipoSede {
	
	@Id @GeneratedValue
	private Long id;
	private String nombre;
	
	
	/* Constructor sin argumentos */	

	public TipoSede() {
		super();
	}

	/* Metodos Getters y Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
