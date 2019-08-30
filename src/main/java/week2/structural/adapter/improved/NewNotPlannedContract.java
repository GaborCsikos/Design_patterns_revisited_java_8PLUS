package week2.structural.adapter.improved;

import java.util.Date;

public interface NewNotPlannedContract {
    static NewNotPlannedContract newInstance(String task, Date dueDate) {
        return new NewNotPlannedContract() {
            @Override
            public String getTaskWithHighPrio() {
                return task;
            }

            @Override
            public Date getHighPrioDueDate() {
                return dueDate;
            }
        };
    }

    String getTaskWithHighPrio();

    Date getHighPrioDueDate();
}
