package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
2.SignInPage -
Email address, Password, Sign In Button, Create an account button and
"AUTHENTICATION" text, "CREATE AN ACCOUNT" text Locators
and create appropriate methods for it.
 */
public class SignInPage extends Utility {
        public SignInPage() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//h1[normalize-space()='Authentication']")
        WebElement authenticationMsg;

        @FindBy(id = "email")
        WebElement emailField;

        @FindBy(id = "email_create")
        WebElement newEmail;

        @FindBy(xpath = "//span[normalize-space()='Create an account']")
        WebElement createAccountBtn;

        @FindBy(xpath = "//input[@id='passwd']")
        WebElement passwordField;

        @FindBy(xpath = "//span[normalize-space()='Sign in']")
        WebElement signInbtn;
        @FindBy(xpath = "//a[@title='Log me out']")
        WebElement signOutLink;

        @FindBy(xpath = "//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]")
        WebElement errorMessage;

        public void clickOnCreateAccountBtn(){
            clickOnElement(createAccountBtn);
        }
        public boolean verifySignOutLink(){
            return signOutLink.isDisplayed();
        }

        public void enterEmailCreate(String email){
            sendTextToElement(newEmail,email);
        }


        public void verifySignInLink(){
            verifyThatElementIsDisplayed(signInbtn);
        }

        public void clickOnSignOut(){
            clickOnElement(signOutLink);
        }

    public String verifyErrorMessage(String errorMsg) {

        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMsg)) {
                break;
            }
        }
        return errorMsg;
    }

    public void enterEmail(String text){
            sendTextToElement(emailField,text);
        }

        public void enterPassword(String text){
            sendTextToElement(passwordField,text);
        }
        public void clickOnSignInBtn(){
            clickOnElement(signInbtn);
        }

        public void verifyAuthenticationMsg(String text){
            verifyThatTextIsDisplayed(authenticationMsg,text);
        }

}
