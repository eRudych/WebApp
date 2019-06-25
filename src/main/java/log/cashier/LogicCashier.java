package log.cashier;

        import log.Logic;

public class LogicCashier implements ILogicCashier {

    @Override
    public void logInfo(String mess) {
        Logic.getInstance().logInfoCashier("CASHIER_INFO:" + mess);
    }

    @Override
    public void logError(String mess, Exception ex) {
        Logic.getInstance().logErrorCashier(ex, "CASHIER_ERROR" + mess);
    }

    @Override
    public void logUpdate(String mess) {
        Logic.getInstance().logUpdateCashier("CASHIER_UPDATE:" + mess);
    }
}
