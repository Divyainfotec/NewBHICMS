package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.ClientPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.TestBase.TestBase;

public class ClientTypeTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(ClientTypeTest.class);
	Config con;
	ClientPage clientpg;
	Masterpage mstrpge;
	JavascriptHelper js;//=new JavascriptHelper(driver);
	 @BeforeMethod
		public void Login() throws InterruptedException, IOException 
		{
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
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
public void AddClientType() throws InterruptedException, AWTException
{
	 mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	 clientpg=new ClientPage(driver);
	 // clientpg.clickclientsettings();
	  logger.info("----------click settings menu--------------------");
	  Thread.sleep(2000);
	  clientpg.clicksettingsclienttype();
	  logger.info("----------click client type from settings menu--------------------");
	  Robot robo=new Robot();
	  robo.keyPress(KeyEvent.VK_CONTROL);
	  robo.keyPress(KeyEvent.VK_MINUS);
	  robo.keyRelease(KeyEvent.VK_CONTROL);
	  robo.keyRelease(KeyEvent.VK_MINUS);
	  Thread.sleep(3000);
	  clientpg.clickaddclienttype();
	  Thread.sleep(2000);
	  logger.info("----------click add client type button--------------------");
	  clientpg.typenewclienttype("PRODUCTIONTYPE"+RandomStringUtils.randomAlphabetic(2));
	  logger.info("----------type new client type--------------------");
	  clientpg.clickclienttypecreatebtn();
	  
	  logger.info("----------click client type create button-------------------");
	  Thread.sleep(2000);
}
@AfterMethod
public void Logout() throws InterruptedException
{
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  Thread.sleep(2000);
}
}
