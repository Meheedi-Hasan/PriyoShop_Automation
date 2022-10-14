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
        loginPage.login(utils.getEmail(), utils.getPassword());

    }
    @Test(priority = 5)
    public void doSearch() throws InterruptedException {
        searchPage = new SearchPage(driver);
        String text2 = searchPage.doSearch();
        Assert.assertEquals(text2,"Colorful Polo Shirt for Men-RB (E)");
    }
    @Test(priority = 6)
    public void addToCartWithZeroInput() throws InterruptedException {

        searchPage = new SearchPage(driver);
        String txt = searchPage.addToCartWithZeroInput();
        System.out.println(txt);
//        try {
//
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
 //   @Test(priority = 7)
 //   public void addToCartWithValidInput() throws InterruptedException {
 //       searchPage = new SearchPage(driver);
 //       String txt = searchPage.addToCartWithValidInput();
 //       Assert.assertEquals(txt,"Tk 2,000.00");
//        try {
//
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

