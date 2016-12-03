package automationFramework;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG {

	public WebDriver driver;
 
	  @Test
	   public void main() {
	 
		String title = driver.getTitle();
		
		//System.out.println("Title: "+title);
		System.out.println("Title: "+title);
		
		Assert.assertTrue(title.contains("Fandor" ));
	  }
	 
	  public boolean tryElementXpath(String tag, String text, int level) {
		  if (level > 1) {
			  try {
				  driver.findElement(By.xpath("(//" + tag + "[contains(text(),'" + text + "')])[" + level + "]"));
			  } catch (NoSuchElementException e) {
					 return false;
					}
			  return true;
		  }
		  else {
				//System.out.println("ELSE ");

			  try {
				  driver.findElement(By.xpath("(//" + tag + "[contains(text(),'" + text + "')])"));
			  } catch (NoSuchElementException e) {
					//System.out.println("FALSE ");
					 return false;
					}
				//System.out.println("TRUE ");
			  return true;
		  }
	  }
	  
	  public WebElement getElementByLinkText(String text) {
		  
		  WebElement retval = null;
		  
		  try {
			  retval = driver.findElement(By.linkText(text));
		  } catch (NoSuchElementException e) {
			  e.printStackTrace();
			  Assert.assertTrue(false);
		  }
		  return retval;
	  }
	  
	  @Test
	   public void button() {
		  
		  System.out.println("Test: button");
	 
		  WebElement lButton = driver.findElement(By.xpath("//div[2]/div/button"));
		  Assert.assertTrue(lButton.getText().contains("Learn More"));
		  lButton.click();
		  
		  WebElement modalButton = null;
		  
			try {
				modalButton = driver.findElement(By.cssSelector("#learn-more-modal > a.close-reveal-modal"));
				
			} catch (NoSuchElementException e) {
				 Assert.assertTrue(false);
				e.printStackTrace();
			}
			modalButton.click();
	  }

	  @Test
	   public void newReleases() {

		  System.out.println("Test: New Releases");

		  WebElement filmsLink = null;
		  WebElement newReleases = null;
		  
		  try {
			  filmsLink = driver.findElement(By.className("films-link"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  filmsLink.click();
		  
		  try {
			  newReleases = driver.findElement(By.xpath("(//a[contains(text(),'New Releases')])[2]"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  newReleases.click();
		  
		  try {
			  driver.findElement(By.className("genre-title"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
	  }
	  
	  @Test
	  public void animatedFilm() {
		  
		  System.out.println("Test: Animated Films");
		  
		  WebElement filmsLink = null;
		  WebElement genresItem = null;
		  WebElement animatedItem = null;
		  //WebElement newPage = null;
		  
		  try {
			  filmsLink = driver.findElement(By.className("films-link"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  filmsLink.click();
		  
		  genresItem = driver.findElement(By.xpath("(//a[contains(text(),'Genres')])[2]"));
		  Assert.assertTrue(genresItem.getText().contains("Genres"));
		  
		  filmsLink.sendKeys(Keys.ESCAPE);
		  filmsLink.sendKeys(Keys.ARROW_DOWN);
		  filmsLink.sendKeys(Keys.ARROW_DOWN);
		  
		  animatedItem = driver.findElement(By.xpath("(//a[contains(text(),'Animated')])[2]"));
		  animatedItem.click();

		  boolean result = tryElementXpath("h1","Animated",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void clickLogo() {
		  
		  System.out.println("Test: Click Logo");
		  
		  WebElement nameLogo = driver.findElement(By.className("name"));
		  nameLogo.click();
		  
		  boolean result = tryElementXpath("h1","More than movies",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void loginPage() {

		  System.out.println("Test: Login");
		  
		  WebElement loginLink = driver.findElement(By.xpath("(//a[contains(text(),'Log in')])"));
		  loginLink.click();
		  
		  boolean result = tryElementXpath("h3","Log in",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void signupPage() {
		  
		  System.out.println("Test: Login");

		  WebElement trialButton = driver.findElement(By.xpath("(//a[contains(text(),'Start your free trial today')])[2]"));
		  trialButton.click();
		  
		  boolean result = tryElementXpath("p","Create your account",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void readMore() {
		  
		  System.out.println("Test: READ MORE");

		  WebElement dirMoreLink = getElementByLinkText("READ MORE");
		  dirMoreLink.click();
		  
		  WebElement dirLessLink = getElementByLinkText("READ LESS");
		  dirLessLink.click();
		  
		  dirMoreLink = getElementByLinkText("READ MORE");
		  Assert.assertTrue(dirMoreLink.isDisplayed());
	  }

	  @Test
	  public void trailerButton() {
		  
		  System.out.println("Test: Trailer Button");
		  
		  WebElement trailerButton = null;
		  WebElement xButton = null;
		  
		  try {
		  	 trailerButton = driver.findElement(By.xpath("//button[@type='button']"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  trailerButton.click();
		  
		  try {
			  xButton = driver.findElement(By.cssSelector("i.fa.fa-close"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  xButton.click();
	  }

	  @Test
	  public void playButton() {
		  
		  System.out.println("Test: Play Button");
		  
		  WebElement playButton = null;
		  WebElement xButton = null;
		  
		  try {
			  playButton = driver.findElement(By.cssSelector("i.fa.fa-play"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  playButton.click();
		  
		  try {
			  xButton = driver.findElement(By.cssSelector("i.fa.fa-close"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  xButton.click();
	  }
	  
	  @Test
	  public void castCrew() {
		  
		  System.out.println("Test: Cast & Crew");
		  
		  WebElement castLink = null;
		  
		//  try {
		//	  castLink = driver.findElement(By.linkText("Cast & Crew"));
		//  } catch (NoSuchElementException e) {
		//	  Assert.assertTrue(false);
		//	  e.printStackTrace();
		 // }
		  castLink = getElementByLinkText("Cast & Crew");
		  castLink.click();
		  
		  boolean result = tryElementXpath("h5","Starring",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void genres() {
		  
		  System.out.println("Test: Genres");

		  WebElement genresLink = null;
		  
		  try {
			  genresLink = driver.findElement(By.xpath("(//a[contains(text(),'Genres')])[5]"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  for (int x=0; x<=1; x++) { genresLink.sendKeys(Keys.ARROW_DOWN); }
		  
		  genresLink.click();
		  
		  WebElement adaptLink = getElementByLinkText("Adaptation");
		  adaptLink.click();
		  
		  boolean result = tryElementXpath("h1","Adaptation",1);
		  Assert.assertTrue(result);
	}
	  
	  @Test
	  public void genresNeg() {
		  
		  System.out.println("Test: Genres Negative");

		  WebElement genresLink = null;
		  WebElement castLink = null;
		  WebElement adaptLink = null;

		  try {
			  genresLink = driver.findElement(By.xpath("(//a[contains(text(),'Genres')])[5]"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  for (int x=0; x<=1; x++) { genresLink.sendKeys(Keys.ARROW_DOWN); }
		  
		  genresLink.click();
		  
		  adaptLink = getElementByLinkText("Adaptation");
		  
		  try {
			  castLink = driver.findElement(By.linkText("Cast & Crew"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  castLink.click();
		  
		  try {
			  adaptLink.click();
		  } catch (ElementNotVisibleException f) {
			  Assert.assertTrue(true);
			  f.printStackTrace();
		  }
	  }
	  
	  @Test
	  public void festivals() {
		  
		  System.out.println("Test: Festivals");
		  
		  WebElement festivalsLink = getElementByLinkText("Festivals & Awards");
		  festivalsLink.click();
		  
		  boolean result = tryElementXpath("h5","Festivals",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void related() {
		  
		  System.out.println("Test: Related");
		  
		  WebElement dailyLink = null;

		  WebElement relatedLink = getElementByLinkText("Related Articles");
		  for (int x=0; x<=6; x++) {
			  relatedLink.sendKeys(Keys.ARROW_DOWN);
		  }
		  relatedLink.click();
		  
		  try {
			  dailyLink = driver.findElement(By.xpath("(//a[contains(text(),'Daily | Most Anticipated Films of 2015')])"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  dailyLink.click();
		  
		  boolean result = tryElementXpath("h1","Daily | Most Anticipated Films of 2015",1);
		  Assert.assertTrue(result);
	  }
	  
	  @Test
	  public void featured() {
		  
		  System.out.println("Test: Related");
		  		  
		  String[] sel = {"Spotlights","Criterion Picks","Video Essays"};
		  String[] chk = {"Spotlight","Criterion Collection","Video Essays"};
		  
		  WebElement featuredLink = null;
		  WebElement linkHandle = null;
		  
		  for (int x=0; x<sel.length; x++){
			  
			  try {
				  featuredLink = driver.findElement(By.className("featured-link"));
			  } catch (NoSuchElementException e) {
				  Assert.assertTrue(false);
				  e.printStackTrace();
			  }
			  featuredLink.click();
			  linkHandle = driver.findElement(By.xpath("(//a[contains(text(),'" + sel[x] + "')])[2]"));
			  linkHandle.click();
			  
			  boolean result = tryElementXpath("h1",chk[x],1);
			  Assert.assertTrue(result);
			  
			  driver.navigate().back();
		  }
	  }
	  
	  @Test
	  public void joinUs() {
		  
		  System.out.println("Test: Join Us");
		  
		  WebElement linkHandle = null;
		  
		  String[] sel = {"Subscribe","Pricing Plans","Gift Subscriptions","Invite a Friend","Educators & Students"};
		  String[] chk = {"Sign up","Your subscription options","Do you love","Share movies you love","Resources and discounts"};
		  String [] hdr = {"h2","h1","h1","h1","h1"};
		  
		  for (int x=0; x<sel.length; x++) {
			  
			  linkHandle = driver.findElement(By.xpath("(//a[contains(text(),'" + sel[x] + "')])"));
			  linkHandle.click();
			  
			  try {
				  driver.findElement(By.xpath("(//" + hdr[x] + "[contains(text(),'" + chk[x] + "')])"));
			  } catch (NoSuchElementException e) {
				  Assert.assertTrue(false);
			  }
			  driver.navigate().back();
		  }
	  }
	  
	  @Test
	  public void communityItems() {
		  
		  System.out.println("Test: Community");
		  
		  WebElement communityLink = null;
		  WebElement topReviews = null;
		  
		  try {
			  communityLink = driver.findElement(By.className("community-link"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  communityLink.click();

		  try {
			  topReviews = driver.findElement(By.xpath("(//a[contains(text(),'Top Movie Reviews')])[2]"));
		  } catch (NoSuchElementException e) {
			  Assert.assertTrue(false);
			  e.printStackTrace();
		  }
		  topReviews.click();
		  
		  boolean result = tryElementXpath("h1","Reviews",1);
		  Assert.assertTrue(result);
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
 
		  // Create a new instance of the Firefox driver
		  driver = new FirefoxDriver();
 
		  // Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
		  // Launch the FANDOR Website
		  driver.get("https://www.fandor.com/films/sita_sings_the_blues#");
       
		  // Dismiss the popup thingie
		  WebElement logo = driver.findElement(By.className("name"));
		  logo.sendKeys(Keys.ESCAPE);
	  }
 
	  @AfterMethod
	  public void afterMethod() {
 
		  // Close the driver (closes browser)
		  driver.quit();
	  }
}