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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.TestBase.TestBase;

public class UserCreationTest extends TestBase{
	
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 JavascriptHelper js;
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
		 boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				
				logger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  	
		}
	 /*-----------------------------------------------
	 
	 @Test
	 public void UserCreation() throws InterruptedException
	 {
		 con=new Config(pr);
		  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 userpge=new UserPage(driver);
		 userpge.clicksettingsusers();
		 logger.info("----------user click users from settings menu-----------");
		 userpge.clickadduserbtn();
		 logger.info("----------user click add user button-----------");
		 Thread.sleep(2000);
		  userpge.typefirstname("bhiuser"+RandomStringUtils.randomAlphabetic(2));
		 logger.info("----------user type first name-----------");
		 userpge.typelastname("bhi"+RandomStringUtils.randomAlphabetic(2));
		 logger.info("----------user type last name-----------");
		 String uname="annbhi"+RandomStringUtils.randomAlphabetic(2);
		 userpge.typeusername(uname);
		 logger.info("----------user type username-----------");
		 userpge.typeuserpassword("annbhi"+RandomStringUtils.randomNumeric(2));
		 logger.info("----------user type password-----------");
		 userpge.typeuseremail(RandomStringUtils.randomAlphabetic(5)+"@bhiemail.com");
		 logger.info("----------user type email-----------");
		 JavascriptHelper js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 userpge.typeuserphoneno("576723423");
		 logger.info("----------user type user phone number-----------");
		 userpge.selusertype("Administrator");
		 logger.info("----------select user type -----------");
		 Thread.sleep(2000);
	//	 selreportperson();
		// logger.info("----------select report person -----------");
		 //Thread.sleep(2000);
		 selectcompanyuser();
		 Thread.sleep(2000);
		 logger.info("----------select company -----------");
		 userpge.clickactivestatus();
		 logger.info("----------user click active status-----------");
		 userpge.clickcreatebtn();
		 logger.info("---------user click create button -----------");
		 Thread.sleep(2000);
		 Getusername(uname);
		 Thread.sleep(2000);
	 } 


	 public void Getusername(String uname) {
		
     List<WebElement> userslst=driver.findElements(By.xpath("//*[@id='usertable']//tbody//tr//td[2]"));
     for(WebElement we:userslst)
     {
    	 if(we.getText().equals(uname))
    	 {
    		 logger.info("-------------User created successfully!!-------------------------");
    		 Assert.assertTrue(true);
    	 }
     }
		
	}
	public void selectcompanyuser()
	 {
		// String expcompanyname=cmpnyname;
		 int compnycnt=driver.findElements(By.xpath("//span[@id='Users_company_id']//li//label")).size();
		 WebElement elem= driver.findElement(By.xpath("//span[@id='Users_company_id']//li["+compnycnt+"]//label"));
		 if(!elem.isSelected())
		 {
			 elem.click();
		 }
		/* for(int i=1;i<=compnycnt;i++)
		 {
		 String actcmpnyuname=driver.findElement(By.xpath("//span[@id='Users_company_id']//li["+i+"]//label")).getText();
		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		 if(actcmpnyuname.equalsIgnoreCase(expcompanyname))
			{
			WebElement chkbox=driver.findElement(By.xpath("//span[@id='Users_company_id']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	       e.executeScript("arguments[0].click();", chkbox);
			}
		 }*/
		
	// }	
	 public void selreportperson()
	 {
		//select[@id='Users_reporting_person']//optgroup
		 
		 //body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[2]/select[1]//optgroup//option[text()='divya qc']
		 String username=con.Getcompanyusername();
		// WebElement rptperson=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[2]/select[1]//optgroup//option[text()='divya qc']"));
		 
		 if(username.equalsIgnoreCase("BHI Team"))
			 {
				  WebElement chkbox=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[2]/select[1]//optgroup//option[text()='divya qc']"));
					JavascriptExecutor e =(JavascriptExecutor)driver;
			       e.executeScript("arguments[0].click();", chkbox);
				 //we.click();
			 }
		 
	 }
	 //-----------------------------*/
	 
	 @Test
	 public void UserToCompanyPermission() throws InterruptedException
	 {
		 con=new Config(pr);
		  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 userpge=new UserPage(driver);
		 userpge.clicksettingsusers();
		 logger.info("----------user click users from settings menu-----------");
		 String uname=con.Getusername();
		 Searchuname(uname);
		 		 Thread.sleep(2000); 
	 }
private void Searchuname(String uname) throws InterruptedException {
		List<WebElement>userlist=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=userlist.size();i++)
		{
			if(uname.equals(driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText()))

				{
					WebElement editelm=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[10]//a"));
					 js=new JavascriptHelper(driver);
			        js.scrollIntoView(editelm);
			        Thread.sleep(2000);
			        editelm.click();
					Thread.sleep(2000);
					SelectLastCompanyname() ;
					Thread.sleep(2000);
				}
		}
		
	}
public void SelectLastCompanyname() throws InterruptedException
{
  int cmpnycnt=driver.findElements(By.xpath("//*[@id='Users_company_id']//li//label")).size();
  try {
	  WebElement cmpny=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+cmpnycnt+"]//label"));
	  //js=new JavascriptHelper(driver);
     // js.scrollIntoView(cmpny);
	  if(cmpny.getAttribute("checked")==null)
	  {
		  cmpny.click();
		  Thread.sleep(2000);
		  JavascriptHelper js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  userpge.clicksavebutton();
	  }
	  //Boolean attributevalue=cmpny.getAttribute("checked").contains("checked");
	 //if(attributevalue.booleanValue()==true)
	  if(cmpny.getAttribute("checked").contains("checked"))
	  {
		 // cmpny.click();
		  //Thread.sleep(2000);
		  //JavascriptHelper js=new JavascriptHelper(driver);
		  //js.scrollDownByPixel();
		 // userpge.clicksavebutton();
      }
	  }
  catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 


}
@AfterMethod
public void Logout() throws InterruptedException
{
	 //driver.findElement(By.xpath("//li//a[text()='Home']")).click();
	   logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  Thread.sleep(2000);
}
}


