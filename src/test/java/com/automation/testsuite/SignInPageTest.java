package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class SignInPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        signInPage = new SignInPage();
    }
    @Test(groups = {"smoke","regression", "sanity"}, priority = 0)
    public void userShouldNavigateToSignInPageSuccessFully(){
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnSignInLink();
        signInPage.verifyAuthenticationMsg("Authentication");
        softAssert.assertAll();
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = TestData.class,groups = {"smoke","regression"}, priority = 2)
    public void verifyTheErrorMessageWithInValidCredentials(String username,String password,String errorMsg){
        //Click on sign link
        homePage.clickOnSignInLink();
        //Enter EmailId
        signInPage.enterEmail(username);
        //Enter Password
        signInPage.enterPassword(password);
        //Click on Sign Button
        signInPage.clickOnSignInBtn();
        //Verify error message
        String expectedResult =errorMsg ;
        String actualResult = signInPage.verifyErrorMessage(errorMsg);
        Assert.assertEquals(actualResult, expectedResult, "Result not found");

    }

    @Test(groups = {"regression"}, priority = 1)
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        //Click on sign link
        homePage.clickOnSignInLink();
        //Enter EmailId
        signInPage.enterEmail("Ras8@gmail.com");
        //Enter Password
        signInPage.enterPassword("Nehal123!");
        //Click on Sign Button
        signInPage.clickOnSignInBtn();
        //Verify that Sign out link is displayed
        Assert.assertTrue(signInPage.verifySignOutLink(), "not displayed");
    }

    @Test(groups = {"regression"}, priority = 3)
    public void VerifyThatUserShouldLogOutSuccessFully(){
        //Click on sign link
        homePage.clickOnSignInLink();
        //Enter EmailId
        signInPage.enterEmail("Ras8@gmail.com");
        //Enter Password
        signInPage.enterPassword("Nehal123!");
        //Click on Signin Button
        signInPage.clickOnSignInBtn();
        //Click on Signout Button
        signInPage.clickOnSignOut();
        //Verify that Sign in link is displayed
        signInPage.verifySignInLink();
    }

}
