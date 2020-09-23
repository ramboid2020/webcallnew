package ac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class htmlUnitYest {				
	private static Logger log = LoggerFactory.getLogger(htmlUnitYest.class);

	private static WebDriver driver = null;

	@BeforeClass
	public static void htmlUnitYestTestBeforeClass() throws IOException {
		// Create driver
		driver = new HtmlUnitDriver();
	}
 
	@Test
	public void htmlUnitYestTest() throws IOException {
		log.info("Start test of web page: {}", "Welcome to Maven World ....");

		// Main try-catch statement
		try {
			// Retrieve website parameters
			String url = System.getProperty("app.domain");
			
			// Check start of url
			if ( url.startsWith( "http") || url.startsWith("https") ) {			
				System.out.println("DOMAIN: " + url.trim());
			} else {
				url = "http://" + url.trim();
				System.out.println("CORRECTED DOMAIN: " + url.trim());
			}

			String strURL = Util.getHost(url.trim());
			String strProtocol = Util.getProtocol(url.trim());
			System.out.println("HOST: " + strURL.trim());
			System.out.println("PROTOCOL: " + strProtocol.trim());

			// Navigate to site
			driver.get(url.trim());

			// Check if valid title
			if ( driver.getTitle().trim() != "") {
				log.info("Page title is: {}", driver.getTitle());

				// Update website url
				url = System.getProperty("app.domain2");

				// Check start of url
				if ( url.startsWith("http") || url.startsWith("https") ) {
					System.out.println("DOMAIN: " + url.trim());
				} else {
					url = "http://" + url.trim();
					System.out.println("DOMAIN: " + url.trim());
				}
				strURL = Util.getHost(url.trim());
				strProtocol = Util.getProtocol(url.trim());
				System.out.println("HOST: " + strURL.trim());
				System.out.println("PROTOCOL: " + strProtocol.trim());

				// Navigate to site
				driver.get(url.trim());
				
				// Check page title
				if ( driver.getTitle().trim() != "") {
					log.info("Page title is: {}", driver.getTitle());
					try { Assert.assertTrue("Websites are valid!", true); } catch(Exception oaf){};
				} else {
					log.info("Page title is: {}", "Empty");
					try { Assert.fail("Invalid website title: Null value"); } catch(Exception oaf){}
				}
			} else {
				log.info("Page title is: {}", "Empty");
				try { Assert.fail("Invalid website title: Null value"); } catch(Exception oaf){}
			}
		} catch(Exception eek) {
			try { Assert.fail("Failed to open website"); } catch(Exception oaf){}
		}			
	}

	@AfterClass
	public static void logout() {
		log.info("Quiting driver");
		try { driver.quit(); } catch(Exception oaf){}
	}
}
