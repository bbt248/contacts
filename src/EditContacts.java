import java.util.ArrayList;
import java.util.Scanner;

public class EditContacts implements MenuAction {

    private ImMemoryContacts contactsMem;

    public EditContacts(ImMemoryContacts memoryContacts) {
        this.contactsMem = memoryContacts;
    }

    @Override
    public String getName() {
        return("Редагувати контакт");
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
        System.out.print("Вкажіть номер контакта для редагування: ");
        Scanner scanner = new Scanner(System.in);
        int contactNumber = scanner.nextInt();

        if (contactNumber >= 1 && contactNumber <= contacts.size()) {
            Contact contact = contacts.get(contactNumber - 1);
            System.out.println("Ви вибрали контакт: " + contact.getName() + " " + contact.getPhoneNumber());
            System.out.print("Введіть нове ім'я: ");
            scanner.nextLine(); // Очистка буфера после nextInt()
            String newName = scanner.nextLine();
            System.out.print("Введіть новий номер телефону: ");
            String newPhoneNumber = scanner.nextLine();

            contact.setName(newName);
            contact.setPhoneNumber(newPhoneNumber);
            System.out.println("Контакт успішно відредаговано");
        } else {
            System.out.println("Помилка: такого контакту не існує");
        }
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}