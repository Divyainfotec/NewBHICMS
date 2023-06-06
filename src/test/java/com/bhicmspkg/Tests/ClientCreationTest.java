package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.ClientPage;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.TestBase.TestBase;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class ClientCreationTest extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(ClientCreationTest.class);
	Config con;
	ClientPage clientpg;
	Masterpage mstrpge;
	JavascriptHelper js;//=new JavascriptHelper(driver);
	 @BeforeMethod
		public void Login() throws InterruptedException, IOException 
		{
		  LoginPage bhilogin=new LoginPage(driver);
		   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				
				logger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  }
  @Test
  public void ClientCreation() throws InterruptedException, AWTException {
	  mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  CompanyPage cmpge=new CompanyPage(driver);
	  cmpge.clickcompany();
	  String lastcmpname=cmpge.getlastcmpnyname();
	  mstrpge.clicksettingsmenu();
	  clientpg=new ClientPage(driver);
	  clientpg.clickclientsettings();
	  Thread.sleep(2000);
	Robot robo=new Robot();
	  robo.keyPress(KeyEvent.VK_CONTROL);
	  robo.keyPress(KeyEvent.VK_MINUS);
	  robo.keyRelease(KeyEvent.VK_CONTROL);
	  robo.keyRelease(KeyEvent.VK_MINUS);
	  Thread.sleep(3000);
	 
	 // Thread.sleep(2000);
	 // JavascriptHelper js=new JavascriptHelper(driver);
	  //js.scrollIntoView(driver.findElement(By.xpath("//*[contains(text(),'Add Client')]")));
	  clientpg.clickaddclient();
	  //clientpg.switchclientfr();
	  Thread.sleep(3000);
	  String clientname="bhiclient"+RandomStringUtils.randomAlphabetic(2);
	  clientpg.typeclientname(clientname);
	  clientpg.selclienttype("Corporates");
	  Thread.sleep(2000);
	  clientpg.typeclientphone();
	  clientpg.typeclientaddr("kadavanthra"+RandomStringUtils.randomAlphabetic(2));
	  clientpg.typeclientemail(RandomStringUtils.randomAlphabetic(2)+"divqc@bhi.com");
	  JavascriptHelper js=new JavascriptHelper(driver);
	  js.scrollDownByPixel();
	  clientpg.typeclientgstno("87870"+RandomStringUtils.randomNumeric(2));
	  clientpg.clickclientstatus();
	  Thread.sleep(2000);
	  con=new Config(pr);
	 // clientpg.clickallcmpny();
	  selectcompany();
	  Thread.sleep(2000);
	  clientpg.typedescr("client descr"+RandomStringUtils.randomAlphabetic(2));
	  Thread.sleep(2000);
	  clientpg.clickcreatebutton();
	  Thread.sleep(2000);
	/*  String createdclient=clientpg.getgrdclientname();
	  if(clientname.equals(createdclient))
	  {
		  logger.info("--------client created successfully------------");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  logger.info("--------client created failed!!--------------------");
		  Assert.assertTrue(false, "client creation failed");
	  }*/
  }
  public void selectcompany() throws InterruptedException
  {
  	
  	 int compnycnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Clients_company_id']//li")).size();
  	 int cmpcnt=compnycnt;
  		WebElement chkbox=driver.findElement(By.xpath("//*[@id='Clients_company_id']//li["+cmpcnt+"]//label"));
  		JavascriptExecutor e =(JavascriptExecutor)driver;
         e.executeScript("arguments[0].click();", chkbox);
         Thread.sleep(2000);
        
  }
	///*-------------------------------------
  @AfterMethod
  public void Logout() throws InterruptedException
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  Thread.sleep(2000);
  }
  //------------------------------------*/
}
