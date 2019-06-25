package log.cashier;

public interface ILogicCashier {
    void logInfo(String mess);

    void logError(String mess, Exception ex);

    void logUpdate(String mess);
}
