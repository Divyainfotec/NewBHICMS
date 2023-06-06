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
import com.bhicmspkg.Helper.LoggerHelper;

public class PurchaseItemMasterPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(PurchaseItemMasterPage.class);
	public PurchaseItemMasterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
		@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
		@FindBy(xpath = "//li//a[text()='Purchase Item']") public WebElement purchaseitemssettings;
		@FindBy(xpath = "//*[@id='myTab']//li//a[text()='Item List']") public WebElement itmlstbtn;
		@FindBy(xpath = "//a[text()='Add Category']") public WebElement addcategorybtn;
		@FindBy(xpath = "//*[@id='PurchaseCategory_category_name']") public WebElement categoryname;
		@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]") public WebElement companyname;
		@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/input[1]") public WebElement savebutton;
		@FindBy(xpath = "//table//tbody//tr//td[2]") public WebElement categorylist;
		@FindBy(xpath = "//li//a[text()='Brand List']") public WebElement addbrandlist;
		@FindBy(xpath = "//a[text()='Add Brand']") public WebElement addbrand;
		@FindBy(xpath = "//*[@id='Brand_brand_name']") public WebElement brandname;
		@FindBy(xpath = "//*[@id='Brand_company_id']") public WebElement brandcmp;
		@FindBy(xpath = "//form[@id='brand-form']//div[3]//input[@value='Save']") public WebElement brandsavebtn;
		

		@FindBy(xpath = "//li//a[text()='Specification List']") public WebElement specificationlstbtn;
		@FindBy(xpath = "//div//a[text()='Add Specification']") public WebElement addspecificationbutton;
		@FindBy(xpath = "//html/body/span/span/span[1]/input") public WebElement searchspec;
		
		@FindBy(xpath = "//*[@id='itemtable']//tbody//tr[1]//td[2]") public WebElement getcategoryname;
		@FindBy(xpath = "//*[@id='select2-PurchaseSpecification_cat_id-container']") public WebElement clickchooseitm;
		@FindBy(xpath = "//*[@id='select2-PurchaseSpecification_brand_id-container']") public WebElement clickchoosebrand;
		@FindBy(xpath = "//*[@id='brandtable']//tbody//tr[1]//td[2]") public WebElement getbrandname;
		@FindBy(xpath = "//*[@id='select2-PurchaseSpecification_specification_type-container']") public WebElement clickchoosequantity;
		@FindBy(xpath = "//*[@id='PurchaseSpecification_dieno']") public WebElement lengthdieno;
		@FindBy(xpath = "//*[@id='PurchaseSpecification_specification']") public WebElement specification;
		@FindBy(xpath = "//*[@id='PurchaseSpecification_unit']") public WebElement unitspec;
		@FindBy(xpath = "//*[@id='PurchaseSpecification_hsn_code']") public WebElement hsncode;
		@FindBy(xpath = "//*[@id='purchase-specification']/div[2]/div[3]/div/span/span[1]/span/ul/li/input") public WebElement purcspeccomp;
		@FindBy(xpath = "//*[@class='btn btn-sm btn-info btn-submit createspec']") public WebElement purchasesavebtn;
		@FindBy(xpath = "//li//a[text()='Unit Convertion']") public WebElement unitconversion;
		@FindBy(xpath = "///*[@id='select2-purchase_items-container']") public WebElement chooseitmunitconv;
		
		
		public void clicksettings()
		{
			this.settingsmenu.click();
			logger.info("--------click settings menu----------------");
		}
		public void clickpurchaseitems()
		{
			this.purchaseitemssettings.click();
			logger.info("--------click purchase items from settings menu----------------");
		}
		public void clickitemlist()
		{
			this.itmlstbtn.click();
			logger.info("--------click item list----------------");
		}
		public void clickaddcategorybtn()
		{
			this.addcategorybtn.click();
			logger.info("--------click add category button----------------");
		}
		public void typecategoryname(String categoryname)
		{
			//this.clickchooseitm.click();
			this.categoryname.sendKeys(categoryname);
			logger.info("--------type category name----------------");
		}
		public void selcompanyname(String cmpname)
		{
			//DropdownHelper dpsel=new DropdownHelper(driver);
			//dpsel.SelectUsingVisibleText(this.companyname, cmpname);
			this.companyname.sendKeys(cmpname);
			this.companyname.sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath("//[@ititle='cmpname']")).click();
		}
		public void clicksavebutton() throws InterruptedException
		{
			//WebElement elem=this.savebutton;
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", elem);
			this.savebutton.click();
			Thread.sleep(2000);
			logger.info("----------click save button-------------");
		}
		public void clickaddbrandlist()
		{
			this.addbrandlist.click();
			logger.info("---------click add brand list-------------");
		}
		public void clickaddbrand()
		{
			this.addbrand.click();
			logger.info("---------click add brand -------------");
		}
		public void typebrandname(String brandname)
		{
			this.brandname.sendKeys(brandname);
			logger.info("-----type brand name----------");
		}
		public void selbrandcompany(String brandcmpny)
		{
			DropdownHelper dpselbrand=new DropdownHelper(driver);
			dpselbrand.SelectUsingVisibleText(this.brandcmp, brandcmpny);
			logger.info("----------select the company ---------------");
		}
		public void clickbrandsavebtn() throws InterruptedException
		{
			this.brandsavebtn.click();
			Thread.sleep(2000);
			logger.info("----------click brand save button-------------");
		}
		//------------------------------------------specification
		public void clickspecificationlst()
		{
			this.specificationlstbtn.click();
			logger.info("--------click specification list button------------");
		}
		public void clickaddspecification()
		{
			this.addspecificationbutton.click();
			logger.info("------------click add specification button------------");
		}
		public void typesearchitemspec(String Categoryname) throws InterruptedException
		{
			this.clickchooseitm.click();
			Thread.sleep(2000);
			this.searchspec.sendKeys(Categoryname);
			Thread.sleep(2000);
			this.searchspec.sendKeys(Keys.ENTER);
			logger.info("--------search item for specification--------------");
		}
		public String getcategoryname()
		{
		     String categoryname=this.getcategoryname.getText();
		     return categoryname;
		}
		public String getbrandname()
		{
			 String brandname=this.getbrandname.getText();
		     return brandname ;
		}
		public void typesearchbrandspec(String brandname) throws InterruptedException
		{
			this.clickchoosebrand.click();
			Thread.sleep(2000);
			this.searchspec.sendKeys(brandname);
			Thread.sleep(2000);
			this.searchspec.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			logger.info("--------search brand for specification--------------");
		}
		public void typesearchquantityspec(String spec) throws InterruptedException
		{
			this.clickchoosequantity.click();
			Thread.sleep(2000);
			this.searchspec.sendKeys(spec);
			Thread.sleep(2000);
			this.searchspec.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			logger.info("--------search quantity for specification--------------");
		}
		public void typespecification() throws InterruptedException
		{
			String spectype=this.clickchoosequantity.getText();
			Thread.sleep(2000);
			if(spectype.equals("By Length"))
			{
				this.lengthdieno.sendKeys("34"+RandomStringUtils.randomNumeric(2));
				Thread.sleep(2000);
			}
			else {
				this.specification.sendKeys("spec1"+RandomStringUtils.randomNumeric(2));
				
			}
			
		}
		public void selunit(String unit)
		{
			DropdownHelper dpselunit=new DropdownHelper(driver);
			dpselunit.SelectUsingVisibleText(unitspec, unit);
		}
		public void typehsncode(String hsncode)
		{
			this.hsncode.sendKeys(hsncode);
		}
		public void selpurchasespeccompany(String company)
		{
		    this.purcspeccomp.sendKeys(company);
		    this.purcspeccomp.sendKeys(Keys.ENTER);
			logger.info("---------selecting the company--------------");
		}
		public void clickpurchasesavebutton()
		{
			this.purchasesavebtn.click();
		}
		public void clickunitconversion()
		{
			this.unitconversion.click();
			logger.info("---------click unit conversion---------------");
		}
		public void clickchooseunitconv()
		{
			this.chooseitmunitconv.click();
			logger.info("------click choose item for unit conversion--------------------");
		}
}
