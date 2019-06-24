package db;

import app.entities.Product;

import java.sql.ResultSet;

public interface Interact {
     boolean addProduct(Product product);
     boolean setQuantity(int amount, int code);
     int createCheck(int idCashier);
     void addProduct(int code, int amount, int id);
     void addProduct(String name, int amount, int id);
     int getMaxIdForChecks();
     void selectSeniorCashier(int id);
     void addingToDocumentation(int numberOperation);
     void removeCheck(int idCheck);
}
