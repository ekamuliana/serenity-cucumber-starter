package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QuotePages extends PageObject {

    public void openPage() {
        getDriver().get("http://bdd.atlasid.tech/");
    }

    public void inputQuote(String quote) {
        WebElement element = getDriver().findElement(By.id("inputQuote"));
        element.sendKeys(quote);
    }

    public void selectColor(String color) {
        WebElement element = getDriver().findElement(By.id("colorSelect"));
        Select select = new Select(element);
        select.selectByVisibleText(color);
    }

    public void clickAddQuote() {
        WebElement element = getDriver().findElement(By.id("buttonAddQuote"));
        element.click();
    }

    public boolean isQuoteWithColorVisible(String quote, String color) {
        List<WebElement> quoteTexts = getDriver().findElements(By.name("quoteText"));
        List<WebElement> quotePanels = getDriver().findElements(By.name("quotePanel"));

        for (int i = 0; i < quoteTexts.size(); i++) {
            String tempQuote = quoteTexts.get(i).getText();
            if (tempQuote.equals(quote)) {
                String tempAttribute = quotePanels.get(i).getAttribute("style");
                if (tempAttribute.contains(color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clickTableView() {
        WebElement element = getDriver().findElement(By.id("tableView"));
        element.click();
    }

    public void hoverOnButtonShowTable() {
        WebElement element = getDriver().findElement(By.id("buttonShowTable"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    public boolean isTableAppear() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        WebElement element = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("tableQuote")));
        return element.isDisplayed();
    }

    public void clickButtonShowTableAfterTenSec() {
        WebElement element = getDriver().findElement(By.id("buttonShowAfterTen"));
        element.click();
    }
}
