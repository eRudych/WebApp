package db.merchandise;

import app.entities.Product;
import app.models.ProductList;
import db.InteractDB;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSet;

public class MerchandiseInteract {
    public void addProduct(Product product){
        InteractDB.getInstance().addProduct(product);
    }
    public void setQuantity(int amount, int code){
        InteractDB.getInstance().setQuantity(amount,code);
    }
    public ResultSet allProducts(){ return InteractDB.getInstance().allProducts();}
}
