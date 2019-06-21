package app.servlets.senior_cashier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectCheckId extends HttpServlet {
    private static SelectCheckId ourInstance = new SelectCheckId();

    public static SelectCheckId getInstance() {
        return ourInstance;
    }

    private SelectCheckId() {

    }
    private int checkId;

    public void setCheckId(int checkId){
        this.checkId=checkId;
    }
    public int getCheckId(){
        return checkId;
    }
}
