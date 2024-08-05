package org.example.stepDefs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.example.page.Login.LoginPage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class StepLogin {
    private LoginPage loginPage = new LoginPage((AndroidDriver<MobileElement>) Hooks.driver);
    SoftAssert soft = new SoftAssert();

    @Given("I open the app")
    public void iOpenTheApp() throws InterruptedException, MalformedURLException {
        Hooks.setUp();
        Thread.sleep(3000);
        MobileElement passUpdateMessage = (MobileElement) Hooks.driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        passUpdateMessage.click();
    }

    @When("I enter a valid phone number {string}")
    public void iEnterAValidPhoneNumber(String phoneNumber) {
        loginPage.enterPhoneNumber(phoneNumber);
    }

    @When("I click on the continue button")
    public void iClickOnTheContinueButton() {
        loginPage.clickContinueButton();
    }

    @When("I click on the continue button again")
    public void iClickOnTheContinueButtonAgain() {
        loginPage.clickSecondContinueButton();
    }

    @When("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter an invalid password {string}")
    public void iEnterAnInvalidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the user data section {string}")
    public void iShouldSeeTheUserDataSection(String expectedText) {
        String actualText = loginPage.getUserDataText();
        soft.assertTrue(actualText.contains(expectedText), "Wrong section opens");
        soft.assertAll();
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedText) {
        String actualText = loginPage.getErrorMessageText();
        soft.assertTrue(actualText.contains(expectedText), "Wrong error message appears");
        soft.assertAll();
    }

    @When("I click on the eye icon")
    public void iClickOnTheEyeIcon() {
        loginPage.clickEyeIcon();
    }

    @Then("the password field should display the password {string}")
    public void thePasswordFieldShouldDisplayThePassword(String expectedText) {
        String actualText = loginPage.getPasswordText();
        soft.assertTrue(actualText.contains(expectedText), "No password appears");
        soft.assertAll();
    }
}
