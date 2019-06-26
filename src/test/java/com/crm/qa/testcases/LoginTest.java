package com.crm.qa.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.Utils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class LoginTest extends TestBase {
	String className = this.getClass().getSimpleName();
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		TestBase.initialization();	
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Adding dress to Cart")
	@Story("Story name: R&D")
	public void loginfunction() throws InterruptedException{
		initializePOM();
		Map<String, String> m = userForm();
		//loginPage.pageLogin(m.get("User"),m.get("Password"));
		//crmHomePage.clickWeekView();
		dressHomePage.clickOnDress();
		dressHomePage.selectCategory("CASUAL");
		dressHomePage.selectSize("SMALL");
		dressHomePage.clickListIcon();
		//dressHomePage.dressAddToCart();
		//dressHomePage.proceedToCheckout();
		//dressCartPage.validateDressCount();
	}
	
	public Map<String, String> userForm(){
		String filename=prop.getProperty("filename");
		String sheetname=prop.getProperty("sheetname");
		Map<String, String> data = new HashMap<String, String>();
		try {
			data = Utils.getTestData(filename,sheetname,className);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	
	@AfterMethod
	public void endOfScript(){
		//driver.quit();
	}

}
