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

public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/add_products.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idCashier = SelectCashierId.getInstance().getSelectCashierId();
            int idCheck=CheckId.getInstance().getCheckId();
            Integer code=null;
            String name=null;
            try {
                code = Integer.parseInt(req.getParameter("code"));
            }
            catch (NumberFormatException ex){
                name = req.getParameter("name");
            }
            Integer amount = Integer.parseInt(req.getParameter("amount"));
            CheckId.getInstance().setCheckId(idCheck);
            if(code!=null){
                new CashierInteract().addProduct(code,amount,idCheck , idCashier);
            }
            if(name!=null){
                new CashierInteract().addProduct(name,amount,idCheck,idCashier);
            }
            doGet(req,resp);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/cashier/add_products.jsp").forward(req, resp);
        }
    }
}
