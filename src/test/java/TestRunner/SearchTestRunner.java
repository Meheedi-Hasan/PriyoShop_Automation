package TestRunner;

import Setup.Setup;
import org.json.simple.parser.ParseException;
//import org.junit.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import utils.Utils;

import java.io.IOException;

public class SearchTestRunner extends Setup {
    SearchPage searchPage;
    LoginPage loginPage;
    Utils utils = new Utils();

    @Test(priority = 4)
    public void login() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(0);
        String accountName = loginPage.login(utils.getEmail(), utils.getPassword());
        Assert.assertEquals("mh.hassann19@gmail.com",accountName);
    }
    @Test(priority = 5)
    public void doSearch() throws InterruptedException {
        searchPage = new SearchPage(driver);
        String text2 = searchPage.doSearch();
        Assert.assertEquals(text2,"Colorful Polo Shirt for Men-RB (E)");
    }
}
