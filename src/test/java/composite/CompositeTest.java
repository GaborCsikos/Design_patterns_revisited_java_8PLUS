package composite;

import org.junit.Test;
import week2.structural.composite.DepartmentComposite;
import week2.structural.composite.Developer;
import week2.structural.composite.Employee;
import week2.structural.composite.Engineer;

import static org.junit.Assert.assertEquals;

public class CompositeTest {

    @Test
    public void testComposite() {
        Employee engineer = new Engineer();
        Employee developer = new Developer();
        DepartmentComposite departmentComposite = new DepartmentComposite();
        assertEquals(0, departmentComposite.salaryInGoldenCoins());

        //hire more people
        departmentComposite.addEmployee(engineer);
        departmentComposite.addEmployee(developer);
        assertEquals(30, departmentComposite.salaryInGoldenCoins());

    }
}
