package clasesDelSistema;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Elemento {
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String nombre;
	private String descripcion;
	
	
	/* Constructor sin argumentos */	

	public Elemento() {
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
