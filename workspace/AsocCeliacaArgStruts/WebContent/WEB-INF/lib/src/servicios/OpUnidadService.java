package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.OperadorUnidad;


public class OpUnidadService {
	GenericDAO<OperadorUnidad> dao = FactoryDAO.getOperadorUnidadDAO();
	OperadorUnidad op = new OperadorUnidad();
	
	public void cambiarPass(OperadorUnidad user) {
		dao.update(user);
	}

	public void modificar(OperadorUnidad user) {
		dao.update(user);	}

}
