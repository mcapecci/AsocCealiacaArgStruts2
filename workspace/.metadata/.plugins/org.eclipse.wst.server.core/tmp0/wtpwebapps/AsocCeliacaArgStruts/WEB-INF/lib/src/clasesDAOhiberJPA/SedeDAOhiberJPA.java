package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import aspectJ.Transactional;

import clasesDAO.SedeDAO;
import clasesDelSistema.Sede;

public class SedeDAOhiberJPA extends GenericDAOhiberJPA<Sede>  implements SedeDAO{

	public SedeDAOhiberJPA() {
		super(Sede.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true") 
	public List<Sede> getAllWithType(String tipo) {
		Query consulta = entityManager.createQuery("from Sede where tipoSede.nombre ='"+tipo+"' ");
		return (consulta.getResultList());
	}

}
