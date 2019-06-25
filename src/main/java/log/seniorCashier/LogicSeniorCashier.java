package log.seniorCashier;

import log.Logic;

public class LogicSeniorCashier implements ILogicSeniorCashier {
    @Override
    public void logInfo(String mess) {
        Logic.getInstance().logInfoSeniorCashier("SENIOR_CASHIER_INFO:" + mess);
    }

    @Override
    public void logError(String mess, Exception ex) {
        Logic.getInstance().logErrorSeniorCashier(ex, "SENIOR_CASHIER_ERROR" + mess);
    }

    @Override
    public void logUpdate(String mess) {
        Logic.getInstance().logUpdateSeniorCashier("SENIOR_CASHIER_UPDATE:" + mess);
    }
}
