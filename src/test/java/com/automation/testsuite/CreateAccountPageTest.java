package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        //Click on sign link
        homePage.clickOnSignInLink();
        //Enter EmailId
        signInPage.enterEmailCreate("Ras12@gmail.com");
        //click on create account
        signInPage.clickOnCreateAccountBtn();
        //Enter first name
        createAccountPage.enterFirstName("Nehal");
        //Enter surname
        createAccountPage.enterLastName("Patel");
        //Enter Password
        createAccountPage.enterPassWord("Nehal123!");
        //Enter first name
        createAccountPage.enterFirstName("Nehal");
        //Enter surname
        createAccountPage.enterLastName("Patel");
        //Enter address
        createAccountPage.enterAddress("5 Buckingham Court Road");
        //enter city
        createAccountPage.enterCity("Miami");
        //Enter State
        createAccountPage.enterState("Florida");
        //Enter zipcode
        createAccountPage.enterZipCode("33101");
        //Enter mobile number
        createAccountPage.enterMobile("07854036589");
        createAccountPage.enterAssignAdd("Home Address");
        //Click on register
        createAccountPage.clickRegister();
        softAssert.assertAll();
    }
}
