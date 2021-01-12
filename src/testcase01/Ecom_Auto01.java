/*
Test Case 1 - Automate End to End Buy Order functionality.

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.

 */

package testcase01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Ecom_Auto01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// This is for initiating the web driver process. 
		String baseUrl = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "D:\\SUBRAT 2021\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
	
	// signing In  the site.
		
		driver.findElement(By.xpath("//*[@class = 'login']")).click();
	/*	
		driver.findElement(By.xpath("//input[@name = 'email_create']")).sendKeys("subrat.pattanaikInfy@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//form submission.
		
		WebElement title_Mr = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")); // for male
//		WebElement title_Mrs = driver.findElement(By.id("id_gender2")); // for female
		WebElement firstName = driver.findElement(By.name("customer_firstname"));
		WebElement lastName = driver.findElement(By.name("customer_lastname"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement passsword = driver.findElement(By.name("passwd"));
		WebElement dayOfbirth = driver.findElement(By.xpath("//select[@id=\"days\"]/option[16]"));
		WebElement monthOfBirth = driver.findElement(By.xpath("//*[@id=\"months\"]/option[9]"));
		WebElement yearOfBirth = driver.findElement(By.xpath("//*[@id=\"years\"]/option[24]"));
		
		WebElement AddressFirstName = driver.findElement(By.id("firstname"));
		WebElement AddressLastName = driver.findElement(By.id("lastname"));
		WebElement AddressCompany = driver.findElement(By.id("company"));
		WebElement AddressLine1 = driver.findElement(By.id("address1"));
		WebElement city = driver.findElement(By.id("city"));
		WebElement state = driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
		WebElement postalCode = driver.findElement(By.id("postcode"));
		
		WebElement phone = driver.findElement(By.id("phone_mobile"));
		WebElement submitBtn = driver.findElement(By.id("submitAccount"));
		
		title_Mr.click();
		firstName.sendKeys("Subrat");
		lastName.sendKeys("Pattanaik");
		passsword.sendKeys("Subrat123");
		AddressFirstName.sendKeys("Subrat");
		AddressLastName.sendKeys("Pattanaik");
		AddressCompany.sendKeys("Infy");
		dayOfbirth.click();
		monthOfBirth.click();
		yearOfBirth.click();
		AddressLine1.sendKeys("256-Street NYK");
		city.sendKeys("NYK");
		state.click();
		postalCode.sendKeys("52668");
		phone.sendKeys("1234567890");
		submitBtn.click();
		
	*/	
		/*
		 * System.out.println("Details that we capture.");
		 * //System.out.println("title "+title_Mr.getText());
		 * System.out.println("Name: "+firstName.getText());
		 * System.out.println("Company "+AddressCompany.getText());
		 * 
		 */		
		
	// login actions
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
		WebElement moreBtn = driver.findElement(By.xpath("//*[@title='View']/span"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(tShirtImage).moveToElement(moreBtn).click().perform();
		System.out.println("More btn clicked!");
		
	// increase the quantity to 2
		WebElement quantity = driver.findElement(By.name("qty"));
		WebElement plusIcon = driver.findElement(By.xpath("//i[@class='icon-plus']"));
		plusIcon.click();
		System.out.println("The quantity now is "+quantity.getAttribute("value"));
	//select the size L
		WebElement size = driver.findElement(By.xpath("//option[@title=\"L\"]"));
		size.click();
		System.out.println("Size L is clicked!");
	//select the color
		WebElement color = driver.findElement(By.xpath("//a[@title=\"Orange\"]"));
		color.click();
		System.out.println("color<orange> is clicked!");
	//Click the add to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement addToCartBtn = driver.findElement(By.name("Submit"));
		addToCartBtn.click();
		System.out.println("Add to card clicked!");
	//Proceed to checkOut
		WebElement checkOut = driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]"));
		checkOut.click();
		System.out.println("Proceed To checkOut clicked!");
		
		System.out.println("Procced to direct checkout!");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
	
		driver.findElement(By.partialLinkText("Pay by check")).click();
		
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		System.out.println("Checkout complete by placing the order!");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
		  
		  // Verify that Product is ordered
		  if(ConfirmationText.contains("complete")) {
		   System.out.println("Order Completed: Test Case Passed");
		  }
		  else {
		   System.out.println("Order Not Successfull: Test Case Failed");
		  }
       
		
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.close();
	}

}
