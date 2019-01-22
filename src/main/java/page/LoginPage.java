package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
//    private By phoneOtherLogin1 = text("手机及其他登录");
    private By phoneOtherLogin = locate("tv_login_by_phone_or_others");
    private By loginWithAccount= locate("tv_login_with_account");
    private By loginAccount = locate("login_account");
//    private By loginPassword = locate("//*[@password='true']");
    private By loginPassword = locate("login_password");
    private By buttonNext = locate("button_next");
    private By message = locate("md_content");
    private By mdButtonDefaultPositive = locate("md_buttonDefaultPositive");
    private By actionBack = locate("iv_action_back");

    private String msg;

    public LoginPage passwordLoginFail(String account, String password){
        findElement(phoneOtherLogin).click();
        findElement(loginWithAccount).click();

        findElement(loginAccount).sendKeys(account);
        findElement(loginPassword).sendKeys(password);

        findElement(buttonNext).click();

        this.msg = findElement(message).getText();
        findElement(mdButtonDefaultPositive).click();
        return this;
    }

    public MainPage passwordLoginSuccess(String account, String password){
        findElement(phoneOtherLogin).click();
        findElement(loginWithAccount).click();

        findElement(loginAccount).sendKeys(account);
        findElement(loginPassword).sendKeys(password);

        findElement(buttonNext).click();
        return new MainPage();
    }

    public void weixinLogin(){
        //todo
    }

    public void phoneLogin(){
        //todo
    }

    public ProfilePage gotoProfilePage(){
        findElement(actionBack).click();
        return new ProfilePage();
    }

    public String getMsg() {
        return msg;
    }
}
