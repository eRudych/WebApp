package app.servlets.senior_cashier;

import app.servlets.senior_cashier.helpers.ProductCode;
import app.servlets.senior_cashier.helpers.SelectCheckId;
import app.servlets.senior_cashier.helpers.SeniorSelectCashierId;
import db.SeniorCashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_product.jsp");
        int check = SelectCheckId.getInstance().getCheckId();
        req.setAttribute("check", check);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductCode.getInstance().setProductCode(Integer.parseInt(req.getParameter("product")));
            new SeniorCashierInteract().removeProduct(SelectCheckId.getInstance().getCheckId(),
                    Integer.parseInt(req.getParameter("product")),
                    SeniorSelectCashierId.getInstance().getSeniorSelectCashierId());
            doGetAfterPost(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_product.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/cancel_product");
    }

}