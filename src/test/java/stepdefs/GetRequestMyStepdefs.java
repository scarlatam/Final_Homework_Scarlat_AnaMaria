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
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class GetRequestMyStepdefs {
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
    private WebElement specialties;
    private WebElement clickout;
    private WebElement deletevet;
    private WebElement petType;
    private WebElement addPet;
    private WebElement namePet;
    private WebElement savePet;
    private WebElement home;
    private WebElement updatePet;
    private WebElement addSpec;
    private WebElement editspec;
    private WebElement namespec;
    private WebElement savespec;
    private WebElement editname;
    private WebElement updatespec;
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

    @Given("^I open Pet Types page$")
    public void iOpenPetTypesPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        petType = webDriver.findElement(By.xpath("//a[span][contains(.,'Pet Types')]"));
        petType.click();
    }
    @When("^I perform POST request to pettypes$")
    public void iPerformPOSTRequestToPettypes() {
        petType = webDriver.findElement(By.xpath("//a[span][contains(.,'Pet Types')]"));
        petType.click();
        addPet = webDriver.findElement(By.xpath("//button[text()[contains(.,'Add')]]"));
        addPet.click();
        namePet = webDriver.findElement(By.id("name"));
        namePet.sendKeys("Pet 3");
        savePet = webDriver.findElement(By.xpath("//button[text()[contains(.,'Save')]]"));
        savePet.click();
    }
    @Then("^I click on Home$")
    public void iClickOnHome() throws InterruptedException{
        Thread.sleep(1500);
        home = webDriver.findElement(By.xpath("//button[text()[contains(.,'Home')]]"));
        home.click();
    }


    @Given("^I am on Pet Type page$")
    public void iAmOnPetTypePage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        petType = webDriver.findElement(By.xpath("//a[span][contains(.,'Pet Types')]"));
        petType.click();
    }

    @When("^I edit the new pet type$")
    public void iEditTheNewPetType() {
        title = webDriver.findElement(By.xpath("//a[contains(.,'Pet Types')]"));
        title.click();
        webDriver.get("http://bhdtest.endava.com/petclinic/pettypes/4/edit");
        webDriver.findElement(By.id("name")).clear();
        webDriver.findElement(By.id("name")).sendKeys("Porumbita");
        updatePet = webDriver.findElement(By.xpath("//button[text()[contains(.,'Update')]]"));
        updatePet.click();
    }

    @Then("^I go on Home Page$")
    public void iGoOnHomePage() throws InterruptedException{
        title = webDriver.findElement(By.xpath("//a[span] [contains(.,'Pet Types')]"));
        title.click();
        Thread.sleep(1500);
        home = webDriver.findElement(By.xpath("//button[text()[contains(.,'Home')]]"));
        home.click();
    }

    @Given("^I open Speciality page$")
    public void iOpenSpecialityPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        title = webDriver.findElement(xpath("//a[span] [contains(.,'Specialties')]"));
        title.click();
    }
    @When("^I add a new spectialty$")
    public void iAddANewSpectialty() {
        addSpec =webDriver.findElement(xpath("//button[text()[contains(.,'Add')]]"));
        addSpec.click();
        namespec = webDriver.findElement(id("name"));
        namespec.sendKeys("ortoped");
        savespec = webDriver.findElement(xpath("//button[text()[contains(.,'Save')]]"));
        savespec.click();
    }

    @Then("^I back at Home$")
    public void iBackAtHome() throws InterruptedException{
        Thread.sleep(1500);
        home = webDriver.findElement(By.xpath("//button[text()[contains(.,'Home')]]"));
        home.click();
    }

    @Given("^Open the Specialty page$")
    public void openTheSpecialtyPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        title = webDriver.findElement(xpath("//a[span] [contains(.,'Specialties')]"));
        title.click();
    }

    @When("^I edit a specialty$")
    public void iEditASpecialty() {
        editspec = webDriver.findElement(xpath("//input[@id='0']/parent::td//parent::tr//button[text()[contains(.,'Edit')]]"));
        editspec.click();
        editname = webDriver.findElement(By.xpath("//*[@id=\"name\"]"));
        editname.click();
        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("ortodont Ana");
        updatespec = webDriver.findElement(By.xpath("//button[text()[contains(.,'Update')]]"));
        updatespec.click();
    }

    @Then("^I click on Home Page$")
    public void iClickOnHomePage() {
        title = webDriver.findElement(By.xpath("//a/span[text()[contains(.,'Home')]]"));
        title.click();
    }
}
