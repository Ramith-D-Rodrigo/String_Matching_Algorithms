public class rabin_karp_algorithm {

    public static boolean comparison(String text, String pattern){
        pattern = pattern.toLowerCase();   //convert the string to lowercase
        long pattern_hash_value = pattern.hashCode();  //generate pattern hash value

        int i = 0;
        int n = text.length();
        int m = pattern.length();
        while(i < n - m + 1){    //considering index out of bound
            String temp = text.substring(i, i+m).toLowerCase();  //convert the current substring to lowercase
            if(pattern_hash_value == temp.hashCode()){  //check both's hash values
                int j;
                for(j = 0; j < m; j++){  //compare the actual pattern and the text
                    if(pattern.charAt(j) != temp.charAt(j)){  //mismatch (spurious hit)
                        System.out.println("Spurious hit");
                        break;
                    }
                }
                if(j == m){  //actual match
                    return true;
                }
            }
            i++;
        }
        return false;
    }
/*     public static long hashValue(String txt){
        long hash = 0;
        int w = txt.length();
        for(int i = 0; i < txt.length(); i++){
            hash = hash + (long)((txt.charAt(i) * Math.pow(2, (w - 1))));
            w--;
        }
        return hash;
    } */
}
