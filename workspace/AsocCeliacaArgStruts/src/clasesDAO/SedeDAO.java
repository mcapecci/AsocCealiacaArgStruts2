package clasesDAO;

import clasesDelSistema.Sede;
import java.util.List;

public interface SedeDAO extends GenericDAO<Sede> {

	List<Sede> getAllWithType(String tipo);
}
