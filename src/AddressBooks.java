import java.util.ArrayList;
import java.util.Scanner;

public class AddressBooks {
    private ArrayList<Contact> contacts;

    public AddressBooks() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        AddressBooks addressBooks = new AddressBooks();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter company: ");
                    String company = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, company, email, phone);
                    addressBooks.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter name to find: ");
                    String nameToFind = scanner.nextLine();
                    Contact foundContact = addressBooks.findContactByName(nameToFind);
                    if (foundContact != null) {
                        System.out.println("Found contact: " + foundContact.getPhone());
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 3:
                    addressBooks.displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
