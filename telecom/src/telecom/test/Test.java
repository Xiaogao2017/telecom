package telecom.test;

import telecom.web.dao.UserDao;
import telecom.web.domain.UserBeanMonth;
import telecom.web.domain.UserBeanYear;

import java.util.List;

/**
 * @author Mr. Li xiaogao 2020-06-02 15:58
 */
public class Test {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        List<UserBeanYear> userLists = dao.findUsersYear();
//        for (UserBeanYear userList : userLists) {
//            System.out.println("userList = " + userList);
//        }
//        List<UserBeanMonth> usersMonth = dao.findUsersMonth();
//        for (UserBeanMonth userBeanMonth : usersMonth) {
//            System.out.println("userBeanMonth = " + userBeanMonth);
//        }
        List<UserBeanMonth> usersMonthByTel = dao.findUsersMonthByTel("");
        for (UserBeanMonth userBeanMonth : usersMonthByTel) {
            System.out.println("userBeanMonth = " + userBeanMonth);
        }

    }
}
