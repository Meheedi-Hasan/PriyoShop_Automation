package pages;

import org.openqa.selenium.Alert;
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
    public WebElement DLoginBtn;
    @FindBy(xpath = "//input[@id='Username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[contains(@class, 'ico-logout')]")
    public WebElement logOut;


    public String doLogin(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(2000);
        DLoginBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(email);
        Thread.sleep(2000);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
        account.click();
        Thread.sleep(2000);
        String heading = driver.findElement(By.xpath("//a[@class='ico-account']")).getText();
        logOut.click();
        return heading;
    }


    public String doLoginWithWrongPassword(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(2000);
        DLoginBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(email);
        Thread.sleep(2000);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
        String alertMessage = driver.findElement(By.xpath("//li[normalize-space()= 'The credentials provided are incorrect']")).getText();
        return alertMessage;
    }
    public String doLoginWithWrongEmail(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(2000);
        DLoginBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(email);
        Thread.sleep(2000);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
        String alertMessage = driver.findElement(By.xpath("//li[normalize-space()= 'No customer account found']")).getText();
        return alertMessage;
    }

    public void login(String email, String password) throws InterruptedException {
        account.click();
        Thread.sleep(2000);
        DLoginBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(email);
        Thread.sleep(2000);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
    }


}
