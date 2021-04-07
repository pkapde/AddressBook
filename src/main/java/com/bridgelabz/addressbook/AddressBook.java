package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
        private String AddressBookName;
        public List <Contact> contactList;

        public List<Contact> contactList(){
            return contactList;
        }

        public AddressBook(String AddressBookName) {
            contactList = new ArrayList<Contact>();
            this.AddressBookName = AddressBookName;
        }

        public AddressBook() {
            contactList = new ArrayList<Contact>();
        }

        public String getName() {
            return AddressBookName;
        }

        public void displayAllContacts() {
            System.out.println("CONTACT DETAILS FROM ADDRESS BOOK");
            for(int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i));
            }
        }
}
