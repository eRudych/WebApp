package db;

import app.entities.Product;

public interface Interact {
     void addProduct(Product product);
     void remove(Object o);
     void update(Object o);
     void select(Object o);
     void setQuantity(int amount, int code);
     int createCheck(int idCashier);
     void addProduct(int code, int amount, int id);
     void addProduct(String name, int amount, int id);
     int getMaxIdForChecks();
     void selectSeniorCashier(int id);
     void addingToDocumentation(int numberOperation);
     void removeCheck(int idCheck);
}
