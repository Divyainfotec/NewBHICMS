package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class MastersalesTest extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(MastersalesTest.class);
	Config con;
	
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
	/*-----------------------------------------------------------
  @Test
  public void QuotationCategory() throws InterruptedException, AWTException {
	  mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotcategory();
	  logger.info("---------click Quotation category from settings ---------------");
	  Thread.sleep(2000);
	  String categoryname="category"+RandomStringUtils.randomAlphabetic(2);
	  mstrpge.typecategoryname(categoryname);
	  Thread.sleep(2000);
	  mstrpge.clickcreatecategorybtn();
	  Thread.sleep(2000);
	  Getcategoryname(categoryname);
	  Thread.sleep(2000);
  }
  public void Getcategoryname(String expcategoryname) throws InterruptedException
  {
	  try {
	  WebElement elem=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//thead//tr[2]//td[3]//input"));
	 elem.sendKeys(expcategoryname);
	// elem.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  List<WebElement>ctgrylist=driver.findElements(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]"));
	  for(int i=1;i<=ctgrylist.size();i++)
	  {
		String actctgrynme =driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+i+"]//td[3]")).getText();
		if(expcategoryname.equals(actctgrynme))
		{
			logger.info("-------------category created successfully!!!!---------------");
			Assert.assertTrue(true);
		}
	  }}
	  catch(Exception ex)
	  {
		  logger.info("---------category creation failed!!!------------------");
		  Assert.assertTrue(false, "-----------something went wrong.category cannot create-------------");
		
	  }
  }
  
  //worktype
  @Test
  public void CreateQuotationWorktype() throws InterruptedException, AWTException {
	  mstrpge=new Masterpage(driver);
	  mstrpge.clicksettingsmenu();
	  Thread.sleep(2000);
	  logger.info("--------click settings menu-----------------");
	  mstrpge.clicksettingsquotworktype();
	  Thread.sleep(2000);
	  logger.info("---------click Quotation worktype from settings ---------------");
	  String worktypename="Kitchenwardrobe"+RandomStringUtils.randomAlphabetic(2);
	  mstrpge.typeworktype(worktypename);
	  Thread.sleep(2000);
	  logger.info("----------type work type name ----------------------");
	  mstrpge.selworktypetmplate("Box Template");
	  Thread.sleep(2000);
	  logger.info("----------select work type template ----------------------");
	  mstrpge.selworktypestatus("Active");
	  Thread.sleep(2000);
	  logger.info("----------select work type status----------------------");
	  mstrpge.clickworktypecreatebtn();
	  Thread.sleep(2000);
	  logger.info("----------click work type create  button----------------------");
	  Getquotationworktype(worktypename);
	  Thread.sleep(2000);
  }
  
  private void Getquotationworktype(String expworktypename) throws InterruptedException {
		try {
	  WebElement elem=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//thead//tr[2]//td[3]//input"));
		 Thread.sleep(2000);
		elem.sendKeys(expworktypename);
		 Thread.sleep(2000);
		String actworktype=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]")).getText();
		if(expworktypename.equals(actworktype))
		{
			logger.info("---------worktype creation successfullly!!--------------");
			Assert.assertTrue(true);
		}
		}catch(Exception ex)
		{
			logger.info("---------worktype creation failed!!--------------");
			Assert.assertTrue(false, "---------something went wrong, Quotation work type creation failed!!!------------------------");
		}
		
	}
	
	 @Test
	 public void CreateQuotationFinish() throws InterruptedException, AWTException {
		  mstrpge=new Masterpage(driver);
		  mstrpge.clicksettingsmenu();
		  Thread.sleep(2000);
		  logger.info("--------click settings menu-----------------");
		  mstrpge.clicksettingsquotfinish();
		  Thread.sleep(2000);
		  logger.info("---------click Quotation Finish from settings ---------------");
		  String quotationfinish="GlassFinish"+RandomStringUtils.randomAlphabetic(2);
		  mstrpge.typequotationfinish(quotationfinish);
		  Thread.sleep(2000);
		  logger.info("------type quotation finish----------------");
		  mstrpge.clickcreatequotationfinish();
		  Thread.sleep(2000);
		  GetquotationFinish(quotationfinish);
		  
	 }
private void GetquotationFinish(String expquotationfinish) throws InterruptedException {
	WebElement elem=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//thead//tr[2]//td[3]//input"));
	elem.sendKeys(expquotationfinish);
	Thread.sleep(2000);
	elem.sendKeys(Keys.ENTER);
   String actquotationfinsh=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]")).getText();
   if(expquotationfinish.equals(actquotationfinsh))
   {
	   logger.info("--------quotation finish create successfully!!!--------------");
	   Assert.assertTrue(true);
   }
		
		
	}
	-------------------------------------------------------------------------*/
	 @Test
	  public void createquotationitemmaster() throws InterruptedException
	 {
		 mstrpge=new Masterpage(driver);
		  mstrpge.clicksettingsmenu();
		  Thread.sleep(2000);
		  logger.info("--------click settings menu-----------------");
		  mstrpge.clicksettingsquotcategory();
		  logger.info("---------click Quotation category from settings ---------------");
		  Thread.sleep(2000);
		  String ctgry=Getctgrynameforqitm();
		  System.out.println("last  category name  "+ctgry);
		  mstrpge.clicksettingsmenu();
		  Thread.sleep(2000);
		  logger.info("--------click settings menu-----------------");
		  mstrpge.clicksettingsquotworktype();
		  Thread.sleep(2000);
		  String worktype=Getctgrynameforqitm();
		  Thread.sleep(2000);
		  System.out.println("last  work type name"+worktype);
		  Thread.sleep(2000);
	     mstrpge.clicksettingsmenu();
		  Thread.sleep(2000);  
		  mstrpge.clicksettingsquotitem();
		  Thread.sleep(2000);
		  logger.info("---------click Quotation Item from settings ---------------");
		  mstrpge.clickaddquotationitem();
		  Thread.sleep(2000);
		  mstrpge.selctgryforqitm(ctgry);
		  Thread.sleep(2000);
		  mstrpge.selworktypeforqitm(worktype);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id='file']")).sendKeys("C:\\Users\\divya\\OneDrive\\Desktop\\Works\\upload\\pc21.jpeg");
		  Thread.sleep(2000);
		  mstrpge.typeworktypelabel(worktype+"lbl"+RandomStringUtils.randomAlphabetic(2));
		  Thread.sleep(2000);
		  mstrpge.selworktypematerial();//"Category1-Brand1-Spec1"
		  Thread.sleep(2000);
		  mstrpge.selworktypefinish();
		  Thread.sleep(2000);
		  mstrpge.typeworktypedescr(worktype+"description");
		  mstrpge.selworktypematerial1();//"Category1-Brand1-Spec1"
		  Thread.sleep(2000);
		  mstrpge.selworktypefinish1();
		  Thread.sleep(2000);
		  mstrpge.typeworktypedescr1(worktype+"description");
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  mstrpge.typerate(RandomStringUtils.randomNumeric(3));
		  Thread.sleep(2000);
		  mstrpge.typeprofit("2");
		  Thread.sleep(2000);
		  mstrpge.typediscount("1");
		  Thread.sleep(2000);
		  mstrpge.clickQaddbtn();
		  Thread.sleep(2000);
		 // }
	/*	  catch(Exception ex)
		  {
			  System.out.println("----------------------");
		  } */
		 
		  
	 }
	 public String Getworktypeforqitm()
	 {
		 
		return null;
		 
	 }
	 public String Getctgrynameforqitm() throws InterruptedException
	 {
		 List<WebElement> categorynameelements=driver.findElements(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]"));
		  List<String> categorynamelist=new ArrayList<String>();
		/*--  for(WebElement ctgrynmeelm:categorynameelements)
		  {
			  categorynamelist.add(ctgrynmeelm.getText());
			  String ctgryname=ctgrynmeelm.getText();
			  //System.out.println(ctgryname);
		  } --*/
		  int ctgrycnt=categorynameelements.size();
		  Thread.sleep(2000);
		  //System.out.println("Count of ctgryelements"+ctgrycnt);
		  JavascriptHelper js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  String nextbtnclass=driver.findElement(By.xpath("//li[@class='next']")).getAttribute("class");
		 // while(!nextbtnclass.equals("next hidden"))
		  try {
		  while(driver.findElement(By.xpath("//li[@class='next']")).isDisplayed())
		  {
			  Thread.sleep(2000);
			 // JavascriptHelper js=new JavascriptHelper(driver);
			 // js.scrollDownByPixel();
			  driver.findElement(By.xpath("//li[@class='next']//a")).click();
			  Thread.sleep(2000);
			  categorynameelements=driver.findElements(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]"));
			  Thread.sleep(2000);
			  int cnt=driver.findElements(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]")).size();
			  //for(WebElement ctgrynmeelm:categorynameelements)
			  /*--	  for(int i=1;i<=categorynameelements.size();i++)
			  {
				  WebElement elem=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+i+"]//td[3]"));
				  categorynamelist.add(elem.getText());
				  String ctgryname=elem.getText();
				  Thread.sleep(2000);
				 // System.out.println(ctgryname);
				 // return driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]")).getText();
				 // return ctgryname;
			  }--*/
			 
		  } 
		  }catch(Exception ex)
		  {
			  System.out.println("--------category/work type not available--------------");
		  }
		 // Thread.sleep(2000);
		  //String txtctgry=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr[+cnt+]//td[3]")).getText();
		  //System.out.println("-----------------------------"+txtctgry);
		  List<WebElement> grditm=driver.findElements(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]"));
		  int grdcnt=grditm.size();
		  //System.out.println("last grid value"+driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+grdcnt+"]//td[3]")).getText());
		  return driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+grdcnt+"]//td[3]")).getText();
		/*for(int i=1;i<grditm.size();i++)
		{
			String grdvalue=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+i+"]//td[3]")).getText();
			System.out.println(grdvalue);
			String  lastgrdvalue=driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr["+i+"]//td[3]")).getText();
			String getlastgrdvalue=lastgrdvalue;
			System.out.println("last grd value"+getlastgrdvalue);
			
		}
		return getlastgrdvalue;*/
		 // return driver.findElement(By.xpath("//*[@id='quotation-category-master-grid']//table//tbody//tr//td[3]")).getText();
		
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
