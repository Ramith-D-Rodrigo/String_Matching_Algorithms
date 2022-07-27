import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    
    public static void main(String []args){
        ArrayList<String> modules_catalogue = new ArrayList<>();    //array to store all the modules
        try{
            File readModules = new File("modules.txt");
            Scanner reader = new Scanner(readModules);
            while(reader.hasNextLine()){
                String temp = reader.nextLine();
                modules_catalogue.add(temp);    //adding to the list
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred while trying to open the file.");
            return;
        }

        int matches = 0;

        Scanner user_input = new Scanner(System.in);    //user input string pattern
        System.out.print("Please enter a string to search: ");
        String user_pattern = user_input.nextLine();

        System.out.print("\n");
        long start = System.nanoTime(); //to find the program execution time   (Startinng the timer here to compare only the algorithms)
        for(int i = 0; i < modules_catalogue.size(); i++){  //comparing every model with user input
            boolean check = rabin_karp_algorithm.comparison(modules_catalogue.get(i), user_pattern);    //calling the rabin karp algorithm
            if(check == true){
                System.out.println(modules_catalogue.get(i));   //it was noticed that println takes the most of the execution time
                matches++;
            }
        }

        System.out.println("\nNumber of matches : "+ matches);  //total matches

        long duration = (System.nanoTime() - start)/1000000;    //execution time
        System.out.println("\nAlgorithm execution time: "+ duration +"ms");

        System.out.print("Press enter to close the program...");
        String q = user_input.nextLine();
        user_input.close();
    }
}
