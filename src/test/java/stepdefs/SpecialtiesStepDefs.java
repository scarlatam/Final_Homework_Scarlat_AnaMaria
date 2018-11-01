package stepdefs;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SpecialtiesStepDefs {
    WebDriver webDriver;

    private WebElement home;
    private WebElement title;
    private WebElement addSpec;
    private WebElement editspec;
    private WebElement namespec;
    private WebElement savespec;
    private WebElement editname;
    private WebElement updatespec;




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
