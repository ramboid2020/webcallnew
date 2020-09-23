package ac;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.junit.Test;
import org.junit.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import java.io.*;
import java.util.*;
		
public class htmlUnitYest {				
	// Reference to file anme with urls and ports
	//private static String configFile = "src/test/resources/urls/config.txt";

	Logger log = LoggerFactory.getLogger(htmlUnitYest.class);
 
	@Test
	public void htmlUnitYestTest() throws IOException {
		log.info("Start test of web page: {}", "Welcome to Maven World ....");

		// Class references
		WebDriver driver = null;

		// Main try-catch statement
		try {
			// Create driver instance
                	driver = new HtmlUnitDriver();
                    

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
		} finally {
			// Close file reader
			//try { reader.close(); } catch(Exception oaf) {}

			log.info("Quitting driver");
			try { driver.quit(); } catch(Exception oaf){}
		}			
	}		
}
