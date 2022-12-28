package aptech.project2.dao;

import aptech.project2.entities.Catalog;
import aptech.project2.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DQT
 */
public class CatalogDAO implements ICatalogDAO {
    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    @Override
    public boolean create(Catalog cat) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "INSERT INTO catalog(name) VALUES(?)";

        stm = conn.prepareStatement(sql);
        stm.setString(1, cat.getName());

        return stm.executeUpdate() > 0;

    }

    @Override
    public boolean update(Catalog cat) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "UPDATE catalog SET name = ? WHERE id = ?";

        stm = conn.prepareStatement(sql);
        stm.setString(1, cat.getName());
        stm.setString(2, cat.getName());

        return stm.executeUpdate() > 0;

    }

    @Override
    public boolean deleteById(int id) throws Exception {

        conn = DBConnection.getConnection();

        String sql = "DELETE FROM catalog WHERE id = ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public Catalog findById(int id) throws Exception {
        conn = DBConnection.getConnection();

        Catalog cat = new Catalog();

        String sql = "SELECT * FROM catalog WHERE id = ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        rs = stm.executeQuery();
        if (rs.next()) {
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));

        }
        return cat;

    }

    @Override
    public List<Catalog> findAll() throws Exception {
        List<Catalog> list = new ArrayList<>();

        conn = DBConnection.getConnection();

        String sql = "SELECT * FROM catalog ";
        stm = conn.prepareStatement(sql);

        rs = stm.executeQuery();
        if (rs.next()) {
            Catalog cat = new Catalog();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));

            list.add(cat);

        }
        return list;
    }
}
