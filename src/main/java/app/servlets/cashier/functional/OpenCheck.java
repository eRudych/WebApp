package app.servlets.cashier.functional;

import app.servlets.cashier.FunctionalCashier;
import db.specific.interactions.CashierInteract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class create new check into DB
 * writes this check to the particular cashier
 */
public class OpenCheck extends FunctionalCashier {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("OpenCheck doGet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/cashier/open_check.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * idCashier - user selects
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idCashier = Integer.parseInt(req.getParameter("idCashier"));
            FunctionalCashier.SelectCashierId.getInstance().setSelectCashierId(idCashier);
            int idCheck=new CashierInteract().createCheck(idCashier);
            if(idCheck!=0){log("created check - "+idCheck);}
            FunctionalCashier.CheckId.getInstance().setCheckId(idCheck);
            doGetAfterPost(req,resp);
        }
        catch(Exception ex) {
            //getLogic().logError("OpenCheck",ex);
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/views/cashier/open_check.jsp").forward(req, resp);
        }
    }

    protected void doGetAfterPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getLogic().logInfo("OpenCheck completed");
        resp.sendRedirect("/add_products");
    }

}
