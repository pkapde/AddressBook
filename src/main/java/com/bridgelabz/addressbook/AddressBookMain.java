package com.bridgelabz.addressbook;
import java.util.*;

public class AddressBookMain {
    Contact contact;
    //Map.Entry[] contents;
    //private static List<Contact> Contact = new ArrayList<Contact>();
    public static void main(String[] args) {
        System.out.println("Welcome to address book");

        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.contact = addressBookMain.getUserInput();
        //UC3_EditEntry entry3 = new UC3_EditEntry();
        //addressBookMain.contact = addressBookMain.editEntry();
        //addressBookMain.contact = addressBookMain.deleteByFirstName();
        System.out.println("new Contact---->" + addressBookMain.contact);

    }



    private Contact getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fist name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter city:");
        String city = scanner.nextLine();
        System.out.println("Enter state:");
        String state = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter zip:");
        String zip = scanner.nextLine();
        //return contact;
        return new Contact(firstName, lastName, phoneNumber,city,state,email,address,zip);
    }
    public boolean createContact(Contact contact) {
        this.contact = contact;
        if(this.contact == null){
            return false;
        }
        return true;
    }

}