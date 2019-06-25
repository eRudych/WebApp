package log.merchandise;

public interface ILogicMerchandise {
    void logInfo(String mess);
    void logError(String mess, Exception ex);
    void logUpdate(String mess);
}
