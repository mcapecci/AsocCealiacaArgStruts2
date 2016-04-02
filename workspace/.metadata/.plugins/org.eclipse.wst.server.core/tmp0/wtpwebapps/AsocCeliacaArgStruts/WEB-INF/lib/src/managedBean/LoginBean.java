package managedBean;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import clasesDelSistema.Usuario;

import servicios.LoginService;

/** Este bean realiza las funciones referidas las sesiones
 * de todos los usuarios
 */

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	
	private long id;
	private String username;
	private String password;
	private String profile;
	private Usuario user;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
		
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
	public String login(){
		LoginService serv = new LoginService();
		id = serv.validarUsuario(username, password);
		if (id != -1){
			profile = serv.getPerfilUsuario(id);
			user = serv.getUser(id, profile);
			return profile;
		}
		return "error";
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "logout";
	}	

}
