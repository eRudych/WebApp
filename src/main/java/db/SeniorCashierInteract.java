package db;

public class SeniorCashierInteract {

    public boolean removeCheck(int idCheck, int idCashier) {
        InteractDB.getInstance().addingToDocumentation(3, idCashier, idCheck);
        return InteractDB.getInstance().removeCheck(idCheck);
    }

    public boolean removeProduct(int idCheck, int code, int idCashier) {
        InteractDB.getInstance().addingToDocumentation(4, idCashier, idCheck);
        return InteractDB.getInstance().removeProduct(idCheck, code);
    }
}
