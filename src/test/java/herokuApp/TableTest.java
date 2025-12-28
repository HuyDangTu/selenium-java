package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class TableTest {
    @Test
    void maxDueisJohnDoe(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        Double maxDue = 00.00;
        int indexOfPersonHavingLargestDue = 0;

        List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[4]"));
        for(WebElement e: list){
            Double Due = Double.parseDouble(e.getText().replace("$",""));
            if(Due > maxDue){
                indexOfPersonHavingLargestDue = list.indexOf(e);
                maxDue = Due;
            }
        }
        //System.out.println(indexOfPersonHavingLargestDue);
        //System.out.println(maxDue);

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody//tr[%d]//td[1]",indexOfPersonHavingLargestDue+1))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody//tr[%d]//td[2]", indexOfPersonHavingLargestDue+1))).getText();
        Assert.assertEquals(firstName+" "+lastName, "Jason Doe");
    }

    public class Person{

        String lastName;
        String firstName;
        Double due;
        String email;
        public Person(String lastName,String firstName,Double due, String email){
            this.lastName = lastName;
            this.firstName = firstName;
            this.due = due;
            this.email = email;
        };
    }

    @Test
    void minDue() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        List<Person> listPerson = list.stream().map(e -> e.getText())
                .map(e -> e.split(" "))
                .map(e -> new Person(e[0],e[1],Double.parseDouble(e[3].replace("$", "")),e[2]))
                .toList();

        Person maxDuePerson = listPerson.stream().max(Comparator.comparing(e-> e.due)).get();

        Double minDue = listPerson.stream().min(Comparator.comparing(e->e.due)).get().due;
        List<Person> minDuePeople = listPerson.stream().filter(e->e.due.equals(minDue)).filter(e-> e.firstName.equals("Tim")).toList();
        minDuePeople.forEach(e -> System.out.println(e.firstName+" "+e.lastName+" "+e.due));

        System.out.print(maxDuePerson.firstName+" "+maxDuePerson.lastName+" "+maxDuePerson.due);
    }

}
