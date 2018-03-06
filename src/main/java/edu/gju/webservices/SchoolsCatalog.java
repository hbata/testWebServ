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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author hesham
 */
@WebService
public class SchoolsCatalog {

    @EJB
    private SchoolDao schoolDao;
    @EJB
    private DepartmentDao depDao;

    @WebMethod
    public List<String> retriveGJUSchools() {
        List<String> schools = new ArrayList<>();
        List<Schools> rs = schoolDao.retriveAllRecords();
        for (Schools s : rs) {
            schools.add(s.getSchoolName());
        }
        return schools;
    }

    @WebMethod
    public List<String> retriveSchoolDepartments(String school) {
        List<String> deps = new ArrayList<>();
        List<Departments> dps = depDao.retriveAllRecords();
        for (Departments d : dps) {
            String s = d.getSchoolId().getSchoolName();
            if (s.equalsIgnoreCase(school)) {
                deps.add(d.getDepartmentName());
            }
        }
        return deps;
    }

}
