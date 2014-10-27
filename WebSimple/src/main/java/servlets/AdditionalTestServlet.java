package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 26.10.2014.
 */
public class AdditionalTestServlet extends HttpServlet {

    public static final String PATH = "/pages/user-list.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IN ADDITIONAL_TEST_SERVLET");
        req.getRequestDispatcher(PATH).forward(req, resp);
    }
}
