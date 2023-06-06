package com.bhicmspkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class WarehousePage {

	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	private final Logger logger=LoggerHelper.getLogger(WarehousePage.class);
	public WarehousePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='WAREHOUSE']")public WebElement warehousemenu;
	@FindBy(xpath="/html/body/div/nav/div/div[2]/ul/li[3]/ul/li[1]/a")public WebElement warehousecreatelink;
	@FindBy(xpath = "//*[@id='yw11']/li[3]/ul/li[1]//a[text()='Warehouse ']")public WebElement warehouseopt;
	@FindBy(xpath="//*[@id='myTable']//tbody//tr[1]//td[2]")public WebElement warehousename;
	@FindBy(xpath = "//*[@id='myTable']//tbody//tr[1]//td[8]//a")public WebElement wheditbtn;
	@FindBy(xpath = "//a[text()='Add Warehouse']")public WebElement addwarehouse;
	@FindBy(xpath = "//*[@id='Warehouse_warehouse_name']")public WebElement typewarehsename;
	@FindBy(xpath = "//*[@id='Warehouse_warehouse_place']")public WebElement warehseplace;
	@FindBy(xpath = "//*[@id='Warehouse_warehouse_incharge']")public WebElement seluser;
	@FindBy(xpath = "//*[@id='Warehouse_warehouse_incharge']//option")public WebElement inchrgeuser;
	@FindBy(xpath = "//*[@id='Warehouse_assigned_to']")public WebElement assgnto;
	@FindBy(xpath = "//*[@id='Warehouse_warehouse_address']")public WebElement whaddress;
	@FindBy(xpath = "//*[@class='panel-footer text-center btn_top save-btnHold']//input[@value='Create']")public WebElement createbtn;
	@FindBy(xpath = "//li//a[text()='Warehouse Receipt ']")public WebElement whsereceipt;
	@FindBy(xpath = "//div//a[text()='Add Receipt']")public WebElement addreceiptbtn;
	@FindBy(xpath = "//*[@id='select2-Warehousereceipt_warehousereceipt_warehouseid-container']")public WebElement whseldp;
	@FindBy(xpath = "//*[@class='select2-search__field']")public WebElement searchvalue;
	//10-02-2022
	@FindBy(xpath = "//*[@id='select2-clerk-container']")public WebElement receiptclrk;
	@FindBy(xpath = "//*[@id='receipt_no']")public WebElement receiptno;
	@FindBy(xpath = "//*[@id='select2-transfer_type-container']")public WebElement transfertype;
	@FindBy(xpath = "//*[@id='select2-purchase_bill_no-container']")public WebElement clickpubll;
	 @FindBy(xpath = "//*[@id='vendor']")public WebElement whremarks;
	 @FindBy(xpath = "//*[@id='receivedquantity_0']")public WebElement whquantity;
	 @FindBy(xpath = "//li//a[text()='Warehouse Despatch']")public WebElement whdespatch;
	 @FindBy(xpath = "//a[text()='Add Despatch']")public WebElement adddespatchbtn;
	 @FindBy(xpath = "//*[@id='select2-warehouse-container']")public WebElement choosewarehouse;
	 @FindBy(xpath = "//*[@id='select2-warehouse_to-container']")public WebElement choosewarehouseto;
	 @FindBy(xpath = "//*[@id='despatch_no']")public WebElement despatchno;
	 @FindBy(xpath = "//*[@id='vendor']")public WebElement despatchrmks;
	 @FindBy(xpath = "//*[@id='select2-stock_item-container']")public WebElement despatchitm;
	 @FindBy(xpath = "//*[@id='quantity']")public WebElement whdesquantity;
	 @FindBy(xpath = "//*[@id='remark']")public WebElement whdesprmks;
	 @FindBy(xpath = "//*[@class='item_save']")public WebElement whdespsavebtn;
	 @FindBy(xpath = "//*[@id='select_div']//select[@id='stock_item']")public WebElement despatchitem;
	/* 
	  @FindBy(xpath = "")public WebElement;
	 * @FindBy(xpath = "")public WebElement;
	 * @FindBy(xpath = "")public WebElement;
	 * @FindBy(xpath = "")public WebElement; 
	 * @FindBy(xpath = "")public WebElement;
	 * @FindBy(xpath = "")public WebElement;*/
	
	
	public void clickwarehousemenu()
	{
		this.warehousemenu.click();
	}
	public void clickwarehouseoption()
	{
		this.warehousecreatelink.click();
	}
	public String getwarehousename() throws InterruptedException
	{
		String whname=this.warehousename.getText();
		Thread.sleep(2000);
		 return whname;
		
	}
	public void whassignee(String whuser) throws InterruptedException
	{
		
		this.wheditbtn.click();
		Thread.sleep(2000);
		List<WebElement>users=driver.findElements(By.xpath("//*[@id='Warehouse_assigned_to']//li//label"));
		for(int i=1;i<=users.size();i++)
		{
			String actualusername=driver.findElement(By.xpath("//*[@id='Warehouse_assigned_to']//li["+i+"]//label")).getText();
			if(actualusername.equals(whuser))
			{
				driver.findElement(By.xpath("//*[@id='Warehouse_assigned_to']//li["+i+"]//label")).click();
			}
		}
		Thread.sleep(2000);
	}
	public void clickaddwarehouse()
	{
		this.addwarehouse.click();
	}
	public void typewarehousename(String whnme)
	{
		this.typewarehsename.sendKeys(whnme);
	}
	public void typewarehouseplace(String whplace)
	{
		this.warehseplace.sendKeys(whplace);
	}
	public void selwarehouseinchrge(String username)
	{
		//this.seluser.click();
		DropdownHelper dpselwh=new DropdownHelper(driver);
		dpselwh.SelectUsingVisibleText(this.seluser, username);
	}
	public void typewhaddr()
	{
		this.whaddress.sendKeys("wh Nagar");
	}
	public void clickcrestebtn()
	{
		this.createbtn.click();
	}
	//warehouse receipt
	public void clickwhreceipt()
	{
		this.whsereceipt.click();
	}
	public void clickaddreceipt()
	{
	this.addreceiptbtn.click();	
	}
	public void clickselwh()
	{
		this.whseldp.click();
	}
	public void typwhname(String whname) throws InterruptedException
	{
		GenericHelper gh=new GenericHelper();
		gh.typevalueinsearch(this.searchvalue, whname);
	}
	//10-02-2022
	public void clickreceiptclrk()
	{
		this.receiptclrk.click();
	}
	public void typclrkname(String clrkname) throws InterruptedException
	{
		GenericHelper gh=new GenericHelper();
		gh.typevalueinsearch(searchvalue, clrkname);
	}
	public void typereceiptno(String receiptno)
	{
		this.receiptno.sendKeys(receiptno);
	}
	public void clicktransfertype()
	{
		this.transfertype.click();
	}
	public void typetransfertype(String transfertype) throws InterruptedException
	{
		GenericHelper gh=new GenericHelper();
		gh.typevalueinsearch(searchvalue, transfertype);
	}
	public void clickpubill()
	{
		this.clickpubll.click();
	}
	public void typepubill(String pubill) throws InterruptedException
	{
		GenericHelper gh=new GenericHelper();
		gh.typevalueinsearch(searchvalue, pubill);
	}
	public void typermks(String rmks)
	{
		this.whremarks.sendKeys(rmks);
	}
	public void typewhquantity(String qnty)
	{
		this.whquantity.sendKeys(qnty);
	}
	public void clickaddespatch()
	{
		this.whdespatch.click();
	}
	public void clickaddespatchbtn()
	{
		this.adddespatchbtn.click();
	}
	public void clickchoosewh()
	{
		this.choosewarehouse.click();
	}
	public void searchwh(String whname) throws InterruptedException
	{
		gh=new GenericHelper();
		gh.typevalueinsearch(this.searchvalue, whname);
	}
	public void clickchoosewhto()
	{
		this.choosewarehouseto.click();
	}
	public void searchwhto(String whname) throws InterruptedException
	{
		gh=new GenericHelper();
		gh.typevalueinsearch(this.searchvalue, whname);
	}
	public void clickclrkreceipt()
	{
		this.receiptclrk.click();
	}
	public void searchclerk(String whname) throws InterruptedException
	{
		gh=new GenericHelper();
		gh.typevalueinsearch(this.searchvalue, whname);
	}
	public void typedespatchno(String despano)
	{
		this.despatchno.sendKeys(despano);
	}
	public void typedespatchrmks(String dsprmks)
	{
		this.despatchrmks.sendKeys(dsprmks);
	}
	
public void seldespatchitm()
{
	DropdownHelper dpselpoitm=new DropdownHelper(driver);
	dpselpoitm.SelectUsingIndex(despatchitem, 1);
	
}
	public void clickdespatchitm()
	{
		this.despatchitm.click();
		//this.despatchitm.sendKeys(Keys.ARROW_DOWN);
	}
	public void searchdespatchitm(String despatchitm) throws InterruptedException
	{
		
		gh=new GenericHelper();
		gh.typevalueinsearch(searchvalue, despatchitm);
		//this.searchvalue.sendKeys(Keys.ARROW_DOWN);
		//this.searchvalue.sendKeys(Keys.ENTER);

	}
	public void typedesquantity(String whdespqnty)
	{
		this.whdesquantity.sendKeys(whdespqnty);
	}
	public void typedesrmks(String whdesprmks)
	{
		this.whdesprmks.sendKeys(whdesprmks);
	}
	public void clickwhdespatchsavebtn()
	{
		this.whdespsavebtn.click();
	}
}
