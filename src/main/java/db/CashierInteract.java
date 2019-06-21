package db;

public class CashierInteract {
    public int createCheck(int idCashier){
        return InteractDB.getInstance().createCheck(idCashier);
    }
    public void addProduct(int code, int amount, int id){ InteractDB.getInstance().addProduct(code,amount,id);}
    public  void addProduct(String name, int amount, int id){ InteractDB.getInstance().addProduct(name,amount,id);}
    public int getMaxIdForChecks(){return InteractDB.getInstance().getMaxIdForChecks();}
}
