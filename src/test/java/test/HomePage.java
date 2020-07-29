package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage {

    WebDriver driver;
    String browserType;
    String applUrl;

    @Test
    public void test(){         ///Users/raja/IdeaProjects/TestNgTest/src/test/resources

        String path = System.getProperty("user.dir")+"/src/test/resources/input.properties";

        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
            browserType = prop.getProperty("browserType");
            applUrl = prop.getProperty("applicationUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(browserType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/raja/IdeaProjects/Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/raja/IdeaProjects/Drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("current url:" +driver.getCurrentUrl());
        System.out.println("Get title of the page:" +driver.getTitle());
    }
}
