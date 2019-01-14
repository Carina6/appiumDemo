import org.junit.Test;

public class LoginTest {
    @Test
    public void notphone(){
        mainPage = App().start();
        loginPage = mainpage.gotoLoginPage();
        toast = loginPage.login("13233333333", "12345");
        assertThat(toast,equalsto("手机号填写错误"));
    }
}
