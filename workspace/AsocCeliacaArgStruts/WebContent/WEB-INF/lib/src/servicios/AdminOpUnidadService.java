package servicios;

import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.OperadorUnidad;
import clasesDelSistema.Sede;

public class AdminOpUnidadService {
	GenericDAO<OperadorUnidad> dao = FactoryDAO.getOperadorUnidadDAO();
	
	
	public void modificar(OperadorUnidad selected) {
		dao.update(selected);		
	}
	
	public void eliminar(long id){
		dao.removeById(id);
	}
	

	public List<OperadorUnidad> getAll(Long id) {
		UsuarioDAO userDAO = FactoryDAO.getUsuarioDAO();
		return userDAO.getAllOpUnidad(id);
	}
	
	public void registrar(String perfil, Sede sede, String nomyap, String telefono,
			String direccion, String email, String username, String password) {
		OperadorUnidad op = new OperadorUnidad();
		op.setPerfil(perfil);
		op.setNomyap(nomyap);
		op.setTelefono(telefono);
		op.setDireccion(direccion);
		op.setEmail(email);
		op.setUsername(username);
		op.setPassword(password);
		op.setSede(sede);
		dao.save(op);		
	}




}
