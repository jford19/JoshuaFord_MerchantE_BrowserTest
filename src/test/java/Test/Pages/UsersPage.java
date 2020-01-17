package Test.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage{

//class properties
@FindBy(id = "q_username")
WebElement usernameTextField;

@FindBy(xpath="//input[@value='Filter']")
WebElement filterButton;

@FindBy(linkText="New User")
WebElement newUserButton;

//class methods
public void clickFilter(WebDriverWait webDriverWait){
    try {
        webDriverWait.until(ExpectedConditions.visibilityOf(filterButton));
    }catch(Exception e){
        e.printStackTrace();
        Assert.assertTrue("ISSUE in display of Users Page",false);
    }

    filterButton.click();
    System.out.println("filter button clicked successfully");
}

public void typeValueToUserNameTexField(WebDriverWait webDriverWait, String textVal){
    try {
        webDriverWait.until(ExpectedConditions.visibilityOf(usernameTextField));
    }catch(Exception e){
        e.printStackTrace();
        Assert.assertTrue("ISSUE in display of Users Page",false);
    }
    usernameTextField.sendKeys(textVal);
    System.out.println("value "+textVal+" entered in username text field");
}

public void selectFromUserNameDropDown (WebDriver driverVal, String dropDownValue){

    try {
        //put the t back on t
        Select userNameDropField = new Select( driverVal.findElement(By.xpath("//*[@id=\"q_username_input\"]/select")) );
        userNameDropField.selectByVisibleText(dropDownValue);
    }catch (Exception e){
        e.printStackTrace();
        Assert.assertTrue("ISSUE in selecting value from dropdown",false);
    }
    System.out.println("drop down value "+dropDownValue+" selected");

}


public List<WebElement> fetchUserNameResultFromUsersTable(WebDriverWait webDriverWait,WebDriver driverVal){


    List<WebElement> fetchResults = new ArrayList<WebElement>();
    try {
         fetchResults = driverVal.findElements(By.xpath("//td[@class='col col-username']"));
    }catch(Exception e){
        e.printStackTrace();
        Assert.assertTrue("ISSUE in fetching user filter results",false);
    }
    return fetchResults;
}


public void clickNewUserButton(WebDriverWait webDriverWait){
    try {
        webDriverWait.until(ExpectedConditions.visibilityOf(newUserButton));
    }catch(Exception e){
        e.printStackTrace();
        Assert.assertTrue("ISSUE in displaying new user button",false);
    }

    newUserButton.click();
    System.out.println("New User button clicked successfully");
}

}
