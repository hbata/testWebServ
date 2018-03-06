/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hesham
 */
@Entity
@Table(name = "STUDENTS")

@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Students.findByStudentFirstName", query = "SELECT s FROM Students s WHERE s.studentFirstName = :studentFirstName")
    , @NamedQuery(name = "Students.findByStudentLastName", query = "SELECT s FROM Students s WHERE s.studentLastName = :studentLastName")
    , @NamedQuery(name = "Students.findByDateOfBirth", query = "SELECT s FROM Students s WHERE s.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Students.findByNationality", query = "SELECT s FROM Students s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Students.findByGpa", query = "SELECT s FROM Students s WHERE s.gpa = :gpa")
    , @NamedQuery(name = "Students.findByYearsOfExperience", query = "SELECT s FROM Students s WHERE s.yearsOfExperience = :yearsOfExperience")
    , @NamedQuery(name = "Students.findByFacebook", query = "SELECT s FROM Students s WHERE s.facebook = :facebook")
    , @NamedQuery(name = "Students.findByLinkedin", query = "SELECT s FROM Students s WHERE s.linkedin = :linkedin")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "STUDENT_ID")
    private String studentId;
    @Size(max = 18)
    @Column(name = "STUDENT_FIRST_NAME")
    private String studentFirstName;
    @Size(max = 15)
    @Column(name = "STUDENT_LAST_NAME")
    private String studentLastName;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Size(max = 18)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "GPA")
    private Short gpa;
    @Column(name = "YEARS_OF_EXPERIENCE")
    private Short yearsOfExperience;
    @Size(max = 50)
    @Column(name = "FACEBOOK")
    private String facebook;
    @Size(max = 70)
    @Column(name = "LINKEDIN")
    private String linkedin;
    @JoinColumn(name = "DEGREE_ID", referencedColumnName = "DEGREE_ID")
    @ManyToOne
    private Deegree degreeId;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Departments departmentId;
    @JoinColumn(name = "GENDER_ID", referencedColumnName = "GENDER_ID")
    @ManyToOne
    private Gender genderId;
    @JoinColumn(name = "GRADUATION_SEMESTER_ID", referencedColumnName = "GRADUATION_SEMESTER_ID")
    @ManyToOne
    private GraduationSemester graduationSemesterId;
    @JoinColumn(name = "GRADUATION_YEAR_ID", referencedColumnName = "GRADUATION_YEAR_ID")
    @ManyToOne
    private GraduationYear graduationYearId;
    @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "SCHOOL_ID")
    @ManyToOne
    private Schools schoolId;
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID")
    @ManyToOne
    private StudentStatus statusId;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserGroup userGroup;

    public Students() {
    }

    public Students(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Short getGpa() {
        return gpa;
    }

    public void setGpa(Short gpa) {
        this.gpa = gpa;
    }

    public Short getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Short yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Deegree getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Deegree degreeId) {
        this.degreeId = degreeId;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public GraduationSemester getGraduationSemesterId() {
        return graduationSemesterId;
    }

    public void setGraduationSemesterId(GraduationSemester graduationSemesterId) {
        this.graduationSemesterId = graduationSemesterId;
    }

    public GraduationYear getGraduationYearId() {
        return graduationYearId;
    }

    public void setGraduationYearId(GraduationYear graduationYearId) {
        this.graduationYearId = graduationYearId;
    }

    public Schools getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Schools schoolId) {
        this.schoolId = schoolId;
    }

    public StudentStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(StudentStatus statusId) {
        this.statusId = statusId;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.Students[ studentId=" + studentId + " ]";
    }
    
}
