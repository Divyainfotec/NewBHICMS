package com.bhicmspkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class Masterpage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(Masterpage.class);
		
	public Masterpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
	@FindBy(xpath = "//li//a[text()='Users']") public WebElement settingsusers;
	@FindBy(xpath = "//table//tbody//tr//td[2]") public WebElement grdusers;
	@FindBy(xpath = "//*//form[1]/div[2]/input[1]") public WebElement userpagesavebtn;
	
	
	@FindBy(xpath = "//li//a[text()='Quotation Category']") public WebElement settingsquotcategory;
	@FindBy(xpath = "//li//a[text()='Quotation Item']") public WebElement settingsquotitem;
	@FindBy(xpath = "//li//a[text()='Quotation Finish']") public WebElement settingsquotfinish;
	@FindBy(xpath = "//li//a[text()='Quotation Worktype']") public WebElement settingsquotworktype;
	@FindBy(xpath = "//li//a[text()='Sales Executive']") public WebElement settingssalesexecutive;
	//category============================================================================================
	@FindBy(xpath="//*[@id='QuotationCategoryMaster_name']")public WebElement categoryname;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]")public WebElement createcategorybtn;
	
	//worktype=====================================================================================================
	@FindBy(xpath="//*[@id='QuotationWorktype_name']")public WebElement worktypename;
	@FindBy(xpath="//*[@id='QuotationWorktype_template_id']")public WebElement selworktypetemplate;
	@FindBy(xpath="//*[@id='QuotationWorktype_status']")public WebElement selworktypestatus;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/input[1]")public WebElement worktypecreatebtn;
	//Quotation FInish=====================================================================================================
		@FindBy(xpath="//*[@id='QuotationFinishMaster_name']")public WebElement quotationfinishname;
		@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]")public WebElement quotationfinshcreatebtn;
		@FindBy(xpath="//*[@value='Create']") public WebElement qfinishcreatebtn;
		
		//Quotation FInish=====================================================================================================
				@FindBy(xpath="//*[@id='QuotationFinishMaster_name']")public WebElement addquotationitembtn;
				@FindBy(xpath="//*[@id='worktype']")public WebElement quotationitemcategory;
				
		//Quotation item
				@FindBy(xpath="//a[text()='Add Quotation Item']")public WebElement addquotationitem;
				@FindBy(xpath="//*[@id='QuotationItemMaster_quotation_category_id']")public WebElement selctgryforqitm;
				@FindBy(xpath="//*[@id='worktype']")public WebElement selworktype;
				@FindBy(xpath="//*[@id='additem-button']")public WebElement AddQitmbtn;
