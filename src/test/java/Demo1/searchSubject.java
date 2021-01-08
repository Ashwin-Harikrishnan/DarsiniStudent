package Demo1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import objRepository.searchSubjectRep;
import BaseClassPackage.BaseClass;;

public class searchSubject extends BaseClass{
	

	searchSubjectRep obj = new searchSubjectRep(androidDriver);
	BaseClass baseObj = new BaseClass();
	
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "11.0.0");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("app", "E:\\\\Random Crap\\\\Work\\\\Downloads\\\\Darisni-v457-dars_staging-release.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("App started");*/
		
		baseObj.mobileDriver();
		
	}
	
	@Test
	public void searchSubjectTest()
	{
		obj.engBtn.click();
		obj.loginStartBtn.click();
		obj.emailInput.sendKeys("ashwin.harikrishnan@experionglobal.com");
		obj.passwordInput.sendKeys("DarsiniTest");
	}
	
	
	

}
