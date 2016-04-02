package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.AvisoDePagoDAO;
import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.*;

/**
 * Servlet implementation class TestCreate
 */
public class TestCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FactoryDAO factory = new FactoryDAO();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html> <head>");
		out.println(" <link rel=\"stylesheet\" href=\"./css/style.css\" type=\"text/css\"> ");
		out.println(" <link rel=\"stylesheet\" href=\"./css/style-perfil.css\" type=\"text/css\"> ");
		out.println(" <link href=\"../images/icono.png\" rel=\"shortcut icon\" /> ");
		out.println("</head> <body> ");
		out.println("<section id='page'>");
		out.println("<header> <a href=\"index.html\"><img src=\"images/logo.png\" id=\"logo\" alt=\"logo\"/></a>" +
				"<h1>Asociaci&oacute;n Cel&iacute;aca Argentina</h1> </header>");
		out.println(" <section id='content'> ");
		out.println("<h2>PRUEBA DE PERSISTENCIA </h2>");

		// -------- CREATE -------- \\
		
		// Bar \\
		Bar unBar = new Bar();
		unBar.setNombre("Almendra");
		unBar.setDescripcion("Bar-Restarurante");
		unBar.setDireccion("Calle 8 esq 57");
		GenericDAO<Bar> barDAO = factory.getBarDAO();
		barDAO.save(unBar);
		
		Bar unBar2 = new Bar();
		unBar2.setNombre("Foster 54th");
		unBar2.setDescripcion("Bar-Confiteria");
		unBar2.setDireccion("Calle 54 esq 8");
		barDAO.save(unBar2);
		
		Bar unBar3 = new Bar();
		unBar3.setNombre("Hispano");
		unBar3.setDescripcion("Resto-Bar");
		unBar3.setDireccion("Calle 51 esq 4");
		barDAO.save(unBar3);
		
		
		// Medicamento \\
		Medicamento unMedicamento = new Medicamento();
		unMedicamento.setNombre("Trifamox");
		unMedicamento.setDescripcion("Comprimido recubierto");
		unMedicamento.setPrecio(25);
		GenericDAO<Medicamento> medicamentoDAO = factory.getMedicamentoDAO();
		medicamentoDAO.save(unMedicamento);
		
		Medicamento unMedicamento1 = new Medicamento();
		unMedicamento1.setNombre("Paracetampol");
		unMedicamento1.setDescripcion("100ml gota");
		unMedicamento1.setPrecio(22);
		medicamentoDAO.save(unMedicamento1);
		
		Medicamento unMedicamento2 = new Medicamento();
		unMedicamento2.setNombre("Ibuprofenix");
		unMedicamento2.setDescripcion("comprimidos recubiertos");
		unMedicamento2.setPrecio(15);
		medicamentoDAO.save(unMedicamento2);
		
		Medicamento unMedicamento3 = new Medicamento();
		unMedicamento3.setNombre("Tafirol");
		unMedicamento3.setDescripcion("1G comprimidos");
		unMedicamento3.setPrecio(19);
		medicamentoDAO.save(unMedicamento3);
		
		// Producto \\
		GenericDAO<Producto> productoDAO = factory.getProductoDAO();
		Producto unProducto1 = new Producto();
		unProducto1.setNombre("Arroz - Doble Carolina");
		unProducto1.setDescripcion("Tipo largo calidad 00000");
		unProducto1.setComentario("Libre de gluten");
		unProducto1.setEmpresa("Gallo");
		unProducto1.setFecha(new Date(2013, 6, 12));
		unProducto1.setFechaCertLdg(new Date(2012, 6, 1));
		unProducto1.setRne("01-234567");
		unProducto1.setRnpa("025/08000442-7/009");
		productoDAO.save(unProducto1);
		
		Producto unProducto2 = new Producto();
		unProducto2.setNombre("Aceite de Oliva");
		unProducto2.setDescripcion("Aceite de oliva virgen calidad extra");
		unProducto2.setComentario("Libre de gluten");
		unProducto2.setEmpresa("Cocinero");
		unProducto2.setFecha(new Date(2013, 6, 12));
		unProducto2.setFechaCertLdg(new Date(2012, 6, 1));
		unProducto2.setRne("01-234567");
		unProducto2.setRnpa("21-093404");
		productoDAO.save(unProducto2);
		
		Producto unProducto3 = new Producto();
		unProducto3.setNombre("Alfajor de Arroz");
		unProducto3.setDescripcion("Relleno con mousse de dulce de leche con cobertura de chocolate");
		unProducto3.setComentario("Libre de gluten");
		unProducto3.setEmpresa("Cachafaz");
		unProducto3.setFecha(new Date(2013, 6, 12));
		unProducto3.setFechaCertLdg(new Date(2012, 6, 1));
		unProducto3.setRne("01-234567");
		unProducto3.setRnpa("02-569640");
		productoDAO.save(unProducto3);
		
		Producto unProducto4 = new Producto();
		unProducto4.setNombre("Harina de arroz");
		unProducto4.setDescripcion("Harina");
		unProducto4.setComentario("Harina de arroz");
		unProducto4.setEmpresa("Cedro Azul");
		unProducto4.setFecha(new Date(2013, 6, 12));
		unProducto4.setFechaCertLdg(new Date(2012, 6, 1));
		unProducto4.setRne("01-234567");
		unProducto4.setRnpa("21-095955");
		productoDAO.save(unProducto4);
		
		// Tipo Sede \\
		GenericDAO<TipoSede> tipoSedeDAO = factory.getTipoSedeDAO();
		TipoSede tipo1 = new TipoSede();
		tipo1.setNombre("Filial");		
		tipoSedeDAO.save(tipo1);		
		
		TipoSede tipo2 = new TipoSede();
		tipo2.setNombre("Delegacion");
		tipoSedeDAO.save(tipo2);		
		
		TipoSede tipo3 = new TipoSede();
		tipo3.setNombre("Grupo de Referencia");
		tipoSedeDAO.save(tipo3);
		
		TipoSede tipo4 = new TipoSede();
		tipo4.setNombre("Institucion Beneficiaria");
		tipoSedeDAO.save(tipo4);
		
		
		// Sede \\
		Sede unaSede1 = new Sede();
		unaSede1.setNombre("Filial Chivilcoy");
		unaSede1.setProvincia("Buenos Aires");
		unaSede1.setLocalidad("Chivilcoy");
		unaSede1.setDireccion("Calle 21 y Faverio");
		unaSede1.setTelefono("0234615503689");
		unaSede1.setTipoSede(tipo1);
		unaSede1.setValorCuota((float) 100);
		unaSede1.setAdministradores(new ArrayList<AdministradorUnidad>());
		unaSede1.setOperadores(new ArrayList<OperadorUnidad>());
		unaSede1.setSocios(new ArrayList<SocioNormal>());		
		GenericDAO<Sede> sedeDAO = factory.getSedeDAO();
		sedeDAO.save(unaSede1);		
		
		Sede unaSede2 = new Sede();
		unaSede2.setNombre("Filial Necochea");
		unaSede2.setProvincia("Buenos Aires");
		unaSede2.setLocalidad("Necochea");
		unaSede2.setDireccion("Calle 60 Nro. 2962");
		unaSede2.setTelefono("02262438976");
		unaSede2.setTipoSede(tipo1);
		unaSede2.setValorCuota((float) 100);
		unaSede2.setAdministradores(new ArrayList<AdministradorUnidad>());
		unaSede2.setOperadores(new ArrayList<OperadorUnidad>());
		unaSede2.setSocios(new ArrayList<SocioNormal>());
		sedeDAO.save(unaSede2);		
		
		Sede unaSede3 = new Sede();
		unaSede3.setNombre("Delegacion Cordoba");
		unaSede3.setProvincia("Cordoba");
		unaSede3.setLocalidad("Cordoba Capital");
		unaSede3.setDireccion("Calle Salta y Catamarca");
		unaSede3.setTelefono("0351155392662");
		unaSede3.setTipoSede(tipo2);
		unaSede3.setValorCuota((float) 100);
		unaSede3.setAdministradores(new ArrayList<AdministradorUnidad>());
		unaSede3.setOperadores(new ArrayList<OperadorUnidad>());
		unaSede3.setSocios(new ArrayList<SocioNormal>());		
		sedeDAO.save(unaSede3);		
		
		Sede unaSede4 = new Sede();
		unaSede4.setNombre("Delegacion Berazategui");
		unaSede4.setProvincia("Buenos Aires");
		unaSede4.setLocalidad("Berazategui");
		unaSede4.setDireccion("Calle 136 e/ 27 y 30");
		unaSede4.setTelefono("0111561498743");
		unaSede4.setTipoSede(tipo2);
		unaSede4.setValorCuota((float) 100);
		unaSede4.setAdministradores(new ArrayList<AdministradorUnidad>());
		unaSede4.setOperadores(new ArrayList<OperadorUnidad>());
		unaSede4.setSocios(new ArrayList<SocioNormal>());
		sedeDAO.save(unaSede4);		
		
		// Central \\
		Central unaCentral = new Central();
		unaCentral.setNombre("Central Nacional - La Plata") ;
		unaCentral.setProvincia("Buenos Aires");
		unaCentral.setLocalidad("La Plata");
		unaCentral.setDireccion("Calle 14 e/ 65 y 66");
		unaCentral.setTelefono("02214516126");
		unaCentral.setValorCuota((float) 100);				
		unaCentral.setAdministradores(new ArrayList<AdministradorCentral>());
		unaCentral.setOperadores(new ArrayList<OperadorCentral>());
		unaCentral.setSocios(new ArrayList<SocioNormal>());
		unaCentral.setSociosVirtuales(new ArrayList<SocioVirtual>());	
		GenericDAO<Central> centralDAO = factory.getCentralDAO();
		centralDAO.save(unaCentral);
		
		// Administrador Central \\
		AdministradorCentral unAdminCentral = new AdministradorCentral();
		unAdminCentral.setUsername("adminCentral");
		unAdminCentral.setPassword("adminCentral");
		unAdminCentral.setPerfil("adminCentral");
		unAdminCentral.setNomyap("Martina Gerez");
		unAdminCentral.setDireccion("Calle 8 - 1376");
		unAdminCentral.setTelefono("456789");
		unAdminCentral.setEmail("martina@hotmail.com");
		unAdminCentral.setCentral(unaCentral);
		GenericDAO<AdministradorCentral> adminCentralDAO = factory.getAdministradorCentralDAO();
		adminCentralDAO.save(unAdminCentral);
		
		// Administrador Unidad \\
		AdministradorUnidad unAdminUnidad = new AdministradorUnidad();
		unAdminUnidad.setUsername("adminUnidad");
		unAdminUnidad.setPassword("adminUnidad");
		unAdminUnidad.setPerfil("adminUnidad");
		unAdminUnidad.setNomyap("Pedro Aznar");
		unAdminUnidad.setDireccion("una direccion");
		unAdminUnidad.setTelefono("456789");
		unAdminUnidad.setEmail("p.aznar@hotmail.com");
		unAdminUnidad.setSede(unaSede1);
		GenericDAO<AdministradorUnidad> adminUnidadDAO = factory.getAdministradorUnidadDAO();
		adminUnidadDAO.save(unAdminUnidad);
		
		// Operador Central\\
		OperadorCentral unOpCentral = new OperadorCentral();
		unOpCentral.setUsername("opCentral");
		unOpCentral.setPassword("opCentral");
		unOpCentral.setPerfil("opCentral");
		unOpCentral.setNomyap("Luciana Perez");
		unOpCentral.setDireccion("Calle 10-1324");
		unOpCentral.setTelefono("456789");
		unOpCentral.setEmail("luly@hotmail.com");
		unOpCentral.setCentral(unaCentral);
		GenericDAO<OperadorCentral> opCentralDAO = factory.getOperadorCentralDAO();
		opCentralDAO.save(unOpCentral);
		
		// Operador Unidad \\
		OperadorUnidad unOpUnidad = new OperadorUnidad();
		unOpUnidad.setUsername("opUnidad");
		unOpUnidad.setPassword("opUnidad");
		unOpUnidad.setPerfil("opUnidad");
		unOpUnidad.setNomyap("Matias Serrano");
		unOpUnidad.setDireccion("Calle 12-2345");
		unOpUnidad.setTelefono("456789");
		unOpUnidad.setEmail("mati_89@hotmail.com");
		unOpUnidad.setSede(unaSede1);
		GenericDAO<OperadorUnidad> opUnidadDAO = factory.getOperadorUnidadDAO();
		opUnidadDAO.save(unOpUnidad);
		
		// Socio Normal \\
		SocioNormal unSocio1 = new SocioNormal();
		unSocio1.setUsername("jperez");
		unSocio1.setPassword("jperez");
		unSocio1.setPerfil("socioNormal");
		unSocio1.setNomyap("Juan Perez");
		unSocio1.setDireccion("Calle 80 nro 234");
		unSocio1.setTelefono("456789");
		unSocio1.setEmail("jperez@hotmail.com");
		unSocio1.setDni("35567876");
		unSocio1.setOcupacion("Empleado");
		unSocio1.setFechaNacimiento(new Date(1991, 2, 13));
		unSocio1.setFechaDiagnostico(new Date(2010, 1, 24));
		unSocio1.setFechaIngreso(new Date(2010, 3,5));
		unSocio1.setPresentadoPor("Marcos Santaolalla");
		unSocio1.setPagos(new ArrayList<Pago>());
		unSocio1.setEntidad(unaSede1);
		GenericDAO<SocioNormal> socioNormalDAO = FactoryDAO.getSocioNormalDAO();
		socioNormalDAO.save(unSocio1);
		
		SocioNormal unSocio2 = new SocioNormal();
		unSocio2.setUsername("gRiddick");
		unSocio2.setPassword("gRiddick");
		unSocio2.setPerfil("socioNormal");
		unSocio2.setNomyap("Guadalupe Riddick");
		unSocio2.setDireccion("Calle 56-76544");
		unSocio2.setTelefono("456789");
		unSocio2.setEmail("guadi-092@hotmail.com");
		unSocio2.setDni("35341321");
		unSocio2.setOcupacion("una ocupacion");
		unSocio2.setFechaNacimiento(new Date(1991, 2, 13));
		unSocio2.setFechaDiagnostico(new Date(2010, 1, 24));
		unSocio2.setFechaIngreso(new Date(2010, 3,5));
		unSocio2.setPresentadoPor("un presentador");
		unSocio2.setPagos(new ArrayList<Pago>());
		unSocio2.setEntidad(unaSede1);
		socioNormalDAO.save(unSocio2);
		
		// Socio Virtual \\
		SocioVirtual unSocioVirtual = new SocioVirtual();
		unSocioVirtual.setUsername("mVidal");
		unSocioVirtual.setPassword("mVidal");
		unSocioVirtual.setPerfil("socioVirtual");
		unSocioVirtual.setNomyap("Magdalena Vidal");
		unSocioVirtual.setDireccion("Catamarca y Entre Rios");
		unSocioVirtual.setTelefono("456789");
		unSocioVirtual.setEmail("vidal@hotmail.com");
		unSocioVirtual.setDni("15567875");
		unSocioVirtual.setOcupacion("Ama de casa");
		unSocioVirtual.setFechaNacimiento(new Date(1991, 2, 13));
		unSocioVirtual.setFechaDiagnostico(new Date(2010, 1, 24));
		unSocioVirtual.setFechaIngreso(new Date(2010, 3,5));
		unSocioVirtual.setPresentadoPor("un presentador");
		unSocioVirtual.setPagos(new ArrayList<Pago>());
		unSocioVirtual.setCentral(unaCentral);
		GenericDAO<SocioVirtual> socioVirtualDAO = FactoryDAO.getSocioVirtualDAO();
		socioVirtualDAO.save(unSocioVirtual);
		
		// Pago \\
		Pago unaCuota1 = new Pago();		
		unaCuota1.setImporte(100);
		unaCuota1.setFechaPago(new Date(2013, 5, 2));
		unaCuota1.setPeriodo(new Date(2013, 5, 1));
		unaCuota1.setSocio(unSocio1);
		GenericDAO<Pago> pagoDAO = factory.getPagoDAO();
		pagoDAO.save(unaCuota1);
		
		Pago unaCuota2 = new Pago();		
		unaCuota2.setImporte(100);
		unaCuota2.setFechaPago(new Date(2013, 6, 2));
		unaCuota2.setPeriodo(new Date(2013, 6, 1));
		unaCuota2.setSocio(unSocio1);
		pagoDAO.save(unaCuota2);
		
		Pago unaCuota3 = new Pago();		
		unaCuota3.setImporte(100);
		unaCuota3.setFechaPago(new Date(2013, 5, 2));
		unaCuota3.setPeriodo(new Date(2013, 5, 1));
		unaCuota3.setSocio(unSocio2);
		pagoDAO.save(unaCuota3);
		
		Pago unaCuota4 = new Pago();		
		unaCuota4.setImporte(100);
		unaCuota4.setFechaPago(new Date(2013, 6, 2));
		unaCuota4.setPeriodo(new Date(2013, 6, 1));
		unaCuota4.setSocio(unSocio2);
		pagoDAO.save(unaCuota4);
		
		Pago unaCuota5 = new Pago();		
		unaCuota5.setImporte(100);
		unaCuota5.setFechaPago(new Date(2013, 6, 2));
		unaCuota5.setPeriodo(new Date(2013, 6, 1));
		unaCuota5.setSocio(unSocioVirtual);
		pagoDAO.save(unaCuota5);
		
		Pago unaCuota6 = new Pago();		
		unaCuota6.setImporte(100);
		unaCuota6.setFechaPago(new Date(2013, 7, 2));
		unaCuota6.setPeriodo(new Date(2013, 7, 1));
		unaCuota6.setSocio(unSocioVirtual);
		pagoDAO.save(unaCuota6);
		
		// Aviso de Pago \\
		AvisoDePago unAviso = new AvisoDePago();
		unAviso.setFechaAviso(new Date(2013, 6, 2));
		unAviso.setFechaPago(new Date(2013, 6, 2));
		unAviso.setImporte(100);
		unAviso.setPeriodo(new Date(2013, 6, 2));
		unAviso.setSocio(unSocioVirtual);
		AvisoDePagoDAO avisoDAO = factory.getAvisoDePagoDAO();
		avisoDAO.save(unAviso);
		
		
		out.println("</tbody><br><br>"); 
		out.println("</section> </section>");
		out.print("</body></html>");
		out.close();		
		return;
	}	

}
