package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class DressCartPage extends TestBase {
	@FindBy(xpath="//a[@title='View my shopping cart']/child::span[1]")
	private WebElement dressCount;
	

	

	public DressCartPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public void validateDressCount() {
		String cartvalue=dressCount.getText();
		System.out.println("the cart value is.............."+cartvalue);
		
	}
	
	
}
