package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    // arraylist created to store contact details
    private ArrayList<Contact> contactList = new ArrayList<>();

    // method to take input of contact details n
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
    // main function
    public static void main(String[] args) {
        System.out.println("this is address book edit entry feature");
        AddressBookMain Entry = new AddressBookMain();
        Entry.addContact(Entry.getContactDetails());
        Entry.editContact();
        Entry.displayContactDetails();
    }
}