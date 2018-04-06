/**
 * Homework 4, Simple City Class
 * CSC254
 * @author Jon Stockett jstockett@missouriwester.edu
 * @version 03/23/2018
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String city;
        String region;
        String country;
        double latitude;
        double longitude;

        City city0 = new City();
        System.out.println(city0.toString());

        Scanner input = new Scanner(System.in);

        System.out.print("City name? ");
        city0.setCity(input.nextLine().trim());
        System.out.print(city0.toString());

        System.out.print("\nCity name? ");
        city = input.nextLine().trim();

        System.out.print("Region or state? ");
        region = input.nextLine().trim();

        System.out.print("Country? ");
        country = input.nextLine().trim();

        System.out.print("Latitude? ");
        latitude = forceParseDouble(input.nextLine().trim());

        System.out.print("Longitude? ");
        longitude = forceParseDouble(input.nextLine().trim());

        input.close();

        City city1 = new City(city, region, country, latitude, longitude);
        System.out.println(city1.toString());

    }

    public static double forceParseDouble(String str){
        double result;
        try{
            result = Double.parseDouble(str);
        }catch (NumberFormatException e){
            result = 0.0;
        }
        return result;
    }
}
