package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
3.CreateAccountPage -
All the fields locators and create appropriate method for it.
 */
public class CreateAccountPage extends Utility {
    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createEmailAcc;
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAcc;
    @FindBy(xpath = "//h3[normalize-space()='Your personal information']")
    WebElement personalInfo;
    @FindBy(xpath = "//input[@name='id_gender']")
    List<WebElement> gender;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAdd;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passWord;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement secondName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement secondLast;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement address;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityAdd;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateAdd;
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipCode;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobile;
    @FindBy(xpath = "//input[@id='alias']")
    WebElement assignAdd;
    @FindBy(xpath = "//span[normalize-space()='Register']")
    WebElement register;

    @FindBy(xpath = "//h1[normalize-space()='My account']")
    WebElement myAcc;

    public void enterFirstName(String first) {
        sendTextToElement(firstName, first);
    }
    public void enterLastName(String last) {
        sendTextToElement(lastName, last);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailAdd, email);
    }

    public void enterPassWord(String pass) {
        sendTextToElement(passWord, pass);
    }

    public void enterSecondName(String name) {
        sendTextToElement(secondName, name);
    }

    public void enterSecondLast(String last) {
        sendTextToElement(secondLast, last);
    }

    public void enterAddress(String add) {
        sendTextToElement(address, add);
    }

    public void enterCity(String city) {
        sendTextToElement(cityAdd, city);
    }

    public void enterState(String state) {
        selectByVisibleTextFromDropDown(stateAdd, state);
    }

    public void enterZipCode(String zip) {
        sendTextToElement(zipCode, zip);
    }

    public void enterMobile(String mob) {
        sendTextToElement(mobile, mob);
    }

    public void enterAssignAdd(String add) {
        sendTextToElement(assignAdd, add);
    }

    public void clickRegister() {
        clickOnElement(register);
    }

    public String verifyMyAcc() {
        return getTextFromElement(myAcc);
    }
}
