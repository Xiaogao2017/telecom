package telecom.web.domain;

/**
 * @author Mr. Li xiaogao 2020-06-02 18:07
 */
public class UserBeanMonth {
    private String name;
    private String tell;
    private String date;
    private String flag;

    private String sumCountMonth;
    private String sumDurationMonth;

    @Override
    public String toString() {
        return name + '\t'+ tell + '\t' + date + '\t' + flag + '\t' + sumCountMonth + '\t' +
                sumDurationMonth + '\t';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSumCountMonth() {
        return sumCountMonth;
    }

    public void setSumCountMonth(String sumCountMonth) {
        this.sumCountMonth = sumCountMonth;
    }

    public String getSumDurationMonth() {
        return sumDurationMonth;
    }

    public void setSumDurationMonth(String sumDurationMonth) {
        this.sumDurationMonth = sumDurationMonth;
    }

    public UserBeanMonth(String name, String tell, String date, String flag, String sumCountMonth, String sumDurationMonth) {
        this.name = name;
        this.tell = tell;
        this.date = date;
        this.flag = flag;
        this.sumCountMonth = sumCountMonth;
        this.sumDurationMonth = sumDurationMonth;
    }

    public UserBeanMonth() {
    }
}
