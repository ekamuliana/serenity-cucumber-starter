package stepdefinitions;

import data.QuoteData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.QuotePages;

public class QuoteSteps {

    private QuotePages page = new QuotePages();

    @When("User select color {string}")
    public void userSelectColor(String color) {
        page.selectColor(color);
    }

    @Given("User open atlas web playgroud")
    public void userOpenAtlasWebPlaygroud() {
        page.openPage();
    }

    @When("User input quote {string}")
    public void userInputQuote(String quote) {
        page.inputQuote(quote);
    }

    @When("User click button add quote")
    public void userClickButtonAddQuote() {
        page.clickAddQuote();
    }

    @Then("User see quote {string} with backgorund color {string}")
    public void userSeeQuoteWithBackgorundColor(String quote, String backgroundColor) {
        boolean isAppear = page.isQuoteWithColorVisible(quote, backgroundColor);
        Assert.assertTrue(isAppear);
    }

    @When("User click table view")
    public void userClickTableView() {
        page.clickTableView();
    }

    @When("User hover on button Hover to Show Table")
    public void userHoverOnButtonHoverToShowTable() {
        page.hoverOnButtonShowTable();
    }

    @Then("User see table quotes is appear")
    public void userSeeTableQuotesIsAppear() {
        boolean result = page.isTableAppear();
        Assert.assertTrue(result);
    }

    @When("User click button click to show table")
    public void userClickButtonClickToShowTable() {
        page.clickButtonShowTableAfterTenSec();
    }

    @When("User input quote and remember {string}")
    public void userInputQuoteAndRemember(String quote) {
        QuoteData.quote = quote;
        page.inputQuote(quote);
    }

    @And("User select color and remember {string}")
    public void userSelectColorAndRemember(String color) {
        QuoteData.color = color.toLowerCase();
        page.selectColor(color);
    }

    @Then("User see quote is equal with the inputted data")
    public void userSeeQuoteIsEqualWithTheInputtedData() {
        boolean isAppear = page.isQuoteWithColorVisible(QuoteData.quote, QuoteData.color);
        Assert.assertTrue(isAppear);
    }
}