//create quotation item master
	@FindBy(xpath="//*[@id='worktype_label']")public WebElement worktypelabel;
	@FindBy(xpath="//*[@id='shutter_material_1']")public WebElement worktypematerial;
	@FindBy(xpath="//*[@id='shutter_finish_1']")public WebElement worktypefinish;
	@FindBy(xpath="//*[@id='shutterwork_description_1']")public WebElement worktypedescr;
	@FindBy(xpath="//*[@id='caracoss_material_1']")public WebElement worktypematerial1;
	@FindBy(xpath="//*[@id='caracoss_finish_1']")public WebElement worktypefinish1;
	@FindBy(xpath="//*[@id='caracoss_description_1']")public WebElement worktypedescr1;
	@FindBy(xpath="//*[@id='rate']")public WebElement rate;
	@FindBy(xpath="//*[@id='profit']")public WebElement profit;
	@FindBy(xpath="//*[@id='discount']")public WebElement discount;
	//Bank
	@FindBy(xpath="//li//a[text()='Bank']")public WebElement bankname;
	
		
	public void clicksettingsmenu()
	{
		this.settingsmenu.click();
		logger.info("------------click settings menu-----------------------------");
	}
	public void clicksettingsquotcategory() 
	{
		this.settingsquotcategory.click();
		logger.info("---------click quotation category from master---------------");
	}
	public void clicksettingsquotitem() 
	{
		this.settingsquotitem.click();
	}
	public void clicksettingsquotfinish() 
	{
		this.settingsquotfinish.click();
	}
	public void clicksettingsquotworktype() 
	{
		this.settingsquotworktype.click();
		logger.info("----------click quotation worktype from master---------------");
	}
	public void clicksettingssalesexecutive() 
	{
		this.settingssalesexecutive.click();
	}
	//category
	public void typecategoryname(String Categoryname)
	{
		this.categoryname.sendKeys(Categoryname);
		logger.info("---------type quotation category ---------------");
	}
	public void clickcreatecategorybtn()
	{
		this.createcategorybtn.click();
		logger.info("---------click create button----------------");
	}
	//worktype
	
	public void typeworktype(String worktypename)
	{
		this.worktypename.sendKeys(worktypename);
		logger.info("------------type worktype name--------------");
	}
	public void selworktypetmplate(String worktypetmplate)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleValue(selworktypetemplate, worktypetmplate);
	}
	public void selworktypestatus(String worktypestatus)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleValue(selworktypestatus, worktypestatus);
	}
	public void clickworktypecreatebtn()
	{
		this.worktypecreatebtn.click();
	}
	//Quotation Finish
	public void typequotationfinish(String finishname)
	{
	this.quotationfinishname.sendKeys(finishname);	
	}
	public void clickcreatequotationfinish()
	{
		//this.quotationfinshcreatebtn.click();
		this.qfinishcreatebtn.click();
	}
	/*public void clickaddquotationitem()
	{
		this.addquotationitembtn.click();
	}*/
	public void clickquotationitemcategory()
	{
		this.quotationitemcategory.click();
	}
	//item
	
	public void clickaddquotationitem()
	{
		this.addquotationitem.click();
	}
	public void selctgryforqitm(String ctgry)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selctgryforqitm, ctgry);
	}
	public void selworktypeforqitm(String worktype)
	{
		DropdownHelper dpselworktype=new DropdownHelper(driver);
		dpselworktype.SelectUsingVisibleText(selworktype, worktype);
	}
	public void clickQaddbtn()
	{
		this.AddQitmbtn.click();
	}
	public void typeworktypelabel(String worktypelabel)
	{
		this.worktypelabel.sendKeys(worktypelabel);
	}
	public void selworktypematerial2(String material)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.worktypematerial, material);
		
	}
	public void selworktypematerial()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypematerial, 1);
		
	}
	public void selworktypefinish()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypefinish, 1);
	}
	public void typeworktypedescr(String worktypedescr) 
	{
		this.worktypedescr.sendKeys(worktypedescr);
	}
	public void selworktypematerial1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypematerial1, 1);
		
	}
	public void selworktypefinish1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypefinish1, 1);
	}
	public void typeworktypedescr1(String worktypedescr) 
	{
		this.worktypedescr1.sendKeys(worktypedescr);
	}
	public void typerate(String rate)
	{
		this.rate.sendKeys(rate);
	}
	public void typeprofit(String profit)
	{
		this.profit.sendKeys(profit);
	}
	public void typediscount(String discount)
	{
		this.discount.sendKeys(discount);
	}
	public void clicksettingsusers()
	{
		this.settingsusers.click();
	}
	public void clickgrdusername(String username) throws InterruptedException
	{
		List<WebElement>users=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=users.size();i++)
		{
			String user=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
			Thread.sleep(2000);
			if(username.equals(user))
			{
				driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[10]/a[1]")).click();
				Thread.sleep(2000);
			}
		}
	}
	//userpage
	public void clickcompany(String expcompanyname)//choosecompany
	{
		List<WebElement>companylist=driver.findElements(By.xpath("//*[@id='Users_company_id']//li//label"));
		for(int i=1;i<=companylist.size();i++)
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//label")).getText();
			if(expcompanyname.equals(cmpname))
			{
				WebElement elem=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//input"));
				if(!elem.isSelected())
				{
					elem.click();
				//driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//input")).click();
				}
			}
		}
	}
	public void clickuserpagesavebtn()
	{
		this.userpagesavebtn.click();
	}
	//getbankname
	public String getbankname(String cmpname)
	{
		String bankname = null;
		List<WebElement> cmpnames=driver.findElements(By.xpath("//table[@id='banktab']//tbody//tr//td[3]"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpnme=driver.findElement(By.xpath("//table[@id='banktab']//tbody//tr["+i+"]//td[3]")).getText();
			if(cmpname.equals(cmpnme))
			{
				 bankname=driver.findElement(By.xpath("//table[@id='banktab']//tbody//tr["+i+"]//td[2]")).getText();
				 
			}
			
		}
		return bankname;
	}
	public void clickbankname()
	{
		this.bankname.click();
	}
	
	
}
