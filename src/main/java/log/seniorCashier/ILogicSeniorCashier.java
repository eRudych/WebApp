package log.seniorCashier;

public interface ILogicSeniorCashier {
    void logInfo(String mess);

    void logError(String mess, Exception ex);

    void logUpdate(String mess);
}
