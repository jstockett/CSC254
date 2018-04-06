/**
 * This program takes three arguments from the command line - filename of common passwords
 * to read into an array - number of lines to read from common passwords - filename of user
 * passwords to compare to common passwords.  User passwords are not stored in an array, only
 * read.  It will show the total number of user passwords, their average length, the shortest
 * and longest length and the number of matches on the common password list.
 * It has been developed for Homework 03 in CSC 254 at Missouri Western
 * State University, 2018.
 *
 * @author Jon Stockett jstockett@missouriwester.edu
 * @version 03/01/2018
 */





import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompareLists {
    public static void main(String[] args){

        //default args
        String commonPasswordsFilename = "commonPasswords.txt";
        int numberOfLinesToRead = 100;
        String userPasswordsFilename = "users.txt";

        //assign actual args if they exist
        if(args.length > 0){
            commonPasswordsFilename = args[0];
        }
        if(args.length > 1 && forceParseInt(args[1]) > -1){
            numberOfLinesToRead = forceParseInt(args[1]);
        }
        if(args.length > 2){
            userPasswordsFilename = args[2];
        }

        String[] commonPasswordsList = new String[numberOfLinesToRead];

        //read file into array and return logical array length
        int n = readFromFile(commonPasswordsFilename, numberOfLinesToRead, commonPasswordsList);

        //selection sort array
        selectionSort(commonPasswordsList, n);

        int numberOfMatches = 0;
        int numberOfUserPasswords = 0;
        int shortestUserPasswordLength = Integer.MAX_VALUE;
        int longestUserPasswordLength = -1;
        int sumTotalPasswordLength = 0;

        //Read from user passwords file
        try {
            Scanner input = new Scanner(new File (userPasswordsFilename));
            while(input.hasNextLine()){
                String userPassword = input.nextLine().trim();

                if(userPassword.length() < 1){
                    continue;
                }

                numberOfUserPasswords++;
                sumTotalPasswordLength += userPassword.length();

                if(userPassword.length() < shortestUserPasswordLength){
                    shortestUserPasswordLength = userPassword.length();
                }
                if(userPassword.length() > longestUserPasswordLength){
                    longestUserPasswordLength = userPassword.length();
                }

                //use binary search to look for user password on common list method returns -1 if not found
                int matchIndex = binarySearch(userPassword, commonPasswordsList, n);

                if(matchIndex > -1){
                    numberOfMatches++;
                }
            }
            input.close();
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.err.printf("Error could not open file \"%s\"\n", userPasswordsFilename);
            System.exit(1);
        }

        //Print userPasswordsFilename statistics
        System.out.printf("The total number of user passwords is %d.\n" +
                "The average password length is %1.1f characters.\n" +
                "The shortest passwords are %d characters.\n" +
                "The longest passwords are %d characters.\n",
                numberOfUserPasswords, ((double)sumTotalPasswordLength)/numberOfUserPasswords,
                shortestUserPasswordLength, longestUserPasswordLength);

        System.out.printf("There are %d user passwords on common passwords list.\n" +
                "%d%% of user passwords are on common passwords list.\n",
                numberOfMatches, (int)(Math.round(numberOfMatches*100.0)/numberOfUserPasswords));

    }
    /**This method performs a selection sort on a String array*/
    public static void selectionSort(String[] list, int n){
        for(int i = 0; i < n-1; i++){
            String currentMin = list[i];
            int currentMinIndex = i;

            for(int k = i+1; k < n; k++){
                if(currentMin.compareTo(list[k]) > 0){
                    currentMin = list[k];
                    currentMinIndex = k;
                }
            }
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**This method reads the requested number of passwords from a file and stores them in an array*/
    public static int readFromFile(String filename, int maximum, String[] list){
        int n = 0;

        try {
            Scanner input = new Scanner(new File(filename));
            String line;
            while(input.hasNextLine() && n < maximum){
                line = input.nextLine().trim();
                if(line.length() < 1){
                    continue;
                }
                list[n] = line;
                n++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.err.printf("Error could not open file \"%s\"\n", filename);
            System.exit(1);
        }
        return n;
    }
    /**This method performs a binary search and returns index if found and -1 if not found*/
    public static int binarySearch(String keyword, String[] list, int n){
        if(list == null || list[0] == null) {
            return -1;
        }

        int matchIndex = -1;
        int low = 0;
        int high = n - 1;

        while(high >= low && matchIndex == -1){
            int mid = (low + high) / 2;
            if(keyword.compareTo(list[mid]) < 0){
                high = mid - 1;
            }
            else if(keyword.equals(list[mid])){
                matchIndex = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return matchIndex;
    }

    /**This method tries to parse integer from string and returns -1 if it fails*/
    public static int forceParseInt(String str){
        int number;
        try{
            number = Integer.parseInt(str);
        }catch (NumberFormatException e){
            number = -1;
        }

        return number;
    }

}
