package clasesDAO;

import java.util.List;

import clasesDelSistema.*;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	long validarLogin(String username, String password);

	String getPerfilById(long id);

	AdministradorCentral getAdminCentral(long id);

	OperadorCentral getOpCentral(long id);

	AdministradorUnidad getAdminUnidad(long id);

	OperadorUnidad getOpUnidad(long id);

	SocioNormal getSocioNormal(long id);
	
	SocioVirtual getSocioVirtual(long id);
	
	List<AdministradorCentral> getAllAdminCentral(long entidadId);

	List<OperadorCentral> getAllOpCentral(long entidadId);

	List<AdministradorUnidad> getAllAdminUnidad(long entidadId);

	List<OperadorUnidad> getAllOpUnidad(long entidadId);

	List<SocioNormal> getAllSocioNormal(long entidadId);

	List<SocioVirtual> getAllSocioVirtual(long entidadId);

	boolean existeUsername(String username);

	List<SocioNormal> getAllUnidades(long idCentral);

}
