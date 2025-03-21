import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UserAuthenticationSteps {
    WebDriver driver;

    public UserAuthenticationSteps() {
        // Initialize the WebDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Given("the user is on the sign-up page")
    public void userOnSignUpPage() {
        try {
            driver.get("https://xaltsocnportal.web.app/signup");
        } catch (Exception e) {
            System.out.println("Error navigating to sign-up page: " + e.getMessage());
        }
    }

    @When("the user enters a valid email {string} and password {string}")
    public void userEntersValidCredentials(String email, String password) {
        try {
            WebElement emailField = driver.findElement(By.id("//*[@id="root"]/div/main/div[2]/div[1]/div/input[@id="outlined-basic"]"));
            WebElement passwordField = driver.findElement(By.id("/html/body/div/div/main/div[2]/div[2]/div/input"));
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error entering credentials: " + e.getMessage());
        }
    }

    @When("the user clicks on {string}")
    public void userClicksOn(String button) {
        try {
            WebElement signUpButton = driver.findElement(By.id(button.toLowerCase().replace(" ", "_")));
            signUpButton.click();
        } catch (Exception e) {
            System.out.println("Error clicking on button: " + e.getMessage());
        }
    }

    @Then("the user should be redirected to the dashboard")
    public void userRedirectedToDashboard() { 
        try {
            // Assertion to verify redirection
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.equals("https://xaltsocnportal.web.app/dashboard")) {
                throw new Exception("Redirection failed");
            }
        } catch (Exception e) {
            System.out.println("Error during redirection verification: " + e.getMessage());
        }
    }

    @When("the user enters an existing email {string} and password {string}")
    public void userEntersExistingEmail(String email, String password) {
        userEntersValidCredentials(email, password);
    }

    @Then("the {string} button should be disabled")
    public void buttonShouldBeDisabled(String button) {
        try {
            WebElement signUpButton = driver.findElement(By.id(button.toLowerCase().replace(" ", "_")));
            // Add assertion to check if button is disabled
            if (!signUpButton.isEnabled()) {
                System.out.println(button + " button is disabled as expected.");
            } else {
                throw new Exception(button + " button is not disabled.");
            }
        } catch (Exception e) {
            System.out.println("Error checking button state: " + e.getMessage());
        }
    }

    @Given("I am logged in")
    public void userIsLoggedIn() {
        // Code to log in the user
        userOnSignInPage();
        userEntersValidCredentials("AutoTesing@gmail.com", "Password123");
        userClicksOn("Sign In");
    }

    @When("I click on {string}")
    public void iClickOn(String button) {
        userClicksOn(button);
    }

    @Given("I am on the sign-in page")
    public void userOnSignInPage() {
        try {
            driver.get("https://xaltsocnportal.web.app/signin");
        } catch (Exception e) {
            System.out.println("Error navigating to sign-in page: " + e.getMessage());
        }
    }

    @When("I do not enter any email {string} and password {string}")
    public void userDoesNotEnterCredentials(String email, String password) {
        signIn(email,password);
		buttonShouldBeDisabled(button)
		
    }
	
	   public void signUp(String email, String password) {
        try {
            driver.get("https://xaltsocnportal.web.app/signup");
            WebElement emailField = driver.findElement(By.id("//*[@id="root"]/div/main/div[2]/div[1]/div/input[@id="outlined-basic"]"));
            WebElement passwordField = driver.findElement(By.id("/html/body/div/div/main/div[2]/div[2]/div/input"));
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            WebElement signUpButton = driver.findElement(By.id("sign_up"));
            signUpButton.click();
        } catch (Exception e) {
            System.out.println("Error during sign-up: " + e.getMessage());
        }
    }

    public void signIn(String email, String password) {
        try {
            driver.get("https://xaltsocnportal.web.app/signin");
            WebElement emailField = driver.findElement(By.id("//*[@id="root"]/div/main/div[2]/div[1]/div/input[@id="outlined-basic"]"));
            WebElement passwordField = driver.findElement(By.id("/html/body/div/div/main/div[2]/div[2]/div/input"));
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            WebElement signInButton = driver.findElement(By.id("sign_in"));
            signInButton.click();
        } catch (Exception e) {
            System.out.println("Error during sign-in: " + e.getMessage());
        }
    }

    public void signOut() {
        try {
            WebElement signOutButton = driver.findElement(By.id("sign_out"));
            signOutButton.click();
        } catch (Exception e) {
            System.out.println("Error during sign-out: " + e.getMessage());
        }
    }
	
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}