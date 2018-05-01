import model.devices.input.InputDevice;
import model.devices.output.LCDDisplay;
import model.product.ListOfProducts;
import model.product.Product;
import model.product.ProductStates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayStateTest {
    private ProductStates state;
    private Product product;
    private String message,actualMessage;
    private LCDDisplay lcdDisplay;
    @Before
    public void setUp() throws Exception {
        product=new Product(1234,"bread",2.3);
        InputDevice.scanBarcode("1234");
        lcdDisplay =new LCDDisplay();

    }

    @Test
    public void shouldShowProductInfo(){
        state=ProductStates.PRODUCT_FOUND;


        message = lcdDisplay.showMessage();

        actualMessage="Product: " + product.getName() +"\n"+ " Price: " +String.valueOf(product.getPrice());
        assertEquals("This message should show info about product",actualMessage,message);
    }
    @Test
    public void shouldShowProductNotFoundInfo(){
        state=ProductStates.PRODUCT_NOT_FOUND;

        message = lcdDisplay.showMessage();

        actualMessage="PRODUCT NOT FOUND";
        assertEquals("This message should show product not found info",actualMessage,message);
    }
    @Test
    public void shouldShowInvalidBarcodeInfo(){
        state=ProductStates.PRODUCT_NOT_FOUND;

        message = lcdDisplay.showMessage();

        actualMessage="INVALID BARCODE";
        assertEquals("This message should show invalid barcode info",actualMessage,message);
    }


}