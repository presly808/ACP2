package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 26.10.2014.
 */
public class ContextTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IN CONTEXT_TEST_SERVLET");
        List<String> list = Arrays.asList("Adnriy", "Vasia", "Oleg");
        req.setAttribute("names", list);
        RequestDispatcher rq = req.getRequestDispatcher("/add");
        rq.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
