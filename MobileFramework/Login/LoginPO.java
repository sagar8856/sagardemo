package pageobjects.MobileFramework.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;


public class LoginPO extends BasePO {
    /**
     * set driver
     *
     * @param driver driver
     */
    public LoginPO(AppiumDriver driver) {
        super(driver);
    }

    /*
     * All Android Elements are identified by @AndroidFindBy annotation
     * @AndroidFindBy can uiAutomator, accessibility , id , className , tagName, androidDataMatcher, xpath , priority as attributes.
     */

    @FindBy(id = "com.mytatva.patient:id/editTextMobileNumber")
    @iOSXCUITFindBy(id = "btn") // Here is an example of how to write a iOS application locators
    private WebElement mobileNumberTextBox;

    @FindBy(id = "com.mytatva.patient:id/buttonContinue")
    private WebElement continueButton;


    /**
     * Enter login credentials and tap on the submit button
     */
    @Step("Enter mobile number, password, and click on Login button")
    public void enterLoginCredentialsAndTapOnSubmitButton(String mobileNumber) throws InterruptedException {
        appium.enterText(mobileNumberTextBox, mobileNumber, false);
        appium.hideKeyboard();

        appium.tapOrClick(continueButton);
    }
}
