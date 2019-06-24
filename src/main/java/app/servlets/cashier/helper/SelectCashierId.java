package app.servlets.cashier.helper;


    /**
     * This is a helper class which need to store the value
     */
    public class SelectCashierId {
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

