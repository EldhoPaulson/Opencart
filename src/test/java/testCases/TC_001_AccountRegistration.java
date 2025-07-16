package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
	
	
	@Test(groups = {"Regression", "Master"})
	public void verify_account_regustration() {
		
		logger.info("**** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My Account link...");
		
		hp.clickRegister();
		logger.info("Clicked on Register...");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		arp.setFirstname(randomString().toUpperCase());
		arp.setLastname(randomString().toUpperCase());
		arp.setEmail(randomString()+ "@gmail.com");
		arp.telephone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		arp.password(password);
		arp.confirmPassword(password);
		
	
		arp.checkbox();
		arp.clickBtn();
		
		logger.info("Validating expected Message... ");
		String cnfmsg = arp.getConfirmation();
		
		if(cnfmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed... ");
			logger.debug("Debug Logs... ");
			Assert.assertTrue(false);
		}
		
		
		//Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		
		logger.info("Test Passed...");
		}
		catch(Exception e) {
			
			Assert.fail("Test failed: " +e.getMessage());
		}
		finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
		
	}
	
	
}
