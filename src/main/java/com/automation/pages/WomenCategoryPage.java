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
4.WomenCategoryPage -
WOMEN text, TOPS and DRESSES links, SortBy drop down, ProductsList Locators
and create appropriate methods for it.
 */
public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenTxt;

    @FindBy(xpath = "//a[@title='Tops'][normalize-space()='Tops']")
    WebElement topsLink;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Dresses'][normalize-space()='Dresses']")
    WebElement dressesLink;

    @FindBy(xpath = "//select[@id='selectProductSort']")
    WebElement sortByDropDown;
    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;
    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productList;

    public void clickOnWomen() {
        clickOnElement(women);
    }
    public  String verifyWomenTxt() {
       return getTextFromElement(womenTxt);
    }

    public void selectProduct(String text) {
        clickOnElement(productList);


    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select TopMenu: " + menu);

    }

}
