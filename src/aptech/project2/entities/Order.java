/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.entities;

/**
 *
 * @author Admin
 */
public class Order {
    private int id;
    private Transaction transaction;
    private Product product;
    private int Quantity;
    private float amount;
    private String data;
    private int status;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Order(int id, Transaction transaction, Product product, int Quantity, float amount, String data, int status) {
        this.id = id;
        this.transaction = transaction;
        this.product = product;
        this.Quantity = Quantity;
        this.amount = amount;
        this.data = data;
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", transaction=" + transaction + ", product=" + product + ", Quantity=" + Quantity + ", amount=" + amount + ", data=" + data + ", status=" + status + '}';
    }
    
}
