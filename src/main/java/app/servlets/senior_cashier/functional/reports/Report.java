package app.servlets.senior_cashier.functional.reports;

import app.servlets.senior_cashier.FunctionalSeniorCashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class displays the documentation in jsp page
 */
public class Report extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("Report doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/report.jsp");
        requestDispatcher.forward(req, resp);
    }
}