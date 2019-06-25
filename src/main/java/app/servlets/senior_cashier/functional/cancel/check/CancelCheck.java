package app.servlets.senior_cashier.functional.cancel.check;

import app.servlets.senior_cashier.FunctionalSeniorCashier;
import db.specific.interactions.SeniorCashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is needed to view  /cancel_check
 */
public class CancelCheck extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("CancelCheck doGet");
        new SeniorCashierInteract().removeCheck(FunctionalSeniorCashier.SelectCheckId.getInstance().getCheckId(), FunctionalSeniorCashier.SeniorSelectCashierId.getInstance().getSeniorSelectCashierId());
        req.setAttribute("check", FunctionalSeniorCashier.SelectCheckId.getInstance().getCheckId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/cancel_check.jsp");
        requestDispatcher.forward(req, resp);
    }
}
