/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DQT
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id")
    , @NamedQuery(name = "Transaction.findByAction", query = "SELECT t FROM Transaction t WHERE t.action = :action")
    , @NamedQuery(name = "Transaction.findByMessage", query = "SELECT t FROM Transaction t WHERE t.message = :message")
    , @NamedQuery(name = "Transaction.findByCreatedAt", query = "SELECT t FROM Transaction t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "Transaction.findByModifedAt", query = "SELECT t FROM Transaction t WHERE t.modifedAt = :modifedAt")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "action")
    private short action;
    @Basic(optional = false)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "modifed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifedAt;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orders orderId;

    public Transaction() {
    }

    public Transaction(Long id) {
        this.id = id;
    }

    public Transaction(Long id, short action, String message, Date createdAt, Date modifedAt) {
        this.id = id;
        this.action = action;
        this.message = message;
        this.createdAt = createdAt;
        this.modifedAt = modifedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getAction() {
        return action;
    }

    public void setAction(short action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.project2.dao.Transaction[ id=" + id + " ]";
    }
    
}
