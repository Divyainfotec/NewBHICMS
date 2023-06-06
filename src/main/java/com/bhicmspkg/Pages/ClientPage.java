package com.bhicmspkg.Pages;

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

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.AlertHelper;
import com.bhicmspkg.Helper.Dateselectionhelper;
import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Helper.Uploadhelper;


public class ClientPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(ClientPage.class);
	JavascriptExecutor e ;
	Config con;
	public ClientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
	//------------------------------client type
	@FindBy(xpath="//li//a[text()='Client Type']")public WebElement settngsclienttype;
	@FindBy(xpath="//div//a[text()='Add Client type']")public WebElement addclienttype;
	
	@FindBy(xpath="//*[@id='ProjectType_project_type']")public WebElement newclienttype;
	@FindBy(xpath="//*[@class='btn btn-sm btn-info']")public WebElement clienttypecreatebtn;
	
	//-------------------client creation
	@FindBy(xpath="//li//a[text()='Settings']")public WebElement settingsmenu;
	@FindBy(xpath = "//li//a[text()='Clients']") public WebElement clients;
	
	@FindBy(xpath = "//*[contains(text(),'Add Client')]") public WebElement addclient;
	
	@FindBy(xpath = "//*[@id='clients-form']") public WebElement clientform;
	@FindBy(id = "Clients_name") public WebElement clientname;
	@FindBy(id = "Clients_nick_name") public WebElement clientnickname;
	@FindBy(id = "Clients_project_type") public WebElement clientpjttype;
	@FindBy(xpath = "//input[@id='Clients_phone']") public WebElement clientphone;
	@FindBy(xpath = "//*[@id='Clients_address']") public WebElement clientaddress;
	@FindBy(xpath = "//*[@id='Clients_email_id']") public WebElement clientemailid;
	@FindBy(xpath = "//*[@id='Clients_gst_no']") public WebElement clientgstno;
	
	@FindBy(xpath = "//*[@id='Clients_status_0']") public WebElement clientactivestatus;
	@FindBy(xpath ="//*[@id='Clients_company_id_0']") public WebElement checkallcompany;
	// chk all  //input[@id='Clients_company_id_all']
	
	@FindBy(id = "Clients_description") public WebElement clientdescription;
	//@FindBy(xpath = "//*[@id='clients-form']//div[@class='panel-footer save-btnHold text-center']//input[@value='Create']") public WebElement clientcreate;
	@FindBy(xpath ="//*[@id='clients-form']//div[@class='panel-footer save-btnHold text-center']//input[1]")public WebElement createbtn;
	
	@FindBy(id = "projects-grid") public WebElement clientgrid;
	//------------------------client type---------------------------
	@FindBy(xpath = "//li//a[text()='Client Type']") public WebElement clienttype;
	
	//----------Getclientname----------------
	@FindBy(xpath="//table//tbody//tr[1]//td[2]")public WebElement grdclientname;
	
	
	public void clickclientsettings()
	{
		this.clients.click();
		logger.info("--------------click client menu---------------------");
	}
	
	public void clickaddclient() throws InterruptedException
	{   
		WebElement elem=this.addclient;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		this.addclient.click();
		Thread.sleep(2000);
		logger.info("--------------click add client ---------------------");
	}
	public void switchclientfr()
	{
		//AlertHelper alertf=new AlertHelper(driver);
		//alertf.switchtoframe(this.clientform);
		driver.switchTo().frame(this.clientform);
		logger.info("--------------switch into a client frame---------------------");
	}
	public void typeclientname(String clientnme)
	{
		this.clientname.sendKeys(clientnme);
		logger.info("--------------enter client name---------------------");
		
	}
	public void typeclientnickname(String clientnicknme)
	{
		this.clientnickname.sendKeys(clientnicknme);
		logger.info("--------------enter client nick name---------------------");
	}
	public void selclienttype(String pjttype)
	{
		DropdownHelper dpselpjttype=new DropdownHelper(driver);
		dpselpjttype.SelectUsingVisibleText(this.clientpjttype, pjttype);
		logger.info("---------select the project type---------------------");
		
	}
	public void typeclientphone()
	{
		this.clientphone.sendKeys("5227918"+RandomStringUtils.randomNumeric(2));
	}
	public void typeclientemail(String email)
	{
		this.clientemailid.sendKeys(email);
	}
	public void typeclientgstno(String gstno)
	{
		this.clientgstno.sendKeys(gstno);
		logger.info("--------type client gstno-----------------");
	}
	public void typeclientaddr(String clientaddr)
	{
		this.clientaddress.sendKeys(clientaddr);
	}
	public void clickclientstatus()
	{
		this.clientactivestatus.click();
		logger.info("---------choose status of  a client-------------");
	}
	public void clickallcmpny(String cmpname)
	{
		//con=new Config(pr);
		//*[@id='Clients_company_id']//li//label[contains(text(),"BHICompany")]
		//String companyname=con.Getcompanyname();
		WebElement chkbox=driver.findElement(By.xpath("//*[@id='Clients_company_id']//li//label[contains(text(),cmpname)]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       // Checking whether first attempt to check the check box worked
		       // if (!chkbox.isSelected()) {
		            //4) Retrying
		        //	chkbox.click();
		       // }
		    }
	//	this.checkallcompany.click();
		logger.info("-----------click all company----------------");
	}
	public void typedescr(String clientdescr)
	{
		this.clientdescription.sendKeys(clientdescr);
		logger.info("----------Enter client description-------------");
	}
	public void clickcreatebutton() throws InterruptedException
	{
		
		WebElement elem=this.createbtn;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		this.createbtn.click();
		Thread.sleep(2000);
		logger.info("-----------clicking create button-----------------");
	}
	public void verifysuccessfull()
	{
		GenericHelper elmdisplayed=new GenericHelper();
		elmdisplayed.isDisplayed(this.clientgrid);
		logger.info("---------clent is created!!-----------");
	}
	//----------------------------------------------client type----------------
	public void clickclienttype()
	{
		this.clienttype.click();
		logger.info("------------click client type------------------------");
	}
//-----------------------------client type-----------------------------
	public void clicksettingsclienttype()
	{
		this.settngsclienttype.click();
		logger.info("--------click client type-------------");
	}
	public void clickaddclienttype()
	{
		WebElement elem=this.addclienttype;
		 e=(JavascriptExecutor)driver;
		 e.executeScript("arguments[0].click();", elem);
		this.addclienttype.click();
		logger.info("---------click add client type button--------------------");
	}
	public void typenewclienttype(String clienttype)
	{
		this.newclienttype.sendKeys(clienttype);
		logger.info("-----------type client type-------------------");
	}
	public void clickclienttypecreatebtn()
	{
		WebElement elem=this.clienttypecreatebtn;
		 e=(JavascriptExecutor)driver;
		 e.executeScript("arguments[0].click();", elem);
		this.clienttypecreatebtn.click();
		logger.info("------------click create button------------------");
	}
	public String getgrdclientname()
	{
		//List<WebElement> clientnames=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		return this.grdclientname.getText();
		//String clientname= driver.findElement(By.xpath("//table//tbody//tr[1]//td[2]")).getText();
		//return clientname;
	}
}
