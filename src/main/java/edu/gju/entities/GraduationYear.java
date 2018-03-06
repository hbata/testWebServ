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
@Table(name = "GRADUATION_YEAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraduationYear.findAll", query = "SELECT g FROM GraduationYear g")
    , @NamedQuery(name = "GraduationYear.findByGraduationYearId", query = "SELECT g FROM GraduationYear g WHERE g.graduationYearId = :graduationYearId")
    , @NamedQuery(name = "GraduationYear.findByYearName", query = "SELECT g FROM GraduationYear g WHERE g.yearName = :yearName")})
public class GraduationYear implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRADUATION_YEAR_ID")
    private BigDecimal graduationYearId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "YEAR_NAME")
    private String yearName;
    @OneToMany(mappedBy = "graduationYearId")
    private Collection<Students> studentsCollection;

    public GraduationYear() {
    }

    public GraduationYear(BigDecimal graduationYearId) {
        this.graduationYearId = graduationYearId;
    }

    public GraduationYear(BigDecimal graduationYearId, String yearName) {
        this.graduationYearId = graduationYearId;
        this.yearName = yearName;
    }

    public BigDecimal getGraduationYearId() {
        return graduationYearId;
    }

    public void setGraduationYearId(BigDecimal graduationYearId) {
        this.graduationYearId = graduationYearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
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
        hash += (graduationYearId != null ? graduationYearId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GraduationYear)) {
            return false;
        }
        GraduationYear other = (GraduationYear) object;
        if ((this.graduationYearId == null && other.graduationYearId != null) || (this.graduationYearId != null && !this.graduationYearId.equals(other.graduationYearId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.GraduationYear[ graduationYearId=" + graduationYearId + " ]";
    }
    
}
