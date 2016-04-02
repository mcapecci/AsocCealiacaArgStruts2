package clasesDAO;

import java.util.List;

public interface GenericDAO<T> {
	
	public void save(T newInstance);

	public void update(T persistenceInstance);

	public void remove(T persistenceInstance);

	public void removeById(long persistenceId);

	public List<T> getAll();
	
	public T getById(long id);

}
