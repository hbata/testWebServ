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
@Table(name = "DEEGREE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deegree.findAll", query = "SELECT d FROM Deegree d")
    , @NamedQuery(name = "Deegree.findByDegreeId", query = "SELECT d FROM Deegree d WHERE d.degreeId = :degreeId")
    , @NamedQuery(name = "Deegree.findByDegreeName", query = "SELECT d FROM Deegree d WHERE d.degreeName = :degreeName")})
public class Deegree implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEGREE_ID")
    private BigDecimal degreeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEGREE_NAME")
    private String degreeName;
    @OneToMany(mappedBy = "degreeId")
    private Collection<Students> studentsCollection;

    public Deegree() {
    }

    public Deegree(BigDecimal degreeId) {
        this.degreeId = degreeId;
    }

    public Deegree(BigDecimal degreeId, String degreeName) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
    }

    public BigDecimal getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(BigDecimal degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
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
        hash += (degreeId != null ? degreeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deegree)) {
            return false;
        }
        Deegree other = (Deegree) object;
        if ((this.degreeId == null && other.degreeId != null) || (this.degreeId != null && !this.degreeId.equals(other.degreeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.Deegree[ degreeId=" + degreeId + " ]";
    }
    
}
