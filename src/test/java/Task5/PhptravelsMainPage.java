package Task5;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhptravelsMainPage {
    WebDriver driver;
    private long until;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void testPhptravelsHomePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement flightsButton = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/ul/li[2]/a"));
        flightsButton.click();
        WebElement oneWay = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[9]/div[1]/div/div/ins"));
        oneWay.click();

        WebElement departure = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[1]"));
        departure.click();
        WebElement enterLocation = driver.findElement(By.xpath("/html/body/div[18]/div/input"));
        enterLocation.sendKeys("waw");
        WebElement warsawAirport = driver.findElement(By.xpath("/html/body/div[18]/ul/li[1]/div"));
        warsawAirport.click();

        WebElement dateOfDeparture = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[3]/div"));
        dateOfDeparture.click();
        WebElement enterDateOfDeparture = driver.findElement(By.xpath("//*[@id=\"departure\"]"));
        enterDateOfDeparture.click();
        enterDateOfDeparture.clear();
        enterDateOfDeparture.sendKeys("2019-08-17");
        enterDateOfDeparture.click();
        WebElement destination = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[2]/div/div[2]/a"));
        destination.click();
        WebElement enterLocationDestination = driver.findElement(By.xpath("/html/body/div[19]/div/input"));
        enterLocationDestination.sendKeys("jfk");
        enterLocationDestination.click();
        WebElement newYorkAirport = driver.findElement(By.xpath("/html/body/div[19]/ul/li[1]/div"));
        newYorkAirport.click();
        WebElement cookiesPolicy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cookyGotItBtnBox\"]")));
        WebElement gotItButton = driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]"));
        gotItButton.click();
        WebElement numberOfPassengers = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[5]/div"));
        numberOfPassengers.click();
        /*początkowo myślałam, że ten krok będzie potrzebny, by wywołać okno wyboru liczby
        //WebElement passengerNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"manual_flightTravelers\"]")));
        //passengerNumber.click();*/
        //ustawiam w selectach wait, bo ciągle błąd element could not be scrolled into view
        Select numberOfPassengers1 = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("madult"))));
        numberOfPassengers1.selectByVisibleText("1");
        WebElement done = driver.findElement(By.xpath("//*[@id=\"sumManualPassenger\"]"));
        done.click();

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[6]/button"));
        searchButton.submit();
        WebElement bookingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div[3]/form/div/button")));
        bookingButton.submit();
        WebElement book = driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div[3]/form/div/button"));
        book.submit();
        WebElement guestBookingButton = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a"));
        guestBookingButton.click();

        Select title = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))));
        title.selectByValue("Ms.");
        WebElement name = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[2]/div"));
        name.click();
        WebElement passengerName = driver.findElement(By.id("name"));
        passengerName.click();
        passengerName.clear();
        passengerName.sendKeys("Yana");

        WebElement surname = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[3]/div"));
        surname.click();
        WebElement passengerSurname = driver.findElement(By.id("surname"));
        passengerSurname.click();
        passengerSurname.clear();
        passengerSurname.sendKeys("Bana");


       /* cały czas błąd, że input id =email could not be scrolled into view
       WebElement email = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[4]"));
        email.click();
        WebElement emailDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[4]/div")));
        emailDiv.click();
        WebElement passengerEmail = wait.until((By.id("email")));
        passengerEmail.click();
        passengerEmail.clear();
        passengerEmail.sendKeys("yana@bana.pl");*/

        WebElement phone = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[5]/div"));
        phone.click();
        WebElement passengerPhone = driver.findElement(By.id("phone"));
        passengerPhone.click();
        passengerPhone.click();
        passengerPhone.sendKeys("455677899");

        WebElement birthday = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[6]/div"));
        birthday.click();
        WebElement passengerBirthday = driver.findElement(By.id("birthday"));
        passengerBirthday.click();
        passengerBirthday.clear();
        passengerBirthday.sendKeys("1990-05-03");

        WebElement cardNumber = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[7]/div"));
        cardNumber.click();
        //WebElement cardSpan = driver.findElement(By.id("cookieconsent:desc"));
       // cardSpan.click();
        WebElement passengerCardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardno")));
        passengerCardNumber.click();
        passengerCardNumber.clear();
        passengerCardNumber.sendKeys("AWY345678");

        WebElement expiration = driver.findElement(By.xpath("/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[8]/div"));
        expiration.click();
        WebElement expirationDate = driver.findElement(By.id("expiration"));
        expirationDate.click();
        expirationDate.clear();
        expirationDate.sendKeys("2021-12-09");

        /* różne próby na wybranie nationality
        WebElement nationality = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.select2-choice")));
        nationality.click();
        List<WebElement> nationalitiesList = driver.findElements(By.className("select2-results-dept-0 select2-result select2-result-selectable"));
        nationalitiesList.get(1).click();
        lub

        WebElement na = driver.findElement(By.xpath("/html/body/div[11]/div"));
        na.click();
        *Select nationalityOfPassenger = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nationality"))));
        nationalityOfPassenger.selectByVisibleText("ALBANIA");
        lub
        nationalityInput.sendKeys("POLAND");
        WebElement nationalityInput = driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]"));
        nationalityInput.click();
        nationalityInput.clear();
        nationalityInput.sendKeys("Poland");
        nationalityInput.click();*/
        Select card = new Select(driver.findElement(By.id("cardtype")));
        card.selectByVisibleText("MasterCard");
        WebElement numberOfCreditCard = driver.findElement(By.id("card-number"));
        numberOfCreditCard.click();
        numberOfCreditCard.clear();
        numberOfCreditCard.sendKeys("1234567890123456");
        Select expiryMonth = new Select(driver.findElement(By.id("expiry-month")));
        expiryMonth.selectByIndex(2);
        Select expiryYear = new Select(driver.findElement(By.id("expiry-year")));
        expiryYear.selectByValue("2020");
        WebElement cvv = driver.findElement(By.id("cvv"));
        cvv.click();
        cvv.clear();
        cvv.sendKeys("123");

        WebElement confirmBookingButton = driver.findElement(By.id("confirmBooking"));
        confirmBookingButton.submit();

    }
}
