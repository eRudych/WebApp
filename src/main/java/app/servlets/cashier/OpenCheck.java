package app.servlets.cashier;

import app.servlets.cashier.helper.CheckId;
import app.servlets.cashier.helper.SelectCashierId;
import db.CashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/open_check.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idCashier = Integer.parseInt(req.getParameter("idCashier"));
            SelectCashierId.getInstance().setSelectCashierId(idCashier);
            CheckId.getInstance().setCheckId(new CashierInteract().createCheck(idCashier));
            doGetAfterPost(req,resp);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/cashier/open_check.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/add_products");
    }

}
