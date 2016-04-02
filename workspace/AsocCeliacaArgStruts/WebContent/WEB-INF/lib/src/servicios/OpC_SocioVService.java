package servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clasesDAO.AvisoDePagoDAO;
import clasesDAO.GenericDAO;
import clasesDAO.PagoDAO;
import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.AvisoDePago;
import clasesDelSistema.Central;
import clasesDelSistema.Pago;
import clasesDelSistema.SocioVirtual;

public class OpC_SocioVService {
	GenericDAO<SocioVirtual> dao = FactoryDAO.getSocioVirtualDAO();
	
	
	public void modificar(SocioVirtual selected) {
		dao.update(selected);		
	}
	
	public void eliminar(long id){
		dao.removeById(id);
	}
	
	public List<SocioVirtual> getAll(Long id) {
		UsuarioDAO userDAO = FactoryDAO.getUsuarioDAO();
		return userDAO.getAllSocioVirtual(id);
	}

	public void registrar(String string, Central entidad, String nomyap,
			String dni, String ocupacion, String direccion, String telefono,
			Date fechaNacimiento, Date fechaIngreso, Date fechaDiagnostico,String email,
			String presentadoPor, String username, String password) {
		SocioVirtual socio = new SocioVirtual();
		socio.setPerfil(string);
		socio.setCentral(entidad);
		socio.setNomyap(nomyap);
		socio.setDni(dni);
		socio.setOcupacion(ocupacion);
		socio.setDireccion(direccion);
		socio.setTelefono(telefono);
		socio.setFechaNacimiento(fechaNacimiento);
		socio.setFechaIngreso(fechaIngreso);
		socio.setFechaDiagnostico(fechaDiagnostico);
		socio.setEmail(email);
		socio.setPresentadoPor(presentadoPor);
		socio.setUsername(username);
		socio.setPassword(password);
		socio.setPagos(new ArrayList<Pago>());
		dao.save(socio);		
	}

	public List<AvisoDePago> getAvisos() {
		AvisoDePagoDAO avisoDAO = FactoryDAO.getAvisoDePagoDAO();		
		return avisoDAO.getAll();
	}

		public void cargarPagoYEliminarAviso(Pago pago, AvisoDePago avisoSelected) {
		PagoDAO pagoDAO = FactoryDAO.getPagoDAO();
		pagoDAO.save(pago);	
		AvisoDePagoDAO avisoDAO = FactoryDAO.getAvisoDePagoDAO();		
		avisoDAO.remove(avisoSelected);
		
	}

		public void modificarAviso(AvisoDePago avisoSelected) {
			GenericDAO<AvisoDePago> avisoDAO = FactoryDAO.getAvisoDePagoDAO();
			avisoDAO.update(avisoSelected);
			
		}

		public List<Pago> getPagos(Long id) {
			PagoDAO pagoDAO = FactoryDAO.getPagoDAO();
			return pagoDAO.getAll(id);
		}

		public void eliminarAviso(AvisoDePago avisoSelected) {
			AvisoDePagoDAO avisoDAO = FactoryDAO.getAvisoDePagoDAO();		
			avisoDAO.remove(avisoSelected);
			
			
		}


}
