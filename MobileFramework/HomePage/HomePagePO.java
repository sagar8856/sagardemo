package pageobjects.MobileFramework.HomePage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.List;

public class HomePagePO extends BasePO {
    /**
     * set driver
     *
     * @param driver driver
     */

    /*
     * All Android Elements are identified by @AndroidFindBy annotation
     * @AndroidFindBy can uiAutomator, accessibility , id , className , tagName, androidDataMatcher, xpath , priority as attributes.
     */
    public HomePagePO(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.mytatva.patient:id/textViewToolbarTitle")
    private WebElement applicationLogo;

    @FindBy(id = "com.mytatva.patient:id/textViewLabelDailySummary")
    private WebElement yourDailySummaryHeader;

    @FindBy(id = "com.mytatva.patient:id/textViewLabelUpdateYourReading")
    private WebElement updateYourReadingHeader;

    @FindBy(id = "com.mytatva.patient:id/textViewLabelBookYourTest")
    private WebElement bookYourTestHeader;

    @FindBy(id = "com.mytatva.patient:id/textViewSkip")
    private WebElement skipButton;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "com.mytatva.patient:id/imageViewToolbarMenu")
    private WebElement menuIcon;

    @FindBy(id = "com.mytatva.patient:id/textViewAccountSettings")
    private WebElement accountSettingLink;

    @FindBy(xpath = "//*[@text='Care Plan']")
    private WebElement carePlanButton;

