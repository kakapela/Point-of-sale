package Model;

import java.sql.SQLException;
import java.util.Scanner;

public class InputDevice {

    private static Product product;

    public static void readBarcode(String barcodeInput) throws ClassNotFoundException, SQLException {
        Database.getInstance().connect();
        DisplayState displayState = DisplayState.getInstance();
        int barcode = displayState.validate(barcodeInput);
        ProductDAO productDAO = DAOFactory.getProductDAO();

        product = productDAO.getProduct(barcode);
        if (product == null) displayState.setState("PRODUCT NOT FOUND");
    }

    public static Product getProduct() {
        return product;
    }

}
