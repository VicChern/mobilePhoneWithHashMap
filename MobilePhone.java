package com.company;

import java.util.*;

public class MobilePhone {
    Scanner scanner = new Scanner(System.in);
    String name;
    String phoneNumber;
    private HashMap<String, String> contacts = new HashMap();

    public void listOfContacts() {
        for (String c : contacts.keySet()) {
            String value = contacts.get(c);
            System.out.println(c + ": " + value);
            System.out.println("*");
        }
        System.out.println("__________________________________");
    }

    public void addNewContact(String name, String phoneNumber) {
        name = scanner.nextLine();
        phoneNumber = scanner.nextLine();
        if (!(contacts.containsValue(phoneNumber))) {
            contacts.put(name, phoneNumber);
        } else {
            System.out.println("Contact already exists");
        }
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void menu() {
        String name = "";
        String phoneNumber = "";
        System.out.println("1. Print list of contacts \n" +
                "2. Add new contact \n" +
                "3. Update existing contact \n" +
                "4. Remove contact \n" +
                "5. Search/find contact ");
        int point = scanner.nextInt();
        switch (point) {
            case 1:
                listOfContacts();
            case 2:
                addNewContact(name, phoneNumber);
            case 3:
                updateExistingContact(name, phoneNumber);
            case 4:
                removeContact(name);
        }
    }

    public void updateExistingContact(String name, String phoneNumber) {
        if (contacts.containsValue(phoneNumber)) {
            contacts.replace(name, phoneNumber);
        }
    }

}
// Able to store, modify, remove and query contact names.
//Create a master class (MobilePhone) that holds the ArrayList of Contacts
//Add a menu of options that are available.
// Options:
// Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)


//        for (int i = 0; i < contacts.size() - 1; i++) {
//            for (int k = i + 1; k < contacts.size(); k++) {
//                if ((contacts.get(i).equals(contacts.get(k)))) {
//
//                    System.out.println("Contact already exist");
//
//                }
//            }
//                    System.out.println"Contact already exist");

//        }