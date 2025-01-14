/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jakartasec.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<T,ID> {
    @PersistenceContext(unitName = "PU")
    protected EntityManager em;
    private Class<T> entityClass;
    
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
 
    
    public void save(T t) {
        em.persist(t);
    }
    
    public T update(T t) {
        return em.merge(t);
    }
    
    public void remove(ID id) {
        em.remove(em.getReference(entityClass, id));
    }
    
    public T findById(ID id) {
        return em.find(entityClass, id);
    }
    
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
}
