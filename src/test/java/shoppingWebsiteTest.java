import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class shoppingWebsiteTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver(); // opens a new window
        driver.manage().window().setSize(new Dimension(1366, 768));
    }

    @Test
    void shoppingTest() throws InterruptedException {
        this.driver.get("http://automationpractice.com/index.php"); // goes to the page
        WebElement searchBar = driver.findElement(By.id("search_query_top"));
        String searchTerm = "Dress";
        searchBar.sendKeys(searchTerm);
        searchBar.submit();
        WebElement dressClick = driver.findElement(By.className("product_img_link"));
        dressClick.click();
        WebElement addToCart = driver.findElement(By.className("box-cart-bottom"));
        addToCart.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(3000);
        WebElement checkout = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a"));
        checkout.click();
        //driver.findElement(By.className("btn btn-default button button-medium")).click();
        WebElement proceed = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium"));
        proceed.click();

        WebElement signUp = driver.findElement(By.id("email_create"));
        signUp.sendKeys("test@gmail.com");
        signUp.submit();
          }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}