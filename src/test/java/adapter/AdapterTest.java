package adapter;

import org.junit.Test;
import week2.structural.adapter.LegacySystem;
import week2.structural.adapter.PersonAdapter;
import week2.structural.adapter.improved.Contract;
import week2.structural.adapter.improved.HungarianContract;

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
        Contract contract = new HungarianContract("Hungarian conctract", new Date());
        List<Contract> newContracts = new ArrayList<>();
        newContracts.add(contract);
        List<Contract> contracts = newContracts.stream()
                .map(p -> Contract.adapterToUpworkContract(p.getTask(), p.getDueDate()))
                .collect(Collectors.toList());

        assertEquals("Hungarian conctract in Upwork", contracts.get(0).getTask());

    }

    @Test
    public void testJava8Adapter2() {
        HungarianContract contract = new HungarianContract("Hungarian conctract", new Date());
        Contract mapped = Contract.adapterToUpworkContract(contract.getTask(), contract.getDueDate());

        assertEquals("Hungarian conctract in Upwork", mapped.getTask());
    }
}
