package clasesDAO;

import java.util.List;

import clasesDelSistema.AvisoDePago;

public interface AvisoDePagoDAO extends GenericDAO<AvisoDePago> {
	
	List<AvisoDePago> getAllSocio(long idSocio);

}
