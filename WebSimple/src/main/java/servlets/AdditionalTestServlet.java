package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdditionalTestServlet extends HttpServlet {
    public static String PATH = "/pages/user-list.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In additional test servlet");

        List<String> list = (List<String>) req.getServletContext().getAttribute("names");
        if (list == null || list.size() < 1){
            PrintWriter pw = resp.getWriter();
            pw.print("List = null");
            pw.close();
            req.getRequestDispatcher(PATH);

        } else {
            for (String name : list){
                System.out.println(name);
            }
        }
        req.getRequestDispatcher(PATH);
    }
}