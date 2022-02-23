import model.Employee;
import model.EmployeeData;
import model.SalaryChange;

import java.io.IOException;
import java.time.LocalDate;

public class Salary {

    public static Employee getSalary(int id, LocalDate date) throws IOException {
        Reader.readAndSave();
        for (EmployeeData data : Reader.employeeList) {
            if (data.getId() == id) {
                var salaryHistory = data.getSalaryHistory();
                SalaryChange salaryChange = null;
                for (SalaryChange change : salaryHistory) {
                    if (date.compareTo(change.getDate()) >= 0) {
                        salaryChange = change;

                    } else break;
                }
                if (salaryChange == null)
                    return null;
                return new Employee(data.getId(), data.getName(), salaryChange.getSalary());

            }

        }
        return null;
    }
}
