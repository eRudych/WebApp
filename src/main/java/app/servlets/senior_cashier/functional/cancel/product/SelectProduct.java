package app.servlets.senior_cashier.functional.cancel.product;

import app.servlets.senior_cashier.FunctionalSeniorCashier;
import db.specific.interactions.SeniorCashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectProduct extends FunctionalSeniorCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectProduct doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_product.jsp");
        int check = FunctionalSeniorCashier.SelectCheckId.getInstance().getCheckId();
        req.setAttribute("check", check);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FunctionalSeniorCashier.ProductCode.getInstance().setProductCode(Integer.parseInt(req.getParameter("product")));
            new SeniorCashierInteract().removeProduct(FunctionalSeniorCashier.SelectCheckId.getInstance().getCheckId(),
                    Integer.parseInt(req.getParameter("product")),
                    FunctionalSeniorCashier.SeniorSelectCashierId.getInstance().getSeniorSelectCashierId());
            doGetAfterPost(req, resp);
        } catch (Exception ex) {
            //getLogic().logError("SelectProduct",ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_product.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SelectProduct completed");
        resp.sendRedirect("/cancel_product");
    }

}