package app.entities.employees;

public class FactoryCashier {
    public static CashEmployee getCashEmployee(String name, boolean seniorPosition) {
        if (seniorPosition) {
            return new Cashier(name);
        } else {
            return new SeniorCashier(name);
        }
    }
}
