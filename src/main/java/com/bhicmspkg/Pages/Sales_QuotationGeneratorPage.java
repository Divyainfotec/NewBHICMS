package com.bhicmspkg.Pages;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.TestBase.TestBase;


public class Sales_QuotationGeneratorPage {
	 
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptExecutor e ;
	Config con=new Config(pr);
	private final Logger logger=LoggerHelper.getLogger(CompanyPage.class);
	public Sales_QuotationGeneratorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//body/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1][text()='Sales']")public WebElement salesmenu;
	@FindBy(xpath="//li//a[text()='Quotation Generator']")public WebElement quotationgenerator;
	
	@FindBy(xpath="//a[text()='Add Quotation']")public WebElement AddQuotationbtn;
	
	@FindBy(xpath="//*[@id='SalesQuotationMaster_company_id']")public WebElement selectcmpny;
	@FindBy(xpath="//table//tbody//tr//td[2]")public WebElement grdclientname;
	
	@FindBy(xpath="//*[@id='SalesQuotationMaster_client_name']")public WebElement clientname;
	@FindBy(xpath="//*[@id='SalesQuotationMaster_address']")public WebElement sqAddress;
	@FindBy(xpath="//*[@id='SalesQuotationMaster_phone_no']")public WebElement sqphonenumber;
	@FindBy(xpath="//*[@id='SalesQuotationMaster_email']")public WebElement sqemail;
	@FindBy(xpath="//*[@id='datepicker']")public WebElement sqdate;
	@FindBy(xpath="//*[@id='SalesQuotationMaster_location_id']")public WebElement sqlocation;
	@FindBy(xpath="//*//input[@id='SalesQuotationMaster_invoice_no']")public WebElement sqno;
	@FindBy(xpath="//*[@id='SalesQuotation_id']")public WebElement selcategory;
	@FindBy(xpath="//*[@id='category_label']")public WebElement categorylabel;
	//*[@id='worktype_label0']
	@FindBy(xpath="//table[@id='qitem_table']//tbody//tr//td[2]")public WebElement selworktypelabel;
	@FindBy(xpath="//table[@id='qitem_table']//tbody//tr//td[5]")public WebElement selunit;
	//*[@id='unit0']
	@FindBy(xpath="//table[@id='qitem_table']//tbody//tr//td[6]//input")public WebElement quantity;
	@FindBy(xpath="//*[@value='Add Sub Item']")public WebElement addsubitm;
	@FindBy(xpath="//*[@id='subitem_label1']")public WebElement addsubitemlbl;
	@FindBy(xpath="//*[@id='sub_worktype1']")public WebElement  subitmworktypelblseli;
	
	@FindBy(xpath="//*[@value='Add Extra Work']")public WebElement addextrawork;
	//==================subitem=================
	@FindBy(xpath="//*[@value='Add Sub Item']")public WebElement Addsubitem;
	@FindBy(xpath="//*[@id='subitem_label1']")public WebElement subitemlbl;
	@FindBy(xpath="//*[@id='sub_worktype1']")public WebElement subitmwrktypelbl;
	@FindBy(xpath="//*[@id='sub_worktypelabel1']")public WebElement selsubitmlbl;
	@FindBy(xpath="//*[@id='sub_unit1']")public WebElement selsubitmunit;
	@FindBy(xpath="//*[@id='sub_quantity1']")public WebElement subitmqnty;
	@FindBy(xpath="//*[@id='sub_quantity_nos1']")public WebElement subitmqntyno;
	@FindBy(xpath="//*[@id='sub_mrp1']")public WebElement subitmmrp;
	@FindBy(xpath="//*[@id='sub_amount_after_discount1']")public WebElement subitmamntaftrdicnt;
	
	//===========Extra work
	
	@FindBy(xpath="//*[@value='Add Extra Work']")public WebElement sqgextraworkbtn;
	@FindBy(xpath="//*[@id='SalesQuotation_image']")public WebElement addextrawrkimg;
	@FindBy(xpath="//*[@id='SalesQuotation_description']")public WebElement xtrawrkdescription;
	@FindBy(xpath="//*[@id='SalesQuotation_unit']")public WebElement xtrawrkselunit;
	@FindBy(xpath="//*[@id='SalesQuotation_quantity']")public WebElement xtrawrkquntity;
	@FindBy(xpath="//*[@id='SalesQuotation_quantity_nos']")public WebElement xtrawrkqntynos;
	@FindBy(xpath="//*[@id='SalesQuotation_mrp']")public WebElement xtrawrkmrp;
	@FindBy(xpath="//*[@id='SalesQuotation_amount_after_discount']")public WebElement xtrawrkamntaftrdiscnt;
	
