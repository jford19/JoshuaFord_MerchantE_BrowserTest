package Test.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //public static WebDriver ldriver = new ChromeDriver();

    //class properties
    @FindBy(xpath="//a[text()='Users']")
    WebElement userPageLink;

    //class methods
    public void navigateToUsersPage(WebDriverWait webDriverWait){

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(userPageLink));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("issue in navigating to Users Page",false);
        }

        userPageLink.click();

    }

}

