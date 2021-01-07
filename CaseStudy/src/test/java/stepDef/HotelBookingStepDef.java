package stepDef;

import org.testng.Assert;

import baseClass.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pOM.BookingForm;
import pOM.LoginPage;
import pOM.SuccessPage;

public class HotelBookingStepDef extends TestBase {
	LoginPage loginPage;
	BookingForm bookingForm;
	SuccessPage successPage;
	String errorWithoutPassword;
	String errorWithoutUsername;
	String loginPageHeading;
	String alertMessage;
	String incorectAlertMessage;
	String address;
	String numberOfRooms;
	String alertMessageMonth;
	String alertMessageYear;
	
	@Given("^I am in the Login page$")
	public void I_am_in_the_Login_page() throws Throwable {
		TestBase.initialize();
	}
	@Given("^Heading of the Login page is matching$")
	public void heading_of_the_Login_page_is_matching() throws Throwable {
		loginPage = new LoginPage();
		loginPageHeading = loginPage.getLoginPageHeading();
		Assert.assertEquals(loginPage.getHeading(), loginPageHeading);
	}
	@Then("^print the heading of the login page$")
	public void print_the_heading_of_the_login_page() throws Throwable {
		System.out.println("Heading of Login Page: " + loginPageHeading);
		TestBase.closeBrowser();
	}
	@Given("^Click on login without username$")
	public void click_on_login_without_username() throws Throwable {
		loginPage = new LoginPage();
		errorWithoutUsername = loginPage.loginWithoutUserName();
		Assert.assertEquals(loginPage.getErrorMessageWithoutUsername(), errorWithoutUsername);
	}

	@Given("^Click on login without password$")
	public void click_on_login_without_password() throws Throwable {
		loginPage = new LoginPage();
		errorWithoutPassword = loginPage.loginWithoutPassword();
		Assert.assertEquals(loginPage.getErrorMessageWithoutPassword(), errorWithoutPassword);
	}

	@Then("^print the error message and close the browser$")
	public void print_the_error_message_and_clos_the_browser() throws Throwable {
		System.out.println("Message while tryng to login without username is " + errorWithoutUsername);
		System.out.println("Message while tryng to login without password is : " + errorWithoutPassword);
		TestBase.closeBrowser();
	}
	
	@Given("^Enter the login credentials$")
	public void enter_the_login_credentials() throws Throwable {
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Given("^Getting redirected to Hotel Booking Form$")
	public void getting_redirected_to_Hotel_Booking_Form() throws Throwable {
		bookingForm = new BookingForm();
		Assert.assertEquals(bookingForm.getBookingFormUrl(),
				"file:///C:/Users/Ankita%20Mukherjee/Downloads/Casestudy/HotelBooking/Casestudy_HotelBooking/hotelbooking.html");
	}

	@Then("^Print the Hotel booking form URL and close the browser$")
	public void print_the_Hotel_booking_form_URL_and_close_the_browser() throws Throwable {
		bookingForm = new BookingForm();
		Assert.assertEquals(bookingForm.getBookingFormTitle(), "Hotel Booking");
		System.out.println("Title of the Booking form: " + bookingForm.getBookingFormTitle());
		TestBase.closeBrowser();  
	}
	
	@Given("^I am in the Booking form page$")
	public void i_am_in_the_Booking_form_page() throws Throwable {
		TestBase.initialize();
		loginPage = new LoginPage();
		bookingForm = new BookingForm();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(bookingForm.getBookingFormUrl(),
				"file:///C:/Users/Ankita%20Mukherjee/Downloads/Casestudy/HotelBooking/Casestudy_HotelBooking/hotelbooking.html");			
	}

	@Given("^Click on Confirm button without entering the First Name$")
	public void click_on_Confirm_button_without_entering_the_First_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutFirstName();
		Assert.assertEquals(alertMessage, "Please fill the First Name");
	}

