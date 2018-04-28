/*
package Model;
//TESTING CLASS

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try



        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists products");
            statement.executeUpdate("create table products (barcode integer PRIMARY KEY UNIQUE not null, name string not null, price DOUBLE not null)");
            statement.executeUpdate("insert into products values(96363533, 'bread',1.88)");
            statement.executeUpdate("insert into products values(74017816, 'butter',1.15)");
            statement.executeUpdate("insert into products values(17350415, 'milk',2.15)");
            statement.executeUpdate("insert into products values(50486750, 'yogurt',1.05)");
            statement.executeUpdate("insert into products values(63529719, 'meat',5.05)");
            statement.executeUpdate("insert into products values(33010091, 'corn-flakes',3.05)");
            statement.executeUpdate("insert into products values(56218217, 'water',2.21)");
            ResultSet rs = statement.executeQuery("select * from products");
            while(rs.next())
            {
                // read the result set
                System.out.println("");
                System.out.println("barcode = " + rs.getInt("barcode"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("price = " + rs.getDouble("price"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}

*/