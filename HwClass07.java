package class07Hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Utlis.CommonMethods.driver;
import static Utlis.CommonMethods.openBrowserAndLaunchApplication;


public class HwClass07 {
    /* hw:
    goto syntax hrms
    login
    click on recruitment
    select a date on the calanader */
    public static void main(String[] args) {
        //  goto syntax hrms
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);
        //login
        WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement passWord=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys("Hum@nhrm123");

        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        // click on recruitment
        WebElement recruitment = driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitment.click();

        WebElement celender = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
        celender.click();

        WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        yearDropDown.click();
        Select options = new Select(yearDropDown);
        options.selectByVisibleText("2034");

        WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        monthDropDown.click();
        Select options12 = new Select(monthDropDown);
        options12.selectByVisibleText("Dec");

        List<WebElement>allDays= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement store :allDays) {
            String days = store.getText();
            if (days.equals("9")) {
                store.click();
                break;
           }
        }
    }
        }
