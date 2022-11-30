package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String formatNum(String num) {
        if (num.length() == 7) {
            String first = num.substring(0, 3);
            String second = num.substring(3, 7);
            String result = first + "-" + second;
            return result;
        }
        else if (num.length() == 10) {
            String first = num.substring(0, 3);
            String second = num.substring(3, 6);
            String third = num.substring(6, 10);
            String result = "(" + first + ")-" + second + "-" + third;
            return result;
        }
        return "Invalid Number";
    }

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

        // Landing Page
        System.out.println("               \\ /                                          \\   /\n" +
                "              --o--           `\\\\             //'      .____-/.\\-____.\n" +
                "                                \\\\           //             ~`-'~\n" +
                "                                 \\\\. __-__ .//\n" +
                "                       ___/-_.-.__`/~     ~\\'__.-._-\\___                    \n" +
                ".|.       ___________.'__/__ ~-[ \\.\\'-----'/./ ]-~ __\\__`.___________       .|.\n" +
                "~o~~~~~~~--------______-~~~~~-_/_/ |   .   | \\_\\_-~~~~~-______--------~~~~~~~o~\n" +
                "' `               + + +  (X)(X)  ~--\\__ __/--~  (X)(X)  + + +               ' `\n" +
                "                             (X) `/.\\' ~ `/.\\' (X)  \n" +
                "                                 \"\\_/\"   \"\\_/\"");
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
            List<String> printListFromFile = Files.readAllLines(dataFile);

            // Complete User Request
            if (optionChoice == 1) {
                // Read All Contacts
                System.out.println("---------------------------------------------------");
                System.out.printf("%-15s |%-15s |%-15s |\n", "NAME", " CALLSIGN", " PHONE NUMBER");
                System.out.println("---------------------------------------------------");
                for (String line : printListFromFile){
                    String[] tokens = line.split("\\|");
                    System.out.printf("%-15s |%-15s |%-15s |\n", tokens[0], tokens[1], tokens[2]);
                }
                System.out.println("---------------------------------------------------");

                // Create Contact
            } else if (optionChoice == 2) {
                System.out.print("Enter Pilot Name: ");
                String pilotName = myScanner.nextLine();
                System.out.print("Enter Pilot Callsign: ");
                String pilotCallsign = myScanner.nextLine();
                System.out.print("Enter Pilot Number: ");
                String pilotNumber = myScanner.nextLine();
                pilotNumber = formatNum(pilotNumber);
                Contacts myPilot = new Contacts(pilotName, pilotCallsign, pilotNumber);
                Files.write(dataFile, List.of(myPilot.getName() + " | " + myPilot.getCallSign() + " | " + myPilot.getNumber()), StandardOpenOption.APPEND);
                System.out.println("Pilot added successfully");

                // Search for Contact
            } else if (optionChoice == 3) {
                boolean keepSearching = true;
                while (keepSearching) {
                    System.out.println("Search pilot");
                    String searchString = myScanner.nextLine();
                    System.out.println("------------------------------------------");
                    for (int i = 0; i < printListFromFile.size(); i++) {
                        if (printListFromFile.get(i).toLowerCase().contains(searchString.toLowerCase())) {
                            System.out.println(printListFromFile.get(i));
                        }
                    }
                    System.out.println("------------------------------------------");
                    System.out.println("\n1.  Search another pilot");
                    System.out.println("2.  Back to main menu");
                    int returnOrNo = myScanner.nextInt();
                    myScanner.nextLine();
                    if (returnOrNo == 2) {
                        keepSearching = false;
                    }
                }

                // Delete Contact
            } else if (optionChoice == 4) {
                    System.out.println("Select pilot to delete");
                    String searchString = myScanner.nextLine();
                    String blank = "";
                    for (int i = 0; i < printListFromFile.size(); i++) {
                        if (printListFromFile.get(i).contains(searchString)) {
                            blank = printListFromFile.get(i);
                        }
                    } printListFromFile.remove(blank);
                Files.write(dataFile, printListFromFile);

                // Exit App
            } else if (optionChoice == 5) {
                System.out.println("Goodbye and fair skies!");
                keepGoing = false;

                // Invalid Input
            } else {
                System.out.println("Please an option 1-5");
            }
        }
    }
}
