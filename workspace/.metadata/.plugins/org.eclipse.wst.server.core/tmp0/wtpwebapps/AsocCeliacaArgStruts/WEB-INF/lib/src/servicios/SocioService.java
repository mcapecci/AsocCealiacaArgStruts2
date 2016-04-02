package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.SocioNormal;

public class SocioService {
	GenericDAO<SocioNormal> dao = FactoryDAO.getSocioNormalDAO();
	SocioNormal socio = new SocioNormal();
	
	public void cambiarPass(SocioNormal user) {
		dao.update(user);
	}

	public void modificar(SocioNormal user) {
		dao.update(user);	}
}
