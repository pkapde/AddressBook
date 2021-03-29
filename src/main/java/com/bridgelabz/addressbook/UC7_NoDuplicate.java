package com.bridgelabz.addressbook;
import java.util.*;
import java.util.stream.Collectors;

public class UC7_NoDuplicate {
    private static Map<String, ArrayList<Contact>> bookList = new HashMap<String, ArrayList<Contact>>();
    private static List<String> duplicateCheck;
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
    private static void getAddressBook() {
        // TODO Auto-generated method stub
        ArrayList<Contact> contactDetails = new ArrayList<Contact>();
        Map<String, ArrayList<Contact>> bookListLocal = new HashMap<String, ArrayList<Contact>>();
        ArrayList<String> names = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter address book name");
        String bookname = scan.nextLine();
        while (true) {
            System.out.println("enter 1 to add more contact");
            System.out.println("enter 2 to exit ");
            int option = scan.nextInt();
            if (option == 1) {
                Contact contactEntry = getContactDetails();
                String fullName = contactEntry.getFirstName() + " " + contactEntry.getLastName();
                // using stream to check duplicates
                duplicateCheck = names.stream().filter(n -> n.equals(fullName)).collect(Collectors.toList());

                if (duplicateCheck.size() == 0) {
                    contactDetails.add(contactEntry);
                    names.add(contactEntry.getFirstName() + " " + contactEntry.getLastName());
                } else {
                    System.out.println("this name already exists , not added to book");
                }
            } else {
                break;
            }

        }
        bookList.put(bookname, contactDetails);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("this is address book program for no duplicate entry");

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

        for (String i : bookList.keySet()) {
            System.out.println("book name is " + i);
            System.out.println("contact names are ");

            ArrayList<Contact> persons = bookList.get(i);
            for (int y = 0; y < persons.size(); y++) {
                System.out.println(persons.get(y).getFirstName() + " " + persons.get(y).getLastName());
            }
        }

    }
}
