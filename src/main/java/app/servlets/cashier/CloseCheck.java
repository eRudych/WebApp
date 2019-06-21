package app.servlets.cashier;

import db.CashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseCheck  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=new CashierInteract().getMaxIdForChecks();
        req.setAttribute("id", id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/close_check.jsp");
        requestDispatcher.forward(req, resp);
    }
}


