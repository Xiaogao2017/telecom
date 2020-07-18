package telecom.web.domain;

/**
 * @author Mr. Li xiaogao 2020-06-02 15:49
 */
public class UserBeanYear {
    private String name;
    private String tell;
    private String date;
    private String flag;

    private String sumCountYear;
    private String sumDurationYear;

    public UserBeanYear(String name, String tell, String date, String flag, String sumCountYear, String sumDurationYear) {
        this.name = name;
        this.tell = tell;
        this.date = date;
        this.flag = flag;
        this.sumCountYear = sumCountYear;
        this.sumDurationYear = sumDurationYear;
    }

    public UserBeanYear() {
    }

    @Override
    public String toString() {
        return name + '\t'+ tell + '\t' + date + '\t' + flag + '\t' + sumCountYear + '\t' +
                sumDurationYear + '\t';
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

    public String getSumCountYear() {
        return sumCountYear;
    }

    public void setSumCountYear(String sumCountYear) {
        this.sumCountYear = sumCountYear;
    }

    public String getSumDurationYear() {
        return sumDurationYear;
    }

    public void setSumDurationYear(String sumDurationYear) {
        this.sumDurationYear = sumDurationYear;
    }
}
