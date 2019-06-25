package app.servlets.cashier;

import log.cashier.LogicCashier;

import javax.servlet.http.HttpServlet;

public abstract class FunctionalCashier extends HttpServlet {
    private static LogicCashier logic = new LogicCashier();

    public static LogicCashier getLogic() {
        return logic;
    }

    /**
     * This is a helper class which need to store the value
     */
    public static class CheckId{
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

    /**
     * This is a helper class which need to store the value
     */
    public static class SelectCashierId {
        private static SelectCashierId ourInstance = new SelectCashierId();

        public static SelectCashierId getInstance() {
            return ourInstance;
        }

        private SelectCashierId() {

        }

        private int selectCashierId;

        /**
         * @param selectCashierId - stored value
         */
        public void setSelectCashierId(int selectCashierId) {
            this.selectCashierId = selectCashierId;
        }

        /**
         * @return stored value
         */
        public int getSelectCashierId() {
            return selectCashierId;
        }
    }
}
