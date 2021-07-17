import java.io.*;
import java.util.Scanner;

public class VaccinationCenter {

    public static Scanner input = new Scanner(System.in);                                                               // global static variable of Scanner class
    public static int noOfVaccines = 150;                                                                               // hard coded global variable that store the initial number of vaccines
    public static boolean run = true;                                                                                   // initialise a global boolean variable and set it as true.
    public static boolean find = false;                                                                                 // initialise a global  boolean variable and set it as false.
    public static int[] rangeArray = {0, 1, 2, 3, 4, 5, 6};                                                             // initialise an int array as a global variable and hard coded the values,
    public static String[] patientsNamesArray = new String[6];                                                          // initialise a string array and set the  size as 6
    public static boolean checkPatientsNames = false;                                                                   // initialise a boolean variable and set as  false
    public static boolean notUsingBooths = false;                                                                       // initialise a boolean variable and set as  false
    public static boolean usingBooths = true;                                                                           // initialise a boolean variable and set as  true
    public static boolean stored = false;                                                                               // initialise a boolean variable and set as  false

    public static String firstName, lastName, city ;
    public static int age, idNumber,  patientNumber;

    public static void main(String[] args) throws Exception {
        Patient[] patients = new Patient[6];

        initialise(patients);


        while (run) {                                                                                                   // to run continuously unless the user user exit option
            printMenu();                                                                                                // prints the main menu
            mainMenu(patients);                                                                                           // calls the switch cases of the main menu
            System.out.println("");
            checkVaccine();                                                                                             // calling the checkVaccine function that check the amount of remaining vaccines
            System.out.println("");
        }
    }


