package com.playwright.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;


public class AppiumTests {

  static AppiumDriver _appiumDriver;
  private WebDriverWait wait;
  private long explicitWaitTimeoutInSeconds = 90L;
  // app to install - details
  final String testAppName = "Almatar";

  @BeforeEach
  public void launchAppium() throws MalformedURLException {
    DesiredCapabilities _desiredCapabilities= new DesiredCapabilities();
    _desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    _desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
    _desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
    _desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
    _desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.vending");
    _desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.finsky.activities.MainActivity");
    _appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), _desiredCapabilities);
    this.wait = new WebDriverWait(_appiumDriver, explicitWaitTimeoutInSeconds);
  }

  @Test
  @Order(1)
  public void test() throws InterruptedException{
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy
            .AndroidUIAutomator("new UiSelector().resourceId(\"com.android.vending:id/0_resource_name_obfuscated\")"))));
   // _appiumDriver(AndroidKeyCode.ENTER);
    Thread.sleep(10000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementById("com.android.vending:id/0_resource_name_obfuscated")))
        .click();
    Thread.sleep(3000);
    _appiumDriver.findElement(MobileBy.className("android.widget.EditText"))
        .sendKeys(testAppName);
    Thread.sleep(3000);
    ((AndroidDriver<MobileElement>) _appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
    // wait for the app title to be displayed
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.className("android.widget.Button"))))
    .click();
    Thread.sleep(20000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.TextView[@text='Installed']")));
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.className("android.widget.Button"))))
        .click();
    Thread.sleep(10000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.TextView[@text='EN']")))
    .click();
    Thread.sleep(10000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.TextView[@text='Sign In']")))
        .click();
    Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnCreateAccount"))))
        .click();
    Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtFirstName"))))
        .click();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtFirstName"))))
        .sendKeys("test");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtLastName"))))
        .click();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtLastName"))))
        .sendKeys("test");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtLogin"))))
        .click();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtLogin"))))
        .sendKeys("testtt11@test.com");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtPassword"))))
        .click();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtPassword"))))
        .sendKeys("*12Test123Test");
    _appiumDriver.hideKeyboard();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/cpTerms"))))
        .click();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnCreateAccount"))))
        .click();
    Thread.sleep(20000);
    if(_appiumDriver.findElements(MobileBy.id("android:id/autofill_save_no")).size()>0) {
      wait.until(ExpectedConditions.visibilityOf(
          _appiumDriver.findElement(MobileBy.id("android:id/autofill_save_no"))))
          .click();
    }
    ScrollToElement("xpath","//android.widget.TextView[@text='Sign Out']",250);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.TextView[@text='Sign Out']")))
        .click();
    Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.TextView[@text='Yes']")))
        .click();
    Thread.sleep(5000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnLogin"))))
        .click();
    Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnLogin"))))
        .click();
    String emailMandatory = _appiumDriver.findElementByXPath("//android.widget.TextView[@text='Your Email Is Required']").getText();;
    String passwordMandatory =_appiumDriver.findElementByXPath("//android.widget.TextView[@text='Your Password Is Required']").getText();
    Assert.hasText(emailMandatory,"Your Email Is Required");
    Assert.hasText(passwordMandatory,"Your Password Is Required");
    Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.EditText[@text='Email']")))
        .sendKeys("testtt11@test.com");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnLogin"))))
        .click();
    Assert.hasText(passwordMandatory,"Your Password Is Required");
    Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/inputEtLogin"))))
        .clear();
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.EditText[@text='Enter your Password']")))
        .sendKeys("*12Test123Test");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnLogin"))))
        .click();
    Assert.hasText(passwordMandatory,"Your Email Is Required");

    Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElementByXPath("//android.widget.EditText[@text='Email']")))
        .sendKeys("testtt11@test.com");
    wait.until(ExpectedConditions.visibilityOf(
        _appiumDriver.findElement(MobileBy.id("com.almatar:id/btnLogin"))))
        .click();
    Thread.sleep(3000);
  }

  public static AndroidElement ScrollToElement(String by, String using, int miliseconds) {
    AndroidElement element = null;
    int numberOfTimes = 10;
    Dimension size = _appiumDriver.manage().window().getSize();
    int anchor = (int) (size.width * (0.5));
//Swipe up to scroll down
    int startPoint = (int)(size.height*(0.8));
    int endPoint = (int)(size.height*(0.1));

    for (int i = 0; i < numberOfTimes; i++) {
      try {
        new TouchAction(_appiumDriver)
            .longPress(PointOption.point(anchor, startPoint))
            .moveTo(PointOption.point(anchor, endPoint)).release().perform();
        element = (AndroidElement) _appiumDriver.findElement(by, using);
        i = numberOfTimes;
      } catch (NoSuchElementException ex) {
        System.out.println(String.format("Element not available. Scrolling (%s) times…", i + 1));
      }
    }
    return element;
  }



  @AfterAll
  public static void closeDriver() {
    if(_appiumDriver!=null)
    _appiumDriver.quit();
  }
}