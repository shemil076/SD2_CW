package ArrayVersion;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.io.*;
public class ArrayVersion {
    public static Scanner input = new Scanner(System.in);                                                               // global static variable of Scanner class
    public static int noOfVaccines = 150;                                                                               // hard coded global variable that store the initial number of vaccines
    public static String [] patientsArray = new String[6];                                                              // initialised the string array that store patient names as a global variable with size of 6
    public static boolean run = true;                                                                                   // initialise a global boolean variable and set it as true.
    public static boolean find = false;                                                                                 // initialise a global  boolean variable and set it as false.
    public static int [] rangeArray = {0,1,2,3,4,5,6};                                                                  // initialise an int array as a global variable and hard coded the values,
    public static String [] patientsNamesArray = new String[6];                                                         // initialise a string array and set the  size as 6
    public static boolean checkPatientsNames = false;                                                                   // initialise a boolean variable and set as  false
    public static boolean notUsingBooths = false;                                                                       // initialise a boolean variable and set as  false
    public static boolean usingBooths = true;                                                                           // initialise a boolean variable and set as  true
    public static boolean stored = false;                                                                               // initialise a boolean variable and set as  false
    public static String [] lastNameArray = new String[6];

    public static String firstName, lastName;


    public static void main(String[] args) throws Exception {


        initialise(patientsArray);                                                                                      // calling the initialise method to initialise the main array
        initialise(lastNameArray);
        while (run) {                                                                                                   // to run continuously unless the user user exit option
            printMenu();                                                                                                // prints the main menu
            mainMenu();                                                                                                 // calls the switch cases of the main menu
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
     * initialise the String arrays (patientsNamesArray and patientsArray ) and set the default value as "~"
     * @param booth String arrys
     */

    public static void initialise(String[] booth)
    {
        for (int i = 0; i < booth.length; i++ ) booth[i] = "~" ;                                                         // initialise the array with a default value

    }


    /**
     * Get a string input from the user and proceed the appropriate option
     * @throws Exception
     */
    public static void mainMenu() throws Exception {


        if (input.hasNext())                                                                                            // filtering data type (Only stings allowed)
        {

            String operation = input.next();
            switch (operation.toUpperCase())                                                                        // convert the string cases to upper
            {

                // case 100 or VVB selected
                case "100":
                case "VVB":
                    System.out.println("***********************************************************");
                    System.out.println("*                 View all Vaccination Booths             *");
                    System.out.println("***********************************************************\n");

                    viewAllVaccinationBooths();                                                                     // first option
                    break;


                // case 101 or VEB is selected
                case "101":
                case "VEB":
                    System.out.println("***********************************************************");
                    System.out.println("*                   View all Empty Booths                 *");
                    System.out.println("***********************************************************\n");

                    viewAllEmptyBooths();                                                                           //second option
                    break;


                // case 102 or APB selected
                case "102":
                case "APB":
                    System.out.println("***********************************************************");
                    System.out.println("*                   Add Patient to a Booth                *");
                    System.out.println("***********************************************************\n");

                    addPatientToaBooth();                                                                           //third option
                    break;


                // case 103 or RPB selected
                case "103":
                case "RPB":
                    System.out.println("***********************************************************");
                    System.out.println("*               Remove Patient from a Booth               *");
                    System.out.println("***********************************************************\n");

                    removePatientfromaBooth();                                                                      //fourth option
                    break;



                // case 104 or VPS selected
                case "104":
                case "VPS":
                    System.out.println("***********************************************************");
                    System.out.println("*        View Patients Sorted in alphabetical order       *");
                    System.out.println("***********************************************************\n");

                    viewPatientsSortedInAlphabeticalOrder();                                                        //fifth option
                    break;


                // case 105 or SPD selected
                case "105":
                case "SPD":
                    System.out.println("***********************************************************");
                    System.out.println("*                Store Program Data into file             *");
                    System.out.println("***********************************************************\n");

                    storeProgramDataIntoFile();                                                                     //sixth option
                    break;


                // case 106 or LPD selected
                case "106":
                case "LPD":
                    System.out.println("***********************************************************");
                    System.out.println("*                Load Program Data from file              *");
                    System.out.println("***********************************************************\n");

                    loadProgramDataFromFile();                                                                      //seventh option
                    break;


                // case 107 or VRV selected
                case "107":
                case "VRV":
                    System.out.println("***********************************************************");
                    System.out.println("*               View Remaining Vaccinations               *");
                    System.out.println("***********************************************************\n");

                    viewRemainingVaccinations();                                                                    //eighth option
                    break;



                // case 108 or AVS selected
                case "108":
                case "AVS":
                    System.out.println("***********************************************************");
                    System.out.println("*            Add Vaccinations to the Stock                *");
                    System.out.println("***********************************************************\n");

                    addVaccinationsToTheStock();                                                                    //ninth option
                    break;


                // case 109 or LPP selected
                case "109":
                case "LPP":
                    System.out.println("***********************************************************");
                    System.out.println("*           Load Previous Program Data                    *");
                    System.out.println("***********************************************************\n");

                    loadPreviousProgramDataFromFile();                                                              //Extra option
                    break;


                // case 999 or EXT selected
                case "999":
                case "EXT":
                    System.out.println("***********************************************************");
                    System.out.println("*                Exit the Program                         *");
                    System.out.println("***********************************************************\n");

                    exitTheProgram();                                                                               //tenth option
                    break;

                default:
                    System.out.println("Invalid option selected, 'Input out of range'");                            //if the user input an invalid input, the program will not terminate, just repeat bye passing a warning
            }
        }else
        {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat bye passing a warning
        }
    }


    /**+
     * print main main  as an output
     */
    private static void printMenu()
    {
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
        System.out.println("* *    999 or EXT       **      Exit the Program                                  * *");
        System.out.println("* *                     **                                                        * *");
        System.out.println("* ********************************************************************************* *");
        System.out.println("*************************************************************************************\n");

        System.out.println("Enter the respective code for your requirement: ");
    }


    /**+
     * shows all the vaccination booths. if the booths are empty it shows the booth number and 'empty'. if not it shows the booth number and occupied patients name..
     */
    private static void viewAllVaccinationBooths()
    {
        for (int i = 0; i < 6 ;i++ )
        {
            if (patientsArray[i].equals("~"))                                                                         // check whether the booth is occupied or not
            {
                System.out.println("Booth " + i + " is empty");                                                       // print the booth number that empty
            }
            else {
                System.out.println("booth "+ i + " occupied by " + patientsArray[i] + " " + lastNameArray[i]);          // print the booth number and the patient's name that occupied the respective booth
            }
        }

    }


    /**+
     * shows all the empty booths. If the default value of the patientsNamesArray is "~". Then this method shows as that booth is empty.
     */
    private static void viewAllEmptyBooths()
    {
        for (int i = 0 ; i < 6 ; i++)
        {
            if (patientsArray[i].equals("~"))                                                                           // check whether the booth is empty or not
            {
                System.out.println("Booth " + i + " is empty");                                                         // print the empty booth numbers
            }
        }
        if ((!patientsArray[0].equals("~")) && (!patientsArray[1].equals("~")) && (!patientsArray[2].equals("~")) && (!patientsArray[3].equals("~")) && (!patientsArray[4].equals("~")) && (!patientsArray[5].equals("~"))) // check all the booths are empty or not
        {
            System.out.println("No empty booth is available at the moment");
        }
    }


    /**+
     * Check whether the booths empty or not.If the booth is empty patient can be added to the respective booth.
     */
    private static void addPatientToaBooth()
    {
        checknotUsingBooths(patientsArray);                                                                             // check the booths are empty or not

        if(usingBooths)
        {
            while (true) {
                System.out.println("***********************************************************");
                System.out.println("*______________________vaccine Type_______________________*");
                System.out.println("*       0         |     AstraZeneca                       *");
                System.out.println("*       1         |     Sinopharm                         *");
                System.out.println("*       2         |     Pfizer                            *");
                System.out.println("***********************************************************\n");
                System.out.println("Enter the respective code for the vaccine you prefer or enter 6 to exit: ");

                if (input.hasNextInt()){                                                                                // check the input value is empty or not
                    int vaccineType = input.nextInt();
                    if (vaccineType == 6){                                                                              // check whether the user want to terminate the current option
                        break;                                                                                          // if the input value is 6 adding patients to the booth option will terminates and go back to the main menu
                    }else if ((vaccineType > -1) && (vaccineType <=2)){                                                 // check whether the user input value is between -1 to 3 (excluding -1 and 3)
                        if(vaccineType == 0){                                                                           // assign to the booth 0 ior 2 if user preferred AstraZeneca
                            if (patientsArray[0].equals("~")){                                                          // assign the patient to the  0th booth if the booth 0 is empty
                                getPatientData();                                                                       // calling the method to get details of the patient

                                patientsArray[0] = firstName;
                                lastNameArray[0] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce one vaccine from the vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[0] + " "+ lastNameArray[0] + " is  added to the booth number " + 0);

                            } else if (patientsArray[1].equals("~")){                                                   // if the booth number 0 is already taken taken patient will assign to the booth number 1
                                getPatientData();                                                                       // calling the method to get details of the patient

                                patientsArray[1] = firstName;
                                lastNameArray[1] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce one vaccine from vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[1] + " "+ lastNameArray[1] + " is  added to the booth number " + 1);

                            }else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths"); // if the booth 0 and 1 is occupied, user will get a warning message
                            }

                        }else if (vaccineType == 1){                                                                    // if user prefers to get vaccine SinoPharm
                            if (patientsArray[2].equals("~")){                                                          // check whether the booth 2 is empty, if the booth 2 is not empty patient will add to the booth 2
                                getPatientData();

                                patientsArray[2] = firstName;
                                lastNameArray[2] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce one vaccine from vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[2] + " "+ lastNameArray[2] + " is  added to the booth number " + 2);


                            }else if (patientsArray[3].equals("~")){                                                    // if the booth number 2 is occupied patient will add to the booth number 3 if booth number 3 is empty
                                getPatientData();

                                patientsArray[3] = firstName;
                                lastNameArray[3] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce one vaccine from the vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[3] + " "+ lastNameArray[3] + " is  added to the booth number " + 3);
                            }
                            else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths"); // will print a warning message if the booth booths 2 and 3 are occupied
                            }


                        }else if (vaccineType == 2){                                                                    // if the patient prefer to get pfizer
                            if(patientsArray[4].equals("~")){                                                           // check whether the booth 4 is available, if it is, the patient will added to the booth number 3
                                getPatientData();

                                patientsArray[4] = firstName;
                                lastNameArray[4] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce one vaccine from the vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[4] + " "+ lastNameArray[4] + " is  added to the booth number " + 4);

                            }else if (patientsArray[5].equals("~")){                                                    // if the booth number 4 is already occupied the patient will added to the booth number 5 if the booth number 5 is empty
                                getPatientData();

                                patientsArray[5] = firstName;
                                lastNameArray[5] = lastName;

                                System.out.println("");
                                noOfVaccines -= 1;                                                                      // reduce a vaccine from the vaccine stock
                                System.out.println("Requirement is successfully completed");
                                System.out.println(patientsArray[5] + " "+ lastNameArray[5] + " is  added to the booth number " + 5);
                            }else {
                                System.out.println("Booths reserved for  AstraZeneca are already full, if you want to add new patient remove a patient from existing booths"); //will print a warning if the booth booths 4 and 5 is occupied
                            }
                        } else{
                            System.out.println("Input out of range.. enter the respective code to the vaccine as shown above"); // will print if the user enter other numbers neither numbers between -1 to 3
                        }


                    } else{
                        System.out.println("Input out of range.. enter the respective code to the vaccine as shown above"); // will print if the user enter other numbers neither numbers between -1 to 3
                        break;
                    }
                }else{
                    System.out.println("Invalid input, input an integer ");                                             // will print if user user other data types than ints
                    break;
                }

            }
        }
        else
        {
            System.out.println("Already booths are full, if you want to add new patient remove a patient from existing booths "); // will print if the booth no longer available
        }
        usingBooths = true;                                                                                             // resetting the changed value

    }











    /**
     *  Check whether the booths are empty or not. If the respective booth is not empty, user can remove the patient in booth.
     */
    private static void removePatientfromaBooth()
    {

        checkUsingBooths(patientsArray);                                                                                // check the using booths

        if (!notUsingBooths)
        {
            while (true)
            {
                System.out.println("Enter the booth number that the patient you want to remove (0-5) or 6 to exit: ");  // if some booths are occupied user able to select the booth number that wants to delete the current patient

                if (input.hasNextInt())                                                                                 // check the value that getting as a booth number is an integer or not
                {
                    int boothNo = input.nextInt();                                                                      // if the value is an integer the value is assign to the variable
                    findNumbers(boothNo);                                                                               // check the user input values is in the range of 0 - 6 (including 0 and 6)
                    if (find)
                    {
                        if (boothNo == 6)                                                                               // if the value is 6 this menu will terminate and return to the main menu
                        {
                            break;
                        }
                        else if (patientsArray[boothNo].equals("~"))                                                    // if not, check the booth number tha enter by the uer is empty or not
                        {
                            System.out.println("Already booth " + boothNo + " is empty!");                              // will print if the is already empty
                        }
                        else {                                                                                          // if not;
                            patientsArray[boothNo] = "~";                                                               // the first name of the patient in the respective booth will reset to the default value
                            lastNameArray[boothNo] = "~";                                                               // the last name of the patient in the respective booth will reset to the default value

                            System.out.println("Removed!");
                            System.out.println("");
                        }
                    }else
                    {
                        System.out.println("Input booth number is out of range");                                       // will print if the user enter a value out of range
                    }
                }
                else{
                    System.out.println("Invalid input data type, Integer required");                                    // will print if the input data type is other than integer
                    input.next();
                }
                find = false;                                                                                           // reset the changed value
            }
            find = false;                                                                                               // reset the changed value
        }else{
            System.out.println("Nothing to remove");                                                                    // will print if all the booths are empty
        }

        notUsingBooths = false;                                                                                         // reset the changed value
    }


    /**+
     * Sort the patients names in the booths according to alphabetical order.
     */
    private static void viewPatientsSortedInAlphabeticalOrder()                                                      //referring from GeeksforGeek Available from https://www.geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
    {
//        copyArray(patientsArray);

        for (int i = 0 ; i < patientsArray.length; i++) {                                                               // copy the main array into a sub array
            patientsNamesArray[i] = patientsArray[i];
        }

        if ((!patientsNamesArray[0].equals("~")) || (!patientsNamesArray[1].equals("~")) || (!patientsNamesArray[2].equals("~")) || (!patientsNamesArray[3].equals("~")) || (!patientsNamesArray[4].equals("~")) || (!patientsNamesArray[5].equals("~"))) // check whether the booths are empty
        {

            String temp;
            for (int i = 0; i < patientsNamesArray.length; i++)                                                         // travel through the copied array
            {
                for (int j = i; j < patientsNamesArray.length; j++)                                                     // assign the respective values to compare
                {
                    if (patientsNamesArray[i].compareTo(patientsNamesArray[j])> 0)                                      // compare the names of  the patient according to
                    {
                        temp = patientsNamesArray[i];                                                                   // assign the previous value to a temp variable
                        patientsNamesArray[i] = patientsNamesArray[j];                                                  // assign the next value to the previous index
                        patientsNamesArray[j] = temp;                                                                   // assign the value in the temp variable to the next index
                    }
                }
            }
            System.out.println("Patient names according to alphabetical order");
            for (int i = 0   ; i <patientsNamesArray.length; i++)                                                       // traveling through the sorted array
            {
                if (patientsNamesArray[i].equals("~"))                                                                  // if the value is equal to "~", it will change to the next iteration
                {
                    continue;
                }
                else {
                    System.out.println(patientsNamesArray[i]);                                                          // if not the names will print according to the alphabetical order
                }
            }
        }else
        {
            System.out.println("First add patients to booth, Then sort it");                                            // will print if the booths are empty
        }

    }


    /**+
     * if the user calls the respective code for this method. The current data in the program will save to a file.
     * @throws Exception
     */
    private static void storeProgramDataIntoFile()                                                                      // referring Java T Point Available from https://www.javatpoint.com/java-bufferedwriter-class
            throws  Exception

    {


        checkPatientsNamesArray();
        if (checkPatientsNames)
        {

            BufferedWriter writer = new BufferedWriter(new FileWriter("programData.txt",false));
            for(int i = 0; i < patientsArray.length; i++)
            {
                writer.write("patient in booth "+ i +": "+ patientsArray[i].toString() + " " + lastNameArray[i].toString());                             // write the data of booths to the programData file
                writer.newLine();
            }

            writer.write("");
            writer.write("Number of vaccines remaining "+Integer.toString(noOfVaccines));                           // write the number of vaccines to the programData file
            writer.flush();
            System.out.println("Data has been success fully stored to the current program data file");
            stored = true;

            BufferedWriter writerAll = new BufferedWriter(new FileWriter("allProgramData.txt",false));
            for(int j = 0 ; j < patientsArray.length; j++)
            {
                writerAll.write("patient in booth "+ j +": "+ patientsArray[j].toString() + " " + lastNameArray[j].toString());                         // write the data of booths to the allProgramData file
                writerAll.newLine();
            }

            writerAll.write("");
            writerAll.write("Number of vaccines remaining "+Integer.toString(noOfVaccines));                        // write the number of vaccines to the allProgramData file
            writerAll.flush();
            System.out.println("Data has been success fully stored to the previous program data file");



        }
        else
        {
            System.out.println("Nothing to store, please enter patients to booths");                                    // warning message if the booths are empty
        }
        checkPatientsNames = false;
    }




    /**+
     * Read the stored file and print the data in the file
     * @throws FileNotFoundException
     */
    private static void loadProgramDataFromFile() throws IOException                                                    //referring from W3schools Available from https://www.w3schools.com/java/java_files_read.asp
    {
        if (stored)
        {
            File tempData = new File("programData.txt");                                                       // check whether the programData file is exists
            boolean exists = tempData.exists();

            if (exists) {
                File programData = new File("programData.txt");
                Scanner dataReader = new Scanner(programData);
                while (dataReader.hasNext()) {

                    String data = dataReader.nextLine();                                                                // print the data in programData file to the console
                    System.out.println(data);

                }

                dataReader.close();



            } else {
                System.out.println("First store your data and load again");

            }


        }
        else
        {
            System.out.println("Store data before loading");
        }


        stored = false;
    }


    /**+
     * print the remaining number of vaccines
     */
    private static void viewRemainingVaccinations()
    {

        System.out.println("Number of remaining vaccines: " + noOfVaccines);                                            // print the remaining number of vaccines to the console
    }


    /**+
     * check the remaining number of vaccines and if the remaining number of vaccines are less than 150. It allow to add vaccines upto sum of "remaining" and "add vaccienes"  are equal to 150
     */
    public static void addVaccinationsToTheStock() {
        while (true) {
            if (noOfVaccines < 150) {                                                                                   // check whether the stock is full or not
                System.out.println("Number of vaccines going to add or enter (-1) to exit: ");
                if (input.hasNextInt()) {
                    int value = input.nextInt();

                    if (value == -1)                                                                                    // if user input -1 it terminate the option and go to the main menu
                    {
                        break;
                    }
                    else if ((value + noOfVaccines <= 150) && (value + noOfVaccines > 0 ) && (0 < value )){             // check the user input is greater than to 0 or less than or equal to 150
                        noOfVaccines += value;
                        break;
                    }
                    else
                    {
                        System.out.println("Overloading stock of vaccines");
                        System.out.println("you can add only " + (150 - noOfVaccines) );                                // print the maximum amount of vaccines tha can be added to the stock
                    }

                } else {
                    System.out.println("Invalid input data type");
                    input.next();
                }
            } else
            {
                System.out.println("Stock of vaccine is already full");
                break;
            }

        }
    }


    /**+
     * When the user wants to exit the program, program will terminate by making the condition of the while loop in main method as false.
     */
    public static void exitTheProgram() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("programData.txt",false));              // resetting the program data file, referring Java T Point Available from https://www.javatpoint.com/java-bufferedwriter-class
        writer.write("");
        writer.flush();


        System.out.println("Thank you for using Vaccination Center Program");
        System.out.println("");
        System.out.println("                 Stay Safe                       ");
        System.out.println("");
        System.out.println(" ¯\\_(͡❛ ͜ʖ͡❛)_/¯  ¯\\_(͡❛ ͜ʖ͡❛)_/¯  ¯\\_(͡❛ ͜ʖ͡❛)_/¯") ;
        run = false;
    }


    /**+
     * Basically this check the range of the input booth number
     * @param integer the int input that get from the user, as the booth number
     */
    public static void findNumbers( int integer)
    {
        for (int i = 0; i < rangeArray.length ; i ++)                                                                   // validating the user's input is in range
        {
            if ( rangeArray[i] == integer)
            {
                find = true;
            }
        }
    }


    /**+
     * check whether the booth is empty or not.
     */
    public static void checkPatientsNamesArray()
    {
        if ((!patientsArray[0].equals("~")) || (!patientsArray[1].equals("~")) || (!patientsArray[2].equals("~")) || (!patientsArray[3].equals("~")) || (!patientsArray[4].equals("~")) || (!patientsArray[5].equals("~")))
        {
            checkPatientsNames = true;

        }
    }


    /**+
     * check whether the booths are empty or not, and print a list of  booths that are occupied if the booths are already occupied
     * @param usingBooth is a string array
     */
    public static void checkUsingBooths(String[] usingBooth)
    {
        if ((usingBooth[0].equals("~")) || (usingBooth[1].equals("~")) || (usingBooth[2].equals("~")) || (usingBooth[3].equals("~")) || (usingBooth[4].equals("~")) || (usingBooth[5].equals("~"))) // check
        {
            System.out.println("Booths that already occupied :  ");

            if ((usingBooth[0].equals("~")) && (usingBooth[1].equals("~")) && (usingBooth[2].equals("~")) && (usingBooth[3].equals("~")) && (usingBooth[4].equals("~")) && (usingBooth[5].equals("~")))
            {
                System.out.println("None");
                System.out.println("");
                notUsingBooths = true;

            } else
            {
                for (int i = 0; i < usingBooth.length; i++)
                {
                    if (!usingBooth[i].equals("~"))
                    {

                        System.out.println("    Booth number : " + i);                                                  // prints the occupied booths
                    }
                }

            }
        }
    }


    /**+
     * check whether the booths are empty or not. And if there are empty booths, they will print as a list of empty booths.
     * @param notUsingBooth
     */
    public static void checknotUsingBooths(String[] notUsingBooth)
    {
        if ((notUsingBooth[0].equals("~")) || (notUsingBooth[1].equals("~")) || (notUsingBooth[2].equals("~")) || (notUsingBooth[3].equals("~")) || (notUsingBooth[4].equals("~")) || (notUsingBooth[5].equals("~")))  // check all the booths whether they are empty
        {
            System.out.println("Booths that already empty :  ");

            if ((!notUsingBooth[0].equals("~")) && (!notUsingBooth[1].equals("~")) && (!notUsingBooth[2].equals("~")) && (!notUsingBooth[3].equals("~")) && (!notUsingBooth[4].equals("~")) && (!notUsingBooth[5].equals("~"))) //
            {
                System.out.println("None");
                System.out.println("");
                usingBooths = false;

            } else
            {
                for (int i = 0; i < notUsingBooth.length; i++)
                {
                    if (notUsingBooth[i].equals("~"))                                                                   //check
                    {

                        System.out.println("    Booth number : " + i);                                                  //print the empty booths
                    }
                }
            }
        }
    }


    /**+
     * Store the data without deleting, Able to load the previous stored data
     * @throws IOException
     */
    private static void loadPreviousProgramDataFromFile() throws IOException                                            //referring from W3schools Available from https://www.w3schools.com/java/java_files_read.asp
    {

        File tempData = new File("allProgramData.txt");
        boolean exists = tempData.exists();                                                                             // check the file whether it is available or not

        if (exists)
        {
            File programData = new File("allProgramData.txt");
            Scanner dataReader = new Scanner(programData);
            while (dataReader.hasNext())
            {

                String data = dataReader.nextLine();                                                                    // assigning the string type data from the 'allProgramData' file
                System.out.println(data);                                                                               //print the data in allProgram file to the console

            }

            dataReader.close();                                                                                         // close the file after loading the its data to the console


        } else
        {
            System.out.println("First store your data and load again");                                                 // print a warning message if the does not exists

        }
    }


    /**
     * Get first name and the last name
     */
    public static void getPatientData(){
        System.out.println("Enter the first name of the patient:");
        firstName = input.next();

        System.out.println("Enter the Surname name of the patient:");
        lastName = input.next();

    }
}
