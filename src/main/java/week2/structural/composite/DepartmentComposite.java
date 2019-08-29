package week2.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class DepartmentComposite implements Employee {

    private List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public long salaryInGoldenCoins() {
        long salary = 0;
        for (Employee emp : employeeList) {
            salary += emp.salaryInGoldenCoins();
        }
        return salary;
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

}
