package pOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//h1[@align='center']")
	WebElement loginPageHeading;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='userErrMsg']")
	WebElement errorMessageWihoutUsername;
	
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="userPwd")
	WebElement password;
	
    @FindBy(xpath="//div[@id='pwdErrMsg']")
	WebElement errorMessageWithoutPassword;
    public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    
	public String getLoginPageHeading() {
		return driver.findElement(By.xpath("//h1[@align='center']")).getText();
	}
	
	public String loginWithoutUserName() {
		loginBtn.click();
		return driver.findElement(By.xpath("//div[@id='userErrMsg']")).getText();
	}
	
	public String loginWithoutPassword() {
		username.sendKeys("admin");
		loginBtn.click();
		return driver.findElement(By.xpath("//div[@id='pwdErrMsg']")).getText();
	}
	
	public String getHeading() {
		return loginPageHeading.getText();	
	}
	public String getErrorMessageWithoutUsername() {
		return errorMessageWihoutUsername.getText();	
	}
	
	public String getErrorMessageWithoutPassword() {
		return errorMessageWithoutPassword.getText();
	}
	
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}


