package Test.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditUserPage {
    //class properties
    @FindBy(linkText = "Edit User")
    WebElement editUserButton;

    @FindBy(xpath = "//div[@class='flash flash_notice']")
    WebElement flashNotice;

    public String getFlashNoticeText(WebDriverWait webDriverWait){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(flashNotice));
        }catch(Exception e){
            e.printStackTrace();
            Assert.assertTrue("ISSUE in display of flash notice in edit user page",false);
        }

        String flashNoticeText = flashNotice.getText();

        return  flashNoticeText;
    }
}
