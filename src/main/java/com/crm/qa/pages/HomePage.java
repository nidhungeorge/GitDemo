package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Nidhun geoe')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContactLink;
	
	
	//initializing page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean verifyCorrectName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactPage clickonContactLink()
	{
		contactLink.click();
		return new ContactPage();
	}
	
	public void clickOnNewContactLink() 
	{
		Actions act=new Actions(driver);
		act.moveToElement(contactLink).build().perform();
		//newContactLink.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newContactLink);
		
	}
	
	
	

}
