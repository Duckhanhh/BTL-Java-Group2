package Repo;

import java.util.List;

public interface DAOinterface<T> {
    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);
    public T findById(int id);
    public List<T> findAll();
}
