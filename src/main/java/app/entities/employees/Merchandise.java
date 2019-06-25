package app.entities.employees;

import app.entities.Product;

import java.util.LinkedList;
import java.util.List;

public class Merchandise {
    private static Merchandise ourInstance = new Merchandise();
    private List<Product> productList = new LinkedList<Product>();
    public static Merchandise getInstance() {
        return ourInstance;
    }

    private Merchandise() {
    }
}
