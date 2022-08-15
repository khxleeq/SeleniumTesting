import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ftseExercise {
    private RemoteWebDriver driver;


    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
    }
}
