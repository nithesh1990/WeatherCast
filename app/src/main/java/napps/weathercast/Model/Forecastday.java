package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class Forecastday {
    private int period;

    public int getPeriod() { return this.period; }

    public void setPeriod(int period) { this.period = period; }

    private String icon;

    public String getIcon() { return this.icon; }

    public void setIcon(String icon) { this.icon = icon; }

    private String icon_url;

    public String getIconUrl() { return this.icon_url; }

    public void setIconUrl(String icon_url) { this.icon_url = icon_url; }

    private String title;

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    private String fcttext;

    public String getFcttext() { return this.fcttext; }

    public void setFcttext(String fcttext) { this.fcttext = fcttext; }

    private String fcttext_metric;

    public String getFcttextMetric() { return this.fcttext_metric; }

    public void setFcttextMetric(String fcttext_metric) { this.fcttext_metric = fcttext_metric; }

    private String pop;

    public String getPop() { return this.pop; }

    public void setPop(String pop) { this.pop = pop; }
}
