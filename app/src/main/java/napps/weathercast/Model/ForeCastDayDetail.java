package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class ForeCastDayDetail {

    private String detailText;

    private Date date;

    public Date getDate() { return this.date; }

    public void setDate(Date date) { this.date = date; }

    private int period;

    public int getPeriod() { return this.period; }

    public void setPeriod(int period) { this.period = period; }

    private High high;

    public High getHigh() { return this.high; }

    public void setHigh(High high) { this.high = high; }

    private Low low;

    public Low getLow() { return this.low; }

    public void setLow(Low low) { this.low = low; }

    private String conditions;

    public String getConditions() { return this.conditions; }

    public void setConditions(String conditions) { this.conditions = conditions; }

    private String icon;

    public String getIcon() { return this.icon; }

    public void setIcon(String icon) { this.icon = icon; }

    private String icon_url;

    public String getIconUrl() { return this.icon_url; }

    public void setIconUrl(String icon_url) { this.icon_url = icon_url; }

    private String skyicon;

    public String getSkyicon() { return this.skyicon; }

    public void setSkyicon(String skyicon) { this.skyicon = skyicon; }

    private int pop;

    public int getPop() { return this.pop; }

    public void setPop(int pop) { this.pop = pop; }

    private QpfAllday qpf_allday;

    public QpfAllday getQpfAllday() { return this.qpf_allday; }

    public void setQpfAllday(QpfAllday qpf_allday) { this.qpf_allday = qpf_allday; }

    private QpfDay qpf_day;

    public QpfDay getQpfDay() { return this.qpf_day; }

    public void setQpfDay(QpfDay qpf_day) { this.qpf_day = qpf_day; }

    private QpfNight qpf_night;

    public QpfNight getQpfNight() { return this.qpf_night; }

    public void setQpfNight(QpfNight qpf_night) { this.qpf_night = qpf_night; }

    private SnowAllday snow_allday;

    public SnowAllday getSnowAllday() { return this.snow_allday; }

    public void setSnowAllday(SnowAllday snow_allday) { this.snow_allday = snow_allday; }

    private SnowDay snow_day;

    public SnowDay getSnowDay() { return this.snow_day; }

    public void setSnowDay(SnowDay snow_day) { this.snow_day = snow_day; }

    private SnowNight snow_night;

    public SnowNight getSnowNight() { return this.snow_night; }

    public void setSnowNight(SnowNight snow_night) { this.snow_night = snow_night; }

    private Maxwind maxwind;

    public Maxwind getMaxwind() { return this.maxwind; }

    public void setMaxwind(Maxwind maxwind) { this.maxwind = maxwind; }

    private Avewind avewind;

    public Avewind getAvewind() { return this.avewind; }

    public void setAvewind(Avewind avewind) { this.avewind = avewind; }

    private int avehumidity;

    public int getAvehumidity() { return this.avehumidity; }

    public void setAvehumidity(int avehumidity) { this.avehumidity = avehumidity; }

    private int maxhumidity;

    public int getMaxhumidity() { return this.maxhumidity; }

    public void setMaxhumidity(int maxhumidity) { this.maxhumidity = maxhumidity; }

    private int minhumidity;

    public int getMinhumidity() { return this.minhumidity; }

    public void setMinhumidity(int minhumidity) { this.minhumidity = minhumidity; }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }
}
