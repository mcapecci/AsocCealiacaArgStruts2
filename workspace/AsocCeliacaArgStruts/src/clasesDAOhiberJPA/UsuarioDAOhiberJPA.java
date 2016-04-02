package clasesDAOhiberJPA;
import java.util.List;

import javax.persistence.Query;

import clasesDAO.UsuarioDAO;
import clasesDelSistema.*;

public class UsuarioDAOhiberJPA extends GenericDAOhiberJPA<Usuario>  implements UsuarioDAO{

	public UsuarioDAOhiberJPA() {
		super(Usuario.class);
	}
	
	public long validarLogin(String username, String password) {
		@SuppressWarnings("rawtypes")
		List resultado;		
		Query consulta = entityManager.createQuery("select u.id from Usuario u where username = '"+username+"' and password = '"+password+"' ");
		resultado = consulta.getResultList();
		if (resultado.isEmpty()) return -1;
		return (Long) resultado.get(0);
	}

	public String getPerfilById(long id) {			
		Query consulta = entityManager.createQuery("select u.perfil from Usuario u where id = '"+id+"' ");		
		return (String) consulta.getSingleResult();
	}

	public boolean existeUsername(String username) {	
		Query consulta = entityManager.createQuery("from Usuario u where username = '"+username+"' ");
		if (consulta.getResultList().isEmpty()) return false;
		return true;
	}	
	
	public AdministradorCentral getAdminCentral(long id) {
		Query consulta = entityManager.createQuery("from AdministradorCentral where id = '"+id+"' ");
		return ((AdministradorCentral)consulta.getSingleResult());		
	}

	public OperadorCentral getOpCentral(long id) {
		Query consulta = entityManager.createQuery("from OperadorCentral where id = '"+id+"' ");
		return (OperadorCentral) consulta.getSingleResult();
	}

	public AdministradorUnidad getAdminUnidad(long id) {
		Query consulta = entityManager.createQuery("from AdministradorUnidad where id = '"+id+"' ");
		return (AdministradorUnidad) consulta.getSingleResult();
	}

	public OperadorUnidad getOpUnidad(long id) {
		Query consulta = entityManager.createQuery("from OperadorUnidad where id = '"+id+"' ");
		return (OperadorUnidad) consulta.getSingleResult();
	}
	
	public SocioNormal getSocioNormal(long id) {
		Query consulta = entityManager.createQuery("from SocioNormal where id = '"+id+"' ");
		return (SocioNormal) consulta.getSingleResult();
	}	
	
	public SocioVirtual getSocioVirtual(long id) {
		Query consulta = entityManager.createQuery("from SocioVirtual where id = '"+id+"' ");
		return (SocioVirtual) consulta.getSingleResult();
	}

	
	@SuppressWarnings("unchecked")	
	public List<AdministradorCentral> getAllAdminCentral(long entidadId) {		
		Query consulta = entityManager.createQuery("from AdministradorCentral where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<OperadorCentral> getAllOpCentral(long entidadId) {		
		Query consulta = entityManager.createQuery("from OperadorCentral where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<AdministradorUnidad> getAllAdminUnidad(long entidadId) {		
		Query consulta = entityManager.createQuery("from AdministradorUnidad where sedeId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<OperadorUnidad> getAllOpUnidad(long entidadId) {		
		Query consulta = entityManager.createQuery("from OperadorUnidad where sedeId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<SocioNormal> getAllSocioNormal(long entidadId) {		
		Query consulta = entityManager.createQuery("from SocioNormal where entidadId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<SocioVirtual> getAllSocioVirtual(long entidadId) {		
		Query consulta = entityManager.createQuery("from SocioVirtual where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());	
	}

	@SuppressWarnings("unchecked")	
	public List<SocioNormal> getAllUnidades(long centralId) {
		List<SocioNormal> socios = entityManager.createQuery("from SocioNormal").getResultList();
		List<SocioNormal> sociosCentral = entityManager.createQuery("from SocioNormal where entidadId = '"+centralId+"' ").getResultList();
		socios.removeAll(sociosCentral);
		return socios;
	}
	
}
