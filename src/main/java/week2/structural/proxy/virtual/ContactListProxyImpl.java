package week2.structural.proxy.virtual;

import java.util.List;

public class ContactListProxyImpl implements ContactList {

    private boolean forTest = false;
    private ContactList contactList;

    @Override
    public List<Employee> getEmployeeList() {
        if (contactList == null) {
            forTest = true;
            contactList = new ContactListImpl();
        }
        return contactList.getEmployeeList();
    }

    public boolean isForTest() {
        return forTest;
    }

}
