import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main{

    public static void main(String []args) throws IOException{
        ArrayList<String> modules_catalogue = new ArrayList<>();
        try{
            File readModules = new File("modules.txt");
            Scanner reader = new Scanner(readModules);
            while(reader.hasNextLine()){
                String temp = reader.nextLine();
                modules_catalogue.add(temp);  //adding the current reading module to the list
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred while trying to open the file.");
            return;
        }

        int []matches = new int[1];
        matches[0] = 0;

        Scanner user_input = new Scanner(System.in);    //getting user input
        System.out.print("Please enter a string to search: ");
        String user_pattern = user_input.nextLine();

        System.out.print("\n");
        int []pi = kmp_algorithm.prefix_function(user_pattern); //creating the pi table for the user input string

        long start = System.nanoTime(); //to find the program's execution time (Startinng the timer here to compare only the algorithms)
        for(int i = 0; i < modules_catalogue.size(); i++){    //comparing every module with user input
            boolean check = kmp_algorithm.comparison(modules_catalogue.get(i), user_pattern, pi, matches);   //calling kmp algorithm
            if(check == true){  //found a pattern
                System.out.println(modules_catalogue.get(i));   //it was noticed that println takes the most of the execution time
            }
        }

        System.out.println("\nNumber of matches: " + matches[0]); //number of total matches

        long duration = (System.nanoTime() - start)/1000000;    //execution time
        System.out.println("\nAlgorithm execution time: " + duration+"ms");

        System.out.print("Press enter to close the program...");
        String q = user_input.nextLine();
        user_input.close();
        
    }
}