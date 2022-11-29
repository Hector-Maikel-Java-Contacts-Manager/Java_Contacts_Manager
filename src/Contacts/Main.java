package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        boolean keepGoing = true;
        while (keepGoing) {
            Scanner myScanner = new Scanner(System.in);

            // Main Menu
            System.out.println("Welcome to Top Gun Mobile");
            System.out.println("1.  View all pilots.");
            System.out.println("2.  Add a new pilot.");
            System.out.println("3.  Search pilot by name.");
            System.out.println("4.  Delete an existing pilot.");
            System.out.println("5.  Deploy Parachute (Exit).");
            System.out.println("Enter an option (1, 2, 3, 4, or 5):");
            int optionChoice = myScanner.nextInt();

            // Complete User Request
            if (optionChoice == 1) {
                // Read All Contacts
                System.out.println("You chose option 1");
            } else if (optionChoice == 2) {
                // Create Contact
                System.out.println("You chose option 2");
            } else if (optionChoice == 3) {
                // Search for Contact
                // Get user input, iterate through contactList, if exists return contact info, else return "does not exist"
                System.out.println("You chose option 3");
            } else if (optionChoice == 4) {
                // Delete Contact
                System.out.println("You chose option 4");
            } else if (optionChoice == 5) {
                System.out.println("Goodbye and fair skies!");
                keepGoing = false;
            } else {
                System.out.println("Please an option 1-5");
            }
        }


        String directory = "./src/data";
        String filename = "contactList.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }

        // Initial Contact List
        List<Contacts> contactList = new ArrayList<>();
        Contacts gooseObj = new Contacts("Nick Bradshaw", "Goose", "975-234-8854");
        Contacts icemanObj = new Contacts("Tom Kazansky", "Iceman", "232-764-8989");
        Contacts maverickObj = new Contacts ("Pete Mitchell", "Maverick", "523-743-2154");
        contactList.add(gooseObj);
        contactList.add(icemanObj);
        contactList.add(maverickObj);

        //        Files.write(dataFile, contactList);

        List<String> printListFromFile = Files.readAllLines(dataFile);
        System.out.println(printListFromFile);

        public Contacts readInContact(){
            var newContact = new Contacts("","", "");

            System.out.print("Please enter your name: ");
            String personName = inputScanner.nextLine();
            System.out.print("Please enter your phone number:");
            String personPhoneNumber = this.inputScanner.nextLine();

            newContact.setName(personName);
            newContact.setPhoneNumber(personPhoneNumber);
            return newContact;
        }

        public Contacts createContacts(Scanner myScanner) {
            var newContact = new Contacts("","", "");

            System.out.println("Enter the name:  ");
            String contactName = myScanner.nextLine();
            System.out.println("Enter the call-sign:  ");
            String contactCallSign = myScanner.nextLine();
            System.out.println("Enter the number:  ");
            String contactNumber = myScanner.nextLine();

            newContact.setName(contactName);
            newContact.setCallSign(contactCallSign);
            newContact.setNumber(contactNumber);
            contactList.add(newContact);
        }
    }
}
