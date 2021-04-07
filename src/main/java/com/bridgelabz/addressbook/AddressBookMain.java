package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private ArrayList<Contact> contactList = new ArrayList<>();
    Contact contact;
    private String FirstName;
    private String LastName;

    private static Contact getContactDetails() {
        System.out.println("enter contact details ----");
        Scanner scan = new Scanner(System.in);
        System.out.println("enter first name");
        String firstName = scan.nextLine();

        System.out.println("enter last name");
        String lastName = scan.nextLine();

        System.out.println("enter street address");
        String address = scan.nextLine();

        System.out.println("enter city name");
        String cityName = scan.nextLine();

        System.out.println("enter state name");
        String stateName = scan.nextLine();

        System.out.println("enter phone number");
        String phoneNumber = scan.nextLine();

        System.out.println("enter email Address");
        String emailAddress = scan.nextLine();

        System.out.println("enter zip code ");
        String zipCode = scan.nextLine();

        Contact entry = new Contact(firstName, lastName,address, cityName, stateName, zipCode, phoneNumber,
                emailAddress);
        return entry;

    }
    // method to add details of contact in arraylist
    private void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("contact added whose name is :  " + contact.getFirstName() + " " + contact.getLastName());

    }
    // method to display all entries of arraylist
    private void displayContactDetails() {
        System.out.println("displaying contact details :");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("contact no" + (i + 1));
            Contact con = contactList.get(i);
            System.out.println("first name is :" + con.getFirstName());

            System.out.println(" last name is :" + con.getLastName());

            System.out.println(" address is :" + con.getAddress());

            System.out.println(" city name is :" + con.getCity());

            System.out.println(" state name is :" + con.getState());

            System.out.println(" zip code is  :" + con.getZip());

            System.out.println(" phone number is :" + con.getPhone());

            System.out.println(" email address is :" + con.getEmail());
        }
    }

    // method to edit contact details
    public void editContact() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of a person to edit contact details");
        System.out.println("First Name : ");
        String FirstName;
        FirstName = sc.nextLine();
        System.out.println("Last Name : ");
        String LastName;
        LastName = sc.nextLine();

        for (int i = 0; i < contactList.size(); i++) {
            if (FirstName.equalsIgnoreCase(contactList.get(i).getFirstName()) && LastName.equalsIgnoreCase(contactList.get(i).getLastName())) {
                System.out.println("Address : ");
                String address = sc.nextLine();
                System.out.println("City : ");
                String city = sc.nextLine();
                System.out.println("State : ");
                String state = sc.nextLine();
                System.out.println("ZIP : ");
                String zip = sc.nextLine();
                System.out.println("Phone number : ");
                String phone = sc.nextLine();
                sc.nextLine();
                System.out.println("Email ID : ");
                String email = sc.nextLine();

                Contact entry = new Contact(FirstName, LastName, address, city, state, zip, phone,
                        email);
                contactList.set(i, entry);
            }
        }
    }
    public void deleteEntry (){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of a person to DELETE contact details");
        System.out.println("First Name : ");
        FirstName = sc.nextLine();
        System.out.println("Last Name : ");
        LastName = sc.nextLine();

        for (int i = 0; i < contactList.size(); i++) {
            if (FirstName.equalsIgnoreCase(contactList.get(i).getFirstName()) && LastName.equalsIgnoreCase(contactList.get(i).getLastName())) {
                contactList.remove(contactList.get(i));
            }
        }
    }
    public void searchPersonByCity(String name, String city) {
        List<Contact> list = new ArrayList<Contact>();
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();

        for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            list = entry.getValue().contactList().stream()
                    .filter(c -> ((c.getCity()).equals(city)))
                    .filter(c -> ((c.getFirstName()).equals(name))).collect(Collectors.toList());
        }
        if(list.isEmpty()) {
            System.out.println("Person not found");
        }
        else {
            System.out.println("FOUND");
            for(Contact c : list) {
                System.out.println(c);
            }
        }
    }

    public void searchPersonByState(String name, String state) {
        List<Contact> list = new ArrayList<Contact>();
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();
        for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            list = entry.getValue().contactList().stream()
                    .filter(c -> c.getState().equals(state))
                    .filter(c -> c.getFirstName().equals(name) ).collect(Collectors.toList());
        }
        if(list.isEmpty()) {
            System.out.println("Person not found");
        }
        else {
            System.out.println("FOUND");
            for(Contact c : list) {
                System.out.println(c);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");

        Scanner scanner = new Scanner(System.in);
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();

        System.out.println("Enter first Address Book name : ");
        String addressBookName = scanner.nextLine();
        AddressBook NewAddressBook = new AddressBook(addressBookName);
        addressBookMap.put(addressBookName, NewAddressBook);
        AddressBookMain addBookMain = new AddressBookMain();
        addBookMain.getContactDetails();
        int choice;

        do {
            //AddressBookMain addBookMain2 = new AddressBookMain();

            System.out.println("1.to add contact to book");
            System.out.println("2.to edit contact");
            System.out.println("3.to delete contact");
            System.out.println("4. Add new Address Book");
            System.out.println("5. Display Address Book details");
            System.out.println("6. Search person in city");
            System.out.println("7. Search person in state");
            System.out.println("Enter any other interger to exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBookMain.getContactDetails();
                    break;
                case 2:
                    addBookMain.editContact();
                    break;
                case 3:
                    addBookMain.deleteEntry();
                    break;
                case 4:
                    System.out.println("Enter Address Book name : ");
                    addressBookName = scanner.nextLine();
                    NewAddressBook = new AddressBook(addressBookName);
                    addressBookMap.put(addressBookName, NewAddressBook);
                    break;

                case 5:
                    addBookMain.displayContactDetails();
                    break;

                case 6:
                    System.out.println("Enter the name to search : ");
                    String person = scanner.nextLine();
                    System.out.println("Enter the city : ");
                    String city = scanner.nextLine();
                    addBookMain.searchPersonByCity(person, city);
                    break;
                case 7:
                    System.out.println("Enter the name to search : ");
                    person = scanner.nextLine();
                    System.out.println("Enter the state : ");
                    String state = scanner.nextLine();
                    addBookMain.searchPersonByState(person, state);
                    break;
            }
        }
        while (choice > 0 && choice < 8);
    }
}
