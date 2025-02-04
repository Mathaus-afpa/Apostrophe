package apostrophe.java.services;
import apostrophe.java.exceptions.DaoException;
import apostrophe.java.exceptions.ModelException;
import apostrophe.java.exceptions.NullDataException;

import java.util.List;
public interface IApostropheInnerDAO<T> {
    T create(String fromJson) throws DaoException;
    T find(int id) throws DaoException, NullDataException;
    List<T> findAll() throws DaoException;
    T update(String fromJson) throws DaoException;
    boolean delete(int id) throws DaoException, NullDataException, ModelException;
}