package servicios;

import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Medicamento;

public class MedicamentoService {
	GenericDAO<Medicamento> dao = FactoryDAO.getMedicamentoDAO();
	
	public void registrar(String nombre, String descripcion, float precio) {
		Medicamento m = new Medicamento();
		m.setDescripcion(descripcion);
		m.setNombre(nombre);
		m.setPrecio(precio);
		dao.save(m);
		
	}

	public void eliminar(long idSelected) {
		GenericDAO<Medicamento> dao = FactoryDAO.getMedicamentoDAO();
		dao.removeById(idSelected);
		
	}

	public void modificar(Medicamento selected) {
		dao.update(selected);
		
	}

	public List<Medicamento> getAll() {
		return dao.getAll();
	}

}
