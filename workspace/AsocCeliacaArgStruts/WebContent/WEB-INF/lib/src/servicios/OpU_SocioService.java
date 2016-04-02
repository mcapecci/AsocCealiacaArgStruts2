package servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clasesDAO.GenericDAO;
import clasesDAO.PagoDAO;
import clasesDAO.UsuarioDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Pago;
import clasesDelSistema.Sede;
import clasesDelSistema.SocioNormal;

public class OpU_SocioService {
	GenericDAO<SocioNormal> dao = FactoryDAO.getSocioNormalDAO();
	
	
	public void modificar(SocioNormal selected) {
		dao.update(selected);		
	}
	
	public void eliminar(long id){
		dao.removeById(id);
	}

	public List<SocioNormal> getAll(Long id) {
		UsuarioDAO userDAO = FactoryDAO.getUsuarioDAO();
		return userDAO.getAllSocioNormal(id);
	}

	public void registrar(String string, Sede entidad, String nomyap,
			String dni, String ocupacion, String direccion, String telefono,
			Date fechaNacimiento, Date fechaIngreso, Date fechaDiagnostico,String email,
			String presentadoPor, String username, String password) {
		SocioNormal socio = new SocioNormal();
		socio.setPerfil(string);
		socio.setEntidad(entidad);
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

	public List<Pago> getPagos(Long id) {
		PagoDAO pagoDAO = FactoryDAO.getPagoDAO();
		return pagoDAO.getAll(id);
	}

	public void registrar_pago(Date fechaPago, float importe, Date periodo,
			SocioNormal socio) {
		PagoDAO pagoDAO = FactoryDAO.getPagoDAO();
		Pago pago = new Pago();
		pago.setFechaPago(fechaPago);
		pago.setImporte(importe);
		pago.setPeriodo(periodo);
		pago.setSocio(socio);
		pagoDAO.save(pago);
		
	}




}
