/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author hesham
 * @param <T>
 */
public abstract class GeneralDAO<T> {

    private Class<T> myEntity;

    public GeneralDAO(Class<T> myEntity) {
        this.myEntity = myEntity;
    }

    public abstract EntityManager getEntityManager();

    public T searchEntity(Object id) {
        EntityManager em = getEntityManager();
        return em.find(myEntity, id);
    }

    public List<T> retriveAllRecords() {
        List<T> resultList = new ArrayList<>();
        EntityManager em = getEntityManager();
        CriteriaQuery cQuery = em.getCriteriaBuilder().createQuery();
        cQuery.select(cQuery.from(myEntity));
        resultList = em.createQuery(cQuery).getResultList();
        return resultList;

    }

    public void persistEntity(T entityClass) {
        EntityManager em = getEntityManager();
        em.persist(myEntity);
    }

    public void editEntity(T entityClass) {
        EntityManager em = getEntityManager();
        em.merge(entityClass);
    }

    public void deleteEntity(T entityClass) {
        EntityManager em = getEntityManager();
        em.remove(myEntity);
    }

}
