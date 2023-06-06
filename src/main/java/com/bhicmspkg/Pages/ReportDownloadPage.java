package com.bhicmspkg.Pages;

import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.Dateselectionhelper;
import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class ReportDownloadPage {
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(SubcontractorPage.class);
	public ReportDownloadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*  
	 *   @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement
	 *   @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 *  
	 *  
		
	 */
	@FindBy(xpath="//li//a[text()='Reports']")public WebElement reportmenu;
	@FindBy(xpath="//li//a[text()='Financial Reports']")public WebElement financialrpt;
	@FindBy(xpath="//a[text()='SAVE AS PDF']")public WebElement saveaspdf;
	@FindBy(xpath="//a[text()='SAVE AS EXCEL']")public WebElement saveasexcel;
	@FindBy(xpath="//li//a[text()='Receipt Report']")public WebElement receiptrptdwnld;
	@FindBy(xpath="//li//a[text()='Work Status Report']")public WebElement workstatus;
	@FindBy(xpath="//li//a[text()='Weekly Payment Report']")public WebElement weeklypaymntrpt;
	@FindBy(xpath="//li//a[text()='Project Report']")public WebElement projectreport;
	 @FindBy(xpath="//*[@id='project_id']")public WebElement pjtrptpjt;
	 @FindBy(xpath="//*[@id='project_status']")public WebElement pjtstatus;
	 @FindBy(xpath="//*[@id='company_id']")public WebElement pjtrptcmp;
	 @FindBy(xpath="//*[@value='GO']")public WebElement rptpjtgo;
	 @FindBy(xpath="//a[text()='UnReconciled Report']")public WebElement pjtrptunreconrpt;
	 @FindBy(xpath="//*[@id='company_id']")public WebElement receiptcmpny;
	 @FindBy(xpath="//*[@id='Expenses_fromdate']")public WebElement expfrmdate;
	 @FindBy(xpath="//*[@id='Expenses_todate']")public WebElement exptodate;
	 @FindBy(xpath="//*[@id='expenses-form']/div[4]/input[1]")public WebElement receiptrptgobtn;
	 @FindBy(xpath="//*[@id='subcontractor_id']")public WebElement subcntrname;
	 @FindBy(xpath="//*[@id='projectid']")public WebElement weeklyrptsubcntrpjt;
	 @FindBy(xpath="//*[@class='filter_elem filter_btns']//input[@value='Go']")public WebElement weeklypaymntgobtn;
	 @FindBy(xpath="//li//a[text()='Day Book Transactions']")public WebElement daybooktransopt;
	 @FindBy(xpath="//*[@id='Expenses_type']")public WebElement daybooktranstype;
	 @FindBy(xpath="//*[@id='Expenses_vendor_id']")public WebElement daybookvndrname;
	 @FindBy(xpath="//*[@id='Expenses_purchase_type']")public WebElement daybookpurchasetype;
	 @FindBy(xpath="//*[@id='Expenses_expense_type']")public WebElement daybookexptranstype;
	 @FindBy(xpath="//*[@id='Expenses_subcontractor_id']")public WebElement daybooksubcntrname;
	 @FindBy(xpath="//*[@id='search-form']/div[2]//div[5]//input[1]")public WebElement daybookgobtn;
	 //dailyexp rpt
	 @FindBy(xpath="//li//a[text()='Daily Expense Report']")public WebElement dailyexprpt;
	 @FindBy(xpath="//*[@id='Dailyexpense_exp_type']")public WebElement dlyexptype;
	 @FindBy(xpath="//*[@id='dailyexpense_purchase_type']")public WebElement dlyexppurchasetype;
	 @FindBy(xpath="//*[@id='Dailyexpense_expense_type']")public WebElement dlyexptranstype;
	 @FindBy(xpath="//*[@name='monthlyreport']")public WebElement dlyexpgobtn;
	 //vendorpaymnt rpt
	 @FindBy(xpath="//li//a[text()='Vendor Payment Report']")public WebElement vndrpaymntrpt;
	 @FindBy(xpath="//*[@id='vendor_id']")public WebElement vendorname;
	 @FindBy(xpath="//*[@id='btSubmit']")public WebElement vndrgobtn;
	 //subcntr paymnt rpt
	 @FindBy(xpath="//li//a[text()='Subcontractor Payment Report']")public WebElement subcntrpaymntrpt;
	 @FindBy(xpath="//*[@id='subcontractor_id']")public WebElement selsucntrname;
	 @FindBy(xpath="//*[@name='project_id']")public WebElement subcntrpjtname;
	 //cash balance report
	 @FindBy(xpath="//li//a[text()='Cashbalance  Report']")public WebElement cashbalancereport;
	 @FindBy(xpath="//*[@id='date_from']")public WebElement datefrom;
	 //taxreport
	 @FindBy(xpath="//li//a[text()='Tax Report']")public WebElement taxreport;
	 //reconciliation report
	 @FindBy(xpath="//li//a[text()='Reconciliation Report']")public WebElement reconciliationrpt;
	 @FindBy(xpath="//*[@id='Reconciliation_reconciliation_bank']")public WebElement reconcilebankname;
	 @FindBy(xpath="//*[@id='Reconciliation_company_id']")public WebElement  recocilecmpny;
	 @FindBy(xpath="//*[@type='submit']")public WebElement reconciligobtn;
	 //purchase report
	 @FindBy(xpath="//*[@name='Bills[project]']")public WebElement  purchaserptpjt;
	 @FindBy(xpath="//*[@name='Bills[vendor]']")public WebElement purchasevendr;
	 @FindBy(xpath="//li//a[text()='Purchase bill Report']")public WebElement purchasebillrpt;
	public void Clickreportmenu()
	{
		this.reportmenu.click();
	}
	public void Clickfinancialrpt()
	{
		this.financialrpt.click();
	}
	public void clicksaveaspdf()
	{
		this.saveaspdf.click();
	}
	public void clicksaveasexcel()
	{
		this.saveasexcel.click();
	}
	public void clickreceiptrpt()
	{
		this.receiptrptdwnld.click();
	}
	public void clickworkstatus()
	{
		this.workstatus.click();
	}
	public void Clickweeklypaymntrpt()
	{
		this.weeklypaymntrpt.click();
	}
	public void Clickprojectreport()
	{
		this.projectreport.click();
	}
	public void selpjtrptpjt(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtrptpjt, pjtname);
	}
	public void selpjtstatus(String pjtstatus)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtstatus, pjtstatus);
	}
	public void selpjtrptcmpny(String cmpname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtrptcmp, cmpname);
	}
	public void clickpjtrptgo()
	{
		this.rptpjtgo.click();
	}
	public void Clickunreconciledrpt()
	{
		this.pjtrptunreconrpt.click();
	}
	public void selreceiptcmpny(String company)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.receiptcmpny, company);
	}
	public void selexpfromdate() throws InterruptedException
	{
//		this.expfrmdate.clear();
		LocalDate todaydate=java.time.LocalDate.now();
		this.expfrmdate.sendKeys(""+todaydate.minusMonths(1));
		Thread.sleep(2000);
	}
	public void selexptodate()
	{
		//this.exptodate.clear();
		LocalDate todaydate=java.time.LocalDate.now();
		this.exptodate.sendKeys(""+todaydate);
	}
