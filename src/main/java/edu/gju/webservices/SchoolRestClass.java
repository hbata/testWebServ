/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.webservices;

import edu.gju.daos.DepartmentDao;
import edu.gju.daos.SchoolDao;
import edu.gju.entities.Departments;
import edu.gju.entities.Schools;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hesham
 */
@Path("schools")
public class SchoolRestClass {

    @EJB
    private SchoolDao schoolDao;
    @EJB
    private DepartmentDao depDao;

    @GET
    @Path("/getSchools")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departments> retriveSchoolNames() {
        List<String> schools = new ArrayList<>();
//        List<Schools> ss = schoolDao.retriveAllRecords();
//        int size = ss.size();
//        String[] sch = new String[size];

        List<Departments> ds = depDao.retriveAllRecords();

        return ds;
    }

}
