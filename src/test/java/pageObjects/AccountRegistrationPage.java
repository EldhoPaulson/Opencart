package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtPasswordConfirm;
	@FindBy(xpath="//input[@name='agree']") WebElement chkCheckbx;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement successText;
	
	public void setFirstname(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void telephone(String tphone) {
		txtTelephone.sendKeys(tphone);
	}
	
	public void password(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void confirmPassword(String pwd) {
		txtPasswordConfirm.sendKeys(pwd);
	}
	
	public void checkbox() {
		chkCheckbx.click();
	}
	
	public void clickBtn() {
		btnContinue.click();
	}
	
	public String getConfirmation() {
		try{
			return(successText.getText());
		} catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	

}
