

import model.devices.output.Printer;
import model.product.ListOfProducts;
import model.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrinterTest {
    private List<Product> products;
    private Product product1,product2,product3;
    @Before
    public void setUp() throws Exception {
         product1 = new Product(1234,"bread",1.22);
         product2 = new Product(1235,"water",1.16);
         product3 = new Product(1236,"tea",3.09);

        ListOfProducts.getInstance().add(product1);
        ListOfProducts.getInstance().add(product2);
        ListOfProducts.getInstance().add(product3);

    }

    @Test
    public void printTotalSum() throws Exception {


        products=ListOfProducts.getInstance().getAll();
        Printer printer=new Printer();

        String totalSum = printer.printTotalSum().replace(",", ".");
        String tempSum = String.valueOf(product1.getPrice()+product2.getPrice()+product3.getPrice());

        assertEquals("These should check if sum is correct",tempSum,totalSum);
    }

}