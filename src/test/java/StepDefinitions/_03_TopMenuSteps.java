package StepDefinitions;

import Pages.Elements;
import Utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class _03_TopMenuSteps {

    Elements element = new Elements();

    @Then("User hover over top menu links and verifies")
    public void userHoverOverTopMenuLinksAndVerifies() {
        List<String>menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Förderprogramme");
        menuExpectedList.add("Privatpersonen");
        menuExpectedList.add("Unternehmen");
        menuExpectedList.add("Öffentliche Einrichtungen");
        menuExpectedList.add("TAB-Portal");

        Actions actions = new Actions(Driver.getDriver());

        int i =0;
        for (WebElement menu:element.menuActualList) {
            actions.moveToElement(menu).build().perform();
            element.verifyContainsText(menu,menuExpectedList.get(i++));
        }
        System.out.println("The elements on the top menu have been confirmed...");
    }
}
