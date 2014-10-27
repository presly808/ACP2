package jmail.controller;

import jmail.dao.UserDao;
import jmail.model.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 27.10.2014.
 */

@WebServlet("/all-users")
public class AllUsersController extends HttpServlet {

    public static final String PATH = "/WEB-INF/pages/user-list.jsp";
    private UserDao userDao;

    //TODO refactor injecting from spring context
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        userDao = (UserDao) wac.getBean("userDaoHibImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.all();//TODO write implementation for all() method
        if(users == null || users.isEmpty()){
            //TODO orward to error page(create your error page jsp)
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
