package week2.structural.adapter.improved;

import java.util.Date;

public interface Contract {

    //Adapter
    static Contract adapterToUpworkContract(String task, Date dueDate) {
        return new Contract() {
            @Override
            public String getTask() {
                return task + " in Upwork";
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
