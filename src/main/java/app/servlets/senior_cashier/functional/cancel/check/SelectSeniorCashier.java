package app.servlets.senior_cashier.functional.cancel.check;

import app.servlets.senior_cashier.FunctionalSeniorCashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class "selects" SeniorCashier
 */
public class SelectSeniorCashier extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectSeniorCashier doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_senior_cashier.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idCashier = Integer.parseInt(req.getParameter("idCashier"));
            FunctionalSeniorCashier.SeniorSelectCashierId.getInstance().setSeniorSelectCashierId(idCashier);
            doGetAfterPost(req, resp);
        } catch (Exception ex) {
            //getLogic().logError("SelectSeniorCashier",ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_senior_cashier.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectSeniorCashier completed");
        resp.sendRedirect("/select_check");
    }

}
