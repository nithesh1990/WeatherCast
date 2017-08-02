package napps.weathercast.Model;

/**
 * Created by "nithesh" on 8/1/2017.
 */

public class Response {
    private String version;

    public String getVersion() { return this.version; }

    public void setVersion(String version) { this.version = version; }

    private String termsofService;

    public String getTermsofService() { return this.termsofService; }

    public void setTermsofService(String termsofService) { this.termsofService = termsofService; }

    private Features features;

    public Features getFeatures() { return this.features; }

    public void setFeatures(Features features) { this.features = features; }
}
