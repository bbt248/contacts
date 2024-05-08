import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    private ImMemoryContacts contacts;
    private Scanner scanner;

    public AddContactMenuAction(ImMemoryContacts contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "Додати контакт";
    }

    @Override
    public void execute() {
        System.out.println("Введіть ім'я контакту");
        String name = scanner.nextLine();
        System.out.println("Введіть номер телефону");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name,phoneNumber);
        contacts.add(contact);
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}