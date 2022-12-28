package aptech.project2.dao;


import aptech.project2.entities.Catalog;
import aptech.project2.entities.Product;
import aptech.project2.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    @Override
    public boolean create(Product pro) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "INSERT INTO product(catalog,name,price,content,discount,imageLink,imageList) VALUES(?,?,?,?,?,?,?)";

        stm = conn.prepareStatement(sql);
        stm.setInt(1, pro.getCatalog().getId());
        stm.setString(2, pro.getName());
        stm.setDouble(3, pro.getPrice());
        stm.setString(4, pro.getContent());
        stm.setFloat(5, pro.getDiscount());
        stm.setString(6, pro.getImageLink());
        stm.setString(7, pro.getImageList());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Product pro) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "UPDATE product SET catalog_id=?, name=?, price=?, content=?, discount=?, imageLink=?, imageList=? WHERE id = ?";

        stm = conn.prepareStatement(sql);
        stm.setInt(1, pro.getCatalog().getId());
        stm.setString(2, pro.getName());
        stm.setDouble(3, pro.getPrice());
        stm.setString(4, pro.getContent());
        stm.setFloat(5, pro.getDiscount());
        stm.setString(6, pro.getImageLink());
        stm.setString(7, pro.getImageList());
        stm.setInt(8, pro.getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean deleteById(int id) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "DELETE FROM product WHERE id = ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public Product findById(int id) throws Exception {
        Product p = new Product();

        conn = DBConnection.getConnection();

        String sql = "SELECT p.id,p.catalog_id,p.name,p.price,p.content,p.discount,p.image_link,p.image_list,c.name AS cname FROM product p JOIN catalog c ON p.catalog_id=c.id WHERE p.id=?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        rs = stm.executeQuery();
        if (rs.next()) {

            p.setId(rs.getInt("id"));
            Catalog cat = new Catalog();

            cat.setId(rs.getInt("catalog_id"));
            cat.setName(rs.getString("cname"));
            p.setCatalog(cat);

            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setContent(rs.getString("content"));
            p.setDiscount(rs.getFloat("discount"));
            p.setImageLink(rs.getString("image_link"));
            p.setImageList(rs.getString("image_list"));
        }
        return p;
    }

    @Override
    public List<Product> findAll() throws Exception {

        List<Product> list = new ArrayList<>();

        conn = DBConnection.getConnection();

        String sql = "SELECT p.id,p.catalog_id,p.name,p.price,p.content,p.discount,p.image_link,p.image_list,c.name AS cname FROM product p JOIN catalog c ON p.catalog_id=c.id";

        stm = conn.prepareStatement(sql);

        rs = stm.executeQuery();
        if (rs.next()) {
            Product p = new Product();

            p.setId(rs.getInt("id"));
            Catalog cat = new Catalog();

            cat.setId(rs.getInt("catalog_id"));
            cat.setName(rs.getString("cname"));
            p.setCatalog(cat);

            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setContent(rs.getString("content"));
            p.setDiscount(rs.getFloat("discount"));
            p.setImageLink(rs.getString("image_link"));
            p.setImageList(rs.getString("image_list"));
            list.add(p);
        }
        return list;

    }

    public Product searchByName(String name) throws Exception {
        Product p = new Product();

        conn = DBConnection.getConnection();

        String sql = "SELECT p.id,p.catalog_id,p.name,p.price,p.content,p.discount,p.image_link,p.image_list,c.name AS cname FROM product p JOIN catalog c ON p.catalog_id=c.id WHERE p.name=?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, name);

        rs = stm.executeQuery();
        if (rs.next()) {

            p.setId(rs.getInt("id"));
            Catalog cat = new Catalog();
            cat.setId(rs.getInt("catalog_id"));
            cat.setName(rs.getString("cname"));
            p.setCatalog(cat);

            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setContent(rs.getString("content"));
            p.setDiscount(rs.getFloat("discount"));
            p.setImageLink(rs.getString("image_link"));
            p.setImageList(rs.getString("image_list"));

        }
        return p;

    }
}
