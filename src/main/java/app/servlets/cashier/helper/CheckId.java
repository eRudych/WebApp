package app.servlets.cashier.helper;

/**
 * This is a helper class which need to store the value
 */
public class CheckId{
    private static CheckId ourInstance = new CheckId();

    public static CheckId getInstance() {
        return ourInstance;
    }

    private CheckId() {

    }

    private int checkId;

    /**
     * @param checkId- stored value
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
