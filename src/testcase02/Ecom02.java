package testcase02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 *
  Test Case 2 - Verify that 'Add to Wishlist' only works after login.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Move your cursor over Women's link.
3. Click on sub menu 'T-shirts'.
4. Mouse hover on the second product displayed.
5. 'Add to Wishlist' will appear on the bottom of that product, click on it.
6. Verify that error message is displayed 'You must be logged in to manage your wishlist.'


 */
public class Ecom02 {

	public static void main(String[] args) {
		
		// This is for initiating the web driver process. 
		String baseUrl = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "D:\\SUBRAT 2021\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
		
		// signing In  the site.
		driver.findElement(By.xpath("//*[@class = 'login']")).click();
		WebElement login_Email = driver.findElement(By.id("email"));
		login_Email.sendKeys("subrat.pattanaikInfy@gmail.com");
		System.out.println("LoginEmail:"+login_Email.getAttribute("value"));
		WebElement login_Password = driver.findElement(By.id("passwd"));
		login_Password.sendKeys("Subrat123");
		System.out.println("LoginPassword: "+login_Password.getAttribute("value"));
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.println("Logged in success");
		
		// visiting to women section
		WebElement navigateWomen = driver.findElement(By.linkText("Women"));
		Actions action = new Actions(driver);
		action.moveToElement(navigateWomen)
				.click().perform();
		// selecting Tshirt.	
		WebElement womenTops = driver.findElement(By.linkText("Tops"));
		womenTops.click();
		System.out.println("Women top clicked!");
				
		WebElement woemTShirt = driver.findElement(By.partialLinkText("T-shirt"));
		woemTShirt.click();
			
		// hovering over a tshirt
		WebElement tShirtImage = driver.findElement(By.xpath("//*[@title=\"Faded Short Sleeve T-shirts\"]"));
		WebElement addToWishlist = driver.findElement(By.partialLinkText("Add to Wishlist"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(tShirtImage).moveToElement(addToWishlist).click().perform();
		System.out.println("Added into the wishlist!");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String ConfirmationText=driver.findElement(By.xpath("//p[@class=\"fancybox-error\"]")).getText();
		  
		  // Verify that Product is ordered
		  if(ConfirmationText.contains("Added")) {
		   System.out.println("Order Completed: Test Case Passed");
		  }
		  else {
		   System.out.println("Order Not Successfull: Test Case Failed");
		  }
	}

}
////p[@class="fancybox-error"]