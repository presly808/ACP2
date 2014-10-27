package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Admin on 26.10.14.
 */
public class SessionCheckerServlet extends HttpServlet {
    private static int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        count++;
        if((session.getLastAccessedTime() + 20000) < new Date().getTime()){
            count = 0;
        }
        PrintWriter pw = resp.getWriter();
        pw.print(count);
        pw.flush();
        Date access = new Date();
        access.setTime(session.getLastAccessedTime());
        Date date = new Date();
        pw.print("\nLast Access Time: \t" + access.getHours() + ":" + access.getMinutes() + ":" + access.getSeconds() +
                "\nCurrent Access Time: \t" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        pw.close();

    }
}
