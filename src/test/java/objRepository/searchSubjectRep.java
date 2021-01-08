package objRepository;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClassPackage.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class searchSubjectRep extends BaseClass {
	BaseClass obj = new BaseClass();
	//private static AppiumDriver<MobileElement> driver;

	AndroidDriver<MobileElement> androidDriver;
	
	//WebElement element = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon"));
	
	@AndroidFindBy(id = "com.betacom.bcmsf.dars:id/eng")
	public AndroidElement engBtn;
	@AndroidFindBy(id = "com.betacom.bcmsf.dars:id/sign_in_txt2")
	public AndroidElement loginStartBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Email Address']//following::android.widget.EditText[1]")
	public AndroidElement emailInput;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Email Address']//following::android.widget.EditText[2]")
	public AndroidElement passwordInput;
	@AndroidFindBy(id = "com.betacom.bcmsf.dars:id/go_button")
	public AndroidElement signInBtn;
	
	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement popupAccept;
	
	@AndroidFindBy(id = "android:id/message")
	public AndroidElement errorMessageElement;
	
	@AndroidFindBy(xpath= "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"My Classes\"]/android.widget.TextView")
	public AndroidElement myClasses;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='School Feed']//following::android.widget.TextView[1]")
	public AndroidElement myClass;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='About']")
	public AndroidElement classView;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='About']//following::android.widget.ImageView[1]")
	public AndroidElement threeDots;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Classroom Information']")
	public AndroidElement classroomInfo;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/txtClassname")
	public AndroidElement className;
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Library\"]/android.widget.ImageView")
	public AndroidElement library;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/action_home")
	public AndroidElement home;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/action_my_school")
	public AndroidElement mySchool;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/txtFragmentTitle")
	public AndroidElement title;
	@AndroidFindBy(id="com.betacom.bcmsf.dars:id/img_back_navigation")
	public AndroidElement backNavigation;
	
	public void login() {
		//WebDriverWait wait = new WebDriverWait(androidDriver, 20);
		sleep(1000);
		engBtn.click();
		loginStartBtn.click();
		emailInput.sendKeys("ashwin.harikrishnan@experionglobal.com");
		passwordInput.sendKeys("DarsiniTest");
		signInBtn.click();
		sleep(2000);
		
		popupAccept.click();
							
		//signInBtn.click();
		
	}
	
	public void invalidLogin() {
		sleep(1000);
		engBtn.click();
		loginStartBtn.click();
		emailInput.sendKeys("chinchugs+20@gmail.com");
		passwordInput.sendKeys("nima123");
		signInBtn.click();
		sleep(2000);
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "We did not recognize that combination. Please try again";
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		androidDriver.quit();
	}
	//android.widget.TextView[@text = 'Email Address']//following::android.widget.EditText[1]
	
	public searchSubjectRep(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}
	

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}


