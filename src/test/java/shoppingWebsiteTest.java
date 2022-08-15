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
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
        checkout.click();
        WebElement proceed = driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium"));
        proceed.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("K@T.com");
        this.driver.findElement(By.id("passwd")).sendKeys("password");
        this.driver.findElement(By.id("SubmitLogin")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > form > p > button > span")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > p.checkbox > label"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > p > button > span"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart_navigation > button"))).click();
        assertEquals("Your order on My Store is complete.",
                this.driver.findElement(By.cssSelector("#center_column > div > p")).getText());


          }
    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}