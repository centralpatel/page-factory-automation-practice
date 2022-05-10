package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
1.HomePage -
WOMEN, DRESSES, T-SHIRTS and Sign in Links and logo locatores
and create appropriate methods for it.
 */
public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;

    @FindBy(xpath = "//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
    WebElement dresses;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']")
    WebElement tshirts;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement signInLink;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logo;


    public void clickOnWomenLink() {
        clickOnElement(women);
        CustomListeners.test.log(Status.PASS, "Click on women");
    }

    public void clickOnDressesLink() {
        clickOnElement(dresses);
        CustomListeners.test.log(Status.PASS, "Click on dresses");
    }

    public void clickOnTshirtsLink() {
        clickOnElement(tshirts);
        CustomListeners.test.log(Status.PASS, "Click on tshirts");
    }

    public void clickOnSignInLink() {
        //Reporter.log("Click On SignIn Link : " + signInLink.toString());
        clickOnElement(signInLink);
        //CustomListeners.test.log(Status.PASS, "Click on signInLink");
    }

    public void verifyLogo() {
        verifyThatElementIsDisplayed(logo);
        CustomListeners.test.log(Status.PASS, "Verify Logo is displayed");
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select Menu: " + menu);
    }
}
