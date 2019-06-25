package app.servlets.merchandise.functional;

import app.servlets.merchandise.FunctionalMerchandise;
import db.specific.interactions.MerchandiseInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class sets the amount of product to the storage
 */
public class SetQuantity extends FunctionalMerchandise {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("SetQuantity doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/merchandise/set_quantity.jsp");
        requestDispatcher.forward(req, resp);

    }

    /**
     * newAmount, code - user selects
     */
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
            //getLogic().logError("SetQuantity",ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/merchandise/set_quantity.jsp").forward(req, resp);
        }
    }
}