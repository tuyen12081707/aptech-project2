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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product.findByDiscount", query = "SELECT p FROM Product p WHERE p.discount = :discount")
    , @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image")
    , @NamedQuery(name = "Product.findByCreatedAt", query = "SELECT p FROM Product p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Product.findByModifedAt", query = "SELECT p FROM Product p WHERE p.modifedAt = :modifedAt")
    , @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {

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
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "discount")
    private int discount;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "modifed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifedAt;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalog catalogId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Orders> ordersCollection;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, int price, int quantity, String content, int discount, String image, Date createdAt, Date modifedAt, short status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.content = content;
        this.discount = discount;
        this.image = image;
        this.createdAt = createdAt;
        this.modifedAt = modifedAt;
        this.status = status;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifedAt() {
        return modifedAt;
    }

    public void setModifedAt(Date modifedAt) {
        this.modifedAt = modifedAt;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Catalog getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Catalog catalogId) {
        this.catalogId = catalogId;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.project2.dao.Product[ id=" + id + " ]";
    }

    public Product(String name, int price, int quantity, String content, int discount, String image, short status, Catalog catalogId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.content = content;
        this.discount = discount;
        this.image = image;
        this.status = status;
        this.catalogId = catalogId;
    }
    
    
    
}
