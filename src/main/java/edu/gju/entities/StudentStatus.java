/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.entities;

import java.io.Serializable;
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
@Table(name = "STUDENT_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentStatus.findAll", query = "SELECT s FROM StudentStatus s")
    , @NamedQuery(name = "StudentStatus.findByStatusId", query = "SELECT s FROM StudentStatus s WHERE s.statusId = :statusId")
    , @NamedQuery(name = "StudentStatus.findByStatusName", query = "SELECT s FROM StudentStatus s WHERE s.statusName = :statusName")})
public class StudentStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STATUS_ID")
    private String statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "STATUS_NAME")
    private String statusName;
    @OneToMany(mappedBy = "statusId")
    private Collection<Students> studentsCollection;

    public StudentStatus() {
    }

    public StudentStatus(String statusId) {
        this.statusId = statusId;
    }

    public StudentStatus(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentStatus)) {
            return false;
        }
        StudentStatus other = (StudentStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gju.entities.StudentStatus[ statusId=" + statusId + " ]";
    }
    
}
