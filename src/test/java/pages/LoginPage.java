package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//label[normalize-space()='My Account']")
    public WebElement account;
    @FindBy(xpath = "//a[contains(@class,'ico-login ')]")
    public WebElement LoginBtn;

    public String doLogin(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(5000);
        LoginBtn.click();
        Thread.sleep(5000);
        return email;
    }



}
