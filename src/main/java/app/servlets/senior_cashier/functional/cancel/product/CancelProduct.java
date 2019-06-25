package app.servlets.senior_cashier.functional.cancel.product;

import app.servlets.senior_cashier.FunctionalSeniorCashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is needed to view  /cancel_product
 */
public class CancelProduct extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("CancelProduct doGet");
        req.setAttribute("product", FunctionalSeniorCashier.SelectCheckId.getInstance().getCheckId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/cancel_product.jsp");
        requestDispatcher.forward(req, resp);
    }
}