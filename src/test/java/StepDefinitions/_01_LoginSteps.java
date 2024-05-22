package StepDefinitions;

import Pages.Elements;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _01_LoginSteps {

    Elements element = new Elements();

    @Given("Navigate to Thüringer Aufbaubank")
    public void navigateToThüringerAufbaubank() {
        Driver.getDriver().get("https://www.aufbaubank.de/de/");
        Driver.getDriver().manage().window().maximize();

        List<WebElement> cookies = Driver.getDriver().findElements(By.cssSelector("button[class='btnMore btnCookie btn-accept']"));
        if (cookies.size()>0)
            cookies.get(0).click();
    }

    @Then("Verify Thüringer Aufbaubank Page's Title")
    public void verifyThüringerAufbaubankPageSTitle() {
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(title,"Startseite - Thüringer Aufbaubank");
    }

    @And("Verify Thüringer Aufbaubank Page's Company Logo")
    public void verifyThüringerAufbaubankPageSCompanyLogo() {
        Assert.assertTrue(element.getWebElement("ThuringerAufbaubankCompanyLogo").isDisplayed());
    }
}
