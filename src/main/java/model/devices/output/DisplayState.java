package model.devices.output;

import model.product.ProductStates;

public class DisplayState {
    ProductStates state;
    private static DisplayState instance = new DisplayState();

    private DisplayState() {
    }

    public static DisplayState getInstance() {
        return instance;
    }

    public ProductStates getState() {
        return state;
    }

    public void setState(ProductStates state) {
        this.state = state;
    }

    public int validate(String barcode) {
        int barcodeResult = 0;
        if (barcode.isEmpty()) {
            state = ProductStates.INVALID_BARCODE;
            return barcodeResult;
        } else if (!(barcode.matches("[0-9]+"))) {
            state = ProductStates.PRODUCT_NOT_FOUND;
            return barcodeResult;
        } else if (barcode.toUpperCase().matches("EXIT")) {
            state = ProductStates.EXIT;
            return barcodeResult;
        } else {
            barcodeResult = Integer.parseInt(barcode);
            state = ProductStates.PRODUCT_FOUND;
            return barcodeResult;

        }
    }
}