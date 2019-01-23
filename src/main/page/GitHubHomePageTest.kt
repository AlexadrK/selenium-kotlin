package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class GitHubHomePageTest {
    private lateinit var driver: WebDriver
    private lateinit var gitHubSearchPage: GitHubSearchPage
   // private lateinit var gitHubHomePage: GitHubHomePage


    @BeforeMethod
    fun setUp() {
        driver = ChromeDriver()
        //gitHubHomePage = GitHubHomePage(driver)
        gitHubSearchPage = GitHubSearchPage(driver)
        //gitHubHomePage.open()
        gitHubSearchPage.open()

    }

/*    @Test
    fun emptyTest(){
    }*/

    @Test
    fun searchForUsername() {
        gitHubSearchPage = GitHubSearchPage(driver)
        gitHubSearchPage.searchFor("chrisvasqm")
        gitHubSearchPage.filterByUsers()
        gitHubSearchPage.enterUserProfile()
        assertTrue(driver.currentUrl == "https://github.com/chrisvasqm")
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}

   /* @org.testng.annotations.BeforeMethod
    fun setUp() {
    }

    @org.testng.annotations.AfterMethod
    fun tearDown() {
    }
*/