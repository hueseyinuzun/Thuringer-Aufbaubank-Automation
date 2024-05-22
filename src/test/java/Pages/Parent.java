package Pages;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Parent {
    public void sendKeysFunction(WebElement element, String value){
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element){
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyContainsText(WebElement element, String text){
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void changePageAndAssert(String homePageID, String title) {

        Set<String> pageIDs = Driver.getDriver().getWindowHandles();

        for (String pageID: pageIDs) {
            if (!pageID.equals(homePageID))
                Driver.getDriver().switchTo().window(pageID);
        }

        String newPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(newPageUrl.contains(title.toLowerCase()));
        System.out.println(title + " page verified...");
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(homePageID);
    }

    public void selectElement(WebElement selectElement, String value){
        waitUntilVisible(selectElement);
        Select menu = new Select(selectElement);
        menu.selectByValue(value);
    }
}
