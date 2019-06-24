package app.servlets.senior_cashier.helpers;

/**
 * This is a helper class which need to store the value
 */
public class SelectCheckId {
    private static SelectCheckId ourInstance = new SelectCheckId();

    public static SelectCheckId getInstance() {
        return ourInstance;
    }

    private SelectCheckId() {

    }

    private int checkId;

    /**
     * @param checkId - stored value
     */
    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    /**
     * @return stored value
     */
    public int getCheckId() {
        return checkId;
    }
}
