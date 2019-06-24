package app.servlets.merchandise;

import app.entities.Product;
import app.models.ProductList;
import db.merchandise.MerchandiseInteract;
import log.BdLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SetQuantity extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/set_quantity.jsp");
       // req.setAttribute("resultStorage",new MerchandiseInteract().allProducts());
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer newAmount = Integer.parseInt(req.getParameter("newAmount"));
            Integer code = Integer.parseInt(req.getParameter("code"));
            new MerchandiseInteract().setQuantity(newAmount,code);
            req.setAttribute("amount", newAmount);
            doGet(req, resp);
        }
        catch(Exception ex) {
            // logic.webPageException(this.getClass().toString(),ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/merchandise/set_quantity.jsp").forward(req, resp);
        }
    }
}