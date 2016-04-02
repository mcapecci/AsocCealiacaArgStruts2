package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import aspectJ.Transactional;
import clasesDAO.PagoDAO;
import clasesDelSistema.Pago;

public class PagoDAOhiberJPA extends GenericDAOhiberJPA<Pago>  implements PagoDAO{
	
	public PagoDAOhiberJPA() {
		super(Pago.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<Pago> getAll(long idSocio) {
		Query consulta = entityManager.createQuery("from Pago where socioId = '"+idSocio+"' ");
		return (consulta.getResultList());
	}
}
