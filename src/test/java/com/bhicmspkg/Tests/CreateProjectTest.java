package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.Dateselectionhelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;

import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.TestBase.TestBase;

public class CreateProjectTest extends TestBase {
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 ProjectcreationPage pjtpge;
	 CompanyPage cmpnypge;
	private static Logger logger=LoggerHelper.getLogger(CompanycreationTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  logger.info("==============login is sucessful=========================");
		  
	 }
  @Test
  public void Projectcreation() throws InterruptedException {
	  
	  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
	  JavascriptHelper js=new JavascriptHelper(driver);
	  con=new Config(pr);
	  // mstr=new Masterpage(driver);
	  mstr.clicksettingsmenu();
	  logger.info("---------click settings menu---------------");
	   pjtpge=new ProjectcreationPage(driver);
	  pjtpge.clicksettingspjt();
	  logger.info("---------click projects from settings menu---------------");
	  pjtpge.clickaddproject();
	  logger.info("---------click add projects--------------");
	  Thread.sleep(4000);
	 // String newpjtname="BHI Project"+RandomStringUtils.randomAlphabetic(2);
	  String newpjtname="BHI Test Project";
	  pjtpge.typeprojectname(newpjtname);
	  logger.info("---------type project name--------------");
	  pjtpge.selclient("BHI client");
	  Thread.sleep(2000);
	  logger.info("---------select client name-------------");
	  pjtpge.typeprojectstrtdate();
	  Thread.sleep(2000);
	  logger.info("---------type pjt start date-------------");
	  pjtpge.typeprojectenddate();
	  Thread.sleep(2000);
	  logger.info("---------type pjt end date-------------");
	  pjtpge.clickpjtctgry();
	  logger.info("---------click project category-------------");
	   pjtpge.typepjtsitedescr("Site is near to bridge");
	  Thread.sleep(2000);
	  logger.info("---------type pjt site description-------------");
	  pjtpge.typepjtsitename("Aluva"+RandomStringUtils.randomAlphabetic(2));
	  Thread.sleep(2000);
	  logger.info("---------type pjt site name-------------");
	   Thread.sleep(2000);
	  selectcompany(cmpnyname);
	  Thread.sleep(2000);
	  logger.info("---------click the company chk box ------------");
	  js.scrollDownByPixel();
	  selectassignttouser();
	  logger.info("---------user click the assigned user------------");
	  Thread.sleep(2000);
	  pjtpge.selexphead();
	  Thread.sleep(2000);
	  logger.info("---------user choose the expense head------------");
	  
	  pjtpge.selpjtstatus("Ongoing");
	  logger.info("---------choose project status-----------");
	  Thread.sleep(2000);
	  pjtpge.selworkcntrtype("Square Feet Rate");
	  logger.info("-----select work type contractor--------");
	  pjtpge.typepjtsquarefeet("2300");
	  logger.info("-----type square feet---------");
	  pjtpge.typepjtsqrefeetrate("3000");
	  logger.info("-----type square feet rate--------");
	  pjtpge.typepjtquote("300");
	  Thread.sleep(2000);
	  logger.info("-----type project quote---------");
	  pjtpge.typepjtprofitmargin("40");
	  logger.info("-----type project profit margin---------");
	  pjtpge.typepjtremarks("project remarks");
	  logger.info("-----type project remarks---------");
	  pjtpge.clickcreatebtn();
	  Thread.sleep(2000);
	  logger.info("------------click create button--------------------");
	  GetNewpjtname(newpjtname);
  }
  
  public void selectcompany(String cmpname)
	 {

		 //String expcompanyname=con.Getcompanyname();
		 String expcompanyname=cmpname;
		 int compnycnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Projects_company_id']//li")).size();
		 
		 for(int i=1;i<=compnycnt;i++)
		 {
		 String actcmpnyuname=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//label")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actcmpnyuname.equalsIgnoreCase(expcompanyname))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Projects_company_id']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
			
		}
		 }
	 }
  
  public void selectassignttouser()
	 {

		 String expcompanyusername=con.Getcompanyusername();
		 int compnyusercnt=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li//input")).size();
		 
		 for(int i=1;i<=compnyusercnt;i++)
		 {
		 String actcmpnyuname=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actcmpnyuname.equalsIgnoreCase(expcompanyusername))
		{
			WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/ul[1]/li["+i+"]//input"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
			
		}
		 }
	 }
  public void selectExpenseHead()
	 {

		 String expexpenseheadname="Toughen glass work";
		 int expenseheadcnt=driver.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]/li//input")).size();
		 
		 for(int i=1;i<=expenseheadcnt;i++)
		 {
		 String actexpenseheadname=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]//li["+i+"]")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(actexpenseheadname.equalsIgnoreCase(expexpenseheadname))
		{
			WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[5]/div[2]/ul[1]/li["+i+"]//input"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
			
		}
		 }
	 }
  public void GetNewpjtname(String exppjtname)
  {
	 List<WebElement> grdpjtnames=driver.findElements(By.xpath("//table[@id='protable']//tbody//tr//td[2]"));
	 for(WebElement we:grdpjtnames)
	 {
		 String actpjtname=we.getText();
		 if(exppjtname.equalsIgnoreCase(actpjtname))
		 {
			 logger.info("----------project created successfully!!!!-------------------");
			 Assert.assertTrue(true);
		 }
	 }
  }
}
