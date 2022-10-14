package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {
    WebDriver driver;
    @FindBy(name = "q")
    public WebElement searchField;
    @FindBy(xpath = "//input[@value = 'Search']")
    public WebElement searchBtn;
    @FindBy(xpath = "//a[normalize-space()='Colorful Polo Shirt for Men-RB (E)']")
    public WebElement test1;
    // Add cart
    @FindBy(xpath = "//img[@title='Burberry Colorful Polo Shirt for Men-RB (E)']")
    public WebElement imgBox;
    @FindBy(id = "product_attribute_59433_809728")
    public WebElement radioSizeBtn;
    @FindBy(xpath = "//input[@class='qty-input'][contains(@id,'EnteredQuantity')]")
    public WebElement qtyBox;
    @FindBy(id = "add-add-to-cart-button-143465")
    public WebElement cartBtn;
    @FindBy(xpath = "//a[@class='cart-trigger']")
    public WebElement cartBox;
    @FindBy(xpath = "//span[@class='product-subtotal']")
    public WebElement totalPrice;

    @FindBy(xpath = "//input[contains(@class,'qty-input valid')]")
    public WebElement qtybox2;

    @FindBy(className = "qty-input valid")
    public WebElement qtyasrt;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String doSearch() throws InterruptedException {
        searchField.sendKeys("Shirt");

        searchBtn.click();
        Thread.sleep(2000);

        String txt = test1.getText();
        return txt;

    }

    public String addToCartWithZeroInput() throws InterruptedException {
        imgBox.click();

        radioSizeBtn.click();

        qtyBox.clear();

        qtyBox.sendKeys("0");

        cartBtn.click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Quantity should be positive");
        alert.accept();
        Thread.sleep(3000);

        qtybox2.clear();
        // qtyBox.click();
        // qtyBox.clear();
        // Thread.sleep(2000);
        qtybox2.sendKeys("2");

        cartBtn.click();

        cartBox.click();
        Thread.sleep(4000);
        String qty = qtyasrt.getText();
        return qty;

    }
//    public String addToCartWithValidInput() throws InterruptedException {
//        //radioSizeBtn.click();
//        Thread.sleep(2000);
//        qtyBox.clear();
//        Thread.sleep(2000);
//        qtyBox.sendKeys("2");
//        Thread.sleep(2000);
//        cartBtn.click();
//        Thread.sleep(2000);
//        cartBox.click();
//        String txt = totalPrice.getText();
//        return txt;
//    }
}
