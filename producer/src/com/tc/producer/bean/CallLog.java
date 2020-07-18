package com.tc.producer.bean;

/**
 * @author Mr. Li xiaogao 2020-05-30 7:49
 */
public class CallLog {
    private String user1;
    private String call1;
    private String user2;
    private String call2;
    private String callTime;
    private String duration;

    public CallLog(String user1, String call1, String user2, String call2, String callTime, String duration) {
        this.user1 = user1;
        this.call1 = call1;
        this.user2 = user2;
        this.call2 = call2;
        this.callTime = callTime;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return user1 + '\t' + call1 + '\t' + user2 + '\t' + call2 + '\t' + callTime + '\t' + duration + '\t';
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getCall1() {
        return call1;
    }

    public void setCall1(String call1) {
        this.call1 = call1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getCall2() {
        return call2;
    }

    public void setCall2(String call2) {
        this.call2 = call2;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
