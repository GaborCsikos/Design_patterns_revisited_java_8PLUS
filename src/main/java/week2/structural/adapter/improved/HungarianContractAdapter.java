package week2.structural.adapter.improved;

import java.util.Date;

public class HungarianContractAdapter implements HungarianContract {
    private Contract upworkContract;

    public HungarianContractAdapter(Contract upworkContract) {
        this.upworkContract = upworkContract;
    }

    @Override
    public String getTaskInHungarian() {
        return upworkContract.getTask() + " in Hungarian";
    }

    @Override
    public Date getDueDateForGovermentBooking() {
        return upworkContract.getDueDate();
    }
    //

}
