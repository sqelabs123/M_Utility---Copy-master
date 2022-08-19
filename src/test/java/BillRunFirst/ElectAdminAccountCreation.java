package BillRunFirst;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.BrowserList;
import ExtentReport.ExtentReportClass;
import Re_usable.Assertion_Test;
import Re_usable.Repo_Test;
import Re_usable.Sauce_Instance_Login_Test;
import Re_usable.Sauce_instance_Test;

public class ElectAdminAccountCreation extends ExtentReportClass
//public class ElectAdminAccountCreation extends Sauce_instance_Test
{
	
	public Repo_Test action_obj;
	public Assertion_Test Assertion_obj;

	public String username="";
	public Date date = new Date();
	BrowserList bl = new BrowserList();

	
	
	public JavascriptExecutor executor;

	public String companyname="";
	public String contactemail="kingtest@yopmail.com";
	public String pass="Sqe123!@#";
	public String changepass="Sqe123!@#";
 	public String lname="Build";
	public String groupName="";
	public String Fname="John";
	//#####################################################
	@Test(priority = 0)
	@Parameters({"userId"})
	public void createAdminAcc(String userId) throws Exception {
		extentTest = extent.startTest("createAdminAcc");
		bl.initialize();
		Thread.sleep(3000);
		
		 bl.urlStack();	
			driver.manage().window().maximize();   
			Thread.sleep(3000);
			action_obj = new Repo_Test(driver);
			Assertion_obj = new Assertion_Test(driver);
			executor=(JavascriptExecutor) driver;
			Date date = new Date();
			companyname=date.toString();
			companyname=companyname.replace(":", "");
			groupName=date.toString();
			groupName=groupName.replace(":", "");  
			
			
			

			driver.navigate().refresh();
			//Enter User Name
			action_obj.useranme().clear();
			action_obj.useranme().sendKeys(userId);
			//Enter Password
			action_obj.Password().clear();
			action_obj.Password().sendKeys(pass);
			//Click to login
			action_obj.loginbutton().click();  
		action_obj = new Repo_Test(driver);
		Assertion_obj = new Assertion_Test(driver);

		//admin main menu
		action_obj.admin_mainMenu().click();
		//user under user manager section
		action_obj.Users_under_user_manager().click();
		//create new user button
		action_obj.create_new_user_button().click();

		//current date user entry
		username=date.toString();
		System.out.println("The Time Is :-----------"+username);
		username= username.replace(":", "");
		username=username.replace(" ", "");
		username="1111a"+username;

       /* Thread.sleep(8000);
		//id of newly creating user 
        //Add Group 13-05-2019
        action_obj.Groupclick().click();
        Thread.sleep(1000);
        action_obj.selectGroup().click();
 		Actions action = new Actions(driver);
 		action.sendKeys(Keys.ESCAPE).build().perform();
		*/
        action_obj.new_user_id().clear();
		action_obj.new_user_id().sendKeys(username);
		//Password field
		action_obj.new_user_password().clear();
		action_obj.new_user_password().sendKeys("Testing004#");
		//Clik on the Save user link
		action_obj.save_user_button().click();
	//Assertion_obj.userlist_assertion_Validation();

	}

	@Test(priority =1, groups={"A"})
	public void loginCreatedAcc() throws InterruptedException {
		extentTest = extent.startTest("loginCreatedAcc");

		//search user name above created
		action_obj.searchnewcreatedUser().sendKeys(username);
		//admin check box
//		action_obj.admincheckBox().click();
		//ok
//		action_obj.ok().click();
		//refresh
		driver.navigate().refresh();
		//logout
		action_obj.user_icon_logout().click();
		action_obj.logout().click();
		//user id field
		action_obj.useranme().sendKeys(username);
		//Password field
		action_obj.Password().sendKeys("Testing004#");// enter valid password
		//Click to login
		action_obj.loginbutton().click();
		//admin main menu
		action_obj.admin_mainMenu().click();
		//user under user manager section
		action_obj.Users_under_user_manager().click();
		//search user above created
		action_obj.searchnewcreatedUser().sendKeys(username);
		//admin check box
		action_obj.admininquirynow().click();
		Thread.sleep(500);
		action_obj.admincheckBox().click();
		//ok
//		action_obj.ok().click();
		driver.navigate().refresh();
		//logout
		action_obj.user_icon_logout().click();
		action_obj.logout().click();



	}

	@Test(priority =2)
	public void editAcc() throws Exception {
		extentTest = extent.startTest("editAcc");

		//user id field
		action_obj.useranme().sendKeys(username);
		//Password field
		action_obj.Password().sendKeys("Testing004#");// enter valid password
		//login button
		action_obj.loginbutton().click();

		// if permission text is not displayed, only then click to admin main menu
		/*List<WebElement> bcount=driver.findElements(By.xpath(".//span[contains(text(),'Back')]"));
		if(bcount.size()==0)
			//action_obj.admin_mainMenu().click();
		//Assertion_obj.permission_text_Validation();
		//pop up back button
		action_obj.back_button().click();
*/
	}
}
