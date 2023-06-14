package pageobjects.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.AppiumHelpers;
import utilities.Constants;


public class BasePO {
    protected AppiumHelpers appium;
    protected AppiumDriver<WebElement> driver;

    /**
     * set driver
     *
     * @param driver driver
     */

    public BasePO(AppiumDriver driver) {
        this.driver = driver;
        appium = new AppiumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.WEBDRIVER_WAIT_DURATION), this);
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;

    }

}


