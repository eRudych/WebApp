package app.servlets.merchandise;

import log.merchandise.LogicMerchandise;

import javax.servlet.http.HttpServlet;

public abstract class FunctionalMerchandise extends HttpServlet {
    private static LogicMerchandise logic = new LogicMerchandise();

    public static LogicMerchandise getLogic() {
        return logic;
    }
}
