package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import aspectJ.Transactional;
import clasesDAO.AvisoDePagoDAO;
import clasesDelSistema.AvisoDePago;

public class AvisoDePagoDAOhiberJPA extends GenericDAOhiberJPA<AvisoDePago>  implements AvisoDePagoDAO{


	public AvisoDePagoDAOhiberJPA() {
		super(AvisoDePago.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<AvisoDePago> getAllSocio(long idSocio) {
		Query consulta = entityManager.createQuery("from AvisoDePago where socioId = '"+idSocio+"' ");
		return (consulta.getResultList());
	}
	
}
