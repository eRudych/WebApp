package app.entities.employees;

/**
 * Factory for cashiers
 * in the database there are values:
 *
 * new Cashier(Vasya,0)
 * new Cashier(Dasha,0)
 *  new SeniorCashier(Tom,1)
 */
public class FactoryCashier {
    public static CashEmployee getCashEmployee(String name, boolean seniorPosition) {
        if (seniorPosition) {
            return new Cashier(name);
        } else {
            return new SeniorCashier(name);
        }
    }
}
