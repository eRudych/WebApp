package app.servlets.merchandise;

import app.entities.Product;
import db.merchandise.MerchandiseInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class CreateProduct extends HttpServlet {
  // private BdLogic logic = new BdLogic();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer code = Integer.parseInt(req.getParameter("code"));
            System.out.println(code);
            String productName = req.getParameter("productName");
            System.out.println(productName);
            Integer price = Integer.parseInt(req.getParameter("price"));
            System.out.println(price);
            Product product= new Product(productName,code,price);
            new MerchandiseInteract().addProduct(product);
            req.setAttribute("code", code);
            doGet(req, resp);
        }
        catch(Exception ex) {
           // logic.webPageException(this.getClass().toString(),ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/merchandise/create.jsp").forward(req, resp);
        }
    }
}
