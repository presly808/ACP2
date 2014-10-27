package jmail.controller;

import jmail.dao.UserDao;
import jmail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {

    private UserDao userDao;

    //TODO refactor injecting from spring context
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        userDao = (UserDao) wac.getBean("userDaoHibImpl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = new User(login, pass);
        userDao.create(user);

        PrintWriter pw = resp.getWriter();
        pw.print("REGISTRATION DONE!");
        pw.flush();
    }
}
