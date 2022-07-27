import java.util.Scanner;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main{
    public static void main(String []args){
        ArrayList<String> modules_catalogue = new ArrayList<>();
        try{
            File readModules = new File("modules.txt");
            Scanner reader = new Scanner(readModules);
            while(reader.hasNextLine()){
                String temp = reader.nextLine();
                modules_catalogue.add(temp);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred while trying to open the file.");
            return;
        }

        int matches = 0;
        Scanner user_input = new Scanner(System.in);
        System.out.print("Please enter a string to search: ");
        String user_pattern = user_input.nextLine();

        long start = System.nanoTime();
        for(int i = 0; i < modules_catalogue.size(); i++){
            boolean check = Naive_algorithm.comparison(modules_catalogue.get(i), user_pattern);
            if(check == true){
                System.out.println(modules_catalogue.get(i));
                matches++;
            }
        }
        System.out.println("Total number of matches: "+ matches);
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("\nAlgorithm execution time: "+ duration + " ms");

        System.out.println("Press enter to colsoe the program...");
        String q = user_input.nextLine();
        user_input.close();

    }
}