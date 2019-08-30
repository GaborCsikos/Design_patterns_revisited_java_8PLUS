package week2.structural.adapter.improved;

import java.util.Date;

public interface Contract {
    static Contract newInstance(String task, Date dueDate) {
        return new Contract() {
            @Override
            public String getTask() {
                return task;
            }

            @Override
            public Date getDueDate() {
                return dueDate;
            }
        };
    }

    String getTask();

    Date getDueDate();
}
