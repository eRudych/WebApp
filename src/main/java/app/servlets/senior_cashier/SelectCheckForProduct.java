package app.servlets.senior_cashier;

import app.servlets.senior_cashier.helpers.SelectCheckId;
import app.servlets.senior_cashier.helpers.SeniorSelectCashierId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectCheckForProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_check_for_product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SelectCheckId.getInstance().setCheckId(Integer.parseInt(req.getParameter("check")));
            System.out.println(Integer.parseInt(req.getParameter("check")));
            doGetAfterPost(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_check_for_product.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/select_product");
    }

}
