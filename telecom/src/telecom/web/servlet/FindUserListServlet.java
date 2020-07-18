package telecom.web.servlet;

import telecom.web.dao.UserDao;
import telecom.web.domain.UserBeanYear;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr. Li xiaogao 2020-06-02 15:57
 */
@WebServlet( "/findUserListServlet")
public class FindUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<UserBeanYear> usersYear = dao.findUsersYear();

        request.setAttribute("usersYear",usersYear);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
