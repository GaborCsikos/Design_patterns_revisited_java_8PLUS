package week2.structural.adapter.improved;

import java.util.Date;

public class HungarianContract implements Contract {
    private String task;
    private Date dueDate;

    public HungarianContract(String task, Date dueDate) {
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