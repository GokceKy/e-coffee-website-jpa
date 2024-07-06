/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Productcategories;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
@Local
@Stateless
public abstract class AbstractDAO<T> implements Serializable {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    protected EntityManager em;

    private Class<T> entityClass;

    public AbstractDAO() {
    }

    public AbstractDAO(Class<T> ec) {
        this.entityClass = ec;
    }

    public void insert(T entity) {

    }

    public void update(T entity) {

    }

    public void delete(int id) {

    }

    public T getById(int id) {
        return (T) em.find(entityClass, id);
    }

}
