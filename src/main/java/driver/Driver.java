package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AndroidDriver driver;

    public static void start() throws MalformedURLException {
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        for (String key : config.appium.capability.keySet()) {
            Object value = config.appium.capability.get(key);
            desiredCapabilities.setCapability(key, value);
        }

        URL remoteUrl = new URL(config.appium.url);

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}
