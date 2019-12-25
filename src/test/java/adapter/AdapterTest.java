package adapter;

import org.junit.Test;
import week2.structural.adapter.LegacyPerson;
import week2.structural.adapter.Person;
import week2.structural.adapter.improved.ImprovedPerson;
import week2.structural.adapter.improved.NewRewritePerson;
import week2.structural.adapter.improved.StillALegacyPerson;
import week2.structural.adapter.PersonAdapterClass;
import week2.structural.adapter.PersonAdapterObject;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class AdapterTest {

    @Test
    public void adapterTestClass(){
        LegacyPerson legacyPerson = new LegacyPerson("Szabina", "Csikos");
        PersonAdapterClass adapter = new PersonAdapterClass(legacyPerson);
        assertEquals("Szabina Csikos", adapter.getName());
    }

    @Test
    public void adapterTestObject(){
        LegacyPerson legacyPerson = new LegacyPerson("Szabina", "Csikos");
        PersonAdapterObject adapter = new PersonAdapterObject(legacyPerson);
        assertEquals("Szabina Csikos", adapter.getName());
    }

    @Test
    public void adaptWithoutObjectCreation(){
        StillALegacyPerson legacyPerson = new StillALegacyPerson("Szabina", "Csikos");
        assertEquals("Szabina Csikos", ImprovedPerson.adapt(legacyPerson).getName());
    }

    @Test
    public void testAsAList(){
       List<StillALegacyPerson> legacyPersonList = List.of(new StillALegacyPerson("Gabor", "Csikos"), new StillALegacyPerson("Aizhan", "Csikos"));
        List<ImprovedPerson> improved = legacyPersonList.stream().map(p-> ImprovedPerson.adapt(p))
                .collect(Collectors.toList());
        assertEquals("Gabor Csikos", improved.get(0).getName());
        assertEquals("Aizhan Csikos", improved.get(1).getName());

    }
}
