package TestRunner;

import Setup.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CartPage;
import utils.Utils;

import java.io.IOException;

public class CartTestRunner extends Setup {
    CartPage cartPage;
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
        cartPage = new CartPage(driver);
        String text2 = cartPage.doSearch();
        Assert.assertEquals(text2, "Colorful Polo Shirt for Men-RB (E)");
    }
    @Test(priority = 6)
    public void addToCartWithInvalidInput() throws InterruptedException {
        cartPage = new CartPage(driver);
        String txt = cartPage.addToCartWithInvalidInput();
        Assert.assertEquals(txt, "Quantity should be positive");
    }
    @Test(priority = 7)
    public void addToCartWithValidInput() throws InterruptedException {
        cartPage = new CartPage(driver);
        String txt = cartPage.addToCartWithValidInput();
        Assert.assertEquals(txt, "Tk 2,000.00");
    }
    @Test(priority = 8)
    public void deleteProduct() throws InterruptedException {
        cartPage = new CartPage(driver);
        String txt = cartPage.deleteProduct();
        Assert.assertEquals(txt, "Your Shopping Cart is empty!");
    }

}