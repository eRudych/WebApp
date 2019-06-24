package app.servlets.senior_cashier;

import app.servlets.senior_cashier.helpers.SelectCheckId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is needed to view  /cancel_product
 */
public class CancelProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", SelectCheckId.getInstance().getCheckId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/cancel_product.jsp");
        requestDispatcher.forward(req, resp);
    }
}