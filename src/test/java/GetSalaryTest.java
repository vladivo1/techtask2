import model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;


public class GetSalaryTest {


    @Test
    public void whenPassingTheCorrectDateShouldReturnCurrentSalary() throws IOException {
        Employee employee = new Employee(1, "John", 1500.00);
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2020, 1, 1)));

    }

    @Test
    public void whenPassingTheCorrectDateShouldReturnCurrentSalarySecond() throws IOException {
        Employee employee = new Employee(1, "John", 1600.00);
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2020, 10, 1)));

    }

    @Test
    public void whenPassingTheCorrectDateShouldReturnCurrentSalaryThird() throws IOException {
        Employee employee = new Employee(1, "John", 1700.00);
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2021, 1, 1)));

    }

    @Test
    public void onTheDayOfTheSalaryIncreaseMethodShouldReturnTheNewSalary() throws IOException {
        Employee employee = new Employee(1, "John", 1600.00);
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2020, 7, 1)));

    }
    @Test
    public void theDayBeforeTheSalaryIncreaseMethodShouldReturnOldSalary() throws IOException {
        Employee employee = new Employee(1, "John", 1500.00);
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2020, 6, 30)));

    }

    @Test
    public void whenEmployeeWasNotWorkingMethodShouldReturnNull() throws IOException {
        Employee employee = null;
        Assertions.assertEquals(employee, Salary.getSalary(1, LocalDate.of(2000, 1, 1)));

    }

    @Test
    public void whenEmployeeDoesNotExistMethodShouldReturnNull() throws IOException {
        Employee employee = null;
        Assertions.assertEquals(employee, Salary.getSalary(0, LocalDate.of(2000, 1, 1)));

    }
}
