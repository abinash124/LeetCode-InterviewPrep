import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class WordBreakProblem {

    //Note:
    //substring(i) = returns substring from index i to the end
    //substring(start,end);

    //function to determine if the string can be segmented into a space-
    //separated  sequence of one or more dictionary words

    public static boolean wordBreak(HashSet<String> dict, String str, int[] lookup){

        //n stores length of current substring
        int n= str.length();


        //return true if we have reached end of the string
        if(n==0){
            return true;
        }

        //if sub-problem is seen for the first time
        if(lookup[n]==-1)
        {
            //mark sub-problem as seen(0 initially assuming String can't be segmented)
            lookup[n]=0;

            for(int i=0; i<=n; i++){

                //consider all prefix of current string
                String prefix = str.substring(0,i);

                //if prefix is found in dictionary then recurse for suffix
                if(dict.contains(prefix) && wordBreak(dict,str.substring(i),lookup)){
                    lookup[n] = 1;
                    return true;

                }


            }
        }


        return lookup[n]==1;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem"));

        //input string
        String str= "Wordbreakproblem";
        int[] lookup = new int[str.length()+1];
        Arrays.fill(lookup,-1);

        if(wordBreak(set, str, lookup)){
            System.out.println("String can be segmented");
        }
        else{
            System.out.println("String can not be segmented");
        }



    }
}
