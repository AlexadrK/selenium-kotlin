package page

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory


/*class GitHubSearchPage(private val driver: WebDriver) {
    fun open() {
        driver.get("https://github.com/search?")
    }

    fun filterByUsers() {
        val usersFilter = driver.findElement(By.xpath("//a[text() = 'Users']"))
        usersFilter.click()
    }

    fun enterUserProfile() {
        val userProfileLink = driver.findElement(By.xpath("//span[text() = 'Christian Vasquez']/../a/em"))
        userProfileLink.click()
    }

}*/

class GitHubSearchPage(private val driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/nav[1]/a[8]") //"\"//a[text() = 'Users']\""
    private lateinit var usersFilter: WebElement

    @FindBy(xpath = "//*[@id=\"user_search_results\"]/div/div/div[1]/div/a/em") // "//span[text() = 'Christian Vasquez']/../a/em" // //*[text() = 'Christian Vasquez'] // //*[text() = 'Christian Vasquez']
    private lateinit var userProfileLink: WebElement



    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 15), this)
    }

    fun searchFor(query: String) {
        val searchBox = driver.findElement(By.xpath("//*[@id=\"search_form\"]/div/div/input[1]")) ////input[@placeholder='Search GitHub']
        searchBox.sendKeys(query, Keys.ENTER)
    }

    fun open() {
        driver.get("https://github.com/search?") //driver.get("https://github.com/search?")
    }

    fun filterByUsers() {
        usersFilter.click()
    }

    fun enterUserProfile() {
        userProfileLink.click()
    }

}