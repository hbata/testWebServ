/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.daos;

import edu.gju.entities.Departments;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hesham
 */
@Local
public interface DepartmentDao {

    public List<Departments> retriveAllRecords();

    public Departments searchEntity(Object id);

    public void persistEntity(Departments department);

    public void editEntity(Departments department);

    public void deleteEntity(Departments department);

}
