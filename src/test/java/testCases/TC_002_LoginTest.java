package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity", "Master"})
	public void verify_login() {
		
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("Capturing apllication debug logs");
		
		try {
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicking on My account link in Home page...");
		hp.clickMyAccount();
		logger.info("Clicking on Login link on Home page...");
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Entering valid email id and password in Login page...");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Clicked on Login button in Login page...");
		
		MyAccountPage ap = new MyAccountPage(driver);
		
		boolean targetpage = ap.isMyAccountPageDisplayed();
		
		Assert.assertEquals(targetpage, true, "Logine Failed");
		}catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("**** Finished TC_002_LoginTest  ****");
		
	}

}
