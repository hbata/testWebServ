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
@Table(name = "GENDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g")
    , @NamedQuery(name = "Gender.findByGenderId", query = "SELECT g FROM Gender g WHERE g.genderId = :genderId")
    , @NamedQuery(name = "Gender.findByGenderName", query = "SELECT g FROM Gender g WHERE g.genderName = :genderName")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENDER_ID")
    private BigDecimal genderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENDER_NAME")
    private String genderName;
    @OneToMany(mappedBy = "genderId")
    private Collection<Students> studentsCollection;

    public Gender() {
    }

    public Gender(BigDecimal genderId) {
        this.genderId = genderId;
    }

    public Gender(BigDecimal genderId, String genderName) {
        this.genderId = genderId;
        this.genderName = genderName;
    }

    public BigDecimal getGenderId() {
        return genderId;
    }

    public void setGenderId(BigDecimal genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
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
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.Gender[ genderId=" + genderId + " ]";
    }
    
}
