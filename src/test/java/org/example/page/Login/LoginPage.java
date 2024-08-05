package org.example.page.Login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void enterPhoneNumber(String phoneNumber) {
        MobileElement mobileNumberField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text='0xxxxxxxxxx']")));
        mobileNumberField.clear();
        mobileNumberField.sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        MobileElement firstContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
        firstContinuePhoneButton.click();
    }

    public void clickSecondContinueButton() {
        MobileElement secondContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Continue']")));
        secondContinuePhoneButton.click();
    }

    public void enterPassword(String password) {
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='\uEBEB']")));
        loginButton.click();
    }

    public String getUserDataText() {
        MobileElement userData = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter your details']")));
        return userData.getText();
    }

    public String getErrorMessageText() {
        MobileElement errorMessage = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Wrong password']")));
        return errorMessage.getText();
    }

    public void clickEyeIcon() {
        MobileElement eyeIcon = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='\uEBEB']")));
        eyeIcon.click();
    }

    public String getPasswordText() {
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
        return passwordField.getText();
    }
}
