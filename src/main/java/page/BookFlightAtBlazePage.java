package page;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Properties;
import util.xpathUtil;

public class BookFlightAtBlazePage {
    WebDriver driver;
    BasePage basePage;
    Properties prop;private static Logger logger = LogManager.getRootLogger();
    /*Declaration of web elements for the Web Page "Welcome to the Simple Travel Agency!"*/

    By ddDepartureCity= By.xpath(xpathUtil.DD_DEPARTURE_CITY);
    By ddDestinationCity= By.xpath(xpathUtil.DD_DESTINATION_CITY);
    By btnFindFlight= By.xpath(xpathUtil.BTN_FIND_FLIGHT);
    By txtFlightDetails= By.xpath(xpathUtil.TXT_FLIGHT_DETAILS);
    By btnChooseFlight= By.xpath(xpathUtil.BTN_CHOOSE_FLIGHT);
    By btnPurchaseFlights= By.xpath(xpathUtil.BTN_PURCHASE_FLIGHTS);
    By txtName= By.xpath(xpathUtil.TXT_NAME);
    By txtAddress= By.xpath(xpathUtil.TXT_ADDRESS);
    By txtCity= By.xpath(xpathUtil.TXT_CITY);
    By txtState= By.xpath(xpathUtil.TXT_STATE);
    By txtZip= By.xpath(xpathUtil.TXT_ZIP);
    By txtCCNumber= By.xpath(xpathUtil.TXT_CC_NUMBER);
    By txtCCMonth= By.xpath(xpathUtil.TXT_CC_MONTH);
    By txtCCYear= By.xpath(xpathUtil.TXT_CC_YEAR);
    By txtCCNameOnCard= By.xpath(xpathUtil.TXT_CC_NAME_ON_CARD);
    By txtConfirmation=By.xpath(xpathUtil.TXT_CONFIRMATION);
    By txtIdNumber=By.xpath(xpathUtil.TXT_ID_NUMBER);
    By txtStatus=By.xpath(xpathUtil.TXT_STATUS);
    By txtAmount=By.xpath(xpathUtil.TXT_AMOUNT);
    By txtCardNumber=By.xpath(xpathUtil.TXT_CARD_NUMBER);
    By txtExpiration=By.xpath(xpathUtil.TXT_EXPIRATION);
    By txtAuthCode=By.xpath(xpathUtil.TXT_AUTH_CODE);
    By txtDate=By.xpath(xpathUtil.TXT_DATE);

    public BookFlightAtBlazePage(WebDriver driver) {
        this.driver = driver;
    }

    // Validate the UI is loaded properly once we launch the URL
    @Test(priority=1)
    public void validateHomePage(){
        logger.info("validateHomePage method started");
        Assert.assertTrue(driver.findElement(btnFindFlight).isEnabled());
        logger.info("Home Page is displayed");
        logger.info("validateHomePage method ended");

    }
    @Test(priority = 2)
    public void enterDepartAndDestinations(){
        logger.info("enterDepartAndDestinations method started");
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(ddDepartureCity));
        Select sct=new Select(driver.findElement(ddDepartureCity));
        sct.selectByValue("Boston");

        wait.until(ExpectedConditions.elementToBeClickable(ddDestinationCity));
        Select sct1=new Select(driver.findElement(ddDestinationCity));
        sct1.selectByValue("New York");

        wait.until(ExpectedConditions.elementToBeClickable(btnFindFlight));
        driver.findElement(btnFindFlight).click();

        Assert.assertTrue(driver.findElement(txtFlightDetails).isDisplayed());
        logger.info("Flight details display after clicking on FindFlight");

        logger.info("enterDepartAndDestinations method ended");
    }

    @Test(priority = 3)
    public void selectSpecificFlight(){
        logger.info("selectSpecificFlight method started");
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(btnChooseFlight));
        driver.findElement(btnChooseFlight).click();

        Assert.assertTrue(driver.findElement(btnPurchaseFlights).isEnabled());
        logger.info("Purchase flight form is displayed to book a flight");

        logger.info("selectSpecificFlight method ended");
    }

    @Test(priority = 4)
    public void bookAFlight(String Name,String Address,String City,String State,String Zip,String CCN,String CCMonth,String CCYear,String CCNameOnCard){
        logger.info("bookAFlight method started");
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(txtName));
        driver.findElement(txtName).sendKeys("Manorama Sahoo");

        wait.until(ExpectedConditions.elementToBeClickable(txtAddress));
        driver.findElement(txtAddress).sendKeys("Lane1");

        wait.until(ExpectedConditions.elementToBeClickable(txtCity));
        driver.findElement(txtCity).sendKeys("Bangalore");

        wait.until(ExpectedConditions.elementToBeClickable(txtState));
        driver.findElement(txtState).sendKeys("Karnataka");

        wait.until(ExpectedConditions.elementToBeClickable(txtZip));
        driver.findElement(txtZip).sendKeys("560037");

        wait.until(ExpectedConditions.elementToBeClickable(txtCCNumber));
        driver.findElement(txtCCNumber).sendKeys("1111222233334444");

        wait.until(ExpectedConditions.elementToBeClickable(txtCCMonth));
        driver.findElement(txtCCMonth).sendKeys("04");

        wait.until(ExpectedConditions.elementToBeClickable(txtCCYear));
        driver.findElement(txtCCYear).sendKeys("2024");

        wait.until(ExpectedConditions.elementToBeClickable(txtCCNameOnCard));
        driver.findElement(txtCCNameOnCard).sendKeys("Manorama Sahoo");

        wait.until(ExpectedConditions.elementToBeClickable(btnFindFlight));
        driver.findElement(btnFindFlight).click();

        Assert.assertTrue(driver.findElement(txtConfirmation).isDisplayed());
        logger.info("Flight Booking is confirmed");
        logger.info("Booking details are:");
        logger.info("Id:"+driver.findElement(txtIdNumber).getText());
        logger.info("Status:"+driver.findElement(txtStatus).getText());
        logger.info("Amount:"+driver.findElement(txtAmount).getText());
        logger.info("Card Number:"+driver.findElement(txtCardNumber).getText());
        logger.info("Expiration:"+driver.findElement(txtExpiration).getText());
        logger.info("AuthCode:"+driver.findElement(txtAuthCode).getText());
        logger.info("Date:"+driver.findElement(txtDate).getText());

        logger.info("bookAFlight method ended");
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
