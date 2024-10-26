package horoscopeSite;

import java.time.Duration;
import java.util.ArrayList;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Individual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String deatilsPerson = "//*[@id='hororeport']/child::p//*[@id='hororeport']/child::p";
		
		//
		
			String date = "29";
			String month = "8";
			String year = "1994";
			String hour = "8";
			String minute = "45";
			String time = "AM";
			
					
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			ChromeDriver driver = new ChromeDriver(options);
		//	driver = webdriver.Chrome(service=service, options=brave_options)
		
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			driver.get("https://horoscope.hosuronline.com/horoscope.php");
			
			driver.findElement(By.id("name")).sendKeys("Sweety");
			
			WebElement dateofBirth = driver.findElement(By.id("day"));
					
			Select optionDate= new Select(dateofBirth);
			optionDate.selectByValue(date);
			
			
			WebElement dateofMonth = driver.findElement(By.id("month"));
					
			Select optionMonth= new Select(dateofMonth);
			optionMonth.selectByValue(month);
			
			WebElement dateofYear = driver.findElement(By.id("year"));
			
			Select optionYear= new Select(dateofYear);
			optionYear.selectByValue(year);	
			
			WebElement birthHour = driver.findElement(By.id("hour"));
			
			Select optionBirthHour= new Select(birthHour);
			optionBirthHour.selectByValue(hour);
			
			WebElement birthMinute = driver.findElement(By.id("minute"));
			
			Select optionBirthMinute= new Select(birthMinute);
			optionBirthMinute.selectByValue(minute);
			
			WebElement timeDuration = driver.findElement(By.id("AMPM"));
			
			Select optionTimeDuration= new Select(timeDuration);
			if (time=="AM")
				optionTimeDuration.selectByValue("0");
			else
				optionTimeDuration.selectByValue("1");
			
			
			
			driver.findElement(By.name("birthcity")).sendKeys("Chennai");
			
			driver.findElement(By.id("search")).click();
			
			
			
			WebElement submitbutton = driver.findElement(By.name("submit"));
			submitbutton.sendKeys(Keys.PAGE_DOWN);
			wait.until(ExpectedConditions.elementToBeClickable(submitbutton));
			submitbutton.click();
			System.out.println(driver.getTitle());
			
			ArrayList<WebElement> detailsofPerson = (ArrayList<WebElement>) driver.findElements(By.xpath(deatilsPerson));
			
			for( WebElement e:detailsofPerson)
			{
				System.out.println(e.getText());
			}
			
			driver.close();
			
			
			
		
	}

}
