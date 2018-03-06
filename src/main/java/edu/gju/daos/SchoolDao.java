/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.daos;

import edu.gju.entities.Schools;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author hesham
 */
@Local
public interface SchoolDao {

    public List<Schools> retriveAllRecords();

    public Schools searchEntity(Object id);

    public void persistEntity(Schools school);

    public void editEntity(Schools school);

    public void deleteEntity(Schools school);

}
