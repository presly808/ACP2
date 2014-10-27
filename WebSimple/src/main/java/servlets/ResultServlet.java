package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultServlet extends HttpServlet{

    private static final String COUNT = "COUNT";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginValue = req.getParameter("login");
        Cookie[] cookies = req.getCookies();
        String res = "NEW";
        boolean hasSesionId = false;
        if (cookies == null || cookies.length < 1){
            resp.addCookie(new Cookie(COUNT, "1"));
        } else {
            for(int i = 0; i < cookies.length; i++){
                if (cookies[i].getName().equals("s_id")){
                    hasSesionId = true;
                    Integer count = Integer.parseInt(cookies[i].getValue());
                    res = "Already in system\nlogin = " + loginValue + "\ncount = " + count;
                    cookies[i].setValue(String.valueOf(count+1));
                    resp.addCookie(cookies[i]);
                }
            }
            if (!hasSesionId){
                resp.addCookie(new Cookie("s_id", "1"));
            }
        }

        PrintWriter pw = resp.getWriter();
        pw.print(res);
        pw.close();
    }
}