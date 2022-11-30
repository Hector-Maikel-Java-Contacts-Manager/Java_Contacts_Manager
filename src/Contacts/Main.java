package Contacts;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        //Global scanner
        Scanner myScanner = new Scanner(System.in);

        //Create directory & contactList file
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

        //Initial Contact List
        List<Contacts> contactList = new ArrayList<>();

        //Main Menu
        boolean keepGoing = true;
        while (keepGoing) {

            // Main Menu
            System.out.println("\nWelcome to Top Gun Mobile");
            System.out.println("1.  View all pilots.");
            System.out.println("2.  Add a new pilot.");
            System.out.println("3.  Search pilot by name.");
            System.out.println("4.  Delete an existing pilot.");
            System.out.println("5.  Eject, Eject, Eject!");
            System.out.println("Enter an option (1, 2, 3, 4, or 5):");
            int optionChoice = myScanner.nextInt();
            myScanner.nextLine();

            // Complete User Request
            if (optionChoice == 1) {
                // Read All Contacts
                List<String> printListFromFile = Files.readAllLines(dataFile);
                for (String line : printListFromFile){
                    String[] tokens = line.split("\\|");
                    System.out.printf("%-15s |%-15s |%-15s |\n", tokens[0], tokens[1], tokens[2]);
                }

            } else if (optionChoice == 2) {
                // Create Contact
                System.out.print("Enter Pilot Name: ");
                String pilotName = myScanner.nextLine();
                System.out.print("Enter Pilot Callsign: ");
                String pilotCallsign = myScanner.nextLine();
                System.out.print("Enter Pilot Number: ");
                String pilotNumber = myScanner.nextLine();
                Contacts myPilot = new Contacts(pilotName, pilotCallsign, pilotNumber);
                Files.write(dataFile, List.of(myPilot.getName() + " | " + myPilot.getCallSign() + " | " + myPilot.getNumber()), StandardOpenOption.APPEND);

            } else if (optionChoice == 3) {
                // Search for Contact
                // Get user input, iterate through contactList, if exists return contact info, else return "does not exist"
                boolean keepSearching = true;
                while (keepSearching) {
                    System.out.println("1.  Search by name");
                    System.out.println("2.  Search by callsign");
                    System.out.println("3.  Search by phone number");
                    System.out.print(" Select a search option: ");
                    int searchOption = myScanner.nextInt();
                    myScanner.nextLine();
                    if (searchOption == 1){

                    } else if (searchOption ==2){

                    } else if (searchOption == 3){

                    } else {
                        System.out.println("Please select valid option");
                    }
                }

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

        List<String> printListFromFile = Files.readAllLines(dataFile);
        System.out.println(printListFromFile);

//        public Contacts readInContact(){
//            var newContact = new Contacts("","", "");
//
//            System.out.print("Please enter your name: ");
//            String personName = inputScanner.nextLine();
//            System.out.print("Please enter your phone number:");
//            String personPhoneNumber = this.inputScanner.nextLine();
//
//            newContact.setName(personName);
//            newContact.setPhoneNumber(personPhoneNumber);
//            return newContact;
//        }
//
//        public Contacts createContacts(Scanner myScanner) {
//            var newContact = new Contacts("","", "");
//
//            System.out.println("Enter the name:  ");
//            String contactName = myScanner.nextLine();
//            System.out.println("Enter the call-sign:  ");
//            String contactCallSign = myScanner.nextLine();
//            System.out.println("Enter the number:  ");
//            String contactNumber = myScanner.nextLine();
//
//            newContact.setName(contactName);
//            newContact.setCallSign(contactCallSign);
//            newContact.setNumber(contactNumber);
//            contactList.add(newContact);
//        }
    }
}
