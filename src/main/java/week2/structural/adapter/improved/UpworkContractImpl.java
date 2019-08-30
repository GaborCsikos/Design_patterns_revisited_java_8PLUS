package week2.structural.adapter.improved;

import java.util.Date;

public class UpworkContractImpl implements Contract {
    private String task;
    private Date dueDate;

    public UpworkContractImpl(String task, Date dueDate) {
        this.task = task;
        this.dueDate = dueDate;
    }

    @Override
    public String getTask() {
        return task;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }
}