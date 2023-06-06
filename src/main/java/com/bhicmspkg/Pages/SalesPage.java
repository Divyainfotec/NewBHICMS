package com.bhicmspkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.LoggerHelper;

public class SalesPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(SalesPage.class);
	public SalesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='yw0']/li[4]/a")public WebElement SalesMenu;
	@FindBy(xpath="//*[@id=\"yw0\"]//li//a[text()='Quotation Generator']")public WebElement quotationgenerator;
	
	public void clickSalesmenu()
	{
		this.SalesMenu.click();
		logger.info("---click sales menu--------------");
	}
	public void clickquotationgenerator()
	{
		this.quotationgenerator.click();
		logger.info("---click quotation generator on sales-------------");
	}
}
