package app.servlets.senior_cashier.functional.cancel.check;

import app.servlets.senior_cashier.FunctionalSeniorCashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class "selects" check for the remove
 */
public class SelectCheck extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectCheck doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_check.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * check - (checkId) user selects
     * storages the value of the checkId in the class {@link app.servlets.senior_cashier.FunctionalSeniorCashier.SelectCheckId}
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FunctionalSeniorCashier.SelectCheckId.getInstance().setCheckId(Integer.parseInt(req.getParameter("check")));
            doGetAfterPost(req, resp);
        } catch (Exception ex) {
            //getLogic().logError("SelectCheck",ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_check.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectCheck completed");
        resp.sendRedirect("/cancel_check");
    }

}