import java.util.*;


public class Boyer_Moore_Horspool_algorithm {
    public static Map<Character, Integer> horspool_table(String pattern){
        Map<Character, Integer> HpBc_Table = new HashMap<Character, Integer>(); //creating an empty horspool table
        int m = pattern.length(); 
        for(int i = 0; i < m; i++){ //initializing the horspool table with pattern alphabet
            HpBc_Table.put(Character.toLowerCase(pattern.charAt(i)), m);    //make sure to convert into lowercase to ensure case insensitivity
        }
        //System.out.println(Arrays.asList(HpBc_Table));

        for(int j = 0; j < m - 1; j++){ //find the right most occurence
            HpBc_Table.replace(Character.toLowerCase(pattern.charAt(j)), (m - j - 1));  
        }
        //System.out.println(Arrays.asList(HpBc_Table));    
        return HpBc_Table;
    }
    public static boolean Comparison(String text, String pattern, Map<Character, Integer> hpbc, int[] match_count){
        int pos = 0;
        int n = text.length();
        int m = pattern.length();
        int j;
        boolean flag = false;   //to store pattern's availability
        while(pos < n - m + 1){
            j = m - 1;
            while(j >= 0  && Character.toLowerCase(text.charAt(pos+j)) == Character.toLowerCase(pattern.charAt(j))){    //remember that java is 0 indexed
                j = j - 1;
            }
            if(j == -1){    //pattern found
                flag = true;
                match_count[0]++;
            }
            char temp = Character.toLowerCase(text.charAt(pos+m-1));
            if(hpbc.get(temp) == null){ //found a character in the text that is not available in the pattern
                pos = pos + m;
            }
            else{
                pos = pos + hpbc.get(temp); //shift according to horspool table
            }
        }
        return flag;
    }

}
