/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.entities;

/**
 * @author Admin
 */
public class Product extends BaseEntity {
    //image_link: lưu link file ảnh minh họa cho sản phẩm
    //image_list: lưu danh sách link file ảnh kèm theo cho sản phẩm
    private int id;
    private Catalog catalog;
    private String name;
    private double price;
    private String content;
    private float discount;
    private String imageLink;
    private String imageList;
    private int view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }


}
