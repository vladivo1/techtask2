import model.EmployeeData;
import model.SalaryChange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

       public static List<EmployeeData> employeeList = new ArrayList<>();

    public static void readAndSave() throws IOException {

        Pattern id = Pattern.compile("\\d+");
        Pattern name = Pattern.compile("\\w+");
        Pattern localDate = Pattern.compile("\\d+/\\d+/\\d+");
        Pattern salary = Pattern.compile("\\d+\\.+\\d+");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String line;
        BufferedReader br = new BufferedReader(new FileReader("src/main/employee.txt"));

        while ((line = br.readLine()) != null) {
            EmployeeData employeeData = new EmployeeData();
            Matcher matcher = id.matcher(line);
            Matcher matcher1 = name.matcher(line);
            while (matcher.find())
                employeeData.setId(Integer.parseInt(matcher.group()));
            while (matcher1.find())
                employeeData.setName(matcher1.group());

            employeeList.add(employeeData);

            BufferedReader br2 = new BufferedReader(new FileReader("src/main/salary.txt"));

            while ((line = br2.readLine()) != null) {
                String[] arrLine = line.split("\\|");
                for (String s : arrLine) {
                    if (employeeData.getId() == Integer.parseInt(arrLine[0])) {
                        Matcher matcher2 = localDate.matcher(s);
                        Matcher matcher3 = salary.matcher(s);
                        while (matcher2.find() && matcher3.find()) {
                            var date = LocalDate.from(formatter.parse(matcher2.group()));
                            var sal = Double.parseDouble(matcher3.group());
                            SalaryChange salaryChange = new SalaryChange(date, sal);
                            employeeData.getSalaryHistory().add(salaryChange);
                        }
                    }
                }
            }

            employeeData.getSalaryHistory().sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        }
    }
}
