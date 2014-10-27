package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("Create HELLO SERVLET");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> enumeration = req.getHeaderNames();
        System.out.println("HEADERS");
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            System.out.println(key + "=" + req.getHeader(key));
        }
        // PARAMS req.getParam*
        PrintWriter pw = resp.getWriter();
        pw.println("");
        pw.print("<h1>FIRST SERVLET</h1>");
        pw.close();
    }
}
