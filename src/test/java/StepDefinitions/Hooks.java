package StepDefinitions;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(){

    }

    @After
    public void after(Scenario scenario){

        // TODO: We made the ScreenShot filename and Excel filename time-bound so that it doesn't always save over.
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        String strDate = formatter.format(date);

        // Screenshot
        if (scenario.isFailed()){
            TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
            byte[] memory= screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(memory, "image/png", "screenshot name");
        }
        Driver.quitDriver();
    }
}
