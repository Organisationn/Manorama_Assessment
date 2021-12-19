package com.qa.blazedemo;
import org.testng.annotations.DataProvider;
import page.BookFlightAtBlazePage;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.ExcelUtil;
import java.util.Properties;

public class BookFlightAtBlazeTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    BookFlightAtBlazePage bookFlightAtBlazePageObj;

    @BeforeTest
    public void initialSetUp() {
        basePage = new BasePage();
        prop = basePage.init_properties();
        driver = basePage.init_driver(prop);
        bookFlightAtBlazePageObj=new BookFlightAtBlazePage(driver);
    }

    //gives data from excel
    @DataProvider
    public Object[][] getContactsTestData() {
        Object data[][] = ExcelUtil.getTestData("Sheet1");
        return data;
    }

    @Test(dataProvider ="getContactsTestData")
    public void bookFlightAtBlaze(String Name, String Address ,String City,String State,String Zip,String CCN,String CCMonth,String CCYear,String CCNameOnCard) throws Throwable {
        bookFlightAtBlazePageObj.validateHomePage();
        bookFlightAtBlazePageObj.enterDepartAndDestinations();
        bookFlightAtBlazePageObj.selectSpecificFlight();
        bookFlightAtBlazePageObj.bookAFlight(Name, Address ,City,State,Zip,CCN,CCMonth,CCYear,CCNameOnCard);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
