package app.models;

import app.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductList {
    private static ProductList instance = new ProductList();
    private List<Product> productList;

    public static ProductList getInstance() {
        return instance;
    }

    private ProductList() {
        productList = new ArrayList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<String> list() {
        return productList.stream()
                .map(Product::toString)
                .collect(Collectors.toList());
    }
}
