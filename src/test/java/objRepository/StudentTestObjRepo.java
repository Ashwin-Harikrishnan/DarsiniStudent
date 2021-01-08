package objRepository;

import org.openqa.selenium.support.PageFactory;

import BaseClassPackage.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StudentTestObjRepo extends BaseClass{
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
	
	public StudentTestObjRepo(AndroidDriver<MobileElement> androidDriver){
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);	
	}

}

