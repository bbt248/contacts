import java.util.ArrayList;
import java.util.Scanner;

public class RemoveContacts implements MenuAction {

    private ImMemoryContacts contactsMem;

    public RemoveContacts(ImMemoryContacts memoryContacts) {
        this.contactsMem = memoryContacts;
    }

    @Override
    public String getName() {
      return("Видалити контакт");
    }

    @Override
    public void execute() {
        ArrayList<Contact> contacts = contactsMem.getAll();
        System.out.println("=================");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println(i + 1 + " " + contact.getName() + " " + contact.getPhoneNumber());
        }
        System.out.println("=================");
        System.out.print("Введіть номер контакту для видалення: ");
        Scanner scanner = new Scanner(System.in);
        int contactNumber = scanner.nextInt();

        if (contactNumber >= 1 && contactNumber <= contacts.size()) {
            Contact removedContact = contacts.remove(contactNumber - 1);
            System.out.println("Контакт " + removedContact.getName() + " видалено.");
        } else {
            System.out.println("Помилка: такого контакта не існує");
        }
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}