package servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by admin on 26.10.2014.
 */
@WebServlet(value = "/session")
public class SessionTestServlet extends HttpServlet {

    private static final String COUNT = "count";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String message = "";
        if(session.isNew() || req.getSession().getAttribute(COUNT) == null){
            message = "NEW\n";
            session.setAttribute(COUNT, 0);
            session.setMaxInactiveInterval(10);
        } else {
            session.setAttribute(COUNT, ((Integer)session.getAttribute(COUNT))+1);
        }


        PrintWriter pw = resp.getWriter();
        message += "count = " + session.getAttribute(COUNT) + "\ndate = " + new Date();
        pw.print(message);
        pw.flush();

    }


}
