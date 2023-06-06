package com.bhicmspkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class LabourReportPage {
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(LabourReportPage.class);
	public LabourReportPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/* *
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * 
	 * 
	 *
	  
		 */
	@FindBy(xpath="//li//a[text()='Labour Report']")public WebElement labourreportmenu; 
	@FindBy(xpath="//a[text()='Entries']")public WebElement lbrrptentriesbtn;
	@FindBy(xpath="//*[@id='expense']/div[2]/div/button")public WebElement lbrrptaddentries; 
	 @FindBy(xpath="//*[@id='Dailyreport_company_id']")public WebElement lbrrptselcmpny;
	 @FindBy(xpath="//*[@id='Dailyreport_projectid']")public WebElement lbrselpjt;
	 @FindBy(xpath="//*[@id='Dailyreport_subcontractor_id']")public WebElement selsubcntrnme;
	 @FindBy(xpath="//*[@id='Dailyreport_expensehead_id']")public WebElement selexphead;
	 @FindBy(xpath="//*[@id='Dailyreport_description']")public WebElement lbrdescr;
	 @FindBy(xpath="//*[@id='Dailyreport_labour']")public WebElement masonno;
	 @FindBy(xpath = "//*[@id='Dailyreport_wage']")public WebElement wagespersqfeet;
	 @FindBy(xpath="//*[@id='Dailyreport_wage_rate']")public WebElement dlywagerate;
	 @FindBy(xpath="//*[@id='buttonsubmit']")public WebElement lbraddbtn;
	 @FindBy(xpath="//*[@id='fixTable']//tbody[1]//tr[1]//td[8]//span")public WebElement actionmenu;
	// @FindBy(xpath="//html//body//div[1]//div//div[2]//div//div//div[5]//div[1]//div//div[2]//table//tbody[1]//tr//td[8]//span")public WebElement actionmenu;
	 @FindBy(xpath="//*[@class='popover-content']//ul//li//button[text()='Edit']")public WebElement editbtn;
	 @FindBy(xpath="//*[@id='buttonsubmit' and text()='UPDATE']")public WebElement updatebtn;
	 @FindBy(xpath="//*[@class='popover-content']//ul//li//button[text()='Delete']")public WebElement deletebtn;
	
	public void clicklabourreportmenu()
	{
		this.labourreportmenu.click();
	}
	public void clickentriesbtn()
	{
		this.lbrrptentriesbtn.click();
	}
	public void clickaddentriesbtn()
	{
		this.lbrrptaddentries.click();
	}
	public void sellbrcompany(String company)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.lbrrptselcmpny, company);
	}
	public void sellbrproject(String project)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.lbrselpjt, project);
	}
	public void selsubcntr(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selsubcntrnme, subcntrname);
	}
	public void selexphead()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selexphead, 2);
	}
   public void typelbrdescription()
   {
	   this.lbrdescr.clear();
	   this.lbrdescr.sendKeys("---labour description-----");
   }
   public void typemason()
   {
	   this.masonno.sendKeys("1");
   }
   public void typewagespersqfeet()
   {
	   this.wagespersqfeet.sendKeys("100");
   }
   public void typewagerate()
   {
	   this.dlywagerate.sendKeys("20");
   }
   public void clickaddbtn()
   {
	   this.lbraddbtn.click();
   }
   public void clickactionmenu()
	{
		this.actionmenu.click();
	}
   public void clickEdit()
   {
	   this.editbtn.click();
   }
   public void clickupdatebtn()
   {
	   this.updatebtn.click();
   }
   public void clickDelete()
   {
	   this.deletebtn.click();
   }
}
