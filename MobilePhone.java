package com.company;

import java.util.*;

public class MobilePhone {
    Scanner scanner = new Scanner(System.in);
    String name;
    int phoneNumber;
    private HashMap<String, Integer> contacts = new HashMap<>();

    public void listOfContacts() {
        for (String c : contacts.keySet()) {
            Integer value = contacts.get(c);
            System.out.println("->" + c  + ": " + value + "<-");
            System.out.println("*");
        }
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty");
        }
        System.out.println("__________________________________");
        menu();
    }

    public void addNewContact() {
        System.out.println("Please, enter name and phone number");
        name = scanner.next();
        phoneNumber = scanner.nextInt();
        contacts.put(name, phoneNumber);
        System.out.println("Contact " + name + " was added");
        System.out.println();


        menu();
    }

    public void removeContact(String name) {
        System.out.println("Please enter contact, that you want to remove: ");
        if (contacts.containsKey(scanner.next())) {
            contacts.remove(name);
        }else {
            System.out.println("This contact doesn't exist. Please repeat \n");
        }
        menu();
    }

    public void menu() {
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
                addNewContact();
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

    public void updateExistingContact(String UpdatedName, int updatedPhoneNumber) {
        System.out.println("Please enter contact, that you want to replace: ");
        if (contacts.containsKey(scanner.next())) {

            System.out.println("Enter new name of contact");
            UpdatedName = scanner.next();

            System.out.println("Enter new phone number");
            updatedPhoneNumber = scanner.nextInt();

            contacts.replace(name, phoneNumber, updatedPhoneNumber);
            contacts.put(UpdatedName, contacts.remove(name));

            System.out.println("\nYour contact list was updated \n");
        }else
            System.out.println("This contact doesn't exist. Please repeat \n");

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
