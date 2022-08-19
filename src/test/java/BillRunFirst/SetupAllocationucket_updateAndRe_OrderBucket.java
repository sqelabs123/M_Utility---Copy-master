package BillRunFirst;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.BrowserList;
import ExtentReport.ExtentReportClass;
import Re_usable.Assertion_Test;
import Re_usable.Repo_Test;
import Re_usable.Sauce_Instance_Login_Test;
import Re_usable.Sauce_instance_Test;

public class SetupAllocationucket_updateAndRe_OrderBucket extends ExtentReportClass
{
	static String title="";
	//protected WebDriver driver;
	Repo_Test action_obj;
	Assertion_Test Assertion_obj;



	static String mno="";
	static String wno="";
	public static String pID;
	public static String pID1;
	public static String Batchno;
	public static String CID;
	boolean bValue = false;
	public static JavascriptExecutor executor;
	String AddedDescription,firstValue, Secondvalue, updatedText;
	BrowserList bl = new BrowserList();
	@Test(priority = 1)
	@Parameters({"userId"})
	public void SetUpAddNewBucket(String userId) throws Exception
	{	
		extentTest = extent.startTest(" SetUpAddNewBucket");
		bl.initialize();
		Thread.sleep(3000);
		
		 bl.urlStack();	
			driver.manage().window().maximize();   
			Thread.sleep(3000);
			ElectAccountCreation_test.login(userId);

		//throw new SkipException("New Functionality");  
		action_obj = new Repo_Test(driver);
		Assertion_obj = new Assertion_Test(driver);

		action_obj.admin_mainMenu().click();
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1500)", "");
		//Click On Allocation Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[4]/a/p")).click();
		
//      action_obj.allocation().click();	 
		System.out.println("//---------Allocation Section Open----------///");	
		Thread.sleep(3000);
		action_obj.AddNewBucket_Button().click();
		
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		mno=cal.getTime().toString(); 
		System.out.println(mno=mno.substring(11,19));
		mno=mno.replaceAll(":","");
		
			
		action_obj.BucketDescriptionName().sendKeys("Add New Bucket1 "+mno);
		Thread.sleep(2000);
		AddedDescription=action_obj.BucketDescriptionName().getText();

		// Add Bucket Description
		action_obj.Add_List_ButtonOnAllocationBycket().click();
		Thread.sleep(3000);
		action_obj.SaveChangesButton().click();
		Assertion_obj.Success_Message_afterCreateBucket();
		// Assertion_obj.ValidateAddedDescription();



		/*//Drag and Drop Section 

		WebElement Sourcelocator=action_obj.Sourcelocator_allocation();
		WebElement Destinationlocator=action_obj.Destinationlocator_allocation();

		//	Actions.dragAndDrop(Sourcelocator, Destinationlocator);

		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);					

		//Dragged and dropped.		
		act.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();	
		System.out.println("Drag and Drop");
		action_obj.Update_allocation().click();
		Thread.sleep(3000);
		System.out.println("//---------------Allocation Section Complete------------///");  */

