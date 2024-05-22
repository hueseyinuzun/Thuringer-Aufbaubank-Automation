package StepDefinitions;

import Pages.Elements;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class _04_KontaktFormSteps {

    Elements element = new Elements();

    @And("User sending the keys in the Dialog content")
    public void userSendingTheKeysInTheDialogContent(DataTable elements) {
        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            element.sendKeysFunction(element.getWebElement(elementsNameAndValue.get(i).get(0)), elementsNameAndValue.get(i).get(1));
        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> elementsToClick = elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {
            element.clickFunction(element.getWebElement(elementsToClick.get(i)));
        }
    }

    @Then("User select on the element in the Dialog")
    public void userSelectOnTheElementInTheDialog(DataTable elements) {
        List<List<String>> elementsNameAndValue = elements.asLists(String.class);
        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            element.clickFunction(element.getWebElement(elementsNameAndValue.get(i).get(0)));
            element.selectElement(element.getWebElement(elementsNameAndValue.get(i).get(0)), elementsNameAndValue.get(i).get(1));
        }
    }
}
