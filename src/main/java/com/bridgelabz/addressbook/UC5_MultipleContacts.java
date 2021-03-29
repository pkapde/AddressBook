package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;

class UC5_MultipleContacts {
    private ArrayList<Contact> contactList = new ArrayList<>();

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

    private void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("contact added whose name is :  " + contact.getFirstName() + " " + contact.getLastName());

    }

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

    public static void main(String[] args) {
        System.out.println("this is address book feature to add multiple contacts");
        UC5_MultipleContacts entry = new UC5_MultipleContacts();
        System.out.println("Enter  no of contacts you wants to add");
        Scanner scn = new Scanner(System.in);
        int contactNumber = scn.nextInt();

        for (int k = 0; k < contactNumber; k++) {
            System.out.println("Enter new contact details ");
            entry.addContact(entry.getContactDetails());
        }
        System.out.println("contact book after addition");
        entry.displayContactDetails();
    }
}


