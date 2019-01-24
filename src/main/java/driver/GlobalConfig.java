package driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

class GlobalConfig {
    AppiumConfig appium;

    static GlobalConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AppiumConfig getAppium() {
        return appium;
    }

    public void setAppium(AppiumConfig appium) {
        this.appium = appium;
    }
}
