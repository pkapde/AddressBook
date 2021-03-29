package com.bridgelabz.addressbook;

import java.util.*;

public class UC10_CountOfPerson {
    private static Map<String, ArrayList<Contact>> bookList = new HashMap<String, ArrayList<Contact>>();
    private static Map<String, ArrayList<String>> cityList = new HashMap<String, ArrayList<String>>();
    private static Map<String, ArrayList<String>> stateList = new HashMap<String, ArrayList<String>>();
    static ArrayList<Contact> contactDetailsCity = new ArrayList<Contact>();
    static ArrayList<Contact> contactDetailsState = new ArrayList<Contact>();
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
        // TODO Auto-generated method stub
        ArrayList<String> cityNames = new ArrayList<String>();

        for (String i : bookList.keySet()) {
            contactDetailsCity = bookList.get(i);
            for (int j = 0; j < contactDetailsCity.size(); j++) {
                cityNames.add(contactDetailsCity.get(j).getCity());
            }
        }
        Set<String> duplicateRemoval = new LinkedHashSet<String>();
        duplicateRemoval.addAll(cityNames);
        cityNames.clear();
        cityNames.addAll(duplicateRemoval);

        for (int y = 0; y < cityNames.size(); y++) {
            ArrayList<String> personNames = new ArrayList<String>();
            for (String i : bookList.keySet()) {
                contactDetailsCity = bookList.get(i);
                for (int j = 0; j < contactDetailsCity.size(); j++) {
                    Contact initial = contactDetailsCity.get(j);
                    if (initial.getCity().equals(cityNames.get(y))) {
                        personNames.add(initial.getFirstName() + " " + initial.getLastName());
                    }
                }
            }
            cityList.put(cityNames.get(y), personNames);
        }
        return cityList;
    }
    private static Map<String, ArrayList<String>> getPersonsStateWise() {
        ArrayList<String> stateNames = new ArrayList<String>();
        for (String i : bookList.keySet()) {
            contactDetailsState = bookList.get(i);
            for (int j = 0; j < contactDetailsState.size(); j++) {
                stateNames.add(contactDetailsState.get(j).getState());
            }
        }
        Set<String> duplicateRemoval = new LinkedHashSet<String>();
        duplicateRemoval.addAll(stateNames);
        stateNames.clear();
        stateNames.addAll(duplicateRemoval);
        for (int y = 0; y < stateNames.size(); y++) {
            ArrayList<String> personNames = new ArrayList<String>();
            for (String i : bookList.keySet()) {
                contactDetailsState = bookList.get(i);
                for (int j = 0; j < contactDetailsState.size(); j++) {
                    Contact initial = contactDetailsState.get(j);
                    if (initial.getState().equals(stateNames.get(y))) {
                        personNames.add(initial.getFirstName() + " " + initial.getLastName());
                    }
                }
            }
            stateList.put(stateNames.get(y), personNames);
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
            System.out.println("total count of persons in the city is : " + cityList.get(cityName).size());
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
            System.out.println("total count of persons in the state is : " + stateList.get(stateName).size());
            System.out.println("persons in the state are : ");
            for (String i : stateList.keySet()) {
                if (i.equals(stateName)) {
                    ArrayList<String> persons = stateList.get(i);
                    for (int y = 0; y < persons.size(); y++) {
                        System.out.println(persons.get(y));
                    }
                }
            }
        }
        else {
            System.out.println("Wrong input");
        }
    }
}
