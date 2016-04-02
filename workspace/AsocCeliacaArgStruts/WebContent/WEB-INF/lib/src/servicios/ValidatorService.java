package servicios;

import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;

public class ValidatorService {
	UsuarioDAO dao = FactoryDAO.getUsuarioDAO();
	
	public boolean existeUsername(String username) {
		return dao.existeUsername(username);
	}

}
