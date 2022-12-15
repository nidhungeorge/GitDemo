package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(name="title")
	WebElement dropdownTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public Boolean verifyContactLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public Boolean createNewContact(String title,String fname,String Lname, String cmpany)
	{
		Select sct=new  Select(dropdownTitle);
		sct.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(Lname);
		company.sendKeys(cmpany);
		saveBtn.click();
		String fullname=title+" "+fname+" "+Lname;
		WebElement ele=driver.findElement(By.xpath("//td[contains(text(),'"+fullname+"')]"));
		return ele.isDisplayed();
	}

}