public void clickreportgobtn()
		{
			this.receiptrptgobtn.click();
		}
	public void selsubcontractor(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.subcntrname, subcntrname);
	}
	public void selweeklyrptpjt(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.weeklyrptsubcntrpjt, pjtname);
	}
	public void Clickweeklypaymntgobtn()
	{
		this.weeklypaymntgobtn.click();
	}
	public void clickdaybooktransaction()
	{
		this.daybooktransopt.click();
	}
	public void seldaybooktranstype_credit()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybooktranstype, 1);
	}
	public void seldaybooktranstype_debit()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybooktranstype, 1);
	}
	public void seldaybookvndrname(String vndrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.daybookvndrname, vndrname);
	}
	public void seldaybookpurchasetype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybookpurchasetype, 2);
	}
	public void seldaybookpexptype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybookexptranstype, 2);
	}
	public void seldaybooksubcntrname(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.daybooksubcntrname, subcntrname);
	}
	public void clickdaybookgobtn()
	{
		this.daybookgobtn.click();
	}
	//dlyexprpt
	public void clickdlyexprpt()
	{
		this.dailyexprpt.click();
	}
	public void seldailyexptype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexptype, 2);
	}
	public void seldailyexppurchasetype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexppurchasetype, 2);
	}
	public void seldailyexptranstype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexptranstype, 2);
	}
	public void clickdlyexpgobtn()
	{
		this.dlyexpgobtn.click();
	}
	//vendor payment report
	public void clickvendrpaymntreport()
	{
		this.vndrpaymntrpt.click();
	}
	public void selvendornamername(String vendorname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.vendorname, vendorname);
	}
	public void clickvndrgobtn()
	{
		this.vndrgobtn.click();
	}
	public void clicksubcntrpaymntreport()
	{
		this.subcntrpaymntrpt.click();
	}
	public void selsubcntrname(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selsucntrname, subcntrname);
	}
	public void selsubcntrpjtname(String subcntrpjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.subcntrpjtname, subcntrpjtname);
	}
	//cash balance report
	public void clickcashbalancereport()
	{
		this.cashbalancereport.click();
	}
	public void seldatefrom(String todaydate)
	{
		this.datefrom.sendKeys(todaydate.toString());
		//dpsel.SelectUsingVisibleValue(this.datefrom, todaydate);
	}
	 public void rptfromdate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='date_from']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_from']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date.minusMonths(1));
		   Thread.sleep(2000);
		  logger.info("--------------enter service report from date-----------------------");
	  }
	 public void rpttodate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='date_to']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_to']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);
		   Thread.sleep(2000);
		  logger.info("--------------enter service report from date-----------------------");
	  }
	 //tax report
	 public void clicktaxreport()
	 {
		 this.taxreport.click();
	 }
	 //reconciliation
	 public void clickreconciliation()
	 {
		 this.reconciliationrpt.click();
	 }
	 
	 public void Reconciliationrptfromdate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='Reconciliation_fromdate']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='Reconciliation_fromdate']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date.minusMonths(1));
		   Thread.sleep(2000);
		  logger.info("--------------enter from date-----------------------");
	  }
	 public void Reconconciliationrpttodate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='Reconciliation_todate']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='Reconciliation_todate']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);
		   Thread.sleep(2000);
		  logger.info("--------------enter to date-----------------------");
	  }
	 public void selbankreconciliation(String bankname)
	 {
		 DropdownHelper dpsel=new DropdownHelper(driver);
		 dpsel.SelectUsingVisibleText(this.reconcilebankname, bankname);
	 }
	 public void selreconcilcmp(String company)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.recocilecmpny, company);
		}
	 public void clickreconcilgobtn()
	 {
		 this.reconciligobtn.click();
	 }
	 //purchase report
	 public void clickpurchasebillreport()
	 {
		 this.purchasebillrpt.click();
	 }
	 public void selpurchasepjt(String purchasepjt)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.purchaserptpjt, purchasepjt);
		}
	 public void selpurchasevndr(String purchasevndr)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.purchasevendr, purchasevndr);
		}
}