	@FindBy(xpath="//*[@id='additem']")public WebElement  sqgcreatebutton;
	
	//report
	@FindBy(xpath="//table//tbody//tr[1]//td[10]//span")public WebElement sqgaction;
	
	@FindBy(xpath="//table//tbody//tr[1]//td[10]//div[@class='popover-content']//li//a[text()='View']")public WebElement Viewopt;
	@FindBy(xpath="//table//tbody//tr[1]//td[10]//div[@class='popover-content']//li//a[text()='Edit']")public WebElement Editopt;
	@FindBy(xpath="//table//tbody//tr[1]//td[10]//div[@class='popover-content']//li//button[text()='Delete']")public WebElement deleteopt;
	@FindBy(xpath="//a[@id='download']")public WebElement sqgpdf;
	/*
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * 
	
	 * */
	 
	//pdf
	
	public void clicksalesmenu()
	{
		this.salesmenu.click();
	}
	public void clickquotationgenerator()
	{
		this.quotationgenerator.click();
	}
	public void clickaddquotation()
	{
		this.AddQuotationbtn.click();
	}
 public void selcompany(String companyname)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selectcmpny, companyname);
 }
 public void getgrdclientname()
 {
	 
 }
 
 public void typeclientname(String clientname)
 {
	 this.clientname.sendKeys(clientname);
 }
 public void typesqaddress(String address)
 {
	 this.sqAddress.sendKeys(address);
 }
 public void typesqemail(String email)
 {
	 this.sqemail.sendKeys(email);
 }
 public void typesqphoneno(String phoneno)
 {
	 this.sqphonenumber.sendKeys(phoneno);
 }
 public void sellocation()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(sqlocation, 1);
 }
 public void selectcategory(String category)
 {
	 DropdownHelper dpselcategory=new DropdownHelper(driver);
	 dpselcategory.SelectUsingVisibleText(this.selcategory, category);
 }
 public void selworktypelabel()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(selworktypelabel, 1);
 }
 public void selectunit(String unit)
 {
	 DropdownHelper dpselcategory=new DropdownHelper(driver);
	 dpselcategory.SelectUsingVisibleText(this.selunit, unit);
 }
 public void typequantity(String quantity)
 {
	 this.quantity.sendKeys(quantity);
 }
 public void sqdate()
 {
	 LocalDate Today_date=java.time.LocalDate.now();
		String strtdate=Today_date.toString();
		JavascriptHelper jsdate=new JavascriptHelper(driver);
		jsdate.selectDateByJS(driver, this.sqdate, strtdate);
 }
 public void selsqlocation()
 {
	 DropdownHelper dpselloc=new DropdownHelper(driver);
	 dpselloc.SelectUsingIndex(this.sqlocation, 1);
 }
 public String Getqquotationno()
 {
	 return this.sqno.getAttribute("value");
 }
 public void typectgrylabel()
 {
	 this.categorylabel.sendKeys("ctgrylbl"+RandomStringUtils.randomNumeric(1));
 }
 public void selectwrktypelbl() throws InterruptedException
 {
	 List<WebElement>worktypes=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[2]//select"));
	 for(int i=1;i<=worktypes.size();i++)
	 {
		 WebElement elem=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[2]//select"));
		 DropdownHelper dpsel=new DropdownHelper(driver);
		 dpsel.SelectUsingIndex(elem, 1);
		 Thread.sleep(2000);
	 }
 }
 public void selectqgunit(String number) throws InterruptedException
 {
	 List<WebElement>units=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[5]//select"));
	 for(int i=1;i<=units.size();i++)
	 {
		 WebElement elem=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[5]//select"));
		 DropdownHelper dpsel=new DropdownHelper(driver);
		// dpsel.SelectUsingIndex(elem, i);
		 dpsel.SelectUsingVisibleText(elem,number);
		 Thread.sleep(2000);
	 }
 }
 public void typeqgquantity(String quantity) throws InterruptedException
 {
	 List<WebElement>qgquantity=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[6]//input"));
	 for(int i=1;i<=qgquantity.size();i++)
	 {
		 WebElement elem=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[6]//input"));
		 //DropdownHelper dpsel=new DropdownHelper(driver);
		// dpsel.SelectUsingIndex(elem, i);
		 elem.sendKeys(quantity);
		 //dpsel.SelectUsingVisibleText(elem, quantity);
		 Thread.sleep(2000);
	 }
 }
 public void typeqgquantityinnos(String quantityqgnos) throws InterruptedException
 {
	 List<WebElement>quantitynos=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[7]//input"));
	 for(int i=1;i<=quantitynos.size();i++)
	 {
		 WebElement elem=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[7]//input"));
		 elem.sendKeys(quantityqgnos);
		 Thread.sleep(2000);
	 }
 }
 public void typeqgmrp(String MRP) throws InterruptedException
 {
	 List<WebElement>quantitynos=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[8]//input"));
	 for(int i=1;i<=quantitynos.size();i++)
	 {
		 WebElement elem=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[8]//input"));
		 elem.sendKeys(MRP);
		 Thread.sleep(2000);
	 }
 }
 public int getqgamntaftrdicnt() throws InterruptedException
 {
	 int sum=0;
	 List<WebElement>quantitynos=driver.findElements(By.xpath("//table[@id='qitem_table']//tbody//tr//td[9]"));
	 int cnt=quantitynos.size();
	 System.out.println("count is====="+cnt);
	 for(int i=0;i<quantitynos.size();i++)
	 {
		
		//String c=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr["+i+"]//td[9]")).getAttribute("value");
		 //String c=elem.getAttribute("value");
		 String a=driver.findElement(By.xpath("//input[@id='amount_after_discount"+i+"']")).getAttribute("value");
		// String v=driver.findElement(By.xpath("//input[@id='amount_after_discount1']")).getAttribute("value");
		 if(!a.equals(""))
		 {
			 System.out.println("Parse int output "+Integer.parseInt(a));
		 sum=sum+Integer.parseInt(a); 
		 }
		 Thread.sleep(2000);
		// return (String) ((JavascriptExecutor) this.webDriver).executeScript("//input[@id='amount_after_discount1'].text()");
	 }
	 int sum1= sum;
	 System.out.println(sum1);
	 
	 
	 return sum1;
 }
 
 //subitem
 public void clickAddsubItem()
 {
	 this.Addsubitem.click();
 }
 public void Typesubitmlabel(String subitmlbl)
 {
	 this.subitemlbl.sendKeys(subitmlbl);
 }
 public void selsubitmwrktypelbl()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(this.subitmwrktypelbl, 1);
 }
 public void selsubitmlbl()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(this.selsubitmlbl, 1);
 }
