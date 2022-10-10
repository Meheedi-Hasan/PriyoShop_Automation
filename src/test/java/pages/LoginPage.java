package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//input[@id='Username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement logIn;


    public String doLogin(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(5000);
        LoginBtn.click();
        Thread.sleep(5000);
        usernameBox.sendKeys(email);
        Thread.sleep(5000);
        passwordBox.sendKeys(password);
        Thread.sleep(5000);
        logIn.click();
        Thread.sleep(5000);
        account.click();
        Thread.sleep(5000);
        String heading = driver.findElement(By.xpath("//a[@class='ico-account']")).getText();
        return heading;
    }



}
