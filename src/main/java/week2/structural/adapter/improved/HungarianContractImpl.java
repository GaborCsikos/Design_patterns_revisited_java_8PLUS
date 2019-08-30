package week2.structural.adapter.improved;

import java.util.Date;

public class HungarianContractImpl implements HungarianContract {
    private String task;
    private Date dueDate;

    public HungarianContractImpl(String task, Date dueDate) {
        this.task = task;
        this.dueDate = dueDate;
    }


    @Override
    public String getTaskInHungarian() {
        return task;
    }

    @Override
    public Date getDueDateForGovermentBooking() {
        return dueDate;
    }
}