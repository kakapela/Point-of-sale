package model.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListOfProducts {

    private static ListOfProducts instance = new ListOfProducts();
    private final List<Product> products = new ArrayList<>();
    private Double sum=0.0;

    private ListOfProducts(){}

    public static ListOfProducts getInstance() {
        return instance;
    }

    public void add(Product product) {
        products.add(product);
        sum+=product.getPrice();
    }
    public Double getSum() {
        return sum;
    }

    public List<Product> getAll() {
        return products;
    }


}