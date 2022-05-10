package com.automation.testsuite;

import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"smoke","regression", "sanity"}, priority = 2)
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
        womenCategoryPage.clickOnWomen();
        String expected = "Women";
        String actual = womenCategoryPage.verifyWomenTxt();
        Assert.assertEquals(actual,expected,"not displayed");
    }

    @Test(dataProvider = "product",dataProviderClass = TestData.class, groups = {"smoke","regression", "sanity"}, priority = 1)
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String
            size, String colour) throws InterruptedException {
        //click on women
        womenCategoryPage.clickOnWomen();
        //select product
        productPage.selProduct(product);
        Thread.sleep(2000);
        //select colour
        productPage.selColour(colour);
        //select quantity
        productPage.enterQtyAdd(qty);
        //select size
        productPage.selectSize(size);
        //click add to cart
        productPage.clickAddCart();
        //verify add message
        productPage.getAddMessage("Product successfully added to your shopping cart");
        Thread.sleep(2000);
        productPage.setCloseBtn();
    }

}
