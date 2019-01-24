package driver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GlobalConfigTest {

    @Test
    void load() {
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        Assertions.assertNotNull(config);

        Assertions.assertEquals("http://127.0.0.1:4723/wd/hub", config.appium.url);
        Assertions.assertEquals(10, (int)config.appium.wait);
        Assertions.assertEquals("Android", config.appium.capability.get("platformName"));
        Assertions.assertEquals("nexus", config.appium.capability.get("deviceName"));
        Assertions.assertEquals("com.xueqiu.android", config.appium.capability.get("appPackage"));
        Assertions.assertEquals(".view.WelcomeActivityAlias", config.appium.capability.get("appActivity"));
        Assertions.assertTrue((Boolean) config.appium.capability.get("autoGrantPermissions"));
    }
}