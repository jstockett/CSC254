/**
 * This program allows users to evaluate the security strength of passwords.
 * It has been developed for Homework 01 in CSC 254 at Missouri Western
 * State University, 2018.
 *
 * @author Jon Stockett jstockett@missouriwester.edu
 * @version 01/20/2018
 */

import java.util.Scanner;

public class PasswordEntropy {

    private static final int MAX_DISPLAY_LENGTH = 20;
    private static final String SPECIAL_CHARACTERS =  "! \"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        //Prompt user and obtain password to be tested
        System.out.print("Please enter password to be tested for security level or \"q\" to quit: ");


        while(input.hasNextLine()) {
            String password = input.nextLine();

            //If user prompts quit, exit program
            if (password.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            //Print header
            System.out.printf("\n%-24s%-9s%-13s%-13s%-21s%-9s%-10s%-16s\n", "Password", "| Digit", "| Upper Case",
                    "| Lower Case", "| Special Characters", "| Length", "| Entropy", "| Quality Rating");
            //Print values
            System.out.printf("%-24s%-9s%-13s%-13s%-21s%-9s%-10s%-16s\n\n", truncateString(password),
                    "| " + hasDigit(password), "| " + hasUpperCase(password), "| " + hasLowerCase(password),
                    "| " + countSpecialCharacters(password), "| " + trimmedLength(password),
                    "| " + entropy(password), "| " + evaluateEntropy(entropy(password)));

            System.out.print("Please enter password to be tested for security level or \"q\" to quit: ");
        }
    }

    /** This method returns the number of unique special characters used in string.*/
    public static int countSpecialCharacters(String str) {
        int specCharCount = 0;
        for (int i = 0; i < SPECIAL_CHARACTERS.length(); i++) {
            if (str.contains(SPECIAL_CHARACTERS.substring(i, i + 1))) {
                specCharCount++;
            }
        }
        return specCharCount;
    }


    /** This method returns true if the password contains a digit */
    public static boolean hasDigit(String str){
        boolean found = false;

        //loop checks each char in string for digit and stops looking when first digit found
        int i = 0;
        while(i < str.length() && !found) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                found = true;
            }
            i++;
        }
        return found;
    }

    /** This method returns true if password contains at least one uppercase letter */
    public static boolean hasUpperCase(String str){
        boolean found = false;

        //loop checks each char in string for uppercase and stops looking when first uppercase found
        int i = 0;
        while(i <str.length() && !found){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                found = true;
            }
            i++;
        }
        return found;
    }
    /** This method returns true if password contains at least one lowercase letter */
    public static boolean hasLowerCase(String str){
        boolean found = false;

        //loop checks each char in string for uppercase and stops looking when first uppercase found
        int i = 0;
        while(i < str.length() && !found){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                found = true;
            }
            i++;
        }
        return found;
    }

    /** This method returns trimmed length of password */
    public static int trimmedLength(String str){
        str = str.trim();
        return str.length();
    }

    /** This method truncates password to MAX_DISPLAY_LENGTH and adds ellipses to end if password longer than
     * MAX_DISPLAY_LENGTH.
     */
    public static String truncateString(String str){
        str = str.trim();
        if(str.length() > MAX_DISPLAY_LENGTH){
            str = str.substring(0, MAX_DISPLAY_LENGTH) + "...";
        }
        return str;
    }

    /** This method returns log of double in base 2 */
    public static double log2(double x){
        double result = Math.log(x) / Math.log(2);
        return result;
    }

    /** This method returns the range of the password */
    public static int calculateRange(String str){
        int range = 0;
        if(hasUpperCase(str)){
            range = range + 26;
        }
        if(hasLowerCase(str)){
            range = range + 26;
        }
        if(hasDigit(str)){
            range = range + 10;
        }
        range = range + countSpecialCharacters(str);
        return range;
    }

    /** This method calculates and returns password entropy. */
    public static int entropy(String str){
        if(str.length() == 0){ //don't raise zero to zero power
            return  0;
        }
        int result = (int)Math.round(log2((Math.pow(calculateRange(str), str.length() - 1))));

        return result;
    }

    /** This method returns a quality rating of the password entropy */
    public static String evaluateEntropy(int entropy){
        if(entropy <= 64){
            return "Very Weak";
        }
        if(entropy >= 65 && entropy <= 80){
            return "Weak";
        }
        if(entropy >= 81 && entropy <= 112){
            return "Moderate";
        }
        if(entropy >= 113 && entropy <= 128){
            return "Strong";
        }
        //Last return statement covers cases over 128
        return "Very Strong";
    }
}
