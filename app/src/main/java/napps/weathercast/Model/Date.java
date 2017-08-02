package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class Date {
    private String epoch;

    public String getEpoch() { return this.epoch; }

    public void setEpoch(String epoch) { this.epoch = epoch; }

    private String pretty;

    public String getPretty() { return this.pretty; }

    public void setPretty(String pretty) { this.pretty = pretty; }

    private int day;

    public int getDay() { return this.day; }

    public void setDay(int day) { this.day = day; }

    private int month;

    public int getMonth() { return this.month; }

    public void setMonth(int month) { this.month = month; }

    private int year;

    public int getYear() { return this.year; }

    public void setYear(int year) { this.year = year; }

    private int yday;

    public int getYday() { return this.yday; }

    public void setYday(int yday) { this.yday = yday; }

    private int hour;

    public int getHour() { return this.hour; }

    public void setHour(int hour) { this.hour = hour; }

    private String min;

    public String getMin() { return this.min; }

    public void setMin(String min) { this.min = min; }

    private int sec;

    public int getSec() { return this.sec; }

    public void setSec(int sec) { this.sec = sec; }

    private String isdst;

    public String getIsdst() { return this.isdst; }

    public void setIsdst(String isdst) { this.isdst = isdst; }

    private String monthname;

    public String getMonthname() { return this.monthname; }

    public void setMonthname(String monthname) { this.monthname = monthname; }

    private String monthname_short;

    public String getMonthnameShort() { return this.monthname_short; }

    public void setMonthnameShort(String monthname_short) { this.monthname_short = monthname_short; }

    private String weekday_short;

    public String getWeekdayShort() { return this.weekday_short; }

    public void setWeekdayShort(String weekday_short) { this.weekday_short = weekday_short; }

    private String weekday;

    public String getWeekday() { return this.weekday; }

    public void setWeekday(String weekday) { this.weekday = weekday; }

    private String ampm;

    public String getAmpm() { return this.ampm; }

    public void setAmpm(String ampm) { this.ampm = ampm; }

    private String tz_short;

    public String getTzShort() { return this.tz_short; }

    public void setTzShort(String tz_short) { this.tz_short = tz_short; }

    private String tz_long;

    public String getTzLong() { return this.tz_long; }

    public void setTzLong(String tz_long) { this.tz_long = tz_long; }
}
