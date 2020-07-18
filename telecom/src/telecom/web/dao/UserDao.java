package telecom.web.dao;

import org.apache.hadoop.io.Text;
import org.springframework.jdbc.core.JdbcTemplate;
import telecom.web.domain.UserBeanMonth;
import telecom.web.domain.UserBeanYear;
import telecom.web.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mr. Li xiaogao 2020-06-02 11:00
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    public JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public void insertData(Text key, Text value) {
        //插入分析数据
        String sql = "insert into tel (tel_key,tel_value) values(?,?)";
        jdbcTemplate.update(sql,key.toString(),value.toString());
    }

    public List<UserBeanYear> findUsersYear() {
        List<UserBeanYear> userBeanYearList = new ArrayList<UserBeanYear>();
        String sql = "select * from tel";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        String name,tell,date,flag,sumCountYear,sumDurationYear;
        for (Map<String, Object> map : maps) {
            String line = map.toString();
            String[] fields = line.split(",");
            String[] split = fields[1].split("_");
            date = split[4];
            if (date.length() == 4) {
                //tel_key=0_仰莉_19565082510_202001,tel_value=8_7033}
                flag = split[1].substring(4);
                name = split[2];
                tell = split[3];
                String[] split1 = fields[2].split("=");
                sumCountYear = split1[1].split("_")[0];
                sumDurationYear = split1[1].split("_")[1];
                sumDurationYear = sumDurationYear.substring(0, sumDurationYear.length() - 1);
                UserBeanYear telBeanYear = new UserBeanYear(name, tell, date, flag, sumCountYear, sumDurationYear);
                userBeanYearList.add(telBeanYear);
            }
        }
        return userBeanYearList;
    }

    public List<UserBeanMonth> findUsersMonth() {
        List<UserBeanMonth> userBeanMonthList = new ArrayList<UserBeanMonth>();
        String sql = "select * from tel";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        String name,tell,date,flag,sumCountMonth,sumDurationMonth;

        for (Map<String, Object> map : maps) {
            String line = map.toString();
            System.out.println("map = " + map);
            String[] fields = line.split(",");
            String[] split = fields[1].split("_");
            date = split[4];
            if (date.length() == 6) {
                //tel_key=0_仰莉_19565082510_202001,tel_value=8_7033}
                flag = split[1].substring(4);
                name = split[2];
                tell = split[3];
                String[] split1 = fields[2].split("=");
                sumCountMonth = split1[1].split("_")[0];
                sumDurationMonth = split1[1].split("_")[1];
                sumDurationMonth = sumDurationMonth.substring(0, sumDurationMonth.length() - 1);
                UserBeanMonth telBeanMonth = new UserBeanMonth(name,tell,date,flag,sumCountMonth,sumDurationMonth);
                userBeanMonthList.add(telBeanMonth);
            } else {
                continue;
            }
        }
        return userBeanMonthList;
    }

    public List<UserBeanMonth> findUsersMonthByTel(String tel_p) {
        List<UserBeanMonth> userBeanMonthList = new ArrayList<UserBeanMonth>();
        String sql = "SELECT * FROM tel WHERE tel_key LIKE '%"+tel_p+"_______'";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        String name,tell,date,flag,sumCountMonth,sumDurationMonth;
        for (Map<String, Object> map : maps) {
            String line = map.toString();
            String[] fields = line.split(",");
            String[] split = fields[1].split("_");
            date = split[4];
            if (date.length() == 6) {
                //tel_key=0_仰莉_19565082510_202001,tel_value=8_7033}
                flag = split[1].substring(4);
                name = split[2];
                tell = split[3];
                String[] split1 = fields[2].split("=");
                sumCountMonth = split1[1].split("_")[0];
                sumDurationMonth = split1[1].split("_")[1];
                sumDurationMonth = sumDurationMonth.substring(0, sumDurationMonth.length() - 1);
                UserBeanMonth telBeanMonth = new UserBeanMonth(name,tell,date,flag,sumCountMonth,sumDurationMonth);
                userBeanMonthList.add(telBeanMonth);
            } else {
                continue;
            }
        }
        return userBeanMonthList;
    }
}