	//	Thread.sleep(22567);
	}
	@Test(priority = 2)
	public void Re_orderAllocationBucket() throws Exception
	{
		extentTest = extent.startTest("Re_orderAllocationBucket");
		Thread.sleep(3000);
		action_obj.AddNewBucket_Button().click();
		
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		mno=cal.getTime().toString(); 
		System.out.println(mno=mno.substring(11,19));
		mno=mno.replaceAll(":","");
		
		
		
		action_obj.BucketDescriptionName().sendKeys("Add New Bucket2 "+mno);
		Thread.sleep(2000);
		// Add Bucket Description
		action_obj.Add_List_ButtonOnAllocationBycket().click();
		Thread.sleep(3000);
		action_obj.SaveChangesButton().click();
		Assertion_obj.Success_Message_afterCreateBucket();
		Thread.sleep(2000);

		Secondvalue=action_obj.GetSecondVaule().getText();
		//Drag and Drop Section 

		WebElement Sourcelocator=action_obj.Sourcelocator_allocation();
		WebElement Destinationlocator=action_obj.Destinationlocator_allocation();

		//	Actions.dragAndDrop(Sourcelocator, Destinationlocator);

		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);					

		//Dragged and dropped.		
		act.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();	
		System.out.println("Drag and Drop");
		firstValue=action_obj.GetFirstDescriptionValue().getText();
		//action_obj.Update_allocation().click();
		Assert.assertEquals(Secondvalue, firstValue);
		System.out.println("Assert Pass");

		// action_obj.GetSecondVaule().equals(firstValue);
		
	//	Thread.sleep(29678);
	}
	@Test(priority=3)
	public void Update_AllocationBucket() throws Exception
	{
		extentTest = extent.startTest("Update_AllocationBucket");
		driver.navigate().refresh();
		action_obj.admin_mainMenu().click();
		//Click On Allocation Button
		action_obj.allocation().click();
		action_obj.EditIconOFAddedBucket().click();
		Thread.sleep(3000);
		//Assertion_obj.ValidateEditBucketPopupTitleName();
		WebElement AddDestioption=	action_obj.Description_FieldOnEdit(); 
		AddDestioption.clear();
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		mno=cal.getTime().toString(); 
		System.out.println(mno=mno.substring(11,19));
		mno=mno.replaceAll(":","");
					
		AddDestioption.sendKeys("Update Allocation any "+mno);
		Thread.sleep(3000);
		//updatedText=action_obj.Description_FieldOnEdit().getText();
		//System.out.println(updatedText+"test this" );
		Thread.sleep(5000);
		action_obj.Update_Button().click();
		Thread.sleep(5000);
		action_obj.SaveChangesButton().click();
		Thread.sleep(4000);
		Assertion_obj.Success_Message_afterCreateBucket();
		Thread.sleep(4000);
		String updateactual=action_obj.GetFirstDescriptionValue().getText();
		Assert.assertEquals(updateactual, "Update Allocation any "+mno);
		
		//Thread.sleep(32789);
	}
	@Test(priority=4)
	public void Delete_Bucket_Allocation() throws Exception 
	{
		extentTest = extent.startTest("Delete_Bucket_Allocation");
		driver.navigate().refresh();
		action_obj.admin_mainMenu().click();
		//Click On Allocation Button
		Thread.sleep(5000);
		action_obj.allocation().click();
		Thread.sleep(8000);
		action_obj.AddNewBucket_Button().click();
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		mno=cal.getTime().toString(); 
		System.out.println(mno=mno.substring(11,19));
		mno=mno.replaceAll(":","");
		
		
		action_obj.BucketDescriptionName().sendKeys("Add New Bucket3 "+mno);
		Thread.sleep(2000);
		// Add Bucket Description
		action_obj.Add_List_ButtonOnAllocationBycket().click();
		Thread.sleep(3000);
		action_obj.SaveChangesButton().click();
		Assertion_obj.Success_Message_afterCreateBucket();
		Thread.sleep(4000);
		action_obj.DeleteBtn().click();
		action_obj.ConfirmationOk().click();
		List<WebElement> element=driver.findElements(By.xpath("//tbody[@id='priorityData']/tr[3]/td[4]/a[2]"));

		if(element.size()>0){
			System.out.println("Step pass");
		}else {
			//WebElement element2 = driver.findElement(By.xpath("//tbody[@id='priorityData']/tr[3]/td[4]/a[2]"));

			Assert.assertFalse(((WebElement) element).isDisplayed());
		}
		
		//Thread.sleep(28999);
	}
	@Test(priority=5)
	public void ValidateSequanceEqualtoBucketRecord() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("ValidateSequanceEqualtoBucketRecord");
		//	action_obj = new Repo_Test(driver);
		//Assertion_obj = new Assertion_Test(driver);

		driver.navigate().refresh();
		Thread.sleep(8000);
		action_obj.admin_mainMenu().click();
		action_obj.allocation().click();	
		Thread.sleep(5000);
		List listofPriorityBuckets=driver.findElements(By.xpath("//tbody[@id='priorityData']/tr"));
		System.out.println("Number of Buckets List:" +listofPriorityBuckets.size());
		int countgetbuckets=listofPriorityBuckets.size();
		for (int i=0; i<listofPriorityBuckets.size();i++){
			System.out.println("Bucket Row following options available:" + listofPriorityBuckets.get(i));
		}

		String RowOne=driver.findElement(By.xpath("//tbody[@id='priorityData']/tr[1]/td[3]")).getText();
		System.out.println(RowOne);

		String RowTwo=driver.findElement(By.xpath("//tbody[@id='priorityData']/tr[2]/td[3]")).getText();
		System.out.println(RowTwo);
		//Plan Button
		Thread.sleep(4000);
		action_obj.plan_mainmebu().click();
		Thread.sleep(2000);
		action_obj.PlanEditIcon().click();	
		Thread.sleep(3000);

		action_obj.AddTariffButton().click();
		Thread.sleep(2000);
		//	List Bucketoption=driver.findElements(By.xpath("//div[@id='allocDIV']/div/select/option")); 

		//driver.findElement(By.id("alloc")).click();
		action_obj.AllocationDropdownonTariffpopup().click();

		String index1 = driver.findElement(By.xpath("//select[@id='alloc']/option[2]")).getText();
		System.out.println(index1);
		String index2 = driver.findElement(By.xpath("//select[@id='alloc']/option[3]")).getText();		   
		System.out.println(index2);


		Assert.assertEquals(RowOne, index1);
		Assert.assertEquals(RowTwo, index2);
		
	//	Thread.sleep(16333);
	}
	@Test(priority=6)
	public void ValidateSequanceEqualtoBucketRecord_AfterReOrder() throws Exception
	{
		extentTest = extent.startTest("ValidateSequanceEqualtoBucketRecord_AfterReOrder");
		driver.navigate().refresh();
		Thread.sleep(8000);
		action_obj.admin_mainMenu().click();
		action_obj.allocation().click();	
		Thread.sleep(8000);
		Secondvalue=action_obj.GetSecondVaule().getText();
		//Drag and Drop Section 

		WebElement Sourcelocator=action_obj.Sourcelocator_allocation();
		WebElement Destinationlocator=action_obj.Destinationlocator_allocation();

		//	Actions.dragAndDrop(Sourcelocator, Destinationlocator);

		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);					

		//Dragged and dropped.		
		act.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();	
		System.out.println("Drag and Drop");
		Thread.sleep(2000);
		firstValue=action_obj.GetFirstDescriptionValue().getText();
		Thread.sleep(5000);
		//action_obj.Update_allocation().click();
		Thread.sleep(5000);
		Assert.assertEquals(Secondvalue, firstValue);
		System.out.println("Assert Pass");
		Thread.sleep(5000);
		action_obj.SaveChangesButton().click();
		Assertion_obj.Success_Message_afterCreateBucket();
		Thread.sleep(8000);
		
		String RowOneUpdate=driver.findElement(By.xpath("//tbody[@id='priorityData']/tr[1]/td[3]")).getText();
		System.out.println(RowOneUpdate);

		String RowTwoUpdate=driver.findElement(By.xpath("//tbody[@id='priorityData']/tr[2]/td[3]")).getText();
		System.out.println(RowTwoUpdate);
		driver.navigate().refresh();
		//Plan Button
		Thread.sleep(4000);
		action_obj.plan_mainmebu().click();
		Thread.sleep(2000);
		action_obj.PlanEditIcon().click();	
		Thread.sleep(3000);

		action_obj.AddTariffButton().click();
		Thread.sleep(4000);
		action_obj.AllocationDropdownonTariffpopup().click();

		String index1Update = driver.findElement(By.xpath("//select[@id='alloc']/option[2]")).getText();
		System.out.println(index1Update);
		String index2Update = driver.findElement(By.xpath("//select[@id='alloc']/option[3]")).getText();		   
		System.out.println(index2Update);

		Assert.assertEquals(RowOneUpdate, index1Update);
		Assert.assertEquals(RowTwoUpdate, index2Update);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	//	Thread.sleep(21333);

	}
}
