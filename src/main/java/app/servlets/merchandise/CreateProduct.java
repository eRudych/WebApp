package app.servlets.merchandise;

import app.entities.Product;
import db.MerchandiseInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * This servlet is required to create a product and entering data into the table
 *
 */
public class CreateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer code = Integer.parseInt(req.getParameter("code"));
            String productName = req.getParameter("productName");
            Integer price = Integer.parseInt(req.getParameter("price"));
            Product product= new Product(productName,code,price);
            new MerchandiseInteract().addProduct(product);
            req.setAttribute("code", code);
            doGetAfterPost(req,resp);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/merchandise/create.jsp").forward(req, resp);
        }
    }
    private void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/product_created.jsp");
        requestDispatcher.forward(req, resp);
    }
}
