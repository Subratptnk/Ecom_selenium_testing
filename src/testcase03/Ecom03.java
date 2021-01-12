package testcase03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


/*

 Test Case 3 - Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Make sure quantity is set to 1.
8. Select size 'M'
9. Select color of your choice.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Change the quantity to 2.
13. Verify that Total price is changing and reflecting correct price

 */
public class Ecom03 {

	public static void main(String[] args) {
		// This is for initiating the web driver process. 
		String baseUrl = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "D:\\SUBRAT 2021\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
	
	// signing In  the site.
		
		driver.findElement(By.xpath("//*[@class = 'login']")).click();
		
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
				
			//select the size L
				WebElement size = driver.findElement(By.xpath("//option[@title=\"M\"]"));
				size.click();
				System.out.println("Size M is clicked!");
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
				
				System.out.println("Procced to summary page!");
			// change in quantity
				WebElement presentQuantity = driver.findElement(By.xpath("//*[@name=\"quantity_1_3_0_431182\"]"));
				String presentQuant = presentQuantity.getAttribute("value");
				int presentQ = Integer.parseInt(presentQuant);
				System.out.println(presentQuant);	
				WebElement plusIcon = driver.findElement(By.xpath("//i[@class='icon-plus']"));
				plusIcon.click();
				System.out.println("The quantity now is "+presentQuantity.getAttribute("value"));
				System.out.println(presentQ);	
				
				
			// checking the price increments
				String unitPrice = driver.findElement(By.xpath("//span[@class=\"price\"]/span")).getText();
				System.out.println(unitPrice);
				String unitPrice1 = unitPrice.substring(1);
				System.out.println(unitPrice1);
				double unitP = Double.parseDouble(unitPrice1);
				
				String totalPrice = driver.findElement(By.xpath("//*[@id=\"total_product_price_1_3_431182\"]")).getText();
				System.out.println("Total price is "+totalPrice);
				String totalPrice1 = totalPrice.substring(1);
				double totalP = Double.parseDouble(totalPrice1);
				
				double checkPrice = unitP * presentQ;
				System.out.println("Checked Price: "+checkPrice);
				System.out.println("unit Price: "+unitP);
				System.out.println("Total Price: "+totalP);
				if(checkPrice == totalP) {
					System.out.println("Test case: Passed");
				}
				else {
					System.out.println("Test case : Failed");
				}
				
				
				
				
				
				

	}

}
