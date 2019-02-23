import java.util.HashMap;
import java.util.Map;

public class MinPartition {

    public static void main(String[] args)
    {
        // Input: set of items
        int[] S = { 10, 20, 15, 5, 25 };
        Map<String, Integer> dictionary = new HashMap<>();


        System.out.println("The minimum difference is "+ minPartition(S,S.length - 1,0, 0,dictionary));
    }

    public static int minPartition(int[]S, int n, int S1, int S2, Map<String, Integer> dictionary){
        //if the list is empty return the absolute difference between two arrays
        if (n<0)
            return Math.abs(S1-S2);

        String index = n + "|" + S1;

        if(!dictionary.containsKey(index)){
            //if it is included include in thet first array
            int include =  minPartition(S,n-1, S1+S[n],S2, dictionary);

            //if it is not included then int should be included in the second array
            int exclude = minPartition(S, n-1, S1,S2+S[n],dictionary);
            //Get minimum value of the difference when you include the current value
            //And exclude the current value
            dictionary.put(index, Integer.min(include,exclude));

        }

        return dictionary.get(index);



    }




}
