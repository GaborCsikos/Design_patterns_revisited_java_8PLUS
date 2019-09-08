package adapter;

import org.junit.Test;
import week2.structural.adapter.LegacySystem;
import week2.structural.adapter.PersonAdapter;
import week2.structural.adapter.improved.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class AdapterTest {

    @Test
    public void testAdapter() {
        //given
        LegacySystem legacySystem = new LegacySystem();

        PersonAdapter personAdapter = new PersonAdapter(legacySystem);

        //when
        String name = personAdapter.getPerson().getFullName();

        //then
        assertEquals("Szabina Csikos", name);
    }

    @Test
    public void testJava8Adapter() {
        HungarianContract contract = new HungarianContractImpl("simple", new Date());
        List<HungarianContract> newContracts = new ArrayList<>();
        newContracts.add(contract);
        List<Contract> contracts = newContracts.stream()
                .map(p -> Contract.newInstance(p.getTaskInHungarian(), p.getDueDateForGovermentBooking()))
                .collect(Collectors.toList());

        assertEquals("simple", contracts.get(0).getTask());


        NewNotPlannedContract notPlannedContract = new NewNotPlannedContractImpl("NOT_PLANNED", new Date());
        List<NewNotPlannedContract> newNotPlannedContracts = new ArrayList<>();
        newNotPlannedContracts.add(notPlannedContract);
        List<Contract> mappedNewContracts = newNotPlannedContracts.stream()
                .map(p -> Contract.newInstance(p.getTaskWithHighPrio(), p.getHighPrioDueDate()))
                .collect(Collectors.toList());

        assertEquals("NOT_PLANNED", mappedNewContracts.get(0).getTask());
    }

    @Test
    public void testJava8Adapter2() {
        HungarianContract contract = new HungarianContractImpl("simple", new Date());
        Contract mapped = Contract.newInstance(contract.getTaskInHungarian(), contract.getDueDateForGovermentBooking());

        assertEquals("simple", mapped.getTask());
    }
}
