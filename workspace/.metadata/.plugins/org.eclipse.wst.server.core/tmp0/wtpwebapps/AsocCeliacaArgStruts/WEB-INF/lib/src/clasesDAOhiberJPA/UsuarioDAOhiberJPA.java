package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.Query;

import aspectJ.Transactional;
import clasesDAO.UsuarioDAO;
import clasesDelSistema.*;

public class UsuarioDAOhiberJPA extends GenericDAOhiberJPA<Usuario>  implements UsuarioDAO{

	public UsuarioDAOhiberJPA() {
		super(Usuario.class);
	}


	@Transactional(readOnly="true")
	public long validarLogin(String username, String password) {
		@SuppressWarnings("rawtypes")
		List resultado;		
		Query consulta = entityManager.createQuery("select u.id from Usuario u where username = '"+username+"' and password = '"+password+"' ");
		resultado = consulta.getResultList();
		if (resultado.isEmpty()) return -1;
		return (Long) resultado.get(0);
	}

	@Transactional(readOnly="true")
	public String getPerfilById(long id) {			
		Query consulta = entityManager.createQuery("select u.perfil from Usuario u where id = '"+id+"' ");		
		return (String) consulta.getSingleResult();
	}

	@Transactional(readOnly="true")
	public boolean existeUsername(String username) {	
		Query consulta = entityManager.createQuery("from Usuario u where username = '"+username+"' ");
		if (consulta.getResultList().isEmpty()) return false;
		return true;
	}
	
	@Transactional(readOnly="true")
	public AdministradorCentral getAdminCentral(long id) {
		Query consulta = entityManager.createQuery("from AdministradorCentral where id = '"+id+"' ");
		return ((AdministradorCentral)consulta.getSingleResult());		
	}

	@Transactional(readOnly="true")
	public OperadorCentral getOpCentral(long id) {
		Query consulta = entityManager.createQuery("from OperadorCentral where id = '"+id+"' ");
		return (OperadorCentral) consulta.getSingleResult();
	}

	@Transactional(readOnly="true")
	public AdministradorUnidad getAdminUnidad(long id) {
		Query consulta = entityManager.createQuery("from AdministradorUnidad where id = '"+id+"' ");
		return (AdministradorUnidad) consulta.getSingleResult();
	}

	@Transactional(readOnly="true")
	public OperadorUnidad getOpUnidad(long id) {
		Query consulta = entityManager.createQuery("from OperadorUnidad where id = '"+id+"' ");
		return (OperadorUnidad) consulta.getSingleResult();
	}
	
	@Transactional(readOnly="true")
	public SocioNormal getSocioNormal(long id) {
		Query consulta = entityManager.createQuery("from SocioNormal where id = '"+id+"' ");
		return (SocioNormal) consulta.getSingleResult();
	}
	
	@Transactional(readOnly="true")
	public SocioVirtual getSocioVirtual(long id) {
		Query consulta = entityManager.createQuery("from SocioVirtual where id = '"+id+"' ");
		return (SocioVirtual) consulta.getSingleResult();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<AdministradorCentral> getAllAdminCentral(long entidadId) {		
		Query consulta = entityManager.createQuery("from AdministradorCentral where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<OperadorCentral> getAllOpCentral(long entidadId) {		
		Query consulta = entityManager.createQuery("from OperadorCentral where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<AdministradorUnidad> getAllAdminUnidad(long entidadId) {		
		Query consulta = entityManager.createQuery("from AdministradorUnidad where sedeId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<OperadorUnidad> getAllOpUnidad(long entidadId) {		
		Query consulta = entityManager.createQuery("from OperadorUnidad where sedeId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<SocioNormal> getAllSocioNormal(long entidadId) {		
		Query consulta = entityManager.createQuery("from SocioNormal where entidadId = '"+entidadId+"' ");
		return (consulta.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<SocioVirtual> getAllSocioVirtual(long entidadId) {		
		Query consulta = entityManager.createQuery("from SocioVirtual where centralId = '"+entidadId+"' ");
		return (consulta.getResultList());	
	}


	@SuppressWarnings("unchecked")
	@Transactional(readOnly="true")
	public List<SocioNormal> getAllUnidades(long centralId) {
		List<SocioNormal> socios = entityManager.createQuery("from SocioNormal").getResultList();
		List<SocioNormal> sociosCentral = entityManager.createQuery("from SocioNormal where entidadId = '"+centralId+"' ").getResultList();
		socios.removeAll(sociosCentral);
		return socios;
	}
	
}
