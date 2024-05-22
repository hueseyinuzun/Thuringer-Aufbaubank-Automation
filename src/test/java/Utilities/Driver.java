package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.simple.SimpleLogger;


import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver(){
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language","EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error");

        if (threadBrowserName.get() == null){ // for any caller that does not work in parallel, i.e. does not come with parameters from XML
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null){

            String browserName = threadBrowserName.get();

            switch (browserName){

                case "chrome" :
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox" :
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, "/dev/null");
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari" :
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge" :
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }
        return threadDriver.get();
    }

    public static void quitDriver(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null){ // driver varsa
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }
}
