package com.bhicmspkg.Pages;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class DayBookPage {
	
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	private final Logger logger=LoggerHelper.getLogger(DayBookPage.class);
	public DayBookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='Day Book']")public WebElement daybookmenu;
	@FindBy(xpath="//*[@id='expense']/div[2]/div/button")public WebElement daybookaddentries;
	@FindBy(xpath="//*[@id='select2-Expenses_company_id-container']")public WebElement daybookselcmpny;
	@FindBy(xpath = "//*[@class='select2-search__field']")public WebElement searchvalue;
	@FindBy(xpath = "//*[@id='Expenses_projectid']")public WebElement seldaybookproject;
	@FindBy(xpath = "//*[@id='Expenses_expense_type']")public WebElement seltransactionhead;
	@FindBy(xpath = "//*[@id='txtDescription']")public WebElement daybookdescr;
	@FindBy(xpath = "//*[@id='txtPurchaseType']")public WebElement daybookpurtype;
	@FindBy(xpath = "//*[@id='Expenses_bank_id']")public WebElement seldbbank ;
	@FindBy(xpath = "//*[@id='txtChequeno']")public WebElement dbchqno ;
	@FindBy(xpath = "//*[@id='Expenses_bill_id']")public WebElement seldaybillno;
	@FindBy(xpath = "//*[@id='buttonsubmit']")public WebElement dbaddbtn;
	@FindBy(xpath = "//table[@id='fixTable']//tbody//tr//td[4]")public WebElement billno ;
/*	
 * 
 * @FindBy(xpath = "")public WebElement ;
	@FindBy(xpath = "")public WebElement ;
	@FindBy(xpath = "")public WebElement ;
	@FindBy(xpath = "")public WebElement ;*/
	
	
	public void clickdaybook()
	{
		this.daybookmenu.click();
		logger.info("-------click daybook menu------------");
	}
	public void clickdaybookadd()
	{
		this.daybookaddentries.click();
		logger.info("-------click daybook add Entries------------");
	}
	public void clickdaybookselcmpny()
	{
		this.daybookselcmpny.click();
		logger.info("-------click select company------------");
	}
	public void typevalue(String value) throws InterruptedException
	{
		GenericHelper gener=new GenericHelper();
		 gener.typevalueinsearch(this.searchvalue, value);
	}
	public void seldayproject(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seldaybookproject, pjtname);
	}
	public void seldbbillno(String billno)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seldaybillno, billno);
	}
	public void seldbtranshead(String transactionhead)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seltransactionhead, transactionhead);
	}
	public void typedaybookdescr()
	{
		this.daybookdescr.sendKeys("--daybook transaction description-- ");
	}
	public void seldbpurtype(String purtype)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.daybookpurtype, purtype);
	}
	public void seldbbank()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.seldbbank, 1);
	}
	public void typechkno()
	{
	this.dbchqno.sendKeys("chqno"+RandomStringUtils.randomNumeric(3));
	}
	public void clickdbaddbtn()
	{
		this.dbaddbtn.click();
	}
	public String resultbillno()
	{
		String resultbillno=this.billno.getText();
		return resultbillno;
	}
}
