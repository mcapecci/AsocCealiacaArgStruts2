package aspectJ;

import clasesDAO.GenericDAO;
import clasesDAOhiberJPA.FactoryDAO;
import clasesDelSistema.Bar;



public class TestSimpleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Bar \\
		FactoryDAO factory = new FactoryDAO();
		@SuppressWarnings("static-access")
		GenericDAO<Bar> barDAO = factory.getBarDAO();
				
		try {	
			Bar unBar = new Bar();
			unBar.setNombre("un bar");
			unBar.setDescripcion("una descripcion");
			unBar.setDireccion("una direccion");
			barDAO.save(unBar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
