package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ContactListScreen extends BaseScreen {
    public ContactListScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath ="//*[@resource-id ='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    WebElement activityTextView;

    public boolean isActivityTitleDisplayed(String text) {
        //return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView, text, 8);
    }

}
