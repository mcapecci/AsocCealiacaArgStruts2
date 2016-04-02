package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.OperadorCentral;

public class OpCentralService {
	GenericDAO<OperadorCentral> dao = FactoryDAO.getOperadorCentralDAO();
	OperadorCentral op = new OperadorCentral();
	
	public void cambiarPass(OperadorCentral user) {
		dao.update(user);
	}

	public void modificar(OperadorCentral user) {
		dao.update(user);	}
}
