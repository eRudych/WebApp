package app.servlets.senior_cashier.helpers;

/**
 * This is a helper class which need to store the value
 */
public class ProductCode {
    private static ProductCode ourInstance = new ProductCode();

    public static ProductCode getInstance() {
        return ourInstance;
    }

    private ProductCode() {

    }

    private int productCode;

    /**
     * @param productCode - stored value
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    /**
     * @return stored value
     */
    public int getProductCode() {
        return productCode;
    }
}
