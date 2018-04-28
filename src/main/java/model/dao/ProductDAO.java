package model.dao;

import model.product.Product;

import java.sql.SQLException;

public interface ProductDAO {
    Product getProduct(int barcode) throws SQLException;
}
