package tests;

import config.AppiumConfig;
import models.User;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginTests_Second extends AppiumConfig {

    @Test
    public void loginSuccess() {
        new AuthenticationScreen(driver)
                .fillEmail("margo@gmail.com")
                .fillPassword("Mmar123456$")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margo@gmail.com")
                        .password("Mmar123456$").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

}
