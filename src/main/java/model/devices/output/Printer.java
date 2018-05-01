package model.devices.output;

import model.product.ListOfProducts;
import model.product.Product;

import java.util.List;

public class Printer {

    private List<Product> products;
    private String productList = "";
    private String name;
    private String price;
    private String sum;

    public String printProductList() {
        products = ListOfProducts.getInstance().getAll();

        if (products == null || products.isEmpty())
            return productList = "List of Products is empty";
        else {
            for (Product product : products) {
                name = product.getName();
                price = String.valueOf(product.getPrice());
                productList += "Product:  " + name + "\t\t" + " Price:  " + price + "\n";
            }
            return productList;
        }
    }

    public String printTotalSum() {
        double sum = ListOfProducts.getInstance().getSum();
        String result = String.format("%.2f", sum);
        return result;
    }


}
