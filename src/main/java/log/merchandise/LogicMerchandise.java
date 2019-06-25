package log.merchandise;

import log.Logic;

public class LogicMerchandise implements ILogicMerchandise {

    @Override
    public void logInfo(String mess) {
        Logic.getInstance().logInfoMerchandise("MERCHANDISE_INFO:" + mess);
    }

    @Override
    public void logError(String mess, Exception ex) {
        Logic.getInstance().logErrorMerchandise(ex, "MERCHANDISE_ERROR" + mess);
    }

    @Override
    public void logUpdate(String mess) {
        Logic.getInstance().logUpdateMerchandise("MERCHANDISE_UPDATE:" + mess);
    }
}
