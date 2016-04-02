package clasesDelSistema;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	//private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("asocceliacaarg");
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("jyaa2013_grupo24");
	public static EntityManagerFactory getEMF(){
	return emfInstance ;
	}
}
