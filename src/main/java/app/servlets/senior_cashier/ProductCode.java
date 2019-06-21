package app.servlets.senior_cashier;

public class ProductCode {
    private static ProductCode ourInstance = new ProductCode();

    public static ProductCode getInstance() {
        return ourInstance;
    }

    private ProductCode() {

    }
    private int productCode;

    public void setProductCode(int productCode){
        this.productCode=productCode;
    }
    public int getProductCode(){
        return productCode;
    }
}
