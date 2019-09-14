package proxy;

import org.junit.Test;
import week2.structural.proxy.dynamic.DynamicInvocationHandler;
import week2.structural.proxy.protection.CarProxy;
import week2.structural.proxy.protection.Driver;
import week2.structural.proxy.virtual.Company;
import week2.structural.proxy.virtual.ContactList;
import week2.structural.proxy.virtual.ContactListProxyImpl;
import week2.structural.proxy.virtual.Employee;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProxyTest {

    @Test
    public void virtualProxy() {
        ContactList contactList = new ContactListProxyImpl();
        Company company = new Company("ABC Company", "India", "+36306222231", contactList);

        assertEquals("ABC Company", company.getCompanyName());
        assertEquals("India", company.getCompanyAddress());
        assertEquals("+36306222231", company.getCompanyContactNo());

        //This Ugly casting is done only to test how proxy works
        assertFalse(((ContactListProxyImpl) contactList).isForTest());
        contactList = company.getContactList();

        List<Employee> empList = contactList.getEmployeeList();
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        //This Ugly casting is done only to test how proxy works
        assertTrue(((ContactListProxyImpl) contactList).isForTest());
    }

    @Test
    public void testProtectionProxy() {
        Driver szabina = new Driver("Szabina", 5);
        CarProxy car = new CarProxy(szabina);
        assertEquals("Too young to drive", car.drive());


        Driver aizhan = new Driver("Aizhan", 39);
        CarProxy secondCar = new CarProxy(aizhan);
        assertEquals("Aizhan is driving", secondCar.drive());

    }

    @Test
    public void dynamic() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler());

        String message = (String) proxyInstance.put("test", "case");
        assertEquals("Success", message);
    }

    @Test
    public void dynamicWithLambda() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{Map.class},
                (proxy, method, methodArgs) -> "Success 2");

        String message = (String) proxyInstance.put("test", "case");
        assertEquals("Success 2", message);
    }
}
