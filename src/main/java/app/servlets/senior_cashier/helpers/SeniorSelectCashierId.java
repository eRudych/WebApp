package app.servlets.senior_cashier.helpers;

/**
 * This is a helper class which need to store the value
 */
public class SeniorSelectCashierId {
    private static SeniorSelectCashierId ourInstance = new SeniorSelectCashierId();

    public static SeniorSelectCashierId getInstance() {
        return ourInstance;
    }

    private SeniorSelectCashierId() {

    }

    private int seniorSelectCashierId;

    /**
     * @param seniorSelectCashierId - stored value
     */
    public void setSeniorSelectCashierId(int seniorSelectCashierId) {
        this.seniorSelectCashierId = seniorSelectCashierId;
    }

    /**
     * @return stored value
     */
    public int getSeniorSelectCashierId() {
        return seniorSelectCashierId;
    }
}

