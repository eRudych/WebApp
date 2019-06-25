package app.servlets.cashier.functional;

import app.servlets.cashier.FunctionalCashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseCheck  extends FunctionalCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("CloseCheck doGet");
        req.setAttribute("id", FunctionalCashier.CheckId.getInstance().getCheckId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/close_check.jsp");
        requestDispatcher.forward(req, resp);
    }
}


