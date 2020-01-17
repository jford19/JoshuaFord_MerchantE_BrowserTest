package Test.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserPage {
    //class properties
    @FindBy(id="user_username")
    WebElement userNameField;

    @FindBy(id="user_password")
    WebElement userPasswordField;

    @FindBy(id="user_email")
    WebElement userEmailField;

    @FindBy(id="user_submit_action")
    WebElement createUserButton;

    //methods
    public void typeUserName(WebDriverWait webDriverWait,String textValue){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(userNameField));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("ISSUE in display of username field",false);
        }
        userNameField.sendKeys(textValue);
        System.out.println("value "+textValue+" entered in username field");
    }

    public void typePassword(WebDriverWait webDriverWait,String textValue){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(userPasswordField));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("ISSUE in display of user password field",false);
        }
        userPasswordField.sendKeys(textValue);
        System.out.println("value "+textValue+" entered in user password field");
    }

    public void typeEmail(WebDriverWait webDriverWait,String textValue){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(userEmailField));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("ISSUE in display of user email field",false);
        }
        userEmailField.sendKeys(textValue);
        System.out.println("value "+textValue+" entered in user email field");
    }

    public void clickCreateUserButton(WebDriverWait webDriverWait){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(createUserButton));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("ISSUE in display of createUserButton",false);
        }
        createUserButton.click();
        System.out.println("clicked create user button successfully");
    }


}
