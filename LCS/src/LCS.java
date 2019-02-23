import java.util.HashMap;
import java.util.Map;

public class LCS {

    //Problem :
    /*
    X : ABCBDAB
    Y : BDCABA
    Output: length is 4 and LCS are BDAB, BCAB and BCBA
     */

    //Function to find length of Longest common substring
    public static int LCSlength(String X, String Y, int m, int n, Map<String,Integer> dictionary){
        //Base case:
        //If we reach to the end of both the strings then return 0
        if (m==0 || n==0){
            return 0;
        }

        //Construct a unique map key that look up for the same string index
        String index = m + "|" + n;

        if(!dictionary.containsKey(index)){
            //if last char of X and Y matches then
            if(X.charAt(m-1)==Y.charAt(n-1)){
                dictionary.put(index, LCSlength(X, Y, m-1, n-1, dictionary)+1);
            }
            else{
                dictionary.put(index, Integer.max(LCSlength(X,Y,m-1,n,dictionary),LCSlength(X,Y,m,n-1,dictionary)));
            }
        }

        return dictionary.get(index);

    }


    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The length of LCS is "+ LCSlength(X, Y, X.length(), Y.length(), lookup));
    }
}
