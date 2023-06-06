package com.bhicmspkg.Pages;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class DailyExpensePage {
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(DailyExpensePage.class);
	public DailyExpensePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * 
	 *@FindBy(xpath="")public WebElement
	 * 
	 * 
	 * 
	 * 
		 */
	@FindBy(xpath="//li//a[text()='Daily Expenses']")public WebElement dailyexpensemenu;
	@FindBy(xpath="//*[@id='expense']/div[2]/div/div[1]/button[1]")public WebElement dailyexpaddentries;
	@FindBy(xpath="//*[@id='Dailyexpense_company_id']")public WebElement seldlyexpcmpid;
	@FindBy(xpath="//*[@id='Dailyexpense_bill_id']")public WebElement dlyexpbillno;
	@FindBy(xpath="//*[@id='Dailyexpense_expensehead_id']")public WebElement seldlyexptrhead;
	@FindBy(xpath="//*[@id='Dailyexpense_expense_type']")public WebElement seldlyexptrtype;
	@FindBy(xpath="//*[@id='Dailyexpense_employee_id']")public WebElement pettycashuser;
	@FindBy(xpath="//*[@id='txtAmount']")public WebElement dlyexpamnt;
	@FindBy(xpath="//*[@id='txtPurchaseType']")public WebElement dlyexppurtype;
	@FindBy(xpath="//*[@id='txtDescription']")public WebElement dlyexpdescr;
	@FindBy(xpath="//*[@id='buttonsubmit']")public WebElement dlyexpaddbtn;
	@FindBy(xpath="//*[@id='Dailyexpense_bank_id']")public WebElement dlyexpbank;
	@FindBy(xpath="//*[@id='txtChequeno']")public WebElement dlyexpchkno;
	@FindBy(xpath="//*[@id='fixTable']//tbody//tr//td[3]")public WebElement grddlyexpbillno;
	//Edit
	@FindBy(xpath="//html//body//div[1]//div//div[2]//div//div//div[4]//div//div//div//div[2]//table//tbody[1]//tr//td[16]//span")public WebElement dlyexpaction;
	@FindBy(xpath="//*[@class='popover-content']//ul//li//button[text()='Edit']")public WebElement dlyexpeditbtn;
	@FindBy(xpath="//button[@id='buttonsubmit']")public WebElement dlyexpupdatebtn;
	//@FindBy(xpath="//form//div[4]/div[4]//button[1][text()='UPDATE']")public WebElement dlyexpupdatebtn;
	@FindBy(xpath="//*[@class='popover-content']//ul//li//button[text()='Delete']")public WebElement dlyexpdeletebtn;
	@FindBy(xpath="//*[@id='expense']/div[2]/div/div[1]/button[2]")public WebElement fundtransfer;
	@FindBy(xpath="//*[@id='txtSCompany']")public WebElement fundtrselcmpny;
	@FindBy(xpath="//*[@id='txtSPaymentType']")public WebElement paymnttype;
	 @FindBy(xpath="//*[@id='Cashtransfer_sender_bank']")public WebElement selfndtrbnknme;
	 @FindBy(xpath="//*[@id='txtSChequeno']")public WebElement typefndtrchkno;
	 @FindBy(xpath="//*[@id='txtBCompany']")public WebElement selbcmpny;
	 @FindBy(xpath="//*[@id='txtBPaymentType']")public WebElement selbpaytype;
		@FindBy(xpath="//*[@id='Cashtransfer_beneficiary_bank']")public WebElement selBbnk;
		@FindBy(xpath="//*[@id='txtBChequeno']")public WebElement Bchqno;
		@FindBy(xpath="//*[@id='txtTAmount']")public WebElement Bamnt;
		 @FindBy(xpath="//*[@id='txtDescription1']")public WebElement description;
		 @FindBy(xpath="//*[@id='buttontransfersubmit']")public WebElement fndtraddbtn;
	public void clickdailyexpensemenu()
	{
		this.dailyexpensemenu.click();
	}
	public void clickaddentriesdailyexp()
	{
		this.dailyexpaddentries.click();
	}
	public void seldlyexpcmpny(String cmpnyname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seldlyexpcmpid, cmpnyname);
	}
	public void typedlyexpbillno(String dlyexpbillno)
	{
		this.dlyexpbillno.sendKeys(dlyexpbillno);
	}
	public void seldlyexptrhead()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.seldlyexptrhead, 1);
	}
	public void seldlyexptrtype1(int index)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.seldlyexptrtype, index);
	}
	public void seldlyexptrtype(String trtype)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.seldlyexptrtype, trtype);
	}
	public void selpettycashuser()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.pettycashuser, 1);
	}
	public void typeamount(String dlyexpamnt)
	{
		this.dlyexpamnt.clear();
		this.dlyexpamnt.sendKeys(dlyexpamnt);
	}
	public void seldlyexppurtype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexppurtype, 1);
	}
	public void typedlyexpdescr()
	{
		this.dlyexpdescr.clear();
		this.dlyexpdescr.sendKeys("----daily expense description----");
		
	}
	public void clickadddlyexpbtn()
	{
		this.dlyexpaddbtn.click();
	}
	public void seldlyexpbank()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexpbank, 1);
	}
	public void typechkno()
	{
		
	this.dlyexpchkno.sendKeys("chqno"+RandomStringUtils.randomNumeric(3));	
	}
	public String getdlyexpbillno()
	{
		String billno=this.grddlyexpbillno.getText();
		return billno;
	}
	public int getrowno()
	{
		int rowno= driver.findElements(By.xpath("//*[@id='fixTable']//tbody//tr")).size();
		return rowno;
	}
	public void clickdlyexpaction()
	{
		
		 js=new JavascriptHelper(driver);
		 js.scrollToElemetAndClick(dlyexpaction);
		
	}
	public void clickdlyexpeditbtn()
	{
		this.dlyexpeditbtn.click();
	}
	public void clickupdatebtn() throws InterruptedException
	{
		// js=new JavascriptHelper(driver);
		// js.scrollToElemetAndClick(dlyexpupdatebtn);
		this.dlyexpupdatebtn.click();
		Thread.sleep(2000);
		
		
	}
	public void clickdeletebtn()
	{
		this.dlyexpdeletebtn.click();
	}
	//fund transfer
	public void clickfundtransfer()
	{
		this.fundtransfer.click();
	}
	public void selfndtrcmpny(String cmpname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.fundtrselcmpny, cmpname);
	}
	public void selfndtrpaymnttype(String paymnttype)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.paymnttype, paymnttype);
	}
	public void selfndtrbnknme()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selfndtrbnknme, 1);
	}
	public void typechqno(String chqno)
	{
		this.typefndtrchkno.sendKeys(chqno);
	}
	public void selbcmpny(String cmpnme)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbcmpny, cmpnme);
	}
	public void selbpaytype(String paytype)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbpaytype,paytype );
	}
	public void selfndtrBbnknme()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selBbnk, 1);
	}
	public void typeBchqno(String Bchqno)
	{
		this.Bchqno.sendKeys(Bchqno);
	}
	public void typeBamnt()
	{
		this.Bamnt.sendKeys("300");
	}
	public void typedescr()
	{
		this.description.sendKeys("dailyexpdescr");
	}
	public void clickaddbtn()
	{
		this.fndtraddbtn.click();
	}
}
