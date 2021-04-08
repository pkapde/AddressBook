package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain extends AddressBook{
    private ArrayList<Contact> contactList = new ArrayList<>();
    public static HashMap<String, AddressBook> StateAddressBookMap = new HashMap<>();
    public static HashMap<Object, Object> CityaddressBookMap = new HashMap<>();
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
    public void viewPersonsByCity(String city) {
        List<Contact> list = new ArrayList<Contact>();
        for(Map.Entry<String, AddressBook> entry : StateAddressBookMap.entrySet()) {
            list = entry.getValue().contactList().stream().filter(c -> c.getState().equals(city))
                    .collect(Collectors.toList());
        }
        for(Contact c : list) {
            System.out.println(c);
        }
    }

    public void viewPersonsByState(String state) {
        List<Contact> list = new ArrayList<Contact>();

        for(Map.Entry<String, AddressBook> entry : StateAddressBookMap.entrySet()) {
            list = entry.getValue().contactList().stream().filter(s -> s.getState().equals(state))
                    .collect(Collectors.toList());
        }
        for(Contact c : list) {
            System.out.println(c);
        }
    }


    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Address Book name : ");
        String addressBookName = scanner.nextLine();
        AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook NewAddressBook = new AddressBook(addressBookName);
        StateAddressBookMap.put(addressBookName, NewAddressBook);
        addressBookMain.getContactDetails();

        String yes = "y";
        do {
            //AddressBookMain addBookMain2 = new AddressBookMain();

            System.out.println("1.to add contact to book");
            System.out.println("2. Search person in city");
            System.out.println("3. Search person in state");
            System.out.println("4. View person in city");
            System.out.println("5. View person in state");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addressBookMain.getContactDetails();
                    addressBookMain.displayContactDetails();
                    break;
                case 2:
                    System.out.println("Enter the name to search : ");
                    String person = scanner.nextLine();
                    System.out.println("Enter the city : ");
                    String city = scanner.nextLine();
                    addressBookMain.searchPersonByCity(person, city);
                    break;
                case 3:
                    System.out.println("Enter the name to search : ");
                    person = scanner.nextLine();
                    System.out.println("Enter the state : ");
                    String state = scanner.nextLine();
                    addressBookMain.searchPersonByState(person, state);
                    break;
                case 4:
                    System.out.println("Enter the city : ");
                    city = scanner.nextLine();
                    addressBookMain.viewPersonsByCity(city);
                    break;
                case 5:
                    System.out.println("Enter the state : ");
                    state = scanner.nextLine();
                    addressBookMain.viewPersonsByState(state);
                    break;
                default:
                    System.out.println("Select correct choice");
                    break;

            }
            System.out.println("Enter 'y' if you want to PERFORM NEW ACTION \nEnter any other key to EXIT");
            yes = scanner.nextLine();
        }while(yes.equalsIgnoreCase("y"));
    }
}
