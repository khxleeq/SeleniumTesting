
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver(); // opens a new window
    }

    @Test
    void demoTest() {
        this.driver.get("http://automationpractice.com/index.php"); // goes to the page
        WebElement search = this.driver.findElement(By.cssSelector("#search_query_top")); // selects the search input
        search.sendKeys("Dress"); // types in "turtles"
        search.sendKeys(Keys.ENTER); // submits using the enter key
//		this.driver.findElement(By.cssSelector("#main-content > div:nth-child(2) > form > div > div > div > button"))
//				.click();
        // First result in the results page:
        WebElement result = this.driver.findElement(By.cssSelector(
                "#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));

        //		search.getRect();  lol
        // comparing the text of the result to the expected value
        assertEquals("Printed Summer Dress", result.getText());

    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}
