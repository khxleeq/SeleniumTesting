package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#acceptCookieButton")
    private WebElement acceptCookieBtn;

    @FindBy(css = "#view-constituents > ul > li:nth-child(2) > a > strong")
    private WebElement risersBtn;

    @FindBy(css = "#view-constituents > ul > li:nth-child(3) > a > strong")
    private WebElement fallersBtn;

    public void acceptCookies() {
        this.acceptCookieBtn.click();
    }

    public void viewRisers() {
        this.risersBtn.click();
    }

    public void viewFallers() {
        this.fallersBtn.click();
    }
}