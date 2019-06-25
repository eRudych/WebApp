package app.servlets.merchandise.functional;

import app.servlets.merchandise.FunctionalMerchandise;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is needed to confirm the creation of product
 */
public class ProductCreated extends FunctionalMerchandise {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("ProductCreated doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/product_created.jsp");
        requestDispatcher.forward(req, resp);
    }
}
