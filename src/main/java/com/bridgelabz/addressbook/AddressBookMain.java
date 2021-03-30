package com.bridgelabz.addressbook;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private static Map<String, ArrayList<Contact>> bookList = new HashMap<String, ArrayList<Contact>>();
    private static Map<String, ArrayList<Contact>> bookListSorted = new HashMap<String, ArrayList<Contact>>();
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

        System.out.println("enter zip code of address -- interger type");
        int zipCode = scan.nextInt();

        Contact entry = new Contact(firstName, lastName, address, cityName, stateName, zipCode,
                phoneNumber, emailAddress);
        return entry;
    }
    public static void display(Contact member) {
        System.out.println("first name is :" + member.getFirstName());
        System.out.println(" last name is :" + member.getLastName());

        System.out.println(" address is :" + member.getAddress());

        System.out.println(" city name is :" + member.getCity());

        System.out.println(" state name is :" + member.getState());

        System.out.println(" zip code is  :" + member.getZip());

        System.out.println(" phone number is :" + member.getPhone());

        System.out.println(" email address is :" + member.getEmail());
    }
    private static void getAddressBook() {
        ArrayList<Contact> contactDetails = new ArrayList<Contact>();
        Map<String, ArrayList<Contact>> bookListLocal = new HashMap<String, ArrayList<Contact>>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter address book name");
        String bookname = scan.nextLine();
        while (true) {
            System.out.println("enter 1 to add more contact");
            System.out.println("enter 2 to exit ");
            int option = scan.nextInt();
            if (option == 1) {
                Contact contactEntry = getContactDetails();
                contactDetails.add(contactEntry);
            } else {
                break;
            }
        }
        bookList.put(bookname, contactDetails);
    }
    private static void sortByCity() {
        for (String i : bookList.keySet()) {
            System.out.println("Book name is : " + i);
            ArrayList<Contact> contactDetails = bookList.get(i);
            ArrayList<Contact> contacts = new ArrayList<>();
            System.out.println("Sorting people by City : ");
            for (int j = 0; j < contactDetails.size(); j++) {
                contacts.add(contactDetails.get(j));
            }
            List<Contact> sortedcontacts = contacts.stream()
                    .sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());

            for (Contact contact : sortedcontacts) {
                display(contact);
            }
        }
    }
    private static void sortByState() {
        for (String i : bookList.keySet()) {
            System.out.println("Book name is : " + i);
            ArrayList<Contact> contactDetails = bookList.get(i);
            ArrayList<Contact> contacts = new ArrayList<>();
            System.out.println("Sorting people by State : ");
            for (int j = 0; j < contactDetails.size(); j++) {
                contacts.add(contactDetails.get(j));
            }
            List<Contact> sortedcontacts = contacts.stream()
                    .sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
            for (Contact contact : sortedcontacts) {
                display(contact);
            }
        }
    }
    private static void sortByZip() {
        for (String i : bookList.keySet()) {
            System.out.println("Book name is : " + i);
            ArrayList<Contact> contactDetails = bookList.get(i);
            ArrayList<Contact> contacts = new ArrayList<>();
            System.out.println("Sorting people by Zip : ");
            for (int j = 0; j < contactDetails.size(); j++) {
                contacts.add(contactDetails.get(j));
            }
            List<Contact> sortedcontacts = contacts.stream().sorted(Comparator.comparingInt(Contact::getZip))
                    .collect(Collectors.toList());
            for (Contact contact : sortedcontacts) {
                display(contact);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("this is address book program for sort names");
        while (true) {
            System.out.println("enter 1 to add more address books");
            System.out.println("enter 2 to exit from address book program");
            int option = scn.nextInt();
            if (option == 1) {
                getAddressBook();
            } else {
                break;
            }
        }
        System.out.println("address books and contact details added successfully ");
        System.out.println("Select" + "\n1.  to sort by state" + "\n2. to sort by city" + "\n3. to sort by  pin");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                sortByState();
                break;

            case 2:
                sortByCity();
                break;

            case 3:
                sortByZip();
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