    @FindBy(xpath = "//*[@text='Home']")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@text='Engage']")
    private WebElement engageButton;

    @FindBy(id = "com.mytatva.patient:id/imageViewSearch")
    private WebElement searchButton;

    @FindBy(id = "com.mytatva.patient:id/imageViewNotification")
    private WebElement notificationIcon;

    @FindBy(id = "com.mytatva.patient:id/textViewLabelSignUp")
    private WebElement headerText;

    @FindBy(id = "com.mytatva.patient:id/textViewDate")
    private WebElement dateLabel;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Previous month\"]")
    private WebElement backButton;

    @FindBy(id = "com.mytatva.patient:id/textViewLabelDietPlan")
    private WebElement dietLabel;

    @FindBy(id = "com.mytatva.patient:id/imageViewChat")
    private WebElement chatButton;

    @FindBy(id = "com.mytatva.patient:id/layoutHC")
    private WebElement freshChatButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]/following-sibling::*[1]")
    private WebElement freshChatHeader;

    @FindBy(id = "com.mytatva.patient:id/textViewPatientName")
    private WebElement patientName;


    @Step("Is Application logo present ?")
    public Boolean isApplicationLogoPresent() {
        return appium.isElementPresent(headerText);
    }

    @Step("Verify daily summary header present into the home page")
    public Boolean isYourDailySummaryHeaderPresent() {
        return appium.isElementPresent(yourDailySummaryHeader);
    }

    @Step("Verify Update your reading present into the home page")
    public Boolean isUpdateYourReadingHeaderPresent() {
        return appium.isElementPresent(updateYourReadingHeader);
    }

    @Step("Verify Book your header present into the home page")
    public Boolean isBookYourTestHeaderPresent() {
        return appium.isElementPresent(bookYourTestHeader);
    }

    @Step("Tap on skip button")
    public void tapOnSkipButton() {
        appium.waitTillElementIsClickable(skipButton);
        appium.tapOrClick(skipButton);
    }

    @Step("Tap on ok button")
    public void tapOnOkButton() {
        appium.tapOrClick(okButton);
    }

    @Story("Tap on menu icon")
    public void tapOnMenuIcon() {
        appium.tapOrClick(menuIcon);
    }

    @Step("Tap on the account setting")
    public void tapOnAccountSetting() {
        appium.tapOrClick(accountSettingLink);
    }

    @Step("Tap on summary tab")
    public void tapOnSummaryTab(String summaryTab) {
        WebElement locator = driver.findElement(By.xpath("//*[@text='" + summaryTab + "'][@resource-id='com.mytatva.patient:id/textViewName']"));
        locator.click();
    }

    @Step("Tap on care plan button")
    public void tapOnCarePlanButton() {
        appium.tapOrClick(carePlanButton);
    }

    @Step("Tap on home button")
    public void tapOnHomeButton() {
        appium.waitInCaseElementClickable(homeButton, 10);
        appium.tapOrClick(homeButton);
    }

    @Step("Get header text")
    public String getHeaderText() {
        appium.waitInCaseElementClickable(applicationLogo, 10);
        return appium.getText(applicationLogo);
    }

    @Step("Tap on Engage button")
    public void tapOnEngageButton() {
        appium.tapOrClick(engageButton);
    }

    @Step("Is Bookmark page present?")
    public Boolean isBookMarkPagePresent(String bookmark) {
        appium.waitTillElementIsVisible(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerViewBookmarks']/android.view.ViewGroup//androidx.recyclerview.widget.RecyclerView//*[@resource-id='com.mytatva.patient:id/textViewTitle']"), 5);
        List<WebElement> pageList = driver.findElements(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerViewBookmarks']/android.view.ViewGroup//androidx.recyclerview.widget.RecyclerView//*[@resource-id='com.mytatva.patient:id/textViewTitle']"));
        boolean flag = true;
        for (WebElement e : pageList) {
            String bookMarkPageText = e.getText();
            if (bookMarkPageText.equalsIgnoreCase(bookmark)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    @Step("Tap on search button")
    public void tapOnSearchButton() {
        appium.tapOrClick(searchButton);
    }

    @Step("Tap on the search tab")
    public void tapOnSearchTab(String tab) {
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='" + tab + "']/android.widget.TextView")).click();
    }

    @Step("Is discovery feed present ?")
    public Boolean isDiscoveryFeedPresent() {
        return appium.isElementPresent(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerViewFeed']/android.widget.FrameLayout[1]"));
    }

    @Step("Is Ask an expert tab present")
    public Boolean isAskAnExpertTabPresent() {
        return appium.isElementPresent(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerViewAskAnExpert']/*[@resource-id='com.mytatva.patient:id/layoutQuestion']"));
    }

    @Step("Is Record tab present ?")
    public Boolean isRecordTabPresent() {
        return appium.isElementPresent(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerViewRecords']/android.widget.FrameLayout[1]"));
    }

    @Step("Tap on notification icon")
    public void tapOnNotificationButton() {
        appium.tapOrClick(notificationIcon);
    }


    @Step("Is notification displayed")
    public Boolean isNotificationDisplayed() {
        return appium.isElementPresent(By.xpath("//*[@resource-id='com.mytatva.patient:id/recyclerView']/android.view.ViewGroup[1]"));
    }

    @Step("Click on the Date")
    public void clickOnDate() {
        appium.tapOrClick(dateLabel);
    }

    @Step("Get text of the date label")
    public String getTextOfDateLabel() {
        return appium.getText(dateLabel);
    }

    @Step("Select Previous date and verify")
    public String selectPreviousDateAndVerify() {
        appium.tapOrClick(backButton);
        String date = selectPreviousDate();
        return date;

    }

    @Step("Select previous date")
    public String selectPreviousDate() {
        List<WebElement> dateList = driver.findElements(By.xpath("//*[@resource-id='android:id/month_view']/android.view.View"));
        String date = "";
        for (WebElement e : dateList) {
            String dateProperty = e.getAttribute("enabled");
            if (dateProperty.equalsIgnoreCase("true")) {
                e.click();
                date = e.getAttribute("content-desc");
                appium.tapOrClick(okButton);
                break;
            }
        }
        String[] data = date.split(" ");
        return data[1] + " " + data[0];
    }

    @Step("Verify diet label is displayed")
    public Boolean verifyDietLabel() {
        return appium.isElementPresent(dietLabel);
    }

    @Step("Tap on chat bot button")
    public void tapOnChatBotButton() {
        appium.tapOrClick(chatButton);
    }

    @Step("Tap on fresh chat button")
    public void tapOnFreshChatButton() {
        appium.tapOrClick(freshChatButton);
    }

    @Step("Verify fresh chat button is not present if health coach has not assigned")
    public Boolean isFreshChatButtonPresent() {
        return appium.isElementPresent(freshChatButton);
    }


    @Step("Get fresh chat header text")
    public String getFreshChatHeader() {
        return appium.getText(freshChatHeader);
    }

    @Step("Get Firstname and lastname")
    public String getFirstAndLastName() {
        return appium.getText(patientName);
    }
}