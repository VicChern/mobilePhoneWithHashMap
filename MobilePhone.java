package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class MobilePhone {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int phoneNumber;
    private HashMap<String, Integer> contacts = new HashMap<>();
    private final String ASK = "You want to continue?";

    public void listOfContacts() {
        for (String c : contacts.keySet()) {
            Integer value = contacts.get(c);
            System.out.println( c + ": " + value + "\n" + ASK);
            askMethod();
//            System.out.println("*");
        }
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty \n");

        }
        System.out.println("__________________________________");
        menu();
    }

    public void addNewContact() {
        System.out.println("Please, enter name and phone number");
        name = scanner.next();
        phoneNumber = scanner.nextInt();
        contacts.put(name, phoneNumber);
        System.out.println("Contact " + name + " was added\n" + ASK);
        askMethod();
        System.out.println();


        menu();
    }

    public void removeContact() {
        System.out.println("Please enter contact, that you want to remove: ");
        name = scanner.next();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact was successfully removed \n" + ASK + askMethod());
        } else {
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
                break;
            case 3:
                updateExistingContact(name, phoneNumber);
                break;
            case 4:
                removeContact();
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

            System.out.println("\nYour contact list was updated \n" + ASK);
        } else
            System.out.println("This contact doesn't exist. Please repeat \n");

        menu();
    }

    public void searchFind() {
        System.out.println("Enter name of contact that you want to find:");
        name = scanner.next();
        if (contacts.containsKey(name)) {
            phoneNumber = contacts.get(name);
            System.out.println("Contact was successfully founded");
            System.out.println( name + ": " + phoneNumber + " \n" + ASK + askMethod());
        } else {
            System.out.println("Contact doesn't exist, please repeat \n");
        }
        menu();
    }

    public String askMethod() {
        System.out.println( "YES or NO?");
        String answer;
        answer = scanner.next();
        switch (answer) {
            case "YES":
                menu();
                break;
            case "NO":
                break;
            }return "";
        }
    }



/**
 * Not decided Problems:
 
 */
