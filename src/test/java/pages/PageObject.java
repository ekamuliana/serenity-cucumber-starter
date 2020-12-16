package pages;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class PageObject {

    public static WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

}
