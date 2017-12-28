package dao;

import entities.Identified;
import entities.exceptions.PersistentException;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Volochai
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {

    void create(T object) throws PersistentException;

    T getByPK(PK key) throws PersistentException;

    void update(T object) throws PersistentException;

    void delete(T object) throws PersistentException;

    List<T> getAll() throws PersistentException;

}