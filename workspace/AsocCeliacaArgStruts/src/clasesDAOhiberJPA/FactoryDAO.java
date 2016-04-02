package clasesDAOhiberJPA;

import clasesDAO.*;
import clasesDelSistema.*;

public class FactoryDAO {
	
	public static GenericDAO<TipoSede> getTipoSedeDAO() {		
		return new GenericDAOhiberJPA<TipoSede>(TipoSede.class);
	}

	public static GenericDAO<Medicamento> getMedicamentoDAO() {
		return new GenericDAOhiberJPA<Medicamento>(Medicamento.class);
	}

	public static GenericDAO<Bar> getBarDAO() {
		return new GenericDAOhiberJPA<Bar>(Bar.class);
	}

	public static GenericDAO<AdministradorCentral> getAdministradorCentralDAO() {
		return new GenericDAOhiberJPA<AdministradorCentral>(AdministradorCentral.class);
	}

	public static GenericDAO<Producto> getProductoDAO() {
		return new GenericDAOhiberJPA<Producto>(Producto.class);
	}	

	public static GenericDAO<Central> getCentralDAO() {
		return new GenericDAOhiberJPA<Central>(Central.class);
	}	
	
	public static SedeDAO getSedeDAO() {
		return new SedeDAOhiberJPA();
	}

	public static GenericDAO<AdministradorUnidad> getAdministradorUnidadDAO() {
		return new GenericDAOhiberJPA<AdministradorUnidad>(AdministradorUnidad.class);	
	}

	public static GenericDAO<OperadorCentral> getOperadorCentralDAO() {
		return new GenericDAOhiberJPA<OperadorCentral>(OperadorCentral.class);
	}

	public static GenericDAO<OperadorUnidad> getOperadorUnidadDAO() {
		return new GenericDAOhiberJPA<OperadorUnidad>(OperadorUnidad.class);
	}

	public static GenericDAO<SocioNormal> getSocioNormalDAO() {
		return new GenericDAOhiberJPA<SocioNormal>(SocioNormal.class);
	}

	public static GenericDAO<SocioVirtual> getSocioVirtualDAO() {
		return new GenericDAOhiberJPA<SocioVirtual>(SocioVirtual.class);
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOhiberJPA();
	}
	
	public static PagoDAO getPagoDAO() {
		return new PagoDAOhiberJPA();
	}
	
	public static AvisoDePagoDAO getAvisoDePagoDAO(){
		return new AvisoDePagoDAOhiberJPA();
	}
}
