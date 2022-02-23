package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeData {


    private int id;
    private String name;

    private List<SalaryChange> salaryHistory = new ArrayList<>();


}


