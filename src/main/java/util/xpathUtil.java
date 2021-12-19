package util;

import org.openqa.selenium.By;

public interface xpathUtil {
    String DD_DEPARTURE_CITY="//*[@class='form-inline' and @name='fromPort']";
    String DD_DESTINATION_CITY= "//*[@class='form-inline' and @name='toPort']";
    String BTN_FIND_FLIGHT= "//*[@type='submit']";
    String TXT_FLIGHT_DETAILS= "//h3[contains(text(),'Flights from')]";
    String BTN_CHOOSE_FLIGHT= "//*[text()='43']/preceding-sibling::td//input";
    String BTN_PURCHASE_FLIGHTS= "//input[@type='submit']";
    String TXT_NAME= "//input[@id='inputName']";
    String TXT_ADDRESS= "//input[@id='address']";
    String TXT_CITY= "//input[@id='city']";
    String TXT_STATE= "//input[@id='state']";
    String TXT_ZIP= "//input[@id='zipCode']";
    String TXT_CC_NUMBER= "//input[@id='creditCardNumber']";
    String TXT_CC_MONTH= "//input[@id='creditCardMonth']";
    String TXT_CC_YEAR= "//input[@id='creditCardYear']";
    String TXT_CC_NAME_ON_CARD= "//input[@id='nameOnCard']";
    String TXT_CONFIRMATION="//h1[contains(text(),'Thank you for your purchase today!')]";
    String TXT_ID_NUMBER="//tbody/tr[1]/td[2]";
    String TXT_STATUS="//tbody/tr[2]/td[2]";
    String TXT_AMOUNT="//tbody/tr[3]/td[2]";
    String TXT_CARD_NUMBER="//tbody/tr[4]/td[2]";
    String TXT_EXPIRATION="//tbody/tr[5]/td[2]";
    String TXT_AUTH_CODE="//tbody/tr[6]/td[2]";
    String TXT_DATE="//tbody/tr[7]/td[2]";

}
