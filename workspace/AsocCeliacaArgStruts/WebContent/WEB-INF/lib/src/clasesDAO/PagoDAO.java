package clasesDAO;

import java.util.List;

import clasesDelSistema.Pago;

public interface PagoDAO extends GenericDAO<Pago>{
	List<Pago> getAll(long idSocio);
}
