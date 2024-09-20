package Dao;

import Model.Customer;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T>{
    public abstract T findById(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract void create(T entity) throws SQLException;
    public abstract void delete(T entity) throws SQLException;
}
