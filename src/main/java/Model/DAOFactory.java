package Model;

//Static factory design pattern for creating new Products
public class DAOFactory {
    public static ProductDAO getProductDAO(){
        return new ProductDAO();
    }
}
