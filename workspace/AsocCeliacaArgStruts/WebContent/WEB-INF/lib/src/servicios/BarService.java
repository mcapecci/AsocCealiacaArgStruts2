package servicios;

import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Bar;

public class BarService {
	GenericDAO<Bar> dao = FactoryDAO.getBarDAO();

	public void modificar(Bar selected) {
		dao.update(selected);
		
	}

	public void eliminar(long idSelected) {
		GenericDAO<Bar> dao = FactoryDAO.getBarDAO();
		dao.removeById(idSelected);
	}

	public void registrar(String nombre, String descripcion, String direccion) {
		Bar bar = new Bar();
		bar.setNombre(nombre);
		bar.setDescripcion(descripcion);
		bar.setDireccion(direccion);
		dao.save(bar);
		
	}

	public List<Bar> getAll() {
		return dao.getAll();
	}

}
