package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public Product getProduct(int barcode) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        String sql = "select name,price from products where barcode=? order by name";
        PreparedStatement selectStatement = conn.prepareStatement(sql);

        selectStatement.setInt(1, barcode);

        ResultSet results = selectStatement.executeQuery();

        Product product = null;

        if (results.next()) {
            String name = results.getString("name");
            Double price = results.getDouble("price");
            product = new Product(barcode, name, price);
        }
        results.close();
        selectStatement.close();
        return product;
    }

}
