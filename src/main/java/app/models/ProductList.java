package app.models;

import app.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductList {
    private static ProductList instance = new ProductList();
    private List<Product> productList;

    public static ProductList getInstance() {
        return instance;
    }

    public ProductList() {
        productList = new ArrayList<>();
    }

    public boolean add(Product product) {
        return productList.add(product);
    }

    public List<Product> getList() {
        return  productList;
    }
}
