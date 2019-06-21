package log;

import org.apache.log4j.Logger;

public class BdLogic {
    // Инициализация логера
    private static final Logger log = Logger.getLogger(String.valueOf(BdLogic.class));

    public void doConnectToBd(){
        log.info("Происходит подключение к бд");
    }

    public void successfulConnectionToBd() {
        log.info("Подключено");
    }

    public void unsuccessfulConnectionToBd(Exception exception) {
        log.info("Не подлючено");
        showException(exception);
    }

    public void successfulUpdateBd(){
        log.info("Бд изменена");
    }

    public void unsuccessfulUpdateBd(Exception exception){
        log.info("Бд не изменена");
        showException(exception);
    }

    public void webPageException(String className,Exception exception){
        log.trace(className+":",exception);

    }

    public void showException(Exception exception){
        log.error(exception);
    }

}