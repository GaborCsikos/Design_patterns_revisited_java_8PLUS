package week2.structural.adapter.improved;

import java.util.Date;

public class NewNotPlannedContractImpl implements NewNotPlannedContract {
    private String notPlannedWork;
    private Date dueDate;

    public NewNotPlannedContractImpl(String notPlannedWork, Date dueDate) {
        this.notPlannedWork = notPlannedWork;
        this.dueDate = dueDate;
    }

    @Override
    public String getTaskWithHighPrio() {
        return notPlannedWork;
    }

    @Override
    public Date getHighPrioDueDate() {
        return dueDate;
    }
}