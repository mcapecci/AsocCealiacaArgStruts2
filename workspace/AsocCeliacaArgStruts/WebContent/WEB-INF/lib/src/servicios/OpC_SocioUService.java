package servicios;

import java.util.List;

import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.SocioNormal;

public class OpC_SocioUService {
	UsuarioDAO dao = FactoryDAO.getUsuarioDAO();
	
	public List<SocioNormal> getAllUnidades(long idCentral) {
		return dao.getAllUnidades(idCentral);		 
	}
}
