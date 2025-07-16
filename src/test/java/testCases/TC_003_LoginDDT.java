package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/



public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups = "Datadriven")
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {
		
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
		
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicking on My account link in Home page...");
		hp.clickMyAccount();
		logger.info("Clicking on Login link on Home page...");
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Entering valid email id and password in Login page...");
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Clicked on Login button in Login page...");
		
		MyAccountPage ap = new MyAccountPage(driver);
		
		boolean targetpage = ap.isMyAccountPageDisplayed();
		
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(targetpage==true) {
				ap.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetpage==true) {
				ap.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail("An exception occured: " +e.getMessage());
		}
		
		Thread.sleep(5000);
	
		
		logger.info("**** Finished TC_003_LoginDDT *****");

		
	}

}
