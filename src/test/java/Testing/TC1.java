package Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1 {

	 private WebDriver driver;
	 private StringBuffer verificationErrors = new StringBuffer();
     SetUp obj1=new SetUp();

	@BeforeClass
	public void BasicSetUp() {
       driver= obj1.Basics(driver);

	}
	
	@AfterClass
	public void tearDown() throws Exception {
		   // driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }	
	
	
	@Test
	public void T1() throws Exception {
		obj1.screenShotSetup(driver,"Step1");
	  //Select or click on 4th elements 
	    driver.findElement(By.xpath("(//img[@alt=\"I'm a product\"])[4]")).click(); 
	    
		obj1.screenShotSetup(driver,"Step2");
   	 //Change Item Quantity to 3
	    Actions act0=new Actions(driver);
	    WebElement ele0 =driver.findElement(By.xpath("//input[@type=\"number\"]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", ele0);
	    act0.moveToElement(ele0).perform();
	    Point coordinates = driver.findElement(By.xpath("//p[@class=\"_1zyfI\"]")).getLocation();
	    Robot robot = new Robot();
	    WebElement markNews = driver.findElement(By.xpath("//input[@type=\"number\"]"));
	    markNews.click();
	    robot.mouseMove(coordinates.x,coordinates.y+80);    
	    WebDriverWait wait01 = new WebDriverWait(driver, 10);
	    WebElement element01 = wait01.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"_11lkb\"]"))); 
		obj1.screenShotSetup(driver,"Step3");
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element01);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element01);

		obj1.screenShotSetup(driver,"Step4");
	 //Select a Color
	    WebDriverWait wait1 = new WebDriverWait(driver, 20);
	    WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ColorPickerItem1936504531__radioInner\"]"))); 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
	    //driver.findElement(By.cssSelector("div[class=\"ColorPickerItem1936504531__radioInner\"]")).
	
	 //Click on the Button (Add to cart)
	    Actions act=new Actions(driver);
	    WebElement ele =driver.findElement(By.xpath("//button[@class=\"buttonnext1472800972__root Focusable3907780744__root Button3423134372__root Button3423134372--fullWidth StatesButton828051268__root AddToCartButton3061789056__addToCartButton\"]"));
	    act.moveToElement(ele).perform();
	    WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"buttonnext1472800972__root Focusable3907780744__root Button3423134372__root Button3423134372--fullWidth StatesButton828051268__root AddToCartButton3061789056__addToCartButton\"]"))); 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	    
     //Click on the Button (View cart)
		WebElement CBut = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("button[class=\"buttonnext1472800972__root Focusable3907780744__root Button3423134372__root Button3423134372--fullWidth StatesButton828051268__root AddToCartButton3061789056__addToCartButton\"]"))); 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", CBut);
		obj1.screenShotSetup(driver,"Step5");

		
	 //Get the TotalPrice and Check if its more than 75
	    WebElement text =driver.findElement(By.xpath("//dd[@id=\"total-sum\"]"));
	    String TPrice = text.getText();
	    String numberOnly =TPrice.replaceAll("[^\\d]", "");
	    int number = (Integer.parseInt(numberOnly))/100;
	   // if(number>75) { System.out.println("Total Price greater than 75");}
	    
	 //Click on Check out Button
	    WebElement el = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-hook=\"CheckoutButtonDataHook.button\"]"))); 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", el);
	    // WebElement but =driver.findElement(By.cssSelector("button[data-hook=\"CheckoutButtonDataHook.button\"]"));
	    //but.click();
		obj1.screenShotSetup(driver,"Step6");
		
	    assertTrue(number > 75 , "The Total Price is Greater than 75");	   


	}
	

	
}
