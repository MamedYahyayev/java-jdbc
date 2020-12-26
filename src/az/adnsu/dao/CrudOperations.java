package az.adnsu.dao;

import java.util.List;

public interface CrudOperations<T, ID> {

	void save(T t);

	List<T> getAll();

	T getById(ID id);

	void update(T t);

	void deleteById(ID id);

}
