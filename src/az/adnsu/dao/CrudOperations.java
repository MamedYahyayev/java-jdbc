package az.adnsu.dao;

import java.util.List;

public interface CrudOperations<T> {

	void save(T t);

	List<T> getAll();

	T getById(Long id);

	void update(T t);

	void delete(T t);

}
