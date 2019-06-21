package app.servlets.cashier;

import db.CashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/add_products.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer code=null;
            String name=null;
            try {
                code = Integer.parseInt(req.getParameter("code"));
            }
            catch (NumberFormatException ex){
                name = req.getParameter("name");
            }
            Integer amount = Integer.parseInt(req.getParameter("amount"));
            int id = new CashierInteract().getMaxIdForChecks();
            System.out.println(id);
            if(code!=null){
                new CashierInteract().addProduct(code,amount,id);
            }
            if(name!=null){
                new CashierInteract().addProduct(name,amount,id);
            }
            doGet(req,resp);
        }
        catch(Exception ex) {
            // logic.webPageException(this.getClass().toString(),ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/cashier/add_products.jsp").forward(req, resp);
        }
    }
}