    /**
     * Check whether the number of vaccines are less than or equal to 20. If number of vaccines are equal or lower than 20. Prints a warning.
     */
    public static void checkVaccine()
    {
        if (noOfVaccines <= 20)                                                                                         // check the stock of vaccines
        {
            System.out.println("'WARNING', stock reaches a value of "+ noOfVaccines);
        }
    }
    /**
     * Initialise the object array
     *
     * @param patients an array of Patient class
     */
    public static void initialise(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient( "~","~",0,"~",0,"~");
        }
    }


    /**
     * Print the main menu into the console
     */
    private static void printMenu() {
        System.out.println("");
        System.out.println("*************************************************************************************");
        System.out.println("*                                MAIN MENU                                          *");
        System.out.println("* ********************************************************************************* *");
        System.out.println("* *    Input code       **             Options                                    * *");
        System.out.println("* ********************************************************************************* *");
        System.out.println("* *                     **                                                        * *");
        System.out.println("* *    100 or VVB       **      View all Vaccination Booths                       * *");
        System.out.println("* *    101 or VEB       **      View all Empty Booths                             * *");
        System.out.println("* *    102 or APB       **      Add Patient to a Booth                            * *");
        System.out.println("* *    103 or RPB       **      Remove Patient from a Booth                       * *");
        System.out.println("* *    104 or VPS       **      View Patients Sorted in alphabetical order        * *");
        System.out.println("* *    105 or SPD       **      Store Program Data into file                      * *");
        System.out.println("* *    106 or LPD       **      Load Program Data from file                       * *");
        System.out.println("* *    107 or VRV       **      View Remaining Vaccinations                       * *");
        System.out.println("* *    108 or AVS       **      Add Vaccinations to the Stock                     * *");
        System.out.println("* *    109 or LPP       **      Load Previous Program Data                        * *");
        System.out.println("* *    110 or VDP       **      View All the details of the patient               * *");
        System.out.println("* *    999 or EXT       **      Exit the Program                                  * *");
        System.out.println("* *                     **                                                        * *");
        System.out.println("* ********************************************************************************* *");
        System.out.println("*************************************************************************************\n");

        System.out.println("Enter the respective code for your requirement: ");
    }

    /**
     * Get a string input from the user and proceed the appropriate option
     *
     * @param patients an array of Patient class
     * @throws Exception
     */
    public static void mainMenu(Patient [] patients) throws Exception {


        if (input.hasNext())                                                                                            // filtering data type (Only stings allowed)
        {

            String operation = input.next();
            switch (operation.toUpperCase())                                                                            // convert the string cases to upper
            {

                // case 100 or VVB selected
                case "100":
                case "VVB":
                    System.out.println("***********************************************************");
                    System.out.println("*                 View all Vaccination Booths             *");
                    System.out.println("***********************************************************\n");


                    viewAllVaccinationBooths(patients);                                                                   // first option
                    break;


                // case 101 or VEB is selected
                case "101":
                case "VEB":
                    System.out.println("***********************************************************");
                    System.out.println("*                   View all Empty Booths                 *");
                    System.out.println("***********************************************************\n");

                    viewAllEmptyBooths(patients);                                                                          //second option
                    break;


                // case 102 or APB selected
                case "102":
                case "APB":
                    System.out.println("***********************************************************");
                    System.out.println("*                   Add Patient to a Booth                *");
                    System.out.println("***********************************************************\n");

                    addPatientToaBooth(patients);                                                                          //third option
                    break;


                // case 103 or RPB selected
                case "103":
                case "RPB":
                    System.out.println("***********************************************************");
                    System.out.println("*               Remove Patient from a Booth               *");
                    System.out.println("***********************************************************\n");

                    removePatientfromaBooth(patients);                                                                    //fourth option
                    break;


                // case 104 or VPS selected
                case "104":
                case "VPS":
                    System.out.println("***********************************************************");
                    System.out.println("*        View Patients Sorted in alphabetical order       *");
                    System.out.println("***********************************************************\n");

                    viewPatientsSortedInAlphabeticalOrder(patients);                                                       //fifth option
                    break;


                // case 105 or SPD selected
                case "105":
                case "SPD":
                    System.out.println("***********************************************************");
                    System.out.println("*                Store Program Data into file             *");
                    System.out.println("***********************************************************\n");

                    storeProgramDataIntoFile(patients);                                                                    //sixth option
                    break;


                // case 106 or LPD selected
                case "106":
                case "LPD":
                    System.out.println("***********************************************************");
                    System.out.println("*                Load Program Data from file              *");
                    System.out.println("***********************************************************\n");

                    loadProgramDataFromFile();                                                                          //seventh option
                    break;


                // case 107 or VRV selected
                case "107":
                case "VRV":
                    System.out.println("***********************************************************");
                    System.out.println("*               View Remaining Vaccinations               *");
                    System.out.println("***********************************************************\n");

                    viewRemainingVaccinations();                                                                        //eighth option
                    break;


                // case 108 or AVS selected
                case "108":
                case "AVS":
                    System.out.println("***********************************************************");
                    System.out.println("*            Add Vaccinations to the Stock                *");
                    System.out.println("***********************************************************\n");

                    addVaccinationsToTheStock();                                                                        //ninth option
                    break;


                // case 109 or LPP selected
                case "109":
                case "LPP":
                    System.out.println("***********************************************************");
                    System.out.println("*           Load Previous Program Data                    *");
                    System.out.println("***********************************************************\n");

                    loadPreviousProgramDataFromFile();                                                                  //Extra option
                    break;


                case "110":
                case "VDP":
                    System.out.println("***********************************************************");
                    System.out.println("*           View All the details of the patient           *");
                    System.out.println("***********************************************************\n");
                    displayPatientDetails(patients);
                    break;

                // case 999 or EXT selected
                case "999":
                case "EXT":
                    System.out.println("***********************************************************");
                    System.out.println("*                Exit the Program                         *");
                    System.out.println("***********************************************************\n");

                  exitTheProgram();                                                                                     //tenth option
                   break;

                default:
                    System.out.println("Invalid option selected, 'Input out of range'");                                //if the user input an invalid input, the program will not terminate, just repeat bye passing a warning
            }
        } else {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat bye passing a warning
        }
    }

    /**
     *shows all the vaccination booths. if the booths are empty it shows the booth number and 'empty'. if not it shows the booth number and occupied patients name..
     * @param patients an array of booth class
     */
    private static void viewAllVaccinationBooths(Patient [] patients) {
        for (int i = 0; i < 6; i++) {
            if (patients[i].getPatientFirstName().equals("~")) {                                                         // check whether the booth is occupied or not

                System.out.println("Booth " + i + " is empty");                                                          // print the booth number that empty
            } else {
                System.out.println("booth " + i + " occupied by " + patients[i].getPatientFirstName() + " " + patients[i].getPatientLastName());                         // print the booth number and the patient's name that occupied the respective booth
            }
        }

    }

    /**
     *shows all the empty booths. If the default value of the patientsNamesArray is "~". Then this method shows as that booth is empty.
     * @param patients an array of booth class
     */
    private static void viewAllEmptyBooths(Patient [] patients) {
        for (int i = 0; i < 6; i++) {
            if (patients[i].getPatientFirstName().equals("~")) {                                                               // check whether the booth is empty or not
                System.out.println("Booth " + i + " is empty");                                                         // print the empty booth numbers
            }
        }
        if ((!patients[0].getPatientFirstName().equals("~")) && (!patients[1].getPatientFirstName().equals("~")) && (!patients[2].getPatientFirstName().equals("~")) && (!patients[3].getPatientFirstName().equals("~")) && (!patients[4].getPatientFirstName().equals("~")) && (!patients[5].getPatientFirstName().equals("~"))) { // check all the booths are empty or not
            System.out.println("No empty booth is available at the moment");
        }
    }





        /**
     *Check whether the booths empty or not.If the booth is empty patient can be added to the respective booth.
     * @param patients an array of Patient class
     */
    private static void addPatientToaBooth(Patient[] patients) {
        checknotUsingBooths(patients);                                                                                    // check the booths are empty or not

        if (usingBooths) {

            while (true) {
                System.out.println("***********************************************************");
                System.out.println("*______________________vaccine Type_______________________*");
                System.out.println("*       0         |     AstraZeneca                       *");
                System.out.println("*       1         |     Sinopharm                         *");
                System.out.println("*       2         |     Pfizer                            *");
                System.out.println("***********************************************************\n");
                System.out.println("Enter the respective code for the vaccine you prefer or enter 6 to exit: ");

                if (input.hasNextInt()){
                    int vaccineType = input.nextInt();
                    if (vaccineType == 6){
                        break;
                    }else if ((vaccineType > -1) && (vaccineType <=2)){
                        if(vaccineType == 0){
                            if (patients[0].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[0].setPatientFirstName(firstName);
                                patients[0].setPatientLastName(lastName);
                                patients[0].setPatientAge(age);
                                patients[0].setPatientCity(city);
                                patients[0].setPatientIdNumber(idNumber);
                                patients[0].setPatientVaccineType("AstraZeneca");


                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[0].getPatientFirstName() + " "+ patients[0].getPatientLastName() + " is  added to the booth number " + 1);

                            } else if (patients[1].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[1].setPatientFirstName(firstName);
                                patients[1].setPatientLastName(lastName);
                                patients[1].setPatientAge(age);
                                patients[1].setPatientCity(city);
                                patients[1].setPatientIdNumber(idNumber);
                                patients[1].setPatientVaccineType("AstraZeneca");

                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[1].getPatientFirstName() + " "+ patients[1].getPatientLastName() + " is  added to the booth number " + 1);

                            }else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths");

                            }

                        }else if (vaccineType == 1){
                            if (patients[2].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[2].setPatientFirstName(firstName);
                                patients[2].setPatientLastName(lastName);
                                patients[2].setPatientAge(age);
                                patients[2].setPatientCity(city);
                                patients[2].setPatientIdNumber(idNumber);
                                patients[2].setPatientVaccineType("Sinopharm");

                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[2].getPatientFirstName() + " "+ patients[2].getPatientLastName() + " is  added to the booth number " + 2);


                            }else if (patients[3].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[3].setPatientFirstName(firstName);
                                patients[3].setPatientLastName(lastName);
                                patients[3].setPatientAge(age);
                                patients[3].setPatientCity(city);
                                patients[3].setPatientIdNumber(idNumber);
                                patients[3].setPatientVaccineType("Sinopharm");

                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[3].getPatientFirstName() + " "+ patients[3].getPatientLastName() + " is  added to the booth number " + 3);
                            }
                            else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths");
                            }


                        }else if (vaccineType == 2){
                            if(patients[4].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[4].setPatientFirstName(firstName);
                                patients[4].setPatientLastName(lastName);
                                patients[4].setPatientAge(age);
                                patients[4].setPatientCity(city);
                                patients[4].setPatientIdNumber(idNumber);
                                patients[4].setPatientVaccineType("Pfizer");

                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[4].getPatientFirstName() + " "+ patients[4].getPatientLastName() + " is  added to the booth number " + 4);

                            }else if (patients[5].getPatientFirstName().equals("~")){
                                getPatientData();

                                patients[5].setPatientFirstName(firstName);
                                patients[5].setPatientLastName(lastName);
                                patients[5].setPatientAge(age);
                                patients[5].setPatientCity(city);
                                patients[5].setPatientIdNumber(idNumber);
                                patients[5].setPatientVaccineType("Pfizer");

                                System.out.println("");
                                noOfVaccines -= 1;
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patients[5].getPatientFirstName() + " "+ patients[5].getPatientLastName() + " is  added to the booth number " + 5);
                            }else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths");
                            }
                        } else{
                            System.out.println("Input out of range.. enter the respective code to the vaccine as shown above");
                        }


                    } else{
                        System.out.println("Input out of range.. enter the respective code to the vaccine as shown above");
                        break;
                    }
                }else{
                    System.out.println("Invalid input, input an integer ");
                    break;
                }
            }
        } else {
            System.out.println("Already booths are full, if you want to add new patient remove a patient from existing booths ");
        }
        usingBooths = true;

    }










    /**
     * Check whether the booths are empty or not. If the respective booth is not empty, user can remove the patient in booth.
     * @param patients an array of Patient class
     */

    private static void removePatientfromaBooth(Patient [] patients) {

        checkUsingBooths(patients);

        if (!notUsingBooths) {
            while (true) {
                System.out.println("Enter the booth number that the patient you want to remove (0-5) or 6 to exit: ");

                if (input.hasNextInt()) {
                    int boothNo = input.nextInt();
                    findNumbers(boothNo);
                    if (find) {
                        if (boothNo == 6) {
                            break;
                        } else if (patients[boothNo].getPatientFirstName().equals("~")) {
                            System.out.println("Already booth " + boothNo + " is empty!");
                        } else {
                            patients[boothNo].setPatientFirstName("~");
                            patients[boothNo].setPatientLastName("~");
                            patients[boothNo].setPatientAge(0);
                            patients[boothNo].setPatientCity("~");
                            patients[boothNo].setPatientIdNumber(0);

                            System.out.println("Removed!");
                            System.out.println("");
                        }
                    } else {
                        System.out.println("Input booth number is out of range");
                    }
                } else {
                    System.out.println("Invalid input data type, Integer required");
                    input.next();
                }
                find = false;
            }
            find = false;
        } else {
            System.out.println("Nothing to remove");
        }

        notUsingBooths = false;
    }

    /**
     *Sort the patients names in the booths according to alphabetical order.
     * @param patients an array of Patient class
     */
    private static void viewPatientsSortedInAlphabeticalOrder(Patient [] patients)                                           //referring from GeeksforGeek Available from https://www.geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
    {
        for (int i = 0; i < patients.length; i++) {
            patientsNamesArray[i] = patients[i].getPatientFirstName();
        }

        if ((!patientsNamesArray[0].equals("~")) || (!patientsNamesArray[1].equals("~")) || (!patientsNamesArray[2].equals("~")) || (!patientsNamesArray[3].equals("~")) || (!patientsNamesArray[4].equals("~")) || (!patientsNamesArray[5].equals("~"))) {

            String temp;
            for (int i = 0; i < patientsNamesArray.length; i++) {
                for (int j = i; j < patientsNamesArray.length; j++) {
                    if (patientsNamesArray[i].compareTo(patientsNamesArray[j]) > 0) {
                        temp = patientsNamesArray[i];
                        patientsNamesArray[i] = patientsNamesArray[j];
                        patientsNamesArray[j] = temp;
                    }
                }
            }
            System.out.println("Patient names according to alphabetical order");
            for (int i = 0; i < patientsNamesArray.length; i++) {
                if (patientsNamesArray[i].equals("~")) {
                    continue;
                } else {
                    System.out.println(patientsNamesArray[i]);
                }
            }
        } else {
            System.out.println("First add patients to booth, Then sort it");
        }

    }

    /**
     *if the user calls the respective code for this method. The current data in the program will save to a file.
     * @param patients an array of Patient class
     * @throws Exception
     */
    private static void storeProgramDataIntoFile(Patient [] patients) throws Exception {                                     // referring Java T Point Available from https://www.javatpoint.com/java-bufferedwriter-class

        checkPatientsNamesArray(patients);
        if (checkPatientsNames) {

            BufferedWriter writer = new BufferedWriter(new FileWriter("programData.txt", false));
            for (int i = 0; i < patients.length; i++) {
                writer.write("____________________________________________________________________________");
                writer.newLine();
                writer.write(" patient in booth " + i + ": " + patients[i].getPatientFirstName().toString());               // write the data of booths to the programData file
                writer.newLine();
                writer.write(" patient's Last name "  + patients[i].getPatientLastName().toString());
                writer.newLine();
                writer.write(" patient's age"  + Integer.toString(patients[i].getPatientAge()));
                writer.newLine();
                writer.write(" patient's Living city "  + patients[i].getPatientCity().toString());
                writer.newLine();
                writer.write(" patient's age"  + Integer.toString(patients[i].getPatientIdNumber()));
                writer.newLine();
                writer.write(" Vaccination Type "  + patients[i].getPatientVaccineType().toString());
                writer.newLine();
                writer.write("____________________________________________________________________________");
                writer.newLine();

            }

            writer.write("");
            writer.write("Number of vaccines remaining " + Integer.toString(noOfVaccines));                          // write the number of vaccines to the programData file
            writer.flush();
            System.out.println("Data has been success fully stored to the current program data file");
            stored = true;

            BufferedWriter writerAll = new BufferedWriter(new FileWriter("allProgramData.txt", false));
            for (int j = 0; j < patients.length; j++) {
                writerAll.write("____________________________________________________________________________");
                writerAll.newLine();
                writerAll.write(" patient in booth (First name) " + j + ": " + patients[j].getPatientFirstName().toString());               // write the data of booths to the programData file
                writerAll.newLine();
                writerAll.write(" patient's Last name "  + patients[j].getPatientLastName().toString());
                writerAll.newLine();
                writerAll.write(" patient's age "  + Integer.toString(patients[j].getPatientAge()));
                writerAll.newLine();
                writerAll.write(" patient's Living city "  + patients[j].getPatientCity().toString());
                writerAll.newLine();
                writerAll.write(" patient's NIC/PASSPORT number "  + Integer.toString(patients[j].getPatientIdNumber()));
                writerAll.newLine();
                writerAll.write(" Vaccination Type "  + patients[j].getPatientVaccineType().toString());
                writerAll.newLine();
                writerAll.write("____________________________________________________________________________");
                writerAll.newLine();
            }

            writerAll.write("");
            writerAll.write("Number of vaccines remaining " + Integer.toString(noOfVaccines));                      // write the number of vaccines to the allProgramData file
            writerAll.flush();
            System.out.println("Data has been success fully stored to the previous program data file");
        } else {
            System.out.println("Nothing to store, please enter patients to booths");                                    // warning message if the booths are empty
        }
        checkPatientsNames = false;
    }

    /**
     *Read the stored file and print the data in the file
     * @throws IOException
     */
    private static void loadProgramDataFromFile() throws IOException {                                                  //referring from W3schools Available from https://www.w3schools.com/java/java_files_read.asp
        if (stored) {
            File tempData = new File("ProgramData.txt");                                                       // check whether the programData file is exists
            boolean exists = tempData.exists();

            if (exists) {
                File programData = new File("ProgramData.txt");
                Scanner dataReader = new Scanner(programData);
                while (dataReader.hasNext()) {

                    String data = dataReader.nextLine();                                                                // print the data in programData file to the console
                    System.out.println(data);

                }

                dataReader.close();

            } else {
                System.out.println("First store your data and load again");

            }
        } else {
            System.out.println("Store data before loading");
        }


        stored = false;
    }

    /**
     *print the remaining number of vaccines
     */
    private static void viewRemainingVaccinations() {

        System.out.println("Number of remaining vaccines: " + noOfVaccines);                                            // print the remaining number of vaccines to the console
    }

    /**
     *check the remaining number of vaccines and if the remaining number of vaccines are less than 150. It allow to add vaccines upto sum of "remaining" and "add vaccienes"  are equal to 150
     */
    public static void addVaccinationsToTheStock() {
        while (true) {
            if (noOfVaccines < 150) {                                                                                   // check whether the stock is full or not
                System.out.println("Number of vaccines going to add or enter (-1) to exit: ");
                if (input.hasNextInt()) {
                    int value = input.nextInt();

                    if (value == -1) {                                                                                   // if user input -1 it terminate the option and go to the main menu

                        break;
                    } else if ((value + noOfVaccines <= 150) && (value + noOfVaccines > 0) && (0 < value)) {            // check the user input is greater than to 0 or less than or equal to 150
                        noOfVaccines += value;
                        break;
                    } else {
                        System.out.println("Overloading stock of vaccines");
                        System.out.println("you can add only " + (150 - noOfVaccines));                                // print the maximum amount of vaccines tha can be added to the stock
                    }

                } else {
                    System.out.println("Invalid input data type");
                    input.next();
                }
            } else {
                System.out.println("Stock of vaccine is already full");
                break;
            }

        }
    }

    /**
     *When the user wants to exit the program, program will terminate by making the condition of the while loop in main method as false.
     * @throws IOException
     */
    public static void exitTheProgram() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("programData.txt", false));            // resetting the program data file, referring Java T Point Available from https://www.javatpoint.com/java-bufferedwriter-class
        writer.write("");
        writer.flush();


        System.out.println("Thank you for using Vaccination Center Program");
        System.out.println("");
        System.out.println("                 Stay Safe                       ");
        System.out.println("");
        System.out.println(" ¯\\_(͡❛ ͜ʖ͡❛)_/¯  ¯\\_(͡❛ ͜ʖ͡❛)_/¯  ¯\\_(͡❛ ͜ʖ͡❛)_/¯");
        run = false;
    }

    /**
     * Store the data without deleting, Able to load the previous stored data
     * @throws IOException
     */
    private static void loadPreviousProgramDataFromFile() throws IOException {                                           //referring from W3schools Available from https://www.w3schools.com/java/java_files_read.asp
        File tempData = new File("allProgramData.txt");
        boolean exists = tempData.exists();                                                                             // check the file whether it is available or not
        if (exists) {
            File programData = new File("allProgramData.txt");
            Scanner dataReader = new Scanner(programData);
            while (dataReader.hasNext()) {

                String data = dataReader.nextLine();                                                                    //print the data in allProgram file to the console
                System.out.println(data);
            }
            dataReader.close();
        } else {
            System.out.println("First store your data and load again");

        }
    }

    /**
     * check whether the booths are empty or not, and print a list of  booths that are occupied if the booths are already occupied
     * @param booths an array of booth class
     */
    public static void checkUsingBooths(Booth[] booths) {
        String[] usingBooth = new String[booths.length];
        for (int i = 0; i < booths.length; i++) {
            usingBooth[i] = booths[i].getPatientFirstName();
        }
        if ((usingBooth[0].equals("~")) || (usingBooth[1].equals("~")) || (usingBooth[2].equals("~")) || (usingBooth[3].equals("~")) || (usingBooth[4].equals("~")) || (usingBooth[5].equals("~"))) {
            System.out.println("Booths that already occupied :  ");

            if ((usingBooth[0].equals("~")) && (usingBooth[1].equals("~")) && (usingBooth[2].equals("~")) && (usingBooth[3].equals("~")) && (usingBooth[4].equals("~")) && (usingBooth[5].equals("~"))) {
                System.out.println("None");
                System.out.println("");
                notUsingBooths = true;

            } else {
                for (int i = 0; i < usingBooth.length; i++) {
                    if (!usingBooth[i].equals("~")) {

                        System.out.println("    Booth number : " + i);                                                  // prints the occupied booths
                    }
                }

            }
        }
    }

    /**
     * check whether the booths are empty or not. And if there are empty booths, they will print as a list of empty booths.
     * @param patients an arrray of Patient class
     */
    public static void checknotUsingBooths(Patient [] patients) {
        String[] notUsingBooth = new String[patients.length];
        for (int i = 0; i < patients.length; i++) {
            notUsingBooth[i] = patients[i].getPatientFirstName();
        }
        if ((notUsingBooth[0].equals("~")) || (notUsingBooth[1].equals("~")) || (notUsingBooth[2].equals("~")) || (notUsingBooth[3].equals("~")) || (notUsingBooth[4].equals("~")) || (notUsingBooth[5].equals("~"))) {
            System.out.println("Booths that already empty :  ");

            if ((!notUsingBooth[0].equals("~")) && (!notUsingBooth[1].equals("~")) && (!notUsingBooth[2].equals("~")) && (!notUsingBooth[3].equals("~")) && (!notUsingBooth[4].equals("~")) && (!notUsingBooth[5].equals("~"))) {
                System.out.println("None");
                System.out.println("");
                usingBooths = false;

            } else {
                for (int i = 0; i < notUsingBooth.length; i++) {
                    if (notUsingBooth[i].equals("~")) {

                        System.out.println("    Booth number : " + i);                                                  //print the empty booths
                    }
                }

            }
        }
    }

    /**
     *Basically this check the range of the input booth number
     * @param integer an array of boot class
     */
    public static void findNumbers(int integer) {
        for (int i = 0; i < rangeArray.length; i++) {                                                                   // validating the user's input is in range
            if (rangeArray[i] == integer) {
                find = true;
            }
        }
    }

    /**
     *check whether the booth is empty or not.
     * @param patients an array of Patient class
     */
    public static void checkPatientsNamesArray(Patient [] patients) {
        if ((!patients[0].getPatientFirstName().equals("~")) || (!patients[1].getPatientFirstName().equals("~")) || (!patients[2].getPatientFirstName().equals("~")) || (!patients[3].getPatientFirstName().equals("~")) || (!patients[4].getPatientFirstName().equals("~")) || (!patients[5].getPatientFirstName().equals("~"))) {
            checkPatientsNames = true;
        }
    }


    public static void getPatientData(){
        System.out.println("Enter the first name of the patient:");
        firstName = input.next();

        System.out.println("Enter the Surname name of the patient:");
        lastName = input.next();

        while(true) {
            System.out.println("Enter patients age");
            if (input.hasNextInt()) {
                age = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                input.next();
                System.out.println("");

            }
        }

        System.out.println("Enter the current living city of the patient:");
        city = input.next();

        while(true) {
            System.out.println("Enter the patient's NIC/PASSPORT number (Only the integers)");
            if (input.hasNextInt()) {
                idNumber = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                input.next();
                System.out.println("");

            }
        }
    }

    public static void displayPatientDetails(Patient[] patients) {
        if ((!patients[0].getPatientFirstName().equals("~")) && (!patients[1].getPatientFirstName().equals("~")) && (!patients[2].getPatientFirstName().equals("~")) && (!patients[3].getPatientFirstName().equals("~")) && (!patients[4].getPatientFirstName().equals("~")) && (!patients[5].getPatientFirstName().equals("~"))) {
            while (true) {
                System.out.println("Enter the booth number fo view detail of the current patient: ");
                if (input.hasNextInt()) {
                    patientNumber = input.nextInt();
                    if ((patientNumber < 0) || (patientNumber > 6)) {
                        System.out.println("Patient number is out of range");
                        continue;
                    } else {
                        patients[patientNumber].viewPatientDetails();
                        break;
                    }
                } else {
                    System.out.println("Invalid data type to the patent number");
                    input.next();
                }
            }
        }else{
            System.out.println("Please input patients to all the booths to view details");
        }
    }

}
