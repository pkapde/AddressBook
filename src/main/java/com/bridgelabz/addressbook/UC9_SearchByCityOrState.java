package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class UC9_SearchByCityOrState {
    private static Map<String, ArrayList<Contact>> bookList = new HashMap<String, ArrayList<Contact>>();
    private static Map<String, ArrayList<String>> cityList = new HashMap<String, ArrayList<String>>();

    private static Map<String, ArrayList<String>> stateList = new HashMap<String, ArrayList<String>>();
    static ArrayList<Contact> contactDetails = new ArrayList<Contact>();

    private static void addingBooksAndContacts() {
        System.out.println("total books are 3");
        String bookname1 = "test1";
        String bookname2 = "test2";
        String bookname3 = "test3";
        ArrayList<Contact> list1 = new ArrayList<>();
        ArrayList<Contact> list2 = new ArrayList<>();
        ArrayList<Contact> list3 = new ArrayList<>();

        Contact intial1 = new Contact("shubham", "singh", "H.NO. 26", "bhiwani", "haryana", "124367",
                "9087654590", "shubham@abc");
        Contact intial2 = new Contact("amit", "patil", "H.NO. 26", "jalandhar", "punjab", "124367",
                "9087654590", "sumit@abc");
        Contact intial3 = new Contact("vaibhav", "patil", "H.NO. 26", "bhiwani", "haryana", "124367",
                "9087654590", "sumit@abc");
        Contact intial4 = new Contact("dipak", "singh", "H.NO. 26", "jalandhar", "punjab", "124367",
                "9087654590", "sumit@abc");
        Contact intial5 = new Contact("akshay", "mahajan", "H.NO. 26", "bhiwani", "haryana", "124367",
                "9087654590", "sumit@abc");

        Contact intial6 = new Contact("mehul", "yadav", "H.NO. 26", "bhiwani", "haryana", "aaaa",
                "9087654590", "sumit@abc");
        Contact intial7 = new Contact("neeta ", "karwal", "H.NO. 26", "jalandhar", "punjab", "aaaa",
                "9087654590", "sumit@abc");
        Contact intial8 = new Contact("saurabh", "das", "H.NO. 26", "gurgaon", "haryana", "aaaa",
                "9087654590", "sumit@abc");
        Contact intial9 = new Contact("santy", "jhutta", "H.NO. 26", "jaipur", "rajasthan", "aaaa",
                "9087654590", "sumit@abc");
        Contact intial10 = new Contact("yogesh ", "shinde", "H.NO. 26", "mathura", "uttar pradesh", "aaaa",
                "9087654590", "sumit@abc");

        list1.add(intial1);
        list1.add(intial3);
        list1.add(intial5);
        list1.add(intial10);

        list2.add(intial2);
        list2.add(intial8);
        list2.add(intial7);

        list3.add(intial4);
        list3.add(intial6);
        list3.add(intial9);

        bookList.put(bookname1, list1);
        bookList.put(bookname2, list2);
        bookList.put(bookname3, list3);

    }
    private static Map<String, ArrayList<String>> getPersonsCityWise() {
        List<String> cityNames = new ArrayList<String>();
        List<Contact> contacts = new ArrayList<Contact>();
        // ArrayList<Contact> personsInCity = new ArrayList<Contact>();
        for (String i : bookList.keySet()) {
            contactDetails = bookList.get(i);
            for (int j = 0; j < contactDetails.size(); j++) {
                contacts.add(contactDetails.get(j));
                cityNames.add(contactDetails.get(j).getCity());
            }
        }
        List<String> cityNamesDistinct = cityNames.stream().distinct().collect(Collectors.toList());
        for (int y = 0; y < cityNamesDistinct.size(); y++) {
            ArrayList<String> names = new ArrayList<>();
            // using java streams to get personsdetails(object) as per their city
            String cityName = cityNamesDistinct.get(y);
            List<Contact> personsInCity = contacts.stream().filter(per -> per.getCity().equals(cityName))
                    .collect(Collectors.toList());
            for (int z = 0; z < personsInCity.size(); z++) {
                names.add(personsInCity.get(z).getFirstName() + " " + personsInCity.get(z).getLastName());
            }
            cityList.put(cityName, names);
            personsInCity.clear();
        }
        return cityList;
    }
    private static Map<String, ArrayList<String>> getPersonsStateWise() {
        List<String> stateNames = new ArrayList<String>();
        List<Contact> contacts = new ArrayList<Contact>();
        for (String i : bookList.keySet()) {
            contactDetails = bookList.get(i);
            for (int j = 0; j < contactDetails.size(); j++) {
                contacts.add(contactDetails.get(j));
                stateNames.add(contactDetails.get(j).getState());
            }
        }
        List<String> stateNamesDistinct = stateNames.stream().distinct().collect(Collectors.toList());
        for (int y = 0; y < stateNamesDistinct.size(); y++) {
            ArrayList<String> names = new ArrayList<>();
            String stateName = stateNamesDistinct.get(y);
            List<Contact> personsInState = contacts.stream().filter(per -> per.getState().equals(stateName))
                    .collect(Collectors.toList());
            for (int z = 0; z < personsInState.size(); z++) {
                names.add(personsInState.get(z).getFirstName() + " " + personsInState.get(z).getLastName());
            }
            stateList.put(stateName, names);
            personsInState.clear();
        }
        return stateList;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("this is address book program");
        addingBooksAndContacts();
        System.out.println("address books and contact details added successfully ");
        System.out.println("enter 1 to search person by city");
        System.out.println("enter 2 to search person by state");
        int searchoption = scn.nextInt();
        cityList = getPersonsCityWise();
        stateList = getPersonsStateWise();
        if (searchoption == 1) {
            System.out.println("Enter city name  ");
            Scanner scan = new Scanner(System.in);
            String cityName = scan.nextLine();
            System.out.println("persons in the city are : ");
            for (String i : cityList.keySet()) {
                if (i.equals(cityName)) {
                    ArrayList<String> persons = cityList.get(i);
                    for (int y = 0; y < persons.size(); y++) {
                        System.out.println(persons.get(y));
                    }
                }
            }
        }
        else if (searchoption == 2) {
            System.out.println("Enter state name  ");
            Scanner sn = new Scanner(System.in);
            String stateName = sn.nextLine();
            System.out.println("persons in the state are : ");
            for (String i : stateList.keySet()) {
                if (i.equals(stateName)) {
                    ArrayList<String> persons = stateList.get(i);
                    for (int y = 0; y < persons.size(); y++) {
                        System.out.println(persons.get(y));
                    }
                }
            }
        } else {
            System.out.println("Wrong input");
        }
    }
}
