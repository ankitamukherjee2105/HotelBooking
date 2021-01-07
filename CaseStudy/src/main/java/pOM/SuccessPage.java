package pOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.TestBase;


public class SuccessPage extends TestBase {
	@FindBy(xpath="//h1")
	WebElement successPageHeading;
	
	public SuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getSuccessPageHeading() {
		return successPageHeading.getText();
	}
}


