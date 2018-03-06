/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.daos;

import edu.gju.entities.Departments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hesham
 */
@Stateless
public class DepartmentDaoImpl extends GeneralDAO<Departments> implements DepartmentDao {

    @PersistenceContext(unitName = "edu.gju_WebServJPA_war_1.0PU")
    private EntityManager entityManager;

    public DepartmentDaoImpl() {
        super(Departments.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
