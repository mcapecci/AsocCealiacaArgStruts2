package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import clasesDelSistema.AdministradorCentral;
import clasesDelSistema.Usuario;
import servicios.LoginService;

/** Este action realiza las funciones referidas las sesiones
 * de todos los usuarios
 */

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
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
			
			//Guardo el perfil del usuario para usarlo durante la sesion
			ActionContext.getContext().getSession().put("perfil", profile);
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}
		return "error";
	}
	
	public String verDatos(){
		this.user = (Usuario)ActionContext.getContext().getSession().get("user");
		this.profile = (String)ActionContext.getContext().getSession().get("perfil");
		return "ver_datos";
	}
	
	public String editar(){
		this.user = (Usuario)ActionContext.getContext().getSession().get("user");
		this.profile = (String)ActionContext.getContext().getSession().get("perfil");
		return "editar_datos";
	}
	
	public String index(){
		this.user = (Usuario)ActionContext.getContext().getSession().get("user");
		this.profile = (String)ActionContext.getContext().getSession().get("perfil");
		return "index";
	}
	
	
	/*
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "logout";
	}	
	*/

}
