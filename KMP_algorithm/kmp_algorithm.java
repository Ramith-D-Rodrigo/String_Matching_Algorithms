import java.util.Arrays;

public class kmp_algorithm {
    public static int[] prefix_function(String pattern){
        int m = pattern.length();   //pattern length
        int []pi = new int[m];   //pi table
        
        int k = 0;
        pi[0] = 0;  //0 indexed
        for(int j = 1; j < m; j++){
            while(k > 0 && Character.toLowerCase(pattern.charAt(k)) != Character.toLowerCase(pattern.charAt(j))){   //with the addition of case insensitivity
                k = pi[k-1];    //k-1 because pi table is 0 indexed 
            }
            if(Character.toLowerCase(pattern.charAt(k)) == Character.toLowerCase(pattern.charAt(j))){
                k++;
            }
            pi[j] = k;
        }
        return pi;
    }
    public static boolean comparison(String text, String pattern, int []pi, int []match_count){
        int i = 0;
        //System.out.println("comparing "+ text+" and "+ pattern);
        //System.out.println(Arrays.toString(pi));  //pi table check
        int n = text.length();
        int m = pattern.length();
        boolean flag = false;
        for(int j = 0; j < n; j++){
            while(i > 0 && Character.toLowerCase(pattern.charAt(i)) != Character.toLowerCase(text.charAt(j))){
                i = pi[i-1];
            }
            if(Character.toLowerCase(pattern.charAt(i)) == Character.toLowerCase(text.charAt(j))){
                i++;
            }
            if(i == m){ //pattern found inside the text
                //return true;    //no need to continue
                flag = true;
                match_count[0]++;
                i = pi[i-1];
            }
        }       
        return flag;
    }
}
