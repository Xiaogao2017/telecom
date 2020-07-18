package telecom.web.servlet;

import telecom.web.dao.UserDao;
import telecom.web.domain.UserBeanMonth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr. Li xiaogao 2020-06-03 7:26
 */
@WebServlet("/findInfoServlet")
public class FindInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String tel = request.getParameter("tel");
        List<UserBeanMonth> usersMonth = dao.findUsersMonthByTel(tel);
        //主叫和被叫，用户的通话次数通话时长，封装为数组，
        int size = usersMonth.size()/2;
        int [] sumCount_0 = new int[size],sumDuration_0 = new int[size],sumCount_1 = new int[size],sumDuration_1 = new int[size];
        int i = 0,j = 0;
        for (UserBeanMonth userBeanMonth : usersMonth) {
            if ("0".equals(userBeanMonth.getFlag())) {
                sumCount_0[i] = Integer.parseInt(userBeanMonth.getSumCountMonth().toString());
                sumDuration_0[i] = Integer.parseInt(userBeanMonth.getSumDurationMonth().toString());
                i++;
            }
            if ("1".equals(userBeanMonth.getFlag())) {
                sumCount_1[j] = Integer.parseInt(userBeanMonth.getSumCountMonth());
                sumDuration_1[j] = Integer.parseInt(userBeanMonth.getSumDurationMonth());
                j++;
            }
        }

//        request.setAttribute("sumCount_0",sumCount_0);
//        request.setAttribute("sumDuration_0",sumDuration_0);
//        request.setAttribute("sumCount_1",sumCount_1);
//        request.setAttribute("sumDuration_1",sumDuration_1);
//        request.setAttribute("username",usersMonth.get(0).getName());
        HttpSession session = request.getSession();
        session.setAttribute("sumCount_0",sumCount_0);
        session.setAttribute("sumDuration_0",sumDuration_0);
        session.setAttribute("sumCount_1",sumCount_1);
        session.setAttribute("sumDuration_1",sumDuration_1);
        session.setAttribute("username",usersMonth.get(0).getName());
        response.sendRedirect(request.getContextPath()+"/info.jsp");
        //request.getRequestDispatcher("/info2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
