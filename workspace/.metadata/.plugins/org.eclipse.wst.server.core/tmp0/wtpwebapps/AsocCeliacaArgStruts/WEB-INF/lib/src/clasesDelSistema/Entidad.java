package clasesDelSistema;

import java.util.List;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidad {
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String localidad;
	private String provincia;
	private Float valorCuota;
	@OneToMany(mappedBy="entidad", cascade = CascadeType.ALL)
	private List<SocioNormal> socios;
	
	
	/* Constructor sin argumentos */	

	public Entidad() {
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public Float getValorCuota() {
		return valorCuota;
	}


	public void setValorCuota(Float valorCuota) {
		this.valorCuota = valorCuota;
	}

	public List<SocioNormal> getSocios() {
		return socios;
	}

	public void setSocios(List<SocioNormal> socios) {
		this.socios = socios;
	}
	
	public void eliminarSocio(SocioNormal socio) {
		if(this.getSocios().contains(socio)){
			this.getSocios().remove(socio);
		}		
	}	

}
