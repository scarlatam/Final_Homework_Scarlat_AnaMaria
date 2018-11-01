package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class VeterinariansPageStepDefs {

    WebDriver webDriver;

    private WebElement title;
    private WebElement allveterinarians;
    private WebElement addveterinarians;
    private WebElement addNewVet;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement type;
    private WebElement saveVet;
    private WebElement checkvet;
    private WebElement veterinarians;
    private WebElement editVet;
    private WebElement home;
    private WebElement specialties;
    private WebElement clickout;
    private WebElement deletevet;



    @Given("^I open Welcome Page$")
    public void iOpenWelcomePage(){
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("^Click on all veterinarians$")
    public void clickOnAllVeterinarians() {
        title = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]"));
        title.click();
        allveterinarians = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]//parent::li//span[text()[contains(.,'All')]]"));
        allveterinarians.click();
    }

    @Then("^I press the button Home$")
    public void iPressTheButtonHome()  throws InterruptedException{
        Thread.sleep(1600);
        home = webDriver.findElement(By.xpath("//button[text()[contains(.,'Home')]]"));
        home.click();
    }
    @Given("^I open New veterinarians Page$")
    public void iOpenNewVeterinariansPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        title = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]"));
        title.click();
        addveterinarians = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]//parent::li//span[text()[contains(.,'Add')]]"));
        addveterinarians.click();
    }

    @When("^I add a new veterinarians$")
    public void iAddANewVeterinarians() {
        allveterinarians = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]"));
        allveterinarians.click();
        addNewVet = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]//parent::li//span[text()[contains(.,'Add')]]"));
        addNewVet.click();
        firstName = webDriver.findElement(By.id("firstName"));
        firstName.sendKeys("Ana");
        lastName = webDriver.findElement(By.id("lastName"));
        lastName.sendKeys("SCA");
        type = webDriver.findElement(By.xpath("//div/select/option[1]"));
        type.click();
        saveVet = webDriver.findElement(By.xpath("//button[text()[contains(.,'Save')]]"));
        saveVet.click();
    }

    @Then("^I assert if the new veterinarians is present$")
    public void iAssertIfTheNewVeterinariansIsPresent() {
        veterinarians = webDriver.findElement(By.xpath("//td[text()[contains(.,'SCA')]]"));
        assertTrue(veterinarians.getText().contains("SCA"));
    }
    @Given("^I open Veterinarians Page$")
    public void iOpenVeterinariansPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        title = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]"));
        title.click();
        allveterinarians = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]//parent::li//span[text()[contains(.,'All')]]"));
        allveterinarians.click();
    }
    @When("^I check if the veterinarians is present$")
    public void iCheckIfTheVeterinariansIsPresent() {
        checkvet = webDriver.findElement(By.xpath("//td[text()[contains(.,'Ana')]]"));
        assertTrue(checkvet.getText().contains("Ana"));
        checkvet.click();
    }
    @Then("^I edit the new veterinarians$")
    public void iEditTheNewVeterinarians() {
        editVet = webDriver.findElement(By.xpath("//td[text()[contains(.,'Ana')]]/parent::tr/td/button[text()[contains(.,'Edit')]]"));
        editVet.click();
        firstName = webDriver.findElement(By.id("firstName"));
        firstName.click();
        webDriver.findElement(By.id("firstName")).clear();
        webDriver.findElement(By.id("firstName")).sendKeys("Noua Ana");
        specialties = webDriver.findElement(By.id("spec"));
        specialties.click();
        webDriver.findElement(By.xpath("//*[@id='mat-option-4']/mat-pseudo-checkbox")).click();
        specialties.submit();
        clickout = webDriver.findElement(By.xpath("//body"));
        clickout.click();
    }
    @Given("^I open Veterinarians Page to delete request$")
    public void iOpenVeterinariansPageToDeleteRequest(){
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        title = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]"));
        title.click();
        allveterinarians = webDriver.findElement(By.xpath("//a[text()[contains(.,'Veterinarians')]]//parent::li//span[text()[contains(.,'All')]]"));
        allveterinarians.click();
    }

    @When("^I find the new veterinarians$")
    public void iFindTheNewVeterinarians() {
        checkvet = webDriver.findElement(By.xpath("//td[text()[contains(.,'Noua')]]"));
        assertTrue(checkvet.getText().contains("Noua"));
        checkvet.click();
    }

    @Then("^I delete the new veterinarians$")
    public void iDeleteTheNewVeterinarians() {
        deletevet = webDriver.findElement(By.xpath("//td[text()[contains(.,'Noua')]]/parent::tr/td/button[text()[contains(.,'Delete')]]"));
        deletevet.click();
    }


}
