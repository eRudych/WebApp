package app.servlets.senior_cashier;

import db.SeniorCashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new SeniorCashierInteract().removeCheck(SelectCheckId.getInstance().getCheckId());
        System.out.println(SelectCheckId.getInstance().getCheckId());
        req.setAttribute("check", SelectCheckId.getInstance().getCheckId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/cancel_check.jsp");
        requestDispatcher.forward(req, resp);
    }
}
