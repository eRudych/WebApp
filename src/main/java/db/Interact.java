package db;

import app.entities.Product;
import app.models.ProductList;

import java.sql.ResultSet;

/**
 * Interface for working with DB
 */
public interface Interact {
    boolean addProduct(Product product);

    boolean setQuantity(int amount, int code);

    int createCheck(int idCashier);

    boolean addProduct(ResultSet resultSet, int code, int amount, int id);

    ProductList allProducts();

    boolean addProduct(int code, int amount, int id);

    boolean addProduct(String name, int amount, int id);

    int getMaxIdForChecks();

    void selectSeniorCashier(int id);

    boolean addingToDocumentation(int numberOperation, Integer idCashier, Integer idCheck);

    boolean removeCheck(int idCheck);

    boolean removeProduct(int idCheck, int idProduct);
}
