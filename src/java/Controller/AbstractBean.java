/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g
 * @param <E>
 */
public abstract class AbstractBean<E> implements Serializable{

	protected E entity;
	private final Class<E> entityClass;

	public AbstractBean(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public E getEntity() {
		if (this.entity == null) {
			try {
				this.entity = entityClass.getDeclaredConstructor().newInstance();
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
				Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return entity;
	}

	public void clearEntity() {
		try {
			this.entity = entityClass.getDeclaredConstructor().newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}
	
	public abstract void create();
	public abstract void update(E entity);
	public abstract void delete(int categoryId);
	public abstract List<E> getList();
        public abstract void clearForm();
}
