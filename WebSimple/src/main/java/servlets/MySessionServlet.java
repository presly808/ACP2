package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MySessionServlet extends HttpServlet {

    private static final String COUNT = "COUNT";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginValue = req.getParameter("login");
        Cookie[] cookies = req.getCookies();
        String res = "NEW USER";
        if (cookies == null || cookies.length < 1) {
            resp.addCookie(new Cookie(COUNT, "1"));
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COUNT)) {
                    Integer count = Integer.parseInt(cookie.getValue());
                    count++;
                    res = "Already in system\nlogin = " + loginValue + "\ncount = " + count;
                    cookie.setValue(String.valueOf(count));
                    resp.addCookie(cookie);
                }
            }
        }

        PrintWriter pw = resp.getWriter();
        pw.print(res);
        pw.close();

    }
}
