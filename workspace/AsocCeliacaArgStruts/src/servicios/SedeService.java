package servicios;

import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAO.SedeDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Sede;
import clasesDelSistema.TipoSede;

public class SedeService {

	SedeDAO dao = FactoryDAO.getSedeDAO();
	
	public List<Sede> getAll(String tipo) {
		return dao.getAllWithType(tipo);
	}

	public void modificar(Sede selected) {
		dao.update(selected);
	}

	public void eliminar(long idSelected) {
		SedeDAO dao = FactoryDAO.getSedeDAO();
		dao.removeById(idSelected);
	}

	public void registrar(String direccion, String localidad, String nombre,
			String provincia, String telefono, TipoSede tipoSede,
			float valorCuota) {
		Sede sede = new Sede();
		sede.setDireccion(direccion);
		sede.setLocalidad(localidad);
		sede.setNombre(nombre);
		sede.setProvincia(provincia);
		sede.setTelefono(telefono);
		sede.setTipoSede(tipoSede);
		sede.setValorCuota(valorCuota);
		dao.save(sede);
	
	}

	public List<TipoSede> getAllTypes() {
		GenericDAO<TipoSede> daoTipo = FactoryDAO.getTipoSedeDAO();
		return daoTipo.getAll();
	}

	public TipoSede getTipoSedebyID(Long id) {
		GenericDAO<TipoSede> daoTipo = FactoryDAO.getTipoSedeDAO();
		return daoTipo.getById(id);
	}

	public Sede buscar(long idSelected) {
		return dao.getById(idSelected);
	}

}
