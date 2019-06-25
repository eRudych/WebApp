package log;

import org.apache.log4j.Logger;

/**
 * Logger for the project, records in the file - src/main/resources/log/app.log
 */
public class Logic implements ILogic {
    private static Logic ourInstance = new Logic();

    public static Logic getInstance() {
        return ourInstance;
    }

    private Logic() {
    }

    private static final Logger log = Logger.getLogger((Logic.class));
    ;

    @Override
    public void logInfoMerchandise(String mess) {
        log.info(mess);
    }

    @Override
    public void logErrorMerchandise(Exception ex, String mess) {
        log.error(mess, ex);
    }

    @Override
    public void logUpdateMerchandise(String mess) {
        log.info(mess);
    }

    @Override
    public void logInfoCashier(String mess) {
        log.info(mess);
    }

    @Override
    public void logErrorCashier(Exception ex, String mess) {
        log.error(mess, ex);
    }

    @Override
    public void logUpdateCashier(String mess) {
        log.info(mess);
    }

    @Override
    public void logInfoSeniorCashier(String mess) {
        log.info(mess);
    }

    @Override
    public void logErrorSeniorCashier(Exception ex, String mess) {
        log.error(mess, ex);
    }

    @Override
    public void logUpdateSeniorCashier(String mess) {
        log.info(mess);
    }
}
