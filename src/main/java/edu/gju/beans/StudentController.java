/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.beans;

import edu.gju.daos.StudentsDao;
import edu.gju.entities.Students;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author hesham
 */
@ManagedBean(name = "controller")
@SessionScoped
public class StudentController implements Serializable {

    @EJB
    private StudentsDao studentDao;
    @Inject
    private StudentBean studentBean;

    public List<Students> getAllStudents() {
        List<Students> students = studentDao.retriveAllRecords();
        return students;
    }

    public Students searchStudent(Object id) {
        Students s = studentDao.searchEntity(id);
        return s;
    }

    public String editStudent(Students student) {
        studentBean.setStudentId(student.getStudentId());
        studentBean.setFirstName(student.getStudentFirstName());
        studentBean.setLastName(student.getStudentLastName());
        studentBean.setShcoolName(student.getSchoolId().getSchoolName());
        studentBean.setDepartmentName(student.getDepartmentId().getDepartmentName());
        return "edit";
    }

    public String persistObject() {
        Students s = new Students();
        s.setStudentId(studentBean.getStudentId());
        s.setStudentFirstName(studentBean.getFirstName());
        s.setStudentLastName(studentBean.getLastName());
        studentDao.persistEntity(s);
        return "index";
    }

}
