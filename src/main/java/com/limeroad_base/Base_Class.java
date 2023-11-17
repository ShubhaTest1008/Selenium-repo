package com.limeroad_base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;
	public static Actions action;
	public static Robot robot;

	// 1.launch browser
	public static WebDriver launchbrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
//				   ChromeOptions option = new ChromeOptions();
//		            option.addArguments("--remote-allow-origins=*");
//				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			System.out.println("Driver Error");
		}
		driver.manage().window().maximize();
		return driver;
	}

	// 2.getUrl
	public static void getUrl(String pageUrl) {
		try {
			driver.get(pageUrl);
		} catch (Exception e) {
			System.out.println("URL Error");
		}
	}

	// 3.send input
	public static void sendInput(WebElement element, String input) {
		try {
			if (element.isEnabled()) {
				element.sendKeys(input);
			}
		} catch (Exception e) {
			System.out.println("Input Error");
		}
	}

	// 4.click element
	public static void clickElement(WebElement element) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Error!! Element not clickable");
		}
	}

	// 5.is enabled
	public static void checkEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		} catch (Exception e) {
			System.out.println("Element not enabled");
		}
	}

	// 6.is Displayed
	public static void checkDisplayed(WebElement element) {
		try {
			boolean Displayed = element.isDisplayed();
			System.out.println(Displayed);
		} catch (Exception e) {
			System.out.println("Element Not Dispalyed");
		}
	}

	// 7.is Selected
	public static void checkSelected(WebElement element) {
		try {
			boolean Selected = element.isSelected();
			System.out.println(Selected);
		} catch (Exception e) {
			System.out.println("Element Not Selected");
		}
	}

	// 8.close
	public static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Browser Close not working!!");
		}
	}

	// 9.quit
	public static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Browser Quit not working!!");
		}
	}

	// 10.navigate
	public static void navigateTo(String pageUrl) {
		try {
			driver.navigate().to(pageUrl);
		} catch (Exception e) {
			System.out.println("Invalid URL");
		}
	}

	// 11.navigateRefresh
	public static void navigateRefresh(String pageUrl) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println("Refresh is not working!!");
		}
	}

	// 12.navigate forward
	public static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println("Navigate forward is not working!!");
		}
	}

	// 13.navigate back
	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println("Navigate Back is not working!!");
		}
	}

	// 14.simple Alert
	public static void simpleAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Error in Simple Alert!!");
		}
	}

	// 14.Confirm Alert Accept
	public static void confirmAlertAccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Error in Confirm Alert Accept!!");
		}
	}
	// 15.Confirm Alert Dismiss

	public static void confirmAlertDismiss() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			System.out.println("Error in Confirm Alert Dismiss!!");
		}
	}

	// 16.Prompt Alert Send-keys
	public static void promptAlertSendkeys(String KeystoSend) {
		try {
			driver.switchTo().alert().sendKeys(KeystoSend);
		} catch (Exception e) {
			System.out.println("Error in sending values!!");
		}
	}

	// 17.Prompt Alert Accept
	public static void promptAlertAccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Error in promptAlertAccept!!");
		}
	}

	// 18.Prompt Alert Dismiss
	public static void promptAlertDismiss() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			System.out.println("Error in promptAlertDismiss!!");
		}
	}

	// 19.Screenshot
	public static void screenShot(String loc) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(loc);
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			System.out.println("Error in screenshot!!");
		}
	}

	// 20. Actionsrightclick
	public static void rightClick(WebElement element) {
		try {
			action = new Actions(driver);
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			System.out.println("Error in rightClick!!");
		}
	}

	// 21. Actionsdoubleclick
	public static void doubleClick(WebElement element) {
		try {
			action = new Actions(driver);
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			System.out.println("Error in doubleClick!!");
		}
	}

	// 22.Actions movetoelement
	public static void movetoelement(WebElement element) {
		try {
			action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println("Error in move to element!!");
		}
	}

	// 23.Actions DragandDrop
	public static void DragandDrop(WebElement src, WebElement des) {
		try {
			action = new Actions(driver);
			action.dragAndDrop(src, des).build().perform();
		} catch (Exception e) {
			System.out.println("Error in Drag and Drop!!");
		}
	}

	// 24. frameindex
	public static void switchtoFrame(String indexValue) {
		try {
			driver.switchTo().frame(indexValue);
		} catch (Exception e) {
			System.out.println("Error in switchtoFrame with index!!");
		}
	}

	// 25. frameid
	public static void switchtoFrame(int idValue) {
		try {
			driver.switchTo().frame(idValue);
		} catch (Exception e) {
			System.out.println("Error in switchtoFrame with id!!");
		} finally {
			System.out.println("Finally block");
		}
	}

	// 26. frameelement
	public static void switchtoFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			System.out.println("Error in switchtoFrame with element!!");
		}
	}
	//27.implicitlywait
	public static void implicitywait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	//28.getCurrentURL
	public static String getCurrentURL() {
		String currentUrl=null;
		try {
			 currentUrl = driver.getCurrentUrl();
			
		} catch (Exception e) {
			System.out.println("URL Error");
		}
		return currentUrl;
	}
	//29.robotKeyPress
	public static void robotKeyDown() {
		try {
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		} catch (AWTException e) {
			System.out.println("Robot Method Error");
		}
	}
	//30.robotKeyRelease
	public static void robotKeyEnter() {
		try {
			robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			System.out.println("Robot Method Error");
		}
	}
	
	
	}