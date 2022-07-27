public class Naive_algorithm {
    public static boolean comparison(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        for(int i = 0; i < n - m + 1; i++){
            int j = 0;
            while(j < m && Character.toLowerCase(text.charAt(i+j)) == Character.toLowerCase(pattern.charAt(j))){
                j++;
            }
            if(j == m){
                return true;
            }
        }
        return false;
    }
}
