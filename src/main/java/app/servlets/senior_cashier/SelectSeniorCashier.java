package app.servlets.senior_cashier;

import app.servlets.senior_cashier.helpers.SeniorSelectCashierId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectSeniorCashier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/senior_cashier/select_senior_cashier.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idCashier = Integer.parseInt(req.getParameter("idCashier"));
            SeniorSelectCashierId.getInstance().setSeniorSelectCashierId(idCashier);
            doGetAfterPost(req, resp);
            System.out.println("1");
        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_senior_cashier.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2");
        resp.sendRedirect("/select_check");
    }

}