	@Then("^Print the alert message displayed for the first name and close the browser$")
	public void print_the_alert_message_displayed_for_the_first_name_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for First Name: " + alertMessage);
		TestBase.closeBrowser();
	}
	@Given("^Click on Confirm button without entering the Last Name$")
	public void click_on_Confirm_button_without_entering_the_Last_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutLastName();
		Assert.assertEquals(alertMessage, "Please fill the Last Name");
	}

	@Then("^Print the alert message displayed for the Last name and close the browser$")
	public void print_the_alert_message_displayed_for_the_Last_name_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for Last Name: " + alertMessage);
		TestBase.closeBrowser();
	}

	@Given("^Click on Confirm button without entering the Email$")
	public void click_on_Confirm_button_without_entering_the_Email() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutEmail();
		Assert.assertEquals(alertMessage, "Please fill the Email");
	}

	@Given("^Click on Confirm button by entering the incorrect Email$")
	public void click_on_Confirm_button_by_entering_the_incorrect_Email() throws Throwable {
		bookingForm = new BookingForm();
		incorectAlertMessage = bookingForm.confirmWithIncorrectEmail();
		Assert.assertEquals(incorectAlertMessage, "Please enter valid Email Id.");
	}

	@Then("^Print the alert messages for Email and close the browser$")
	public void print_the_alert_messages_for_Email_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for without Email: " + alertMessage);
		System.out.println("Alert message for incorrect Email: " + incorectAlertMessage);
		TestBase.closeBrowser();
	}
	@Given("^Click on Confirm button without entering Mobile number$")
	public void click_on_Confirm_button_without_entering_Mobile_number() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutMobile();
		Assert.assertEquals(alertMessage, "Please fill the Mobile No.");
	}

	@Given("^Click on Confirm by entering incorrect Mobile number$")
	public void click_on_Confirm_by_entering_incorrect_Mobile_number() throws Throwable {
		bookingForm = new BookingForm();
		incorectAlertMessage = bookingForm.confirmWithIncorrectMobile();
		Assert.assertEquals(incorectAlertMessage, "Please enter valid Contact no.");
	}

	@Then("^Print the alert messages for Mobile number and close the browser$")
	public void print_the_alert_messages_for_Mobile_number_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for without Mobile: " + alertMessage);
		System.out.println("Alert message for incorrect Mobile: " + incorectAlertMessage);
		TestBase.closeBrowser();
	}

	@Given("^Enter address in address field$")
	public void enter_address_in_address_field() throws Throwable {
		bookingForm = new BookingForm();
		address = bookingForm.enterAddress();
		Assert.assertEquals(prop.getProperty("address"), address);
	}

	@Then("^Print the entered address details in console$")
	public void print_the_entered_address_details_in_console() throws Throwable {
		System.out.println("Address is: " + address);
		TestBase.closeBrowser();
	}

	@Given("^Click on Confirm button without selecting the City$")
	public void click_on_Confirm_button_without_selecting_the_City() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCity();
		Assert.assertEquals(alertMessage, "Please select city");
	}

	@Then("^Print the alert message for City and close the browser$")
	public void print_the_alert_message_for_City_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for City: " + alertMessage);
		TestBase.closeBrowser();
	}
	@Given("^Click on Confirm button without selecting State$")
	public void click_on_Confirm_button_without_selecting_State() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutState();
		Assert.assertEquals(alertMessage, "Please select state");
	}

	@Then("^Print the alert messages for State and close the browser$")
	public void print_the_alert_messages_for_State_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for state: " + alertMessage);
		TestBase.closeBrowser();
	}

	@Given("^Select the number of people from dropdown$")
	public void select_the_number_of_people_from_dropdown() throws Throwable {
		bookingForm = new BookingForm();
		numberOfRooms = bookingForm.selectPeople();
	}

	@Then("^Print the number of people and number of Rooms and close the browser$")
	public void print_the_number_of_people_and_number_of_Rooms_and_close_the_browser() throws Throwable {
		System.out.println("Number of Rooms: " + numberOfRooms);
		TestBase.closeBrowser();
	}

	@Given("^Click on Confirm button without entering the Card holder Name$")
	public void click_on_Confirm_button_without_entering_the_Card_holder_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCardHolderName();
		Assert.assertEquals(alertMessage, "Please fill the Card holder name");
	}

	@Then("^Print the alert message for Card holder name and close the browser$")
	public void print_the_alert_message_for_Card_holder_name_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for card holder name: " + alertMessage);
		TestBase.closeBrowser();
	}

	@Given("^Click on Confirm button without entering the Debit card number$")
	public void click_on_Confirm_button_without_entering_the_Debit_card_number() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutDebitCard();
		Assert.assertEquals(alertMessage, "Please fill the Debit card Number");
	}

	@Then("^Print the alert message for the Debit card number and close the browser$")
	public void print_the_alert_message_for_the_Debit_card_number_and_clos_the_browser() throws Throwable {
		System.out.println("Alert message for Debit card number: " + alertMessage);
		TestBase.closeBrowser();
	}

	@Given("^Click on Confirm button without entering CVV$")
	public void click_on_Confirm_button_without_entering_CVV() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCVV();
		Assert.assertEquals(alertMessage, "Please fill the CVV");
	}
	

	@Then("^Print the alert message for the CVV and close the browser$")
	public void print_the_alert_message_for_the_CVV_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for CVV: " + alertMessage);
		TestBase.closeBrowser(); 
	}

	@Given("^Click on Confirm button without entering the Expiration Month$")
	public void click_on_Confirm_button_without_entering_the_Expiration_Month() throws Throwable {
		bookingForm = new BookingForm();
		alertMessageMonth = bookingForm.confirmWithoutExpMonth();
		Assert.assertEquals(alertMessageMonth, "Please fill expiration month");
	}

	@Given("^Click on Confirm button without entering the Expiration Year$")
	public void click_on_Confirm_button_without_entering_the_Expiration_Year() throws Throwable {
		bookingForm = new BookingForm();
		alertMessageYear = bookingForm.confirmWithoutExpYear();
		Assert.assertEquals(alertMessageYear, "Please fill the expiration year");
	}

	@Then("^Print the alert messages for Expiration Month and Year and close the browser$")
	public void print_the_alert_messages_for_Expiration_Month_and_Year_and_close_the_browser() throws Throwable {
		System.out.println("Alert message for Expiration Month: " + alertMessageMonth);
		System.out.println("Alert message for Expiration Year: " + alertMessageYear);
		TestBase.closeBrowser();
	}
	
	@Given("^Click on Confirm button after entering all the details$")
	public void click_on_Confirm_button_after_entering_all_the_details() throws Throwable {
		bookingForm = new BookingForm();
		bookingForm.confirmDetails();
	}

	@Then("^User is redirected to success page$")
	public void user_is_redirected_to_success_page() throws Throwable {
		successPage = new SuccessPage();
		Assert.assertEquals(successPage.getSuccessPageUrl(),
				"file:///C:/Users/Ankita%20Mukherjee/Downloads/Casestudy/HotelBooking/Casestudy_HotelBooking/success.html");
		String pageHeading = successPage.getSuccessPageHeading();
		System.out.println("Heading of Success page: " + pageHeading);
		TestBase.closeBrowser();
	}
	
	}	
	
	
