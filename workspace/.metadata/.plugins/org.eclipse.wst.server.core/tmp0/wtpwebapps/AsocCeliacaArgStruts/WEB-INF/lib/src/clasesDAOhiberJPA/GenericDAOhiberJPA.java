package clasesDAOhiberJPA;

import java.util.List;

import javax.persistence.EntityManager;

import aspectJ.Transactional;

import clasesDAO.GenericDAO;

public class GenericDAOhiberJPA<T> implements GenericDAO<T> {
	
	protected Class<T> objectType;
	public EntityManager entityManager;
	
	public GenericDAOhiberJPA(Class<T> objectType) {
		this.objectType = objectType;
	}	

	@Transactional(readOnly="false")
	public void save(T newInstance) {
		entityManager.persist(newInstance);	
	}

	@Transactional(readOnly="false")
	public void update(T persistenceInstance) {
		entityManager.merge(persistenceInstance);
	}

	@Transactional(readOnly="false")
	public void remove(T persistenceInstance) {
		entityManager.remove(entityManager.merge(persistenceInstance));
		//entityManager.remove(persistenceInstance);
	}
	
	@Transactional(readOnly="false")
	public void removeById(long id) {
		T object = entityManager.find(objectType, id);
		entityManager.remove(object);
		
	}
	
	@SuppressWarnings("unchecked")	
	@Transactional(readOnly="true")
	public List<T> getAll() {
		List<T> all=(List<T>)(entityManager.createQuery("from "+ this.objectType.getSimpleName()).getResultList());					
		return all;
	}
	
	@Transactional(readOnly="true")
	public T getById(long id) {
		T object = entityManager.find(objectType, id);	
		return object;
	}

}
