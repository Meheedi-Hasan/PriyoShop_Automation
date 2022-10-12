package TestRunner;

import Setup.Setup;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class SearchTestRunner extends Setup {
    Utils utils = new Utils();
    LoginPage loginPage;

    @Test(priority = 4)
    public void Login() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(0);
        String accountName = loginPage.Login(utils.getEmail(), utils.getPassword());
        Assert.assertEquals("mh.hassann19@gmail.com",accountName);

    }
    public void doSearch(){

    }

}
