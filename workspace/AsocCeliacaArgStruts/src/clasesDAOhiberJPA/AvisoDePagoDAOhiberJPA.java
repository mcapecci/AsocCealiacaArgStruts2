package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import clasesDAO.AvisoDePagoDAO;
import clasesDelSistema.AvisoDePago;

public class AvisoDePagoDAOhiberJPA extends GenericDAOhiberJPA<AvisoDePago>  implements AvisoDePagoDAO{


	public AvisoDePagoDAOhiberJPA() {
		super(AvisoDePago.class);
	}

	@SuppressWarnings("unchecked")
	public List<AvisoDePago> getAllSocio(long idSocio) {
		Query consulta = entityManager.createQuery("from AvisoDePago where socioId = '"+idSocio+"' ");
		return (consulta.getResultList());
	}
	
}
