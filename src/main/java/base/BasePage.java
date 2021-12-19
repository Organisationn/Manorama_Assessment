package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    String strParentPath = System.getProperty("user.dir");

    /**
     * this method is used to initialize the properties from config.properties
     *@return prop(Instance of Properties class)
     */
    public Properties init_properties() {
        prop = new Properties();
        try {
            String strParentPath = System.getProperty("user.dir");
            FileInputStream ip = new FileInputStream(strParentPath + "//src//main//java//config//config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    /**
     * this method is used to initialize the driver on the basis of browser name
     * @parambrowser
     * @return driver
     */
    public WebDriver init_driver(Properties prop) {
        String browser = prop.getProperty("browser");
        String strUrl = prop.getProperty("url");
        String projectPath = System.getProperty("user.dir");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Please pass the correct browser name....");
        }

        driver.get(strUrl);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return driver;
    }
}

