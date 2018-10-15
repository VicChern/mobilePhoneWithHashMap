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
            System.out.println(c + value);
            System.out.println("*");
        }
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty");
        }
        System.out.println("__________________________________");
        menu();
    }

    public void addNewContact(String name, String phoneNumber) {
        System.out.println("Please, enter name and phone number");
        name = scanner.nextLine();
        phoneNumber = scanner.nextLine();
        System.out.println();

        contacts.put(name, phoneNumber);

        menu();
    }

    public void removeContact(String name) {
        contacts.remove(name);
        menu();
    }

    public void menu() {
        String name = "";
        String phoneNumber = "";
        System.out.println("1. Print list of contacts \n" +
                "2. Add new contact \n" +
                "3. Update existing contact \n" +
                "4. Remove contact \n" +
                "5. Search/find contact \n" +
                "6. Exit");
        int point = scanner.nextInt();
        switch (point) {
            case 1:
                listOfContacts();
                break;
            case 2:
                addNewContact(name, phoneNumber);
                break;
            case 3:
                updateExistingContact(name, phoneNumber);
                break;
            case 4:
                removeContact(name);
                break;
            case 5:
                searchFind();
                break;
            case 6:
                System.out.println("You just exit from your program");
                break;
        }
    }

    public void updateExistingContact(String UpdatedName, String UpdatedPhoneNumber) {
        System.out.println("Please enter contact, that you want to replace: ");
        name = scanner.next();

        UpdatedName = scanner.nextLine();
        UpdatedPhoneNumber = scanner.nextLine();
        contacts.replace(UpdatedName, UpdatedPhoneNumber);

        System.out.println("\n Your contact list was updated");

        menu();
    }

    public void searchFind() {

    }

}
// Able to store, modify, remove and query contact names.
//////Create a master class (MobilePhone) that holds the ArrayList of Contacts
//////Add a menu of options that are available.
////// Options:
////// Quit, print list of contacts, add new contact, updat
//////                }
//////            }e existing contact, remove contact
//////// and search/find contact.
//////// When adding or updating be sure to check if the contact already exists (use name)
//////
//////
////////        for (int i = 0; i < contacts.size() - 1; i++) {
////////            for (int k = i + 1; k < contacts.size(); k++) {
////////                if ((contacts.get(i).equals(contacts.get(k)))) {
////////
////////                    System.out.println("Contact already exist");
////////
//////                    System.out.println"Contact already exist");
////
//////        }
