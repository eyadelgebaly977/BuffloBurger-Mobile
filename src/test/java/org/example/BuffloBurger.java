package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class BuffloBurger {
    private AppiumDriver<MobileElement> driver;
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "test1");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.thebuffaloburger");
        caps.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);
        MobileElement passUpdateMessage = driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        passUpdateMessage.click();
    }

    @Test(priority = 1) // Verify that user can login with valid phone number and password
    public void loginPositive() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        MobileElement mobileNumberField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text='0xxxxxxxxxx']")));
        mobileNumberField.clear();
        mobileNumberField.sendKeys("01003803007");
        MobileElement firstContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
        firstContinuePhoneButton.click();
        MobileElement secondContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Continue']")));
        secondContinuePhoneButton.click();
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Eyad123@");
        MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='\uEBEB']")));
        loginButton.click();
        MobileElement userData = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter your details']")));
        String actual_section = userData.getText();
        String expected_section = "Enter your details";
        soft.assertTrue(actual_section.contains(expected_section), "Wrong section opens");
    }

    @Test(priority = 2) // Verify that user can not login with valid phone number and invalid password
    public void loginNegative() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        MobileElement mobileNumberField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text='0xxxxxxxxxx']")));
        mobileNumberField.click();
        mobileNumberField.sendKeys("01003803007");
        MobileElement firstContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
        firstContinuePhoneButton.click();
        MobileElement secondContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Continue']")));
        secondContinuePhoneButton.click();
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
        passwordField.click();
        passwordField.sendKeys("Eyad123@@");
        MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Login']")));
        loginButton.click();
        MobileElement errorMessage = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Wrong password\"]")));
        String actual_error = errorMessage.getText();
        String expected_error = "Wrong password";
        soft.assertTrue(actual_error.contains(expected_error), "Wrong error message appears");
    }

    @Test(priority = 3) // Verify that user can not login with valid phone number and invalid password
    public void loginNegative2() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        MobileElement mobileNumberField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text='0xxxxxxxxxx']")));
        mobileNumberField.clear();
        mobileNumberField.sendKeys("01003803007");
        MobileElement firstContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Continue']")));
        firstContinuePhoneButton.click();
        MobileElement secondContinuePhoneButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Continue']")));
        secondContinuePhoneButton.click();
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
        passwordField.clear();
        passwordField.sendKeys("Eyad123@@");
        MobileElement eyeIcon = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='\uEBEB']")));
        eyeIcon.click();
        String actualData = passwordField.getText();
        String expectedData = "Eyad123@@";
        soft.assertTrue(actualData.contains(expectedData), "No password appears");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
