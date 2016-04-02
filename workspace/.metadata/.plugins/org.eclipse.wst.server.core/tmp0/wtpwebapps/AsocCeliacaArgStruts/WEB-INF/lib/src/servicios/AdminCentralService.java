package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.AdministradorCentral;

public class AdminCentralService {
	GenericDAO<AdministradorCentral> dao = FactoryDAO.getAdministradorCentralDAO();
	AdministradorCentral admin = new AdministradorCentral();
	
	public void cambiarPass(AdministradorCentral user) {
		dao.update(user);
	}

	public void modificar(AdministradorCentral user) {
		dao.update(user);	}
}
