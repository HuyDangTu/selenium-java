package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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


    @Test
    void verifyMaxDuePerson() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/tables");
            //Step1: get due column
            List<Double> dueList = driver
                    .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                    .stream()
                    .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                    .toList();

            // step2: find max due
            Double maxDue = dueList.stream().max(Comparator.naturalOrder()).get();
            // step 3: find max due index
            int maxDueIndex = dueList.indexOf(maxDue);

            // tim index of max due value expected 2+1
            //step 4: get firstname lastname with maxdue index +1 ==> array index from 0, xpath index from 1
            String lastname = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", maxDueIndex + 1))).getText();// => return cell[1][1]
            String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", maxDueIndex + 1))).getText();// => return cell[1][1]

            Assert.assertEquals(String.format("%s %s", firstName, lastname), "Jason Doe");

            driver.quit();
    }
    @Test
    void minDue() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                .toList();

        // step2: find ,im due
        double min = dueList.stream().min(Comparator.naturalOrder()).get();

        List<String> names = new ArrayList();
        for (int i = 0; i < dueList.size(); i++) {
            if (dueList.get(i).equals(min)) {
                String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody//tr[%d]//td[1]", i + 1))).getText();
                String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody//tr[%d]//td[2]", i + 1))).getText();
                names.add(firstName + lastName);
            }
            //Assert.assertTrue(names, List.of("John Smith", "Tim Conway"));
            driver.quit();
        }
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
    void minDueTest() {
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
