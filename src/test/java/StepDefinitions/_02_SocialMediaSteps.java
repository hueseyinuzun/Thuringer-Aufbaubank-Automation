package StepDefinitions;

import Pages.Elements;
import Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

public class _02_SocialMediaSteps {
    Elements element = new Elements();

    @Then("User clicks social media links and verifies")
    public void userClicksSocialMediaLinksAndVerifies(DataTable elements) {
        List<String> elementsToClick = elements.asList(String.class);

        String homePageID = Driver.getDriver().getWindowHandle();

        for (int i = 0; i < elementsToClick.size(); i++) {
            element.clickFunction(element.getWebElement(elementsToClick.get(i)));
            element.changePageAndAssert(homePageID,elementsToClick.get(i));
        }
    }
}
