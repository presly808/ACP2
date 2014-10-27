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

@WebServlet(value = "/user-info")
public class GetUserByIdController extends HttpServlet{

    public static final String PATH = "/WEB-INF/pages/user.jsp";
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
        String idParam = req.getParameter("id");//dont forget about param when send request from client browser
        if(idParam == null || idParam.isEmpty()){
            //TODO orward to error page(create your error page jsp)
        }
        Integer id = Integer.valueOf(idParam);

        User user = userDao.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher(PATH).forward(req,resp);

    }
}
