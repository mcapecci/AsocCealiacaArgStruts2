package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import clasesDAO.SedeDAO;
import clasesDelSistema.Sede;

public class SedeDAOhiberJPA extends GenericDAOhiberJPA<Sede>  implements SedeDAO{

	public SedeDAOhiberJPA() {
		super(Sede.class);
	}

	@SuppressWarnings("unchecked")	 
	public List<Sede> getAllWithType(String tipo) {
		Query consulta = entityManager.createQuery("from Sede where tipoSede.nombre ='"+tipo+"' ");
		return (consulta.getResultList());
	}

}
