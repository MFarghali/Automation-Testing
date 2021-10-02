package Testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@Test
public class SetUp {
	
	public WebDriver Basics(WebDriver driver) {
		 System.setProperty("webdriver.chrome.driver","E:\\Program Files\\chromedriver.exe");
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("start-maximized");*/
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();		    
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get("https://arielkiell.wixsite.com/interview");
		 return(driver);
		 
		}
	
	public void screenShotSetup(WebDriver driver , String step) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
        try {
            FileUtils.copyFile(screenshot, new File(".//screenshot/"+step+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }     
	}
}
