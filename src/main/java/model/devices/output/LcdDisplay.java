package model.devices.output;

import model.devices.input.InputDevice;
import model.product.Product;
import model.product.ProductStates;

public class LcdDisplay {

    private ProductStates state;

    private String message;
    private String name;
    private double price;

    public String showMessage(){

        state=DisplayState.getInstance().state;
        switch (state){
            case PRODUCT_FOUND:
                Product product = InputDevice.getCurrentProduct();
                message="PRODUCT: " + product.getName() + " PRICE: " +String.valueOf(product.getPrice());
                break;
            case INVALID_BARCODE: message="INVALID BARCODE";
                    break;
            case PRODUCT_NOT_FOUND:message="PRODUCT NOT FOUND";break;
        }
        return  message;

    }

}
