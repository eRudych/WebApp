package db.specific.interactions;

import db.InteractDB;

public class CashierInteract {
    public int createCheck(int idCashier) {

        int idCheck = InteractDB.getInstance().createCheck(idCashier);
        InteractDB.getInstance().addingToDocumentation(1, idCashier, idCheck);
        return idCheck;
    }

    public boolean addProduct(int code, int amount, int idCheck, int idCashier) {
        InteractDB.getInstance().addingToDocumentation(2, idCashier, idCheck);
        return InteractDB.getInstance().addProduct(code, amount, idCheck);
    }

    public boolean addProduct(String name, int amount, int idCheck, int idCashier) {
        InteractDB.getInstance().addingToDocumentation(2, idCashier, idCheck);
        return InteractDB.getInstance().addProduct(name, amount, idCheck);
    }

    public int getMaxIdForChecks() {
        return InteractDB.getInstance().getMaxIdForChecks();
    }
}
