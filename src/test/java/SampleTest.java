import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "nexus");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
//        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("SnowBall");
//        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.xueqiu.android:id/user_profile_icon");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_login");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_login_by_phone_or_others");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.xueqiu.android:id/button_next");
        el8.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
