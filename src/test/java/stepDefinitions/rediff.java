package stepDefinitions;

import Pages.HomePage;
import Pages.SigninPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class rediff {

    public WebDriver driver;
    HomePage homePage;
    SigninPage SigninPage;
    @Given("User launches the application")
    public void user_launches_the_application() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote -allow-origins=x");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://books.rediff.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage =new HomePage(driver);
        SigninPage  = new SigninPage(driver);
    }
    @Given("user clicks on Sign In Link")
    public void user_clicks_on_sign_in_link() {
        // Write code here that turns the phrase above into concrete actions
            homePage.click_signIN();
    }
    @Then("the user enters username as {string} and password as {string}")
    public void the_user_enters_username_as_and_password_as(String username, String passwords) {
        // Write code here that turns the phrase above into concrete actions
            SigninPage.txt_Username.sendKeys(username);
            SigninPage.txt_pswd.sendKeys(passwords);
    }

    @Then("user clicks on Login Button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        SigninPage.btn_login.click();
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.isSuccesfullDisplayed(),"The user has successfully login");
    }
    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(SigninPage.isErrorMessageDisplayed(),"The user has not login ");
    }
    @And("user closes the application")
    public void user_closes_the_application(){
        driver.close();
    }

}
