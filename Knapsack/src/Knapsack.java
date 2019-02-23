import java.util.Map;
import java.util.HashMap;

public
class Knapsack {

    public static
    void main(String[] args) {
        // Driver code
        //Input
        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};

        // Knapsack capacity
        int W = 10;

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("Knapsack value is " +
                knapSack(v, w, v.length - 1, W, lookup));
    }

    //Values(stored in array v)
    //Weights(stored in array w)
    //n = Number of distinct items(n)
    //Knapsack capacity = W

    public static
    int knapSack(int[] v, int[] w, int n, int W, Map<String, Integer> lookUp) {

        //Base case : Negative Capacity
        if (W < 0) {
            return Integer.MIN_VALUE;
        }
        //If there are no items left or the knapsack is full
        if (n < 0 || W == 0) {
            return 0;
        }

        String key = n + "|" + W;

        //If sub-problem is seen for the first time, solve it and
        //store it in the map
        if (!lookUp.containsKey(key)) {
            //Case 1: Include current item in the knapsack (v[n]) &
            //recurse for remaining items (n-1) in with decreased capacity: W- w[n]
            int include = v[n] + knapSack(v, w, n - 1, W - w[n], lookUp);

            //Case 2: Exclude current item in the knapsack and
            //recurse for remaining items(n-1) with same capacity

            int exclude = knapSack(v, w, n - 1, W, lookUp);

            lookUp.put(key, Integer.max(include, exclude));
        }

        //return the value we get by incluiding or excluiding current item
        return lookUp.get(key);

    }
}
