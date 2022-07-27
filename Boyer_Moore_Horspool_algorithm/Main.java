import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String []args) throws IOException{
        ArrayList<String> modules_catalogue = new ArrayList<>();
        try{
            File readModules = new File("modules.txt");
            Scanner reader = new Scanner(readModules);
            while(reader.hasNextLine()){
                String temp = reader.nextLine();
                modules_catalogue.add(temp);    //add the current reading module to the list
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred while trying to open the file.");
            return;
        }

        int []matches = new int[1]; //have to pass this value into the function modify when a match is found
        matches[0] = 0; //initial matches

        Scanner user_input = new Scanner(System.in);
        System.out.print("Please enter a string to search: ");  //getting user input
        String user_pattern = user_input.nextLine();

        Map<Character, Integer> HpBc_Table = Boyer_Moore_Horspool_algorithm.horspool_table(user_pattern);   //creating the horspool table for the user input string

        System.out.println("\n");
        long start = System.nanoTime(); //to find the program's execution time (Starting the time here to compare only the algorithms)
        for(int i = 0; i < modules_catalogue.size(); i++){
            boolean check  = Boyer_Moore_Horspool_algorithm.Comparison(modules_catalogue.get(i), user_pattern, HpBc_Table, matches); //calling the boyer-moore-horspool algorithm
            if(check == true){ //found a pattern
                System.out.println(modules_catalogue.get((i))); //println takes the most of the execution time
            }
        }

        System.out.println("\nNumber of matches: "+ matches[0]);
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("\nAlgorithm execution time: "+ duration + " ms");

        System.out.print("Press enter to close the program...");
        String q = user_input.nextLine();
        user_input.close();
    }
}
