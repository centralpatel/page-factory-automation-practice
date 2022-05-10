package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
5.ProductPage -
Quantity, Size drop down, colour Add To Cart button locators and
create appropriate method for it.
 */
public class ProductPage extends Utility {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@title='Blouse'][normalize-space()='Blouse']")
    WebElement blouse;
    @FindBy(xpath = "//a[@id='color_8']")
    WebElement white;
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line']//a[@title='Printed Dress'][normalize-space()='Printed Dress']")
    WebElement printedDress;
    @FindBy(xpath = "//a[@id='color_13']")
    WebElement colorOrg;
    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement prichiDress;
    @FindBy(xpath = "//a[@id='color_15']")
    WebElement colorGrn;
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-item-of-tablet-line']//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress']")
    WebElement summerDress;
    @FindBy(xpath = "//a[@id='color_14']")
    WebElement colorBlu;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement sizesel;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement qtyAdd;
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addCart;
    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement verifyAddText;
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeBtn;


    public void selProduct(String proName){
        if(proName.equalsIgnoreCase("Blouse")){
            clickOnElement(blouse);
        }else if (proName.equalsIgnoreCase("Printed Dress")){
            clickOnElement(printedDress);
        }else if (proName.equalsIgnoreCase("printed Chiffon Dress")){
            clickOnElement(prichiDress);
        }else if(proName.equalsIgnoreCase("Printed Summer Dress with price $28.98"))
            clickOnElement(summerDress);
    }
    public void selColour(String color) {
        if (color.equalsIgnoreCase("White")) {
            clickOnElement(white);
        } else if (color.equalsIgnoreCase("Orange")) {
            clickOnElement(colorOrg);
        } else if (color.equalsIgnoreCase("Green")) {
            clickOnElement(colorGrn);
        } else if (color.equalsIgnoreCase("Blue")) {
            clickOnElement(colorBlu);
        }
    }
    public void enterQtyAdd(String qty){
        qtyAdd.clear();
        sendTextToElement(qtyAdd,qty);
    }
    public void selectSize(String size){
        selectByVisibleTextFromDropDown(sizesel,size);
    }
    public void clickAddCart(){
        clickOnElement(addCart);
    }
    public void getAddMessage(String message){
        verifyThatTextIsDisplayed(verifyAddText,message);
    }
    public void setCloseBtn(){
        clickOnElement(closeBtn);
    }
}
