package servicios;

import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Central;
import clasesDelSistema.OperadorCentral;

public class AdminOpCentralService {
	GenericDAO<OperadorCentral> dao = FactoryDAO.getOperadorCentralDAO();
	
	
	public void modificar(OperadorCentral selected) {
		dao.update(selected);		
	}
	
	public void eliminar(long id){
		dao.removeById(id);
	}
	
	public List<OperadorCentral> getAll(Long id) {
		UsuarioDAO userDAO = FactoryDAO.getUsuarioDAO();
		return userDAO.getAllOpCentral(id);
	}

	public void registrar(String perfil, Central central, String nomyap, String telefono,
			String direccion, String email, String username, String password) {
		OperadorCentral op = new OperadorCentral();
		op.setPerfil(perfil);
		op.setNomyap(nomyap);
		op.setTelefono(telefono);
		op.setDireccion(direccion);
		op.setEmail(email);
		op.setUsername(username);
		op.setPassword(password);
		op.setCentral(central);
		dao.save(op);		
	}

	public OperadorCentral buscar(long idSelected) {
		return dao.getById(idSelected);
	}

	


}
