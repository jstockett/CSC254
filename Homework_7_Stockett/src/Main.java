/**
  Homework 07 in CSC 254 at Missouri Western
 * State University, 2018.
 *
 * @author Jon Stockett jstockett@missouriwester.edu
 * @version 04/25/2018
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String filename = "players";

        if(args.length > 0){
            filename = args[0];
        }

        ArrayList<Critter> players = new ArrayList<>();
        getPlayers(filename, players);

        Collections.sort(players);

        for(Critter c : players){
            System.out.println(c);
        }



    }
    public static void getPlayers(String filename, ArrayList<Critter> list){

        try {
            Scanner input = new Scanner(new File(filename));
            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                String[] attributes;
                attributes = line.split(" ");

                switch (attributes[0]){
                    case "W": list.add(new Warrior(attributes[1])); break;
                    case "S": list.add(new Soldier(attributes[1], Double.parseDouble(attributes[2]))); break;
                    case "T": list.add(new Scout (attributes[1], Double.parseDouble(attributes[2]),
                            Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]),
                            Double.parseDouble(attributes[5]))); break;
                    case "Z": list.add(new Zombie()); break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.err.printf("ERROR, could not open file \"%s\"\n", filename);
            System.exit(1);
        }


    }
}
