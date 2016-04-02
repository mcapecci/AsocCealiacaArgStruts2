package servicios;

import java.util.List;

import clasesDAO.PagoDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Pago;

public class PagoService {
	
	public List<Pago> getAll(long id) {
		PagoDAO pagoDAO = FactoryDAO.getPagoDAO();
		return pagoDAO.getAll(id);
	}

}
