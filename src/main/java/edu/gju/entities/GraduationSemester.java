/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hesham
 */
@Entity
@Table(name = "GRADUATION_SEMESTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraduationSemester.findAll", query = "SELECT g FROM GraduationSemester g")
    , @NamedQuery(name = "GraduationSemester.findByGraduationSemesterId", query = "SELECT g FROM GraduationSemester g WHERE g.graduationSemesterId = :graduationSemesterId")
    , @NamedQuery(name = "GraduationSemester.findBySemesterName", query = "SELECT g FROM GraduationSemester g WHERE g.semesterName = :semesterName")})
public class GraduationSemester implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRADUATION_SEMESTER_ID")
    private BigDecimal graduationSemesterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SEMESTER_NAME")
    private String semesterName;
    @OneToMany(mappedBy = "graduationSemesterId")
    private Collection<Students> studentsCollection;

    public GraduationSemester() {
    }

    public GraduationSemester(BigDecimal graduationSemesterId) {
        this.graduationSemesterId = graduationSemesterId;
    }

    public GraduationSemester(BigDecimal graduationSemesterId, String semesterName) {
        this.graduationSemesterId = graduationSemesterId;
        this.semesterName = semesterName;
    }

    public BigDecimal getGraduationSemesterId() {
        return graduationSemesterId;
    }

    public void setGraduationSemesterId(BigDecimal graduationSemesterId) {
        this.graduationSemesterId = graduationSemesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (graduationSemesterId != null ? graduationSemesterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GraduationSemester)) {
            return false;
        }
        GraduationSemester other = (GraduationSemester) object;
        if ((this.graduationSemesterId == null && other.graduationSemesterId != null) || (this.graduationSemesterId != null && !this.graduationSemesterId.equals(other.graduationSemesterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.GraduationSemester[ graduationSemesterId=" + graduationSemesterId + " ]";
    }
    
}
