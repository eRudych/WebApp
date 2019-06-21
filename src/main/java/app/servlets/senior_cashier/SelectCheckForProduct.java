package app.servlets.senior_cashier;

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
            //documentation
            doGetAfterPost(req,resp);
        }
        catch(Exception ex) {
            // logic.webPageException(this.getClass().toString(),ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/senior_cashier/select_check_for_product.jsp").forward(req, resp);
        }
    }
    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/add_products.jsp");
        //requestDispatcher.forward(req, resp);
        resp.sendRedirect("/select_product");
        //resp.sendRedirect("/cancel_check");
    }

}
