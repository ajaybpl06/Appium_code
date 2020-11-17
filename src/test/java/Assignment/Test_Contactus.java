package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test_Contactus {

	public AndroidDriver driver;
	
	@Test
	  public void Validatinglogin() {
		  
		 	 
		  	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Ajay");
		    driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test@test.com");
		    driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("1234567890");
		    
		    driver.hideKeyboard();
		    
		    driver.findElement(By.xpath("//*[@id=\"top-target\"]/div[1]/div/div[1]/form/div[48]/span/button")).click();
		    
		    String expectedError="THIS FIELD IS REQUIRED.";
		    String actualError=driver.findElement(By.xpath("//*[@id=\"ValidMsgLastName\"]")).getText();
		    Assert.assertEquals(actualError, expectedError);
		    
		    System.out.println(actualError);
	  }
	
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  DesiredCapabilities capability = new DesiredCapabilities();
			//capability.setCapability("deviceName","Ajay");
			capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3a API 30");
			capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
			
			driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("https://magento.com/contact-us");
//			
			
	  }
	
	  @AfterClass
	  public void afterClass() {
		 driver.close();
	  }
	
}
