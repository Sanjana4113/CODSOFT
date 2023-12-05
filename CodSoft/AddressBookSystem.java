import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact 
{
    String name ;
    int phoneNumber ;
    String email ;
    String city;

    Contact(String name, int phoneNumber, String email, String city) 
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city=city;
    }

    public String getName() 
    {
        return name;
    }

    public String toString() 
    {
        return name + " " + phoneNumber + " " + email + " " + city;
    }
}

class AddressBook extends Contact
{
    List<Contact> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    static String name ;
    static int phoneNumber ;
    static String email ;
    static String city;

    AddressBook() 
    {
      super(name, phoneNumber, email, city);
    }

    public void addContact(Contact contact) 
    {
      contactList.add(contact);
    }

    public void removeContact(Contact contact) 
    {
      contactList.remove(contact);
    }

    public Contact searchContact(String name) 
    {
        for(Contact contact : contactList)
        {
            if(contact.getName().equalsIgnoreCase(name))
              return contact;
        }
        return null;
    }
 
    void displayAllContacts() 
    {
        for(Contact contact : contactList)
          System.out.println(contact); 
    }

    public void addNewContact() 
    {
      System.out.print("Enter contact name: ");
      String name = sc.next();
      System.out.print("Enter phone number: ");
      int phoneNumber = sc.nextInt();
      System.out.print("Enter email address: ");
      String email = sc.next();
      System.out.print("Enter city name: ");
      String city = sc.next();

      Contact newContact = new Contact(name, phoneNumber, email, city);
      addContact(newContact);
    }

    public void removeExistingContact() 
    {
        System.out.print("Enter contact name to remove: ");
        String removeinput = sc.next();
        Contact remove = searchContact(removeinput);
        if (remove != null) 
        {
            removeContact(remove);
            System.out.println("Contact removed successfully.");
        } 
        else 
            System.out.println("Contact not found.");
    }

    public void searchExistingContact()
    {
      System.out.print("Enter contact name to search:");
      String removeinput = sc.next();
      Contact search = searchContact(removeinput);
      if(search != null)
      {
        System.out.println("Contact found");
        System.out.println(search);
      }
      else    
        System.out.println("Contact not found");
    }
}

public class AddressBookSystem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        
        while (true) 
        {
            System.out.print("1. Add a contact\n2. Remove a contact\n3. Search for a contact\n4. Display all contacts\nChoose an option: ");
            int choice=sc.nextInt();
            
            switch (choice) 
            {
                case 1: addressBook.addNewContact();
                        break;
              
                case 2: addressBook.removeExistingContact();
                        break;
              
                case 3: addressBook.searchExistingContact();
                        break;
                  
                case 4: addressBook.displayAllContacts();
                        break;

                default:  System.out.println("Invalid choice. Please try again.");
                          System.exit(0);
                          break;
            }
        }
    }
}
