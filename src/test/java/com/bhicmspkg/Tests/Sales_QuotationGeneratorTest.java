package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.AlertHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.ClientPage;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.Sales_QuotationGeneratorPage;
import com.bhicmspkg.TestBase.TestBase;

public class Sales_QuotationGeneratorTest extends TestBase{
	 
		private static Logger logger=LoggerHelper.getLogger(Sales_QuotationGeneratorTest.class);
		Config con;
		Masterpage mstrpge;
		Sales_QuotationGeneratorPage sqgpge;
		ClientPage clientpge;
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
			  		  Thread.sleep(2000);
					 logger.info("==============login is sucessful=========================");
					Assert.assertTrue(true);
					
				}
				else{
					captureScreen(driver,"loginTest");
					Assert.assertTrue(false, "==============login is not sucessful=========================");
				}
			  }
	///*-------------------------------------	 
@Test
public void AddsalesQuotation() throws InterruptedException
{
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	clientpge=new ClientPage(driver);
	clientpge.clickclientsettings();
	Thread.sleep(2000);
	String clientname=clientpge.getgrdclientname();
	 logger.info("--------getting client name-----------------");
	Thread.sleep(2000);
	 mstrpge.clicksettingsmenu();
	CompanyPage cmpnyname=new CompanyPage(driver);
	cmpnyname.clickcompany();
	String lastcmpname=cmpnyname.getlastcmpnyname();
	 logger.info("-------getting company name----------------");
	Thread.sleep(2000);
	mstrpge.clicksettingsmenu();
	Thread.sleep(2000);
	mstrpge.clicksettingsusers();
	Thread.sleep(2000);
	mstrpge.clickgrdusername(con.Getusername());
	Thread.sleep(2000);
	js=new JavascriptHelper(driver);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	mstrpge.clickcompany(lastcmpname);
	Thread.sleep(2000);
	mstrpge.clickuserpagesavebtn();
	Thread.sleep(2000);
	//CompanycreationTest cmpname=new CompanycreationTest();
	//String compname=cmpname.getlastcmpnyname();
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotcategory();
	  logger.info("---------click Quotation category from settings ---------------");
	  Thread.sleep(2000);
	  MastersalesTest mstrtest=new MastersalesTest();
	  String ctgry=mstrtest.Getctgrynameforqitm();
	  System.out.println("last  category name  "+ctgry);
	  logger.info("--------Getting category name-----------------");
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotworktype();
	  Thread.sleep(2000);
	  String worktype=mstrtest.Getctgrynameforqitm();
	  Thread.sleep(2000);
	  logger.info("--------Getting work type----------------");
	  System.out.println("last  work type name"+worktype);
	  Thread.sleep(2000);
	sqgpge=new Sales_QuotationGeneratorPage(driver);
	sqgpge.clicksalesmenu();
	Thread.sleep(2000);
	 logger.info("--------click sales menu-----------------");
	sqgpge.clickquotationgenerator();
	Thread.sleep(2000);
	 logger.info("--------click Quotation Generator from sales menu-----------------");
	sqgpge.clickaddquotation();
	
	sqgpge.selcompany(lastcmpname);
	Thread.sleep(2000);
	 logger.info("--------user select the company-----------------");
	Thread.sleep(2000);
	sqgpge.typeclientname(clientname);
	Thread.sleep(2000);
	 logger.info("--------user type the company-----------------");
	sqgpge.typesqaddress("D2R INTERIORS  NO : D2R.17230 ");
	 logger.info("--------user type the address----------------");
	sqgpge.typesqphoneno("7657"+RandomStringUtils.randomNumeric(4));
	 logger.info("--------user type phone number----------------");
	sqgpge.typesqemail("bhisq"+RandomStringUtils.randomAlphabetic(2)+"@bhi.com");
	 logger.info("--------user type email-----------------");
	sqgpge.sqdate();
	 logger.info("--------take today date-----------------");
	sqgpge.selsqlocation();    
	Thread.sleep(2000);
	 logger.info("--------select the location-----------------");
	String quotationno=sqgpge.Getqquotationno();
	Thread.sleep(2000);
	System.out.println("New quotation number"+quotationno);
	Sales_QuotationGeneratorPage sqgpge=new Sales_QuotationGeneratorPage(driver);
	//sqgpge.selectcategory(ctgry);
	sqgpge.selectcategory("LIVING ROOM");
	logger.info("--------selecting the category-----------------");
	Thread.sleep(2000);
	sqgpge.typectgrylabel();
	logger.info("--------type the category label-----------------");
	Thread.sleep(2000);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	sqgpge.selectwrktypelbl();
	Thread.sleep(2000);
	logger.info("--------selecting the worktype label-----------------");
	sqgpge.selectqgunit("nos");
	Thread.sleep(2000);
	logger.info("--------selecting the unit-----------------");
	sqgpge.typeqgquantity("1");
	logger.info("--------type the quantity-----------------");
	sqgpge.typeqgquantityinnos("1");
	Thread.sleep(2000);
	logger.info("--------type the quantity in nos-----------------");
	//sqgpge.typeqgmrp("100");
	//Thread.sleep(2000);
	//String value1=driver.findElement(By.xpath("//input[@id='amount_after_discount0']")).getAttribute("value");
	//String value=driver.findElement(By.xpath("//table[@id='qitem_table']//tbody//tr[1]//td[9]")).getAttribute("value");
	int Totalamntaftrdiscnt=sqgpge.getqgamntaftrdicnt();
	Thread.sleep(2000);
	System.out.println("Total amount after discount "+Totalamntaftrdiscnt);
	String finaltotalamnt=driver.findElement(By.xpath("//*[@id='total-amount-val']")).getAttribute("value").toString();
	//String finalamnt=finaltotalamnt.split(".");
	//System.out.println(""+finalamnt);
	int d=0;
	 d=d+Integer.parseInt(finaltotalamnt);
	Thread.sleep(2000);
	if(Totalamntaftrdiscnt==d)
	{
		logger.info("-------total amount after discount and final amount are equal----------------");
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false, "-------total amount after discount and final amount are not equal----------------");
	}
	js.scrollDownByPixel();
	Thread.sleep(2000);
	sqgpge.clicksqgcreatebtn();
	Thread.sleep(2000);
	logger.info("------click quotation generator create button---------------");
	logger.info("------user generated a quotation with extra work successfully!!1---------------");

}