public void selsubitmunit(String subitmunit)
{
	DropdownHelper dpsel=new DropdownHelper(driver);
	dpsel.SelectUsingVisibleText(this.selsubitmunit, subitmunit);
	

}
public void typesubitmquantity(String subitmquaquantity)
{
	this.subitmqnty.sendKeys(subitmquaquantity);
}
public void typesubitmqtyno(String qtyno)
{
	this.subitmqntyno.sendKeys(qtyno);
	
}

public void typesubitmMRP(String subMRP)
{
	this.subitmmrp.sendKeys(subMRP);
}
public void typesubitmaftrdisccnt(String amntaftrdiscnt)
{
	this.subitmamntaftrdicnt.sendKeys(amntaftrdiscnt);
}
//extra work
public void clickextrawork()
{
	this.sqgextraworkbtn.click();
	
}
public void clickxtrawrkimg()
{
	this.addextrawrkimg.sendKeys("C:\\Users\\divya\\OneDrive\\Desktop\\Works\\CMS_WORKSPACE\\uploadimg\\punch1.jpeg");
}
public void typextrawrkdescr()
{
this.xtrawrkdescription.sendKeys("Extra work description");	
}
public void selxtrawrkunit(String unit)
{
DropdownHelper dpsel=new DropdownHelper(driver);
dpsel.SelectUsingVisibleText(this.xtrawrkselunit, unit);
}
public void typextrawrkquantity(String xtrawrkqty)
{
	this.xtrawrkquntity.sendKeys(xtrawrkqty);
}
public void typextrawrkqtynos(String qtyno)
{
	this.xtrawrkqntynos.sendKeys(qtyno);
}
public void clicksqgcreatebtn() throws InterruptedException
{

WebElement elem=this.sqgcreatebutton;
JavascriptExecutor e =(JavascriptExecutor)driver;
e.executeScript("arguments[0].click();", elem);
this.sqgcreatebutton.click();
Thread.sleep(2000);
}
	
	public void typextrawrkmrp(String xtrawrkmrp)
	{
		this.xtrawrkmrp.sendKeys(xtrawrkmrp);
	}
	public void typextrawrkamntaftrdiscnt(String xtrawrkamntaftrdiscnt)
	{
		this.xtrawrkamntaftrdiscnt.sendKeys(xtrawrkamntaftrdiscnt);
	}
	//sqgview-report download
	public void clicksqgaction()
	{
		this.sqgaction.click();
	}
	public void clickviewoption()
	{
		this.Viewopt.click();
	}
	public void clickeditoption()
	{
		this.Editopt.click();
	}
	public void clickdeleteoption()
	{
		this.deleteopt.click();
	}
	public void clicksqgpdf()
	{
		this.sqgpdf.click();
	}
}
