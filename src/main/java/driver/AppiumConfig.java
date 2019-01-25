package driver;

import java.util.HashMap;

class AppiumConfig {
    String url = "";
    HashMap<String, Object> capability = new HashMap<>();
    Integer wait = 6;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getCapability() {
        return capability;
    }

    public void setCapability(HashMap<String, Object> capability) {
        this.capability = capability;
    }

    public Integer getWait() {
        return wait;
    }

    public void setWait(Integer wait) {
        this.wait = wait;
    }

}