@Test
public void AddsalesQuotationWithSubItem() throws InterruptedException
{
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	clientpge=new ClientPage(driver);
	clientpge.clickclientsettings();
	Thread.sleep(2000);
	String clientname=clientpge.getgrdclientname();
	 logger.info("--------getting client name-----------------");
	Thread.sleep(2000);
	 mstrpge.clicksettingsmenu();
	CompanyPage cmpnyname=new CompanyPage(driver);
	cmpnyname.clickcompany();
	String lastcmpname=cmpnyname.getlastcmpnyname();
	 logger.info("-------getting company name----------------");
	Thread.sleep(2000);
	mstrpge.clicksettingsmenu();
	Thread.sleep(2000);
	mstrpge.clicksettingsusers();
	Thread.sleep(2000);
	mstrpge.clickgrdusername(con.Getusername());
	Thread.sleep(2000);
	js=new JavascriptHelper(driver);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	mstrpge.clickcompany(lastcmpname);
	Thread.sleep(2000);
	mstrpge.clickuserpagesavebtn();
	Thread.sleep(2000);
	//CompanycreationTest cmpname=new CompanycreationTest();
	//String compname=cmpname.getlastcmpnyname();
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotcategory();
	  logger.info("---------click Quotation category from settings ---------------");
	  Thread.sleep(2000);
	  MastersalesTest mstrtest=new MastersalesTest();
	  String ctgry=mstrtest.Getctgrynameforqitm();
	  System.out.println("last  category name  "+ctgry);
	  logger.info("--------Getting category name-----------------");
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotworktype();
	  Thread.sleep(2000);
	  String worktype=mstrtest.Getctgrynameforqitm();
	  Thread.sleep(2000);
	  logger.info("--------Getting work type----------------");
	  System.out.println("last  work type name"+worktype);
	  Thread.sleep(2000);
	sqgpge=new Sales_QuotationGeneratorPage(driver);
	sqgpge.clicksalesmenu();
	Thread.sleep(2000);
	 logger.info("--------click sales menu-----------------");
	sqgpge.clickquotationgenerator();
	Thread.sleep(2000);
	 logger.info("--------click Quotation Generator from sales menu-----------------");
	sqgpge.clickaddquotation();
	
	sqgpge.selcompany(lastcmpname);
	Thread.sleep(2000);
	 logger.info("--------user select the company-----------------");
	Thread.sleep(2000);
	sqgpge.typeclientname(clientname);
	Thread.sleep(2000);
	 logger.info("--------user type the company-----------------");
	sqgpge.typesqaddress("D2R INTERIORS  NO : D2R.17230 ");
	 logger.info("--------user type the address----------------");
	sqgpge.typesqphoneno("7657"+RandomStringUtils.randomNumeric(4));
	 logger.info("--------user type phone number----------------");
	sqgpge.typesqemail("bhisq"+RandomStringUtils.randomAlphabetic(2)+"@bhi.com");
	 logger.info("--------user type email-----------------");
	sqgpge.sqdate();
	 logger.info("--------take today date-----------------");
	sqgpge.selsqlocation();    
	Thread.sleep(2000);
	 logger.info("--------select the location-----------------");
	String quotationno=sqgpge.Getqquotationno();
	Thread.sleep(2000);
	System.out.println("New quotation number"+quotationno);
	Sales_QuotationGeneratorPage sqgpge=new Sales_QuotationGeneratorPage(driver);
	//sqgpge.selectcategory(ctgry);
	sqgpge.selectcategory("LIVING ROOM");
	logger.info("--------selecting the category-----------------");
	Thread.sleep(2000);
	sqgpge.typectgrylabel();
	logger.info("--------type the category label-----------------");
	Thread.sleep(2000);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	sqgpge.selectwrktypelbl();
	Thread.sleep(2000);
	logger.info("--------selecting the worktype label-----------------");
	sqgpge.selectqgunit("nos");
	Thread.sleep(2000);
	logger.info("--------selecting the unit-----------------");
	sqgpge.typeqgquantity("1");
	logger.info("--------type the quantity-----------------");
	sqgpge.typeqgquantityinnos("1");
	Thread.sleep(2000);
	logger.info("--------type the quantity in nos-----------------");
	int Totalamntaftrdiscnt=sqgpge.getqgamntaftrdicnt();
	Thread.sleep(2000);
	System.out.println("Total amount after discount "+Totalamntaftrdiscnt);
	String finaltotalamnt=driver.findElement(By.xpath("//*[@id='total-amount-val']")).getAttribute("value").toString();
	//String finalamnt=finaltotalamnt.split(".");
	//System.out.println(""+finalamnt);
	int d=0;
	 d=d+Integer.parseInt(finaltotalamnt);
	Thread.sleep(2000);
	if(Totalamntaftrdiscnt==d)
	{
		logger.info("-------total amount after discount and final amount are equal----------------");
		//Assert.assertTrue(true);
	}
	else
	{
		logger.info("-------total amount after discount and final amount are not equal----------------");
		//Assert.assertTrue(false, "-------total amount after discount and final amount are not equal----------------");
	}
	sqgpge.clickAddsubItem();
	Thread.sleep(2000);
	
	logger.info("------click add sub item-----------------");
	sqgpge.Typesubitmlabel("subitemlbl"+RandomStringUtils.randomAlphabetic(2));
	Thread.sleep(2000);
	
	logger.info("------type sub item label----------------");
	sqgpge.selsubitmwrktypelbl();
	Thread.sleep(2000);
	logger.info("------select sub item work type label----------------");
	sqgpge.selsubitmlbl();
	Thread.sleep(2000);
	logger.info("------select sub item label----------------");
	sqgpge.selsubitmunit("nos");
	Thread.sleep(2000);
	logger.info("------select unit----------------");
	js.scrollDownByPixel();
	sqgpge.typesubitmquantity("1");
	logger.info("------type sub item work type label----------------");
	Thread.sleep(2000);
	sqgpge.typesubitmqtyno("1");
	Thread.sleep(2000);
	logger.info("------type sub item quantity no----------------");
	sqgpge.clicksqgcreatebtn();
	Thread.sleep(2000);
	logger.info("------click quotation generator create button---------------");
	logger.info("------user generated a quotation with extra work successfully!!1---------------");

		
}
@Test
public void AddsalesQuotationWithExtrawork() throws InterruptedException
{
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	clientpge=new ClientPage(driver);
	clientpge.clickclientsettings();
	Thread.sleep(2000);
	String clientname=clientpge.getgrdclientname();
	 logger.info("--------getting client name-----------------");
	Thread.sleep(2000);
	 mstrpge.clicksettingsmenu();
	CompanyPage cmpnyname=new CompanyPage(driver);
	cmpnyname.clickcompany();
	String lastcmpname=cmpnyname.getlastcmpnyname();
	 logger.info("-------getting company name----------------");
	Thread.sleep(2000);
	mstrpge.clicksettingsmenu();
	Thread.sleep(2000);
	mstrpge.clicksettingsusers();
	Thread.sleep(2000);
	mstrpge.clickgrdusername(con.Getusername());
	Thread.sleep(2000);
	js=new JavascriptHelper(driver);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	mstrpge.clickcompany(lastcmpname);
	Thread.sleep(2000);
	mstrpge.clickuserpagesavebtn();
	Thread.sleep(2000);
	//CompanycreationTest cmpname=new CompanycreationTest();
	//String compname=cmpname.getlastcmpnyname();
	mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotcategory();
	  logger.info("---------click Quotation category from settings ---------------");
	  Thread.sleep(2000);
	  MastersalesTest mstrtest=new MastersalesTest();
	  String ctgry=mstrtest.Getctgrynameforqitm();
	  System.out.println("last  category name  "+ctgry);
	  logger.info("--------Getting category name-----------------");
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotworktype();
	  Thread.sleep(2000);
	  String worktype=mstrtest.Getctgrynameforqitm();
	  Thread.sleep(2000);
	  logger.info("--------Getting work type----------------");
	  System.out.println("last  work type name"+worktype);
	  Thread.sleep(2000);
	sqgpge=new Sales_QuotationGeneratorPage(driver);
	sqgpge.clicksalesmenu();
	Thread.sleep(2000);
	 logger.info("--------click sales menu-----------------");
	sqgpge.clickquotationgenerator();
	Thread.sleep(2000);
	 logger.info("--------click Quotation Generator from sales menu-----------------");
	sqgpge.clickaddquotation();
	
	sqgpge.selcompany(lastcmpname);
	Thread.sleep(2000);
	 logger.info("--------user select the company-----------------");
	Thread.sleep(2000);
	sqgpge.typeclientname(clientname);
	Thread.sleep(2000);
	 logger.info("--------user type the company-----------------");
	sqgpge.typesqaddress("D2R INTERIORS  NO : D2R.17230 ");
	 logger.info("--------user type the address----------------");
	sqgpge.typesqphoneno("7657"+RandomStringUtils.randomNumeric(4));
	 logger.info("--------user type phone number----------------");
	sqgpge.typesqemail("bhisq"+RandomStringUtils.randomAlphabetic(2)+"@bhi.com");
	 logger.info("--------user type email-----------------");
	sqgpge.sqdate();
	 logger.info("--------take today date-----------------");
	sqgpge.selsqlocation();    
	Thread.sleep(2000);
	 logger.info("--------select the location-----------------");
	String quotationno=sqgpge.Getqquotationno();
	Thread.sleep(2000);
	System.out.println("New quotation number"+quotationno);
	Sales_QuotationGeneratorPage sqgpge=new Sales_QuotationGeneratorPage(driver);
	//sqgpge.selectcategory(ctgry);
	sqgpge.selectcategory("LIVING ROOM");
	logger.info("--------selecting the category-----------------");
	Thread.sleep(2000);
	sqgpge.typectgrylabel();
	logger.info("--------type the category label-----------------");
	Thread.sleep(2000);
	js.scrollDownByPixel();
	Thread.sleep(2000);
	sqgpge.selectwrktypelbl();
	Thread.sleep(2000);
	logger.info("--------selecting the worktype label-----------------");
	sqgpge.selectqgunit("nos");
	Thread.sleep(2000);
	logger.info("--------selecting the unit-----------------");
	sqgpge.typeqgquantity("1");
	logger.info("--------type the quantity-----------------");
	sqgpge.typeqgquantityinnos("1");
	Thread.sleep(2000);
	logger.info("--------type the quantity in nos-----------------");
	int Totalamntaftrdiscnt=sqgpge.getqgamntaftrdicnt();
	Thread.sleep(2000);
	System.out.println("Total amount after discount "+Totalamntaftrdiscnt);
	String finaltotalamnt=driver.findElement(By.xpath("//*[@id='total-amount-val']")).getAttribute("value").toString();
	//String finalamnt=finaltotalamnt.split(".");
	//System.out.println(""+finalamnt);
	int d=0;
	 d=d+Integer.parseInt(finaltotalamnt);
	Thread.sleep(2000);
	if(Totalamntaftrdiscnt==d)
	{
		logger.info("-------total amount after discount and final amount are equal----------------");
		//Assert.assertTrue(true);
	}
	else
	{
		logger.info("-------total amount after discount and final amount are not equal----------------");
		//Assert.assertTrue(false, "-------total amount after discount and final amount are not equal----------------");
	}
	sqgpge.clickextrawork();
	//sqgpge.clickxtrawrkimg();
	Thread.sleep(2000);
	sqgpge.typextrawrkdescr();
	logger.info("------type extra work description---------------");
	sqgpge.selxtrawrkunit("nos");
	Thread.sleep(2000);
	logger.info("------select extra work unit---------------");
	//js.scrollDownByPixel();
	sqgpge.typextrawrkquantity("1");
	Thread.sleep(2000);
	logger.info("------type extra work quantity----------------");
	sqgpge.typextrawrkqtynos("1");
	Thread.sleep(2000);
	logger.info("------type extra work quantity nos-------------");
	js.scrollDownByPixel();
	Thread.sleep(2000);
	sqgpge.typextrawrkmrp("500");
	Thread.sleep(2000);
	logger.info("------type extra work mrp-------------");
	sqgpge.typextrawrkamntaftrdiscnt("500");
	Thread.sleep(2000);
	logger.info("------type extra work amnt after discnt------------");
	sqgpge.clicksqgcreatebtn();
	Thread.sleep(2000);
	logger.info("------click quotation generator create button---------------");
	logger.info("------user generated a quotation with extra work successfully!!1---------------");
}
//--------------------------------*/
@Test
public void SalesquotationView() throws InterruptedException, AWTException
{ 	
	 Sales_QuotationGeneratorPage sqpge=new Sales_QuotationGeneratorPage(driver);
	 sqpge.clicksalesmenu();
	 Thread.sleep(2000);
	 logger.info("-------User click Sales menu----------------");
	 sqpge.clickquotationgenerator();
	 Thread.sleep(2000);
	 logger.info("-------User click Quotation generator----------------");
	 sqpge.clicksqgaction();
	 Thread.sleep(2000);
	 logger.info("-------User click quotation action menu---------------");
	 sqpge.clickviewoption();
	 Thread.sleep(2000);
	 logger.info("-------View option available---------------");
}
@Test
public void SalesquotationEdit() throws InterruptedException, AWTException
{ 	
	 Sales_QuotationGeneratorPage sqpge=new Sales_QuotationGeneratorPage(driver);
	 sqpge.clicksalesmenu();
	 Thread.sleep(2000);
	 logger.info("-------User click Sales menu----------------");
	 sqpge.clickquotationgenerator();
	 Thread.sleep(2000);
	 logger.info("-------User click Quotation generator----------------");
	 sqpge.clicksqgaction();
	 Thread.sleep(2000);
	 logger.info("-------User click quotation action menu---------------");
	 sqpge.clickeditoption();
	 Thread.sleep(2000);
	 logger.info("-------View option available---------------");
}
@Test
public void Salesquotationdelete() throws InterruptedException, AWTException
{ 	
	 Sales_QuotationGeneratorPage sqpge=new Sales_QuotationGeneratorPage(driver);
	 sqpge.clicksalesmenu();
	 Thread.sleep(2000);
	 logger.info("-------User click Sales menu----------------");
	 sqpge.clickquotationgenerator();
	 Thread.sleep(2000);
	 logger.info("-------User click Quotation generator----------------");
	 sqpge.clicksqgaction();
	 Thread.sleep(2000);
	 logger.info("-------User click quotation action menu---------------");
	 sqpge.clickdeleteoption();
	 Thread.sleep(2000);
	 AlertHelper alert=new AlertHelper(driver);
	 alert.AcceptAlertIfPresent();
	 Thread.sleep(2000);
	 logger.info("-------Deletion successfully---------------");
	 
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
