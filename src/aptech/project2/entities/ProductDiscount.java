/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.entities;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ProductDiscount {
    
    private int id;
    private int discountId;
    private Product product;
    private float discountPercentage;
    private Date startDate;
    private Date endDate;

    public ProductDiscount() {

    }

    public ProductDiscount(int id) {
        this.id = id;
    }

    public ProductDiscount(int id, int discountId, Product product, float discount, Date startDate, Date endDate) {
        this.id = id;
        this.discountId = discountId;
        this.product = product;
        this.discountPercentage = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the discountId
     */
    public int getDiscountId() {
        return discountId;
    }

    /**
     * @param discountId the discountId to set
     */
    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the discountPercentage
     */
    public float getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * @param discount the discountPercentage to set
     */
    public void setDiscountPercentage(float discount) {
        this.discountPercentage = discount;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
