package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CrmHomePage extends TestBase {
	@FindBy(xpath="//*[@id='navmenu']/ul/li[2]/a")
	private WebElement calender;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[2]/ul/li[3]/a")
	private WebElement calenderWeekView;
	
	public CrmHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickWeekView(){
		Actions action = new Actions(driver);
		action.moveToElement(calender).perform();
		action.moveToElement(calenderWeekView);
		action.click();
		action.perform();
	}
}
