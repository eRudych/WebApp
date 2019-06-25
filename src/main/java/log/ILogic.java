package log;

/**
 * Interface for {@link Logic}
 */
public interface ILogic {
    void logInfoMerchandise(String mess);

    void logErrorMerchandise(Exception ex, String mess);

    void logUpdateMerchandise(String mess);

    void logInfoCashier(String mess);

    void logErrorCashier(Exception ex, String mess);

    void logUpdateCashier(String mess);

    void logInfoSeniorCashier(String mess);

    void logErrorSeniorCashier(Exception ex, String mess);

    void logUpdateSeniorCashier(String mess);
}
