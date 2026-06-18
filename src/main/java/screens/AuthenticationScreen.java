package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AndroidDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputEmail")
    WebElement emailEditText;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputPassword")
    WebElement passwordEditText;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/loginBtn")
    WebElement loginBtn;


    public AuthenticationScreen fillEmail(String email) {
        //pause(4000)
        should(emailEditText,10);
        type(emailEditText, email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }


    public ContactListScreen submitLogin() {
        loginBtn.click();
        return new ContactListScreen(driver);
    }


}
