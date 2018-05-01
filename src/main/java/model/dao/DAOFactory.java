package model.dao;

//Static factory design pattern for creating new Products
public class DAOFactory {
    public static ProductDaoImpl getProductDAO() {
        return new ProductDaoImpl();
    }
}
