package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClassPackage.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import objRepository.StudentTestObjRepo;

public class StudentTest extends BaseClass{
	StudentTestObjRepo classroomObj;
	public TouchAction action;
	WebDriverWait wait30Sec;
	
 		public void viewClassroomInfo() {
			try {
			System.out.println("entererd test");
			//log.info("Entered viewClassroomInfo");
			actualString = "";
			expectedString = "";
			
			//testData = classroomDataObj.getViewClassroomInfoData();
			expectedString = "test";
			System.out.println(expectedString);
			waitForElementToLoad(classroomObj.library);
			classroomObj.mySchool.click();
			classroomObj.myClasses.click();
			scrollDynamicElement(expectedString);
			androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + expectedString + "']//following::android.widget.ImageView[1]")).click();
			classroomObj.classroomInfo.click();
			waitForElementToLoad(classroomObj.title);
			actualString = classroomObj.className.getText();
			classroomObj.backNavigation.click();
			classroomObj.home.click();
			
		}
		catch(Exception e) {
			System.out.println("viewClassroomInfo Failed");
			e.printStackTrace();
			
		}
		System.out.println("\nActual: " + actualString + "\nExpcted: " + expectedString);
		Assert.assertEquals(actualString, expectedString);
	}





	public void waitForElementToLoad(WebElement element) {
		try {
			wait30Sec = new WebDriverWait(androidDriver, 30);//for normal explicit wait
			wait30Sec.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			System.out.println("Waited for 30 seconds");
			e.printStackTrace();
		}		
	}


@SuppressWarnings("rawtypes")
	public void scrollDynamicElement(String text) {		
		for(int i=0,j=300,k=1000;i<25;i++) {
			try {
				wait30Sec = new WebDriverWait(androidDriver, 05);
				wait30Sec.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"))));
				WebElement element =androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
				element.isDisplayed();
				break;
			}catch(Exception e) {
				action = new TouchAction(androidDriver);
				action.press(PointOption.point(0,k)).
				waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))) //you can change wait durations as per your requirement
				.moveTo(PointOption.point(0, j))
				.release()
				.perform();	
				j+=5;
				k+=5;
			}
		}	
	}
}
