
import model.dao.Database;
import model.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

public class ProductDaoImplTest {
   private Connection connection;
    @Before
    public void setUp() throws Exception {
       Database.getInstance().connect();
    }

    @After
    public void tearDown() throws Exception {
    Database.getInstance().disconnect();
    }

    @Test
    public void getProduct() throws Exception {

        Product product = new Product(74017816, "butter",1.15);
        Product productDAO=null;

        connection=Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String sql = "select name,price from products where barcode=74017816";
        ResultSet results = statement.executeQuery(sql);

        if (results.next()) {
            String name = results.getString("name");
            Double price = results.getDouble("price");
           productDAO = new Product(74017816,name, price);
        }

        assertEquals("These products should have the same barcode", product.getBarcode(),productDAO.getBarcode() );
        assertEquals("These products should have the same name", product.getName(),productDAO.getName() );
        assertEquals(product.getPrice(),productDAO.getPrice(),0.01 );


    }

}