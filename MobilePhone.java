package com.company.MobilePhone;
/**
 * this app able to do some operations with data, as simulation
 * of contacts menu in mobile phone
 * @author Vic Chern
 * @version 1.01
 */

/**
 * Not decided problems:
 * In this case usersInput normally working with next() method only
 * In next contacts, your phone number should contains at most the same number of digits that contains first contact
 * or would be thrown Mismatch Exception.
 * What about the size of com.company.MobilePhone.MobilePhone class? Should I separate it to more class. Or size is OK?
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilePhone {
    private Scanner usersInput = new Scanner(System.in);
    private String name;
    private int phoneNumber;
    private HashMap<String, Integer> contacts = new HashMap<>();
    private final String ASK = "You want to continue?";

    public void listOfContacts() {
        for (String c : contacts.keySet()) {
            Integer value = contacts.get(c);
            System.out.println(c + ": " + value + "\n");
        }
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty \n");
        }
        System.out.println("__________________________________");
        System.out.println(ASK);
        askMethod();
        menu();

    }

    public void addNewContact() throws InputMismatchException {
        try {
            System.out.println("Please, enter name and phone number");
            name = usersInput.next();
            phoneNumber = usersInput.nextInt();
            contacts.put(name, phoneNumber);
            System.out.println("Contact " + name + " was added\n" + ASK);
            askMethod();
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid enter please repeat \n");
            addNewContact();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        menu();

    }

    public void removeContact() {
        System.out.println("Please enter contact, that you want to remove: ");
        name = usersInput.next();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact was successfully removed \n" + ASK);
            askMethod();
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
        int point = usersInput.nextInt();
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
        }
    }

    public void updateExistingContact(String UpdatedName, int updatedPhoneNumber) {
        System.out.println("Please enter contact, that you want to replace: ");
        if (contacts.containsKey(usersInput.next())) {

            System.out.println("Enter new name of contact");
            UpdatedName = usersInput.next();

            System.out.println("Enter new phone number");
            updatedPhoneNumber = usersInput.nextInt();

            contacts.replace(name, phoneNumber, updatedPhoneNumber);
            contacts.put(UpdatedName, contacts.remove(name));

            System.out.println("\nYour contact list was updated \n" + ASK);
            askMethod();
        } else
            System.out.println("This contact doesn't exist. Please repeat \n");

        menu();

    }

    public void searchFind() {
        System.out.println("Enter name of contact that you want to find:");
        name = usersInput.next();
        if (contacts.containsKey(name)) {
            phoneNumber = contacts.get(name);
            System.out.println("Contact was successfully founded");
            System.out.println(name + ": " + phoneNumber + " \n" + ASK);
            askMethod();
        } else {
            System.out.println("Contact doesn't exist, please repeat \n");
        }
        menu();
    }

    public void askMethod() {
        System.out.println("Yes or No?");
        String answer;
        answer = usersInput.next();
        switch (answer) {
            case "Yes":
                menu();
                break;
            case "No":
                System.out.println("You just exit the program.");
                System.exit(0);
            default:
                System.out.println("Invalid enter, you have been directed to menu \n");
                break;
        }
    }
}


