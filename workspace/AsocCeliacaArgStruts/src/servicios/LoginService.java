package servicios;

import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.*;

public class LoginService {

	UsuarioDAO dao = FactoryDAO.getUsuarioDAO();
	
	
	public long validarUsuario(String username, String password){
		return dao.validarLogin(username, password);
	}

	public String getPerfilUsuario(long id) {
		return dao.getPerfilById(id);
	}

	public Usuario getUser(long id, String profile) {
		if(profile.equals("adminCentral")) return dao.getAdminCentral(id);
		if(profile.equals("opCentral")) return dao.getOpCentral(id);
		if(profile.equals("adminUnidad")) return dao.getAdminUnidad(id);
		if(profile.equals("opUnidad")) return dao.getOpUnidad(id);		
		if(profile.equals("socioNormal")) return dao.getSocioNormal(id);
		if(profile.equals("socioVirtual")) return dao.getSocioVirtual(id);
		return null;
	}
}
