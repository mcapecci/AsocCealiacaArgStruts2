package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.AdministradorUnidad;

public class AdminUnidadService {
	GenericDAO<AdministradorUnidad> dao = FactoryDAO.getAdministradorUnidadDAO();
	AdministradorUnidad admin = new AdministradorUnidad();
	
	public void cambiarPass(AdministradorUnidad user) {
		dao.update(user);
	}

	public void modificar(AdministradorUnidad user) {
		dao.update(user);	}
	
}
