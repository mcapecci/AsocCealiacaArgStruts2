package servicios;

import java.util.Date;
import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Producto;

public class ProductoService {
	
	GenericDAO<Producto> dao = FactoryDAO.getProductoDAO();
	
	public List<Producto> getAll() {
		return dao.getAll();
	}

	public void modificar(Producto selected) {
		dao.update(selected);
		
	}

	public void eliminar(long idSelected) {
		GenericDAO<Producto> dao = FactoryDAO.getProductoDAO();
		dao.removeById(idSelected);
		
	}

	public void registrar(String nombre, String descripcion, String rnpa,
			String empresa, String rne, Date fecha, Date fechaCertLdg,
			String comentario) {
		Producto p = new Producto();
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		p.setRnpa(rnpa);
		p.setEmpresa(empresa);
		p.setRne(rne);
		p.setFecha(fecha);
		p.setFechaCertLdg(fechaCertLdg);
		p.setComentario(comentario);
		dao.save(p);	
	}

	public Producto buscar(long idSelected) {
		return dao.getById(idSelected);
	}

	

}
