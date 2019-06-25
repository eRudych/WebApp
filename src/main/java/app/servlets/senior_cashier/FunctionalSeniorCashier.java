package app.servlets.senior_cashier;

import log.seniorCashier.LogicSeniorCashier;

import javax.servlet.http.HttpServlet;

public abstract class FunctionalSeniorCashier extends HttpServlet {
    private static LogicSeniorCashier logic = new LogicSeniorCashier();

    public static LogicSeniorCashier getLogic() {
        return logic;
    }

    /**
     * This is a helper class which need to store the value
     */
    public static class ProductCode {
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

    /**
     * This is a helper class which need to store the value
     */
    public static class SelectCheckId {
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

    /**
     * This is a helper class which need to store the value
     */
    public static class SeniorSelectCashierId {
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
}
