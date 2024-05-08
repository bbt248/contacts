import java.util.ArrayList;

public class ShowContactsMenuAction implements MenuAction {

    private ImMemoryContacts memoryContacts;

    public ShowContactsMenuAction(ImMemoryContacts memoryContacts) {
        this.memoryContacts = memoryContacts;
    }

    @Override
    public String getName() {
        return "Показати усі контакти";
    }

    @Override
    public void execute() {
        ArrayList<Contact> contacts = memoryContacts.getAll();
        System.out.println("=================");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println(i+1 + " " + contact.getName() + " " + contact.getPhoneNumber());
        }
        System.out.println("=================");

    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}