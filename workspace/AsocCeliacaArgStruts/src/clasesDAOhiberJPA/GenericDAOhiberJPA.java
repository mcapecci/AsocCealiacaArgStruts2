package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.EntityManager;

import clasesDAO.GenericDAO;
import clasesDelSistema.EMF;

public class GenericDAOhiberJPA<T> implements GenericDAO<T> {
	
	protected Class<T> objectType;
	public EntityManager entityManager;
	
	public GenericDAOhiberJPA(Class<T> objectType) {
		this.objectType = objectType;
		this.entityManager = EMF.getEMF().createEntityManager();
	}	

	public void save(T newInstance) {
		entityManager.persist(newInstance);	
	}

	public void update(T persistenceInstance) {
		entityManager.merge(persistenceInstance);
	}
	
	public void remove(T persistenceInstance) {
		entityManager.remove(entityManager.merge(persistenceInstance));
		//entityManager.remove(persistenceInstance);
	}
	
	public void removeById(long id) {
		T object = entityManager.find(objectType, id);
		entityManager.remove(object);
		
	}
	
	@SuppressWarnings("unchecked")	
	public List<T> getAll() {
		List<T> all=(List<T>)(entityManager.createQuery("from "+ this.objectType.getSimpleName()).getResultList());					
		return all;
	}
	
	public T getById(long id) {
		T object = entityManager.find(objectType, id);	
		return object;
	}

}
