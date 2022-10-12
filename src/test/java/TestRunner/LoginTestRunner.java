package TestRunner;

import Setup.Setup;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils = new Utils();
    @Test(priority = 1)
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(0);
        String accountName = loginPage.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertEquals("mh.hassann19@gmail.com",accountName);

    }
    @Test(priority = 2)
    public void doLoginWithWrongPassword() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(1);
        String txt = loginPage.doLoginWithWrongPassword(utils.getEmail(), utils.getPassword());
        Assert.assertEquals("The credentials provided are incorrect",txt);
    }
    @Test(priority = 3)
    public void doLoginWithWrongEmail() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(2);
        String txt = loginPage.doLoginWithWrongEmail(utils.getEmail(), utils.getPassword());
        Assert.assertEquals("No customer account found",txt);
    }
}
