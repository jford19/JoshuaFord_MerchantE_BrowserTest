import Test.Pages.BasePage;
import Test.Pages.EditUserPage;
import Test.Pages.NewUserPage;
import Test.Pages.UsersPage;
import Test.Resources.ValueGenerator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestRunner {

    public static void main (String[] args){
        System.out.println("Starting Test Run...");
        String chromeDiverPath = "";


        System.setProperty("webdriver.chrome.driver",chromeDiverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qainterview.merchante-solutions.com:8080/admin");

        //BROWSER TEST CASES
        //Test Case 001
            //Navigate to Users page, validate filter criteria: all users with user name starting with d are only displayed
        System.out.println("Test Case 001 - Navigate to Users page, validate filter criteria: all users with user name starting with d are only displayed");
        BasePage basePage = PageFactory.initElements(driver,BasePage.class);
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);

            //navigate to users page
            basePage.navigateToUsersPage(webDriverWait);

            //enter filter criteria and click filter
            UsersPage usersPage = PageFactory.initElements(driver,UsersPage.class);

            usersPage.selectFromUserNameDropDown(driver,"Starts with");
            usersPage.typeValueToUserNameTexField(webDriverWait,"d");
            usersPage.clickFilter(webDriverWait);

            //validate results
            List<WebElement> userNameResultElement = usersPage.fetchUserNameResultFromUsersTable(webDriverWait,driver);
            for(WebElement currWebElement:userNameResultElement){
                String userNameVal = currWebElement.getText();
                System.out.println("User name from fetch results "+userNameVal);
                    if(!userNameVal.startsWith("d")){
                        Assert.assertTrue("!!after checking result: username value "+userNameVal+" DOES NOT start with d!!FAILING!!",false);
                    }
            }
            System.out.println("Test Case 001 PASS!!");





        //Test Case 002
            //Navigate to Users page, add new user: verify user is successfully created
        System.out.println("Test Case 002 - Navigate to Users page, add new user: verify user is successfully created");

            //navigate to users page
            basePage.navigateToUsersPage(webDriverWait);
            //click new user button
            usersPage.clickNewUserButton(webDriverWait);

            NewUserPage newUserPage = PageFactory.initElements(driver,NewUserPage.class);
            //enter new user
            ValueGenerator valueGenerator = new ValueGenerator();
            String user = valueGenerator.generateRandomValue("user");
            String password = valueGenerator.generateRandomValue("password");
            String email = valueGenerator.generateRandomValue("email");

            newUserPage.typeUserName(webDriverWait,user);
            newUserPage.typePassword(webDriverWait,password);
            newUserPage.typeEmail(webDriverWait,email);
            newUserPage.clickCreateUserButton(webDriverWait);

            EditUserPage editUserPage = PageFactory.initElements(driver,EditUserPage.class);
            //validate new user success created
            String editUserFlashMsg = editUserPage.getFlashNoticeText(webDriverWait);
            if(!editUserFlashMsg.equals("User was successfully created.")){
                    Assert.assertTrue("!Create user confirmation not as expected, !!FAILING!!",false);
            }else{
                System.out.println("message displayed on edit user screen "+editUserFlashMsg);
            }
            System.out.println("Test Case 002 PASS!!");

        driver.quit();

    }
}
