package TestScripts;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import objRepository.StudentTestObjRepo;
import objRepository.searchSubjectRep;;

public class searchSubject extends BaseClass{
	

	searchSubjectRep obj;
	BaseClass baseObj = new BaseClass();
	StudentTest testObj;
	StudentTestObjRepo classroomObj;
	WebDriverWait wait30Sec;
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		
		obj = new searchSubjectRep(androidDriver);
		testObj = new StudentTest();
		
		
	}
	
	@Test
	public void searchSubjectTest() throws InterruptedException
	{
		obj.login();
		//obj.invalidLogin();
		Thread.sleep(3000);
		waitForElementToLoad(obj.library);
		obj.mySchool.click();
		obj.myClasses.click();
		testObj.viewClassroomInfo();
		
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

}
