package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	String sheetName = "Contacts";

	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		homePage=new HomePage();
		contactPage=new ContactPage();
		testUtil=new TestUtil();
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	    testUtil.switchToFrame();
		contactPage=homePage.clickonContactLink();
		
	}
	
	@Test(priority = 1)	
	public void verifyContactLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactLabel(),"Label is missing");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	} 
	
	@Test(priority = 2,dataProvider = "getCRMTestData" )	
	public void createNewContactTest(String title, String firstName, String lastName, String company) 
	{
		homePage.clickOnNewContactLink();
		//contactPage.createNewContact("Mr.","Nidhu","Geo","Google");
		
		Assert.assertTrue(contactPage.createNewContact(title, firstName, lastName, company),"Label is missing");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
