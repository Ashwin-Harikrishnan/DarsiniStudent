package BaseClassPackage;

import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import objRepository.searchSubjectRep;

public class BaseClass {

	public AndroidDriver<MobileElement> androidDriver;
	public static String actualString = "",  expectedString = "";



	@BeforeSuite
	public void setUP() {
	mobileDriver();
}
	public void mobileDriver() {
		for (int i = 0; i < 5; i++) {
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps = new DesiredCapabilities();
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "900");
				caps.setCapability(MobileCapabilityType.APP,"E:\\\\Random Crap\\\\Work\\\\Downloads\\\\Darisni-v457-dars_staging-release.apk");
				// URL url = new URL("http://127.0.0.1:4723/wd/hub");
				androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				// driver = new AppiumDriver<MobileElement>(url, caps);
				break;
			} catch (SessionNotCreatedException e) {
				System.out.println("Error occurred while creating session, retrying...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
