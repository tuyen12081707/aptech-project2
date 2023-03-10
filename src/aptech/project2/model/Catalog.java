/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DQT
 */
@Entity
@Table(name = "catalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalog.findAll", query = "SELECT c FROM Catalog c")
    , @NamedQuery(name = "Catalog.findById", query = "SELECT c FROM Catalog c WHERE c.id = :id")
    , @NamedQuery(name = "Catalog.findByName", query = "SELECT c FROM Catalog c WHERE c.name = :name")
    , @NamedQuery(name = "Catalog.findByCreateAt", query = "SELECT c FROM Catalog c WHERE c.createAt = :createAt")
    , @NamedQuery(name = "Catalog.findByModifedAt", query = "SELECT c FROM Catalog c WHERE c.modifedAt = :modifedAt")})
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Basic(optional = false)
    @Column(name = "modifed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogId")
    private Collection<Product> productCollection;

    public Catalog() {
    }

    public Catalog(Integer id) {
        this.id = id;
    }

    public Catalog(Integer id, String name, Date createAt, Date modifedAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.modifedAt = modifedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifedAt() {
        return modifedAt;
    }

    public void setModifedAt(Date modifedAt) {
        this.modifedAt = modifedAt;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalog)) {
            return false;
        }
        Catalog other = (Catalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.project2.dao.Catalog[ id=" + id + " ]";
    }
    
}
