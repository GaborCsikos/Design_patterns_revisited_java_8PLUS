package mvc;

import org.junit.Test;
import week4.behavioral.mvc.Student;
import week4.behavioral.mvc.StudentController;
import week4.behavioral.mvc.StudentView;

public class MVCTest {

    @Test
    public void testMVC() {
        Student model = new Student();
        model.setName("Szabina Csikos");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Aizhan Csikos");

        controller.updateView();
    }
}
