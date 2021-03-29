package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;

public class UC3_EditEntry {
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
    private void editContact() {
        int match = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first name of person whose contact details you wants to edit");
        String name = sc.nextLine();
        Contact contactToBeEdited = contactList.get(0);
        System.out.println(contactList.get(0));

        for (int j = 0; j < contactList.size(); j++) {
            Contact conMatch = contactList.get(j);
            System.out.println(conMatch.getFirstName());
            if (name.equals(conMatch.getFirstName())) {
                match = j;
                contactToBeEdited = contactList.get(match);

            } else {
                System.out.println("no contact with this first name ");
            }

        }

        if (match != -1) {

            System.out.print(" what you want to edit : "
                    + "\n1. Zip Code" + "\n2. First Name" + "\n3  Last Name" + "\n4. Address"+ "\n5. City" + "\n6. State"

                    + "\n7. Phone Number" + "\n8. Email");

            int option = sc.nextInt();
            sc.nextLine(); // catches the new line character

            switch (option) {
                case 1:
                    System.out.println("enter  new zip code");
                    String newZipCode = sc.nextLine();
                    contactToBeEdited.setZip(newZipCode);
                    break;

                case 2:
                    System.out.println("enter  new first name");
                    String newFirstName = sc.nextLine();
                    contactToBeEdited.setFirstName(newFirstName);
                    break;

                case 3:
                    System.out.println("enter  new last name");
                    String newLastName = sc.nextLine();
                    contactToBeEdited.setFirstName(newLastName);
                    break;

                case 4 :
                    System.out.println("enter  new street address");
                    String address = sc.nextLine();
                    contactToBeEdited.setAddress(address);
                    break;



                case 5:
                    System.out.println("enter  new city name");
                    String newcityName = sc.nextLine();
                    contactToBeEdited.setCity(newcityName);
                    break;

                case 6:
                    System.out.println("enter  new state name");
                    String newStateName = sc.nextLine();
                    contactToBeEdited.setState(newStateName);
                    break;


                case 7:
                    System.out.println("enter  new phone number");
                    String newPhoneNumber = sc.nextLine();
                    contactToBeEdited.setPhone(newPhoneNumber);
                    break;

                case 8:
                    System.out.println("enter  new email address");
                    String newEmailAddress = sc.nextLine();
                    contactToBeEdited.setEmail(newEmailAddress);
                    break;

                default:
                    System.out.println("choice does not exist");

            }

        }

    }


    // main function
    public static void main(String[] args) {

        System.out.println("this is address book edit entry feature");

        UC3_EditEntry editEntry = new UC3_EditEntry();
        editEntry.addContact(editEntry.getContactDetails());
        editEntry.editContact();
        editEntry.displayContactDetails();
    }

}