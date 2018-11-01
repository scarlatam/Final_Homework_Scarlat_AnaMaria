package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class OwnerPageStepDefs {
    WebDriver webDriver;
    private WebElement owners;
    private WebElement allOwners;
    private WebElement addNewOwner;
    private WebElement telefon;
    private WebElement FirstName;
    private WebElement LastName;
    private WebElement address;
    private WebElement city;
    private WebElement addOwner;
    private WebElement checkowner;
    private WebElement editOwner;
    private WebElement updateOwner;
    private WebElement addNewPet;
    private WebElement savePet;
    private WebElement namePet;
    private WebElement petType;
    private WebElement birthDate;
    private WebElement back;


    @Given("^I am on Welcome Page$")
    public void iAmOnWelcomePage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^I click on Owners$")
    public void iClickOnOwners() {
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
    }

    @Then("^I will receive all owners$")
    public void iWillReceiveAllOwners() {
        allOwners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'All')]]"));
        allOwners.click();
    }


    @Given("^I open all owners$")
    public void iOpenAllOwners() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
        allOwners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'All')]]"));
        allOwners.click();
    }

    @When("^I click on Add New Owner$")
    public void iClickOnAddNewOwner() throws InterruptedException {
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
        addNewOwner = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'Add')]]"));
        addNewOwner.click();
        telefon = webDriver.findElement((By.id("telephone")));
        telefon.sendKeys("0726221234");
        FirstName = webDriver.findElement(By.id("firstName"));
        FirstName.sendKeys("Ana");
        LastName = webDriver.findElement(By.id("lastName"));
        LastName.sendKeys("Maria");
        address = webDriver.findElement(By.id("address"));
        address.sendKeys("Bvd. 1 Mai");
        city = webDriver.findElement(By.id("city"));
        city.sendKeys("Pitesti");
        Thread.sleep(1500);
        addOwner = webDriver.findElement(By.xpath("//button[text()[contains(.,'Add Owner')]]"));
        addOwner.click();
    }

    @And("^check if it is present$")
    public void checkIfItIsPresent() throws InterruptedException{
        checkowner = webDriver.findElement(By.xpath("//a[text()[contains(.,'Ana Maria')]]"));
        assertTrue(checkowner.getText().contains("Ana Maria"));
        checkowner.click();
        Thread.sleep(2000);
    }

    @Then("^I edit the new owner and save$")
    public void iEditTheNewOwnerAndSave() throws InterruptedException{
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
        allOwners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'All')]]"));
        allOwners.click();
        checkowner = webDriver.findElement(By.xpath("//a[text()[contains(.,'Ana Maria')]]"));
        assertTrue(checkowner.getText().contains("Ana Maria"));
        checkowner.click();
        Thread.sleep(2000);
        editOwner = webDriver.findElement(By.xpath("//button[text()[contains(.,'Edit')]]"));
        editOwner.click();
        FirstName = webDriver.findElement(By.id("firstName"));
        FirstName.clear();
        FirstName.sendKeys("Test");
        address = webDriver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("Calea Victoriei, nr.13B");
        Thread.sleep(1200);
        updateOwner = webDriver.findElement(By.xpath("//button[text()[contains(.,'Update')]]"));
        updateOwner.click();
    }

    @Given("^I open Owners$")
    public void iOpenOwners() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
        allOwners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'All')]]"));
        allOwners.click();
    }
    @When("^I add new pet to new owner$")
    public void iAddNewPetToNewOwner() throws InterruptedException{
        owners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]"));
        owners.click();
        allOwners = webDriver.findElement(By.xpath("//a[text()[contains(.,'Owners')]]//parent::li//span[text()[contains(.,'All')]]"));
        allOwners.click();
        checkowner = webDriver.findElement(By.xpath("//a[text()[contains(.,'Ana Maria')]]"));
        assertTrue(checkowner.getText().contains("Ana Maria"));
        checkowner.click();
        Thread.sleep(2000);
        addNewPet = webDriver.findElement(By.xpath("//button[text()[contains(.,'Add New Pet')]]"));
        addNewPet.click();
        namePet = webDriver.findElement(By.id("name"));
        namePet.sendKeys("Veta");
        birthDate = webDriver.findElement(By.xpath("/html/body/app-root/app-pet-add/div/div/form/div[4]/input"));
        birthDate.sendKeys("2017/12/25");
        petType = webDriver.findElement(By.xpath("//select/option[text()[contains(.,'bront')]]"));
        petType.click();
        savePet =  webDriver.findElement(By.xpath("//button[text()[contains(.,'Save Pet')]]"));
        savePet.click();
    }
    @Then("^I click on back$")
    public void iClickOnBack() {
        back = webDriver.findElement(By.xpath("//button[text()[contains(.,'Back')]]"));
        back.click();

    }
}
