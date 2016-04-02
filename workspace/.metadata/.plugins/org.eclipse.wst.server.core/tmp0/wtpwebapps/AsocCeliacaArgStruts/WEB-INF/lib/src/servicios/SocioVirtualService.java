package servicios;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.AvisoDePago;
import clasesDelSistema.SocioVirtual;

public class SocioVirtualService {
	GenericDAO<SocioVirtual> dao = FactoryDAO.getSocioVirtualDAO();
	SocioVirtual socio = new SocioVirtual();
	
	public void cambiarPass(SocioVirtual user) {
		dao.update(user);
	}

	public void modificar(SocioVirtual user) {
		dao.update(user);	}

	public void registrarAviso(AvisoDePago unAviso) {
		GenericDAO<AvisoDePago> avisoDAO = FactoryDAO.getAvisoDePagoDAO();
		avisoDAO.save(unAviso);
		
	}
}
