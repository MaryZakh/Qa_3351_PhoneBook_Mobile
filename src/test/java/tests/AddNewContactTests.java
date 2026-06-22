package tests;

import config.AppiumConfig;
import models.Contact;
import models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class AddNewContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(User.builder().email("margo@gmail.com")
                        .password("Mmar123456$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
    }


    @Test
    public void createNewContactSuccessAll() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Cat" + i)
                .email("cat" + i + "@gmail.com")
                .phone("6789456" + i)
                .address("Haifa")
                .description("memory")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(), contact.getLastName());


    }

    @Test
    public void createNewContactSuccessReq() {

    }

    @Test
    public void createNewContactWithEmptyName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Cat")
                .email("cat@gmail.com")
                .phone("678945655555")
                .address("Haifa")
                .description("empty name")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageHasText("{name=must not be blank}");
    }

    @AfterClass
    public void postCondition() {
        new ContactListScreen(driver)
                .logout();
    }

}
