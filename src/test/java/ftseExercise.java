import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ftseExercise {
    private RemoteWebDriver driver;


    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @Test
    void demoTest() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
    }
}
