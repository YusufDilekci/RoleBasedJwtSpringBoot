package kodlama.io.Devs.core.dataAccess;

import java.util.List;

public interface EntityRepository<T> {

	List<T> getAll();
	T getById(int id);
	void Add(T entity);
	void Update(T entity);
	void Delete(T entity);
}
