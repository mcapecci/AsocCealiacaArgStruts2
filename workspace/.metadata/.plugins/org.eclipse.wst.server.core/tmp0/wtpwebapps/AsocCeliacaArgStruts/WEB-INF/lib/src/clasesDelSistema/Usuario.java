package clasesDelSistema;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipoUsuario", discriminatorType=DiscriminatorType.STRING)
public abstract class Usuario {
		
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String username;
	private String password;
	private String nomyap;
	private String direccion;
	private String telefono;
	private String email;
	private String perfil;
	
	
	/* Constructor sin argumentos */

	public Usuario() {
		super();
	}
	
	/* Metodos Getters y Setters */
	
	public Usuario(String usuario, String pass) {
		// TODO Auto-generated constructor stub
		super();
		setUsername(usuario);
		setPassword(pass);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomyap() {
		return nomyap;
	}
	public void setNomyap(String nomyap) {
		this.nomyap = nomyap;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
