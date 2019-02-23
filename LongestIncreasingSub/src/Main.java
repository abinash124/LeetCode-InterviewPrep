import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Arrays;

public class Main {

    public static int LIS(int[] A){
        //Array to store sub problem solution
        int [] dp = new int[A.length];
        int len = 0;
        for (int num : A){
            int i = Arrays.binarySearch(dp, 0, len, num);
            //if it is not found in the dp
            //binarySearch returns (-(insertionPoint) - 1)
            if( i<0 ){
                i=-(i+1);
            }
            dp[i] = num;
            if(i==len){
                len = len+1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 3, 4, 1, 2, 9, 5, 8 };
        int max = LIS(arr);
        System.out.println(max);
    }
}


