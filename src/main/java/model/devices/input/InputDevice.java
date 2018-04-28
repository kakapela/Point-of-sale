package model.devices.input;

import model.devices.output.DisplayState;
import model.dao.DAOFactory;
import model.dao.Database;
import model.dao.ProductDAO;
import model.product.ListOfProducts;
import model.product.Product;
import model.product.ProductStates;

import java.sql.SQLException;

public class InputDevice {

    private static Product product;

    public static void readBarcode(String barcodeInput) throws ClassNotFoundException, SQLException {
        Database.getInstance().connect();
        DisplayState displayState = DisplayState.getInstance();
        int barcode = displayState.validate(barcodeInput);
        ProductDAO productDAO = DAOFactory.getProductDAO();

        product = productDAO.getProduct(barcode);
        if(product == null) DisplayState.getInstance().setState(ProductStates.PRODUCT_NOT_FOUND);
        else
        ListOfProducts.getInstance().add(product);
    }

    public static Product getCurrentProduct() {
        return product;
    }

}
