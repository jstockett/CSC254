/**
  Homework 08 in CSC 254 at Missouri Western
 * State University, 2018.
 *
 * @author Jon Stockett jstockett@missouriwester.edu
 * @version 04/25/2018
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args){

        String filename = "critterList.txt";

        if(args.length > 0){
            filename = args[0];
        }
        System.out.printf("Getting Critters from \"%s\"\n", filename);

        ArrayList<Critter> mob = new ArrayList<Critter>();
        getCritters(filename, mob);
        print(mob);


        while(mob.size() > 1){
            int choice;
            System.out.print("\n1) Print players\n" +
                            "2) Battle players\n" +
                            "3) Battle to the very end\n" +
                            "Select option:");
            Scanner input = new Scanner(System.in);
            choice = forceParseInt(input.nextLine().trim());

            switch (choice){
                case 1 : print(mob); break;

                case 2 :
                    Collections.shuffle(mob);
                    for(int i = 1; i < mob.size(); i+=2) {
                        i -= battle(mob.get(i-1), mob.get(i), mob);
                        //adjust index for removed fatalities
                    }


                    break;
                case 3 :
                    while(mob.size() > 1) {
                        Collections.shuffle(mob);
                        for(int i = 1; i < mob.size(); i+=2) {
                            i -= battle(mob.get(i-1), mob.get(i), mob);
                            //adjust index for removed fatalities
                        }
                    }

                default: continue;
            }

        }
        System.out.printf("%s is the last Critter standing.", mob.get(0).getName());


    }

    public static void getCritters(String filename, ArrayList<Critter> list){

        try {
            Scanner input = new Scanner(new File(filename));
            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                String[] attributes;
                attributes = line.split(" ");

                switch (attributes[0].toLowerCase()){
                    case "w" :
                        if(attributes.length >= 2)
                        list.add(new Warrior(attributes[1]));
                        break;
                    case "s":
                        if(attributes.length >= 3)
                        list.add(new Soldier(attributes[1], forceParseDouble(attributes[2])));
                        break;
                    case "t":
                        if(attributes.length >= 6)
                        list.add(new Scout (attributes[1], forceParseDouble(attributes[2]),
                                forceParseDouble(attributes[3]), forceParseDouble(attributes[4]),
                                forceParseDouble(attributes[5])));
                        break;
                    case "z":
                        list.add(new Zombie());
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.err.printf("ERROR, could not open file \"%s\"\n", filename);
            System.exit(1);
        }


    }
    public static int battle(Critter crit01, Critter crit02, ArrayList<Critter> list){
        int fatalities = 0;
        double healthReduction;
        healthReduction = crit02.acceptDamage(crit01.attackEffectiveness());
        System.out.printf("%s %s at %s (%1.0f health damage)\n", crit01.getName(), crit01.attackMessage(),
                crit02.getName(), 100 * healthReduction);

        healthReduction = crit01.acceptDamage(crit02.attackEffectiveness());
        System.out.printf("%s %s at %s (%1.0f health damage)\n", crit02.getName(), crit02.attackMessage(),
                crit01.getName(), 100 * healthReduction);

        if(crit01.isDead()){
            System.out.println(crit01.getName() + " is dead.");
            list.remove(crit01);
            fatalities++;
        }
        if(crit02.isDead()){
            System.out.println(crit02.getName() + " is dead.");
            list.remove(crit02);
            fatalities++;
        }

        return fatalities;
    }
    public static void print(ArrayList<Critter> list){
        Collections.sort(list);
        for(Critter c : list){
            System.out.println(c);
        }
    }

    public static double forceParseDouble(String str){
        double result;
        try{
            result = Double.parseDouble(str);
        } catch (NumberFormatException e){
            result = 0.0;
        }

        return result;
    }
    public static int forceParseInt(String str){
        int result;
        try{
            result = Integer.parseInt(str);
        } catch (NumberFormatException e){
            result = -1;
        }

        return result;
    }
}
