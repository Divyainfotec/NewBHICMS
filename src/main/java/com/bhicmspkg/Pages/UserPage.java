package com.bhicmspkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class UserPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(UserPage.class);
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
		@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
		@FindBy(xpath = "//li//a[text()='Users']") public WebElement settingsusers;
		@FindBy(xpath = "//*[@class='createuser']") public WebElement Adduserbutton;
		
		@FindBy(xpath = "//*[@id='Users_first_name']") public WebElement Firstname;
		@FindBy(xpath = "//*[@id='Users_last_name']") public WebElement lastname;
		@FindBy(xpath = "//*[@maxlength='20'and @type='text']") public WebElement userusername;
		@FindBy(xpath = "//*[@id='Users_password']") public WebElement userpassword;
		@FindBy(xpath = "//*[@id='Users_email']") public WebElement useremail;
		@FindBy(xpath = "//*[@id='Users_phonenumber']") public WebElement userphone;
		
		
		@FindBy(xpath = "//div[4]//select[@name='Users[user_type]']") public WebElement selusertype;
		@FindBy(xpath = "div[5]//select[@id='Users_reporting_person']") public WebElement selreptperson;
		@FindBy(xpath = "//span[@id='Users_status']//input[1]") public WebElement activestatus;
		@FindBy(xpath = "//input[@value='Create']") public WebElement createbtn;
		@FindBy(xpath = "//*[@value='Save']") public WebElement saveuserbutton;
	public void clicksettings()
	{
		this.settingsmenu.click();
		logger.info("--------click settings menu----------------");
	}
	public void clicksettingsusers()
	{
		this.settingsusers.click();
		logger.info("--------click users from menu----------------");
	}
	public void clickadduserbtn()
	{
		this.Adduserbutton.click();
		logger.info("---------click add user button---------------");
	}
	public void typefirstname(String firstname)
	{
		this.Firstname.sendKeys(firstname);
		logger.info("-----------type firstname----------------");
	}
	public void typelastname(String lastname)
	{
		this.lastname.sendKeys(lastname);
		logger.info("-----------type lastname----------------");
	}
	
	public void typeusername(String username)
	{
		this.userusername.sendKeys(username);
		logger.info("-----------type username----------------");
	}
	public void typeuserpassword(String userpassword)
	{
		this.userpassword.sendKeys(userpassword);
		logger.info("-----------type userpassword----------------");
	}
	public void typeuseremail(String useremail)
	{
		this.useremail.sendKeys(useremail);
		logger.info("-----------type useremail----------------");
	}
	public void typeuserphoneno(String userphoneno)
	{
		this.userphone.sendKeys(userphoneno);
		logger.info("-----------type userphoneno----------------");
	}
	public void selusertype(String usertype)
	{
		DropdownHelper dpselusertype=new DropdownHelper(driver);
		dpselusertype.SelectUsingVisibleText(this.selusertype, usertype);
		logger.info("--------select user type----------------");
	}
	public void selreptperson(String reptperson)
	{
		DropdownHelper dpselrptperson=new DropdownHelper(driver);
		dpselrptperson.SelectUsingVisibleText(selreptperson, reptperson);
		logger.info("------select reporting person----------------------");
	}
	public void clickactivestatus()
	{
		this.activestatus.click();
		logger.info("------------click active status-------------------");
	}
	public void clickcreatebtn()
	{
		this.createbtn.click();
		logger.info("-----------click create button-------------------------");
	}
	public void clicksavebutton()
	{
		this.saveuserbutton.click();
	}
	/*
	 * public void clickcompany(String expcompanyname)//choosecompany {
	 * List<WebElement>companylist=driver.findElements(By.xpath(
	 * "//*[@id='Users_company_id']//li//label")); for(int
	 * i=1;i<=companylist.size();i++) { String
	 * cmpname=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+
	 * "]//label")).getText(); if(expcompanyname.equals(cmpname)) {
	 * driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//label"))
	 * .click(); } } }
	 */
	
}
