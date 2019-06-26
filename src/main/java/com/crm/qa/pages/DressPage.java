package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;


public class DressPage extends TestBase {
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dress;
	
	@FindBy(xpath="//*[@id='layered_category_9']")
	private WebElement casualDressSelection;
	
	@FindBy(xpath="//*[@id='layered_category_10']")
	private WebElement eveningDressSelection;
	
	@FindBy(xpath="//*[@id='layered_category_11']")
	private WebElement summerDressSelection;
	
	@FindBy(xpath="//*[@id='layered_id_attribute_group_1']")
	private WebElement smallSizeSelection;
	
	@FindBy(xpath="//*[@id='layered_id_attribute_group_2']")
	private WebElement mediumSizeSelection;
	
	@FindBy(xpath="//*[@id='layered_id_attribute_group_3']")
	private WebElement largeDressSelection;
	
	@FindBy(xpath="//a[@title='Add to cart'][@data-id-product='3']")
	private WebElement DressAddToCart;
	
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement ProceedToCheckout;

	
	@FindBy(xpath="//i[@class='icon-th-list']")
	private WebElement ListIcon;
	
	
	public DressPage(){
		PageFactory.initElements(driver, this);
		
	}
	@Step("Clicking on the dress link")
	public void clickOnDress() {
		dress.click();
		
	}
	@Step("Selecting the dress catagory with {0}")
	public void selectCategory(String category) {
		int selection=0;
		if(category.equalsIgnoreCase("CASUAL"))
			selection=1;
		else if(category.equalsIgnoreCase("EVENING"))
			selection=2;
		else
			selection=3;
		switch (selection) {
		
		case 1:
			casualDressSelection.click();
			break;
		case 2:
			eveningDressSelection.click();
			break;
		case 3:
			summerDressSelection.click();
			break;
		}
	}
	@Step("Selecting the dress size with {0}")
	public void selectSize(String size) {
		int selection=0;
		if(size.equalsIgnoreCase("SMALL"))
			selection=1;
		if(size.equalsIgnoreCase("MEDIUM"))
			selection=2;
		if(size.equalsIgnoreCase("LARGE"))
			selection=3;
		
		switch (selection) {
		
		case 1:
			smallSizeSelection.click();
			break;
		case 2:
			mediumSizeSelection.click();
			break;
		case 3:
			largeDressSelection.click();
			break;
}
}
	@Step("Adding the dress to cart")
	public void dressAddToCart() {
		DressAddToCart.click();
	}
	@Step("Proceeding to checkout")
	public void proceedToCheckout() {
		
		ProceedToCheckout.click();
	}
	@Step("Clicking on the list icon")
	public void clickListIcon() {
		ListIcon.click();
	}
	
	public void mouseOver() {
		Actions action = new Actions(driver);
		//WebElement element = driver.findElement(By.xpath(xpathExpression));
	}
}
