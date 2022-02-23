import java.io.*;
import java.time.LocalDate;

public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println(Salary.getSalary(1,LocalDate.of(2020,1,1)));
        System.out.println(Salary.getSalary(1,LocalDate.of(2020,10,1)));
        System.out.println(Salary.getSalary(1,LocalDate.of(2021,1,1)));
        System.out.println(Salary.getSalary(1,LocalDate.of(2000,1,1)));
        System.out.println(Salary.getSalary(0,LocalDate.of(2020,1,1)));

    }

}


