package db.merchandise;

import app.entities.Product;
import db.InteractDB;

public class MerchandiseInteract {
    public void addProduct(Product product){
        InteractDB.getInstance().addProduct(product);
    }
    public void setQuantity(int amount, int code){
        InteractDB.getInstance().setQuantity(amount,code);
    }
}
