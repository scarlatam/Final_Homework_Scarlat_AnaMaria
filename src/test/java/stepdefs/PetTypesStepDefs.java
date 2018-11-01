package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PetTypesStepDefs {
    WebDriver webDriver;
    private WebElement title;
    private WebElement petType;
    private WebElement addPet;
    private WebElement namePet;
    private WebElement savePet;
    private WebElement home;
    private WebElement updatePet;



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

}
