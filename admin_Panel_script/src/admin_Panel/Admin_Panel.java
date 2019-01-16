package admin_Panel;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admin_Panel {

	public static void main(String[] args)throws InterruptedException
	{
		
		//firefoxsxdd
		 //System.setProperty("webdriver.gecko.driver", "D:\\seleniumJar\\geckodriver.exe");
         //WebDriver driver = new FirefoxDriver();
		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         
		 //Launch the Online Store Website
		 driver.get("https://dev.grab.in/");
		 
		 //Maximize window
		 driver.manage().window().maximize();
		// Enter UserName
		 driver.findElement(By.name("username")).sendKeys("suniltest");
		 // Enter Password
		 driver.findElement(By.name("password")).sendKeys("Grab@7777");  //Grab@7869
		// Wait For Page To Load
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath(".//*[@id='m_login_signin_submit']")).click();
		 Thread.sleep(1000);
		 
		 
		//expand add order button
		//driver.findElement(By.xpath(".//*[@id='page_data']/div[2]/div/div/div[3]/div/div[1]/h4/a/span")).click();
         
		// Order Placing 
 		for(int i=1;i<=1;i++)
 		{
 		   driver.findElement(By.id("areaId")).sendKeys("Andheri West");
 		   
 		   //driver.findElement(By.id("areaId")).sendKeys("Ghansoli");

 		
 		   Select dropnew=new Select(driver.findElement(By.id("restaurantId")));
 		
 		   dropnew.selectByVisibleText("Suniltest");
 		   //dropnew.selectByVisibleText("Jio Ghansoli");

 		//dropnew.selectByIndex(1);
 	  //dropnew.selectByValue("7620");

 		
 		   Random rand = new Random();
 	       int num = rand.nextInt(9000000) + 1000000;
 		
 		   //String uuid = UUID.randomUUID().toString();
 	
		    driver.findElement(By.id("billNo")).sendKeys(""+num);
		    driver.findElement(By.id("orderAmount")).sendKeys("55");
		    driver.findElement(By.id("customerPhone")).sendKeys("8286682623");
		    
		    Thread.sleep(1000);

		     //delivery years
	 		
	       Select dropndelivery=new Select(driver.findElement(By.id("deliveryArea")));
	 		
	        dropndelivery.selectByVisibleText("4 Bunglows");
	 	    //dropndelivery.selectByIndex(2);
		 
		    driver.findElement(By.id("customerName")).sendKeys("Sunil Yadav");
		    driver.findElement(By.id("customerAddress")).sendKeys("Laxmi Plaza new link road goregaon west");
		 
	 	    driver.findElement(By.xpath("//*[@id=\"placeordrBtn\"]")).click();
	 	   Thread.sleep(10000);
 		}
	       // All menu execution start here
		    List<WebElement> adminlst=driver.findElements(By.xpath(".//*[@id='m_ver_menu']/ul/li"));

		      for(int i=2;i<=adminlst.size();i++)
		      {  
		    	      
					 driver.findElement(By.xpath(".//*[@id='btn-nav-sidebar-minified' or @id='m_aside_left_minimize_toggle']")).click();
					 Thread.sleep(5000);
					 
					 driver.findElement(By.xpath((".//*[@id='main-nav' or @id='m_ver_menu']/ul/li["+i+"]/a"))).click(); 
					 Thread.sleep(5000);
					 
		    	      WebElement texth = driver.findElement(By.xpath(".//*[@id='page_data']/div[1]/div/div/ul/li[5]/a"));
		    	      String value=texth.getText();
		    	      System.out.println("Page Open Successful " +value);
		    	      
			
		      }
		      driver.close();

	}

}
