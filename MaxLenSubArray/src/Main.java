import java.util.HashMap;
import java.util.Map;

public class Main {


    //Maximum len sub array summing to S
    public static int maxLenSubArray(int[] A , int S){

        //len of sub array
        int len = 0;


        Map<Integer, Integer> map = new HashMap<>();

        //sub array to store sum from index 0
        //sum,index
        //for sum 0 index is -1
        map.put(0,-1);

        int sum = 0;

        int ending_index = 0;

        for(int i = 0; i < A.length; i++){
            sum += A[i];

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

            if(map.containsKey(sum-S) && len < i - map.get(sum-S)){
                len = i - map.get(sum-S);
                ending_index = i;
            }
        }

        return len;



    }

    public static void maxLenSubArrayBinary(int[] A){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,-1);

        int len= 0;
        int ending_index = -1;

        int sum = 0;

        //Traverse through the given array

        for(int i = 0; i < A.length; i++){
            sum += (A[i]==0) ? -1:1;

            if(map.containsKey(sum)){

                if(len < i - map.get(sum)){
                    len = i - map.get(sum);
                }


            }
            else{
                map.put(sum, i);
            }
        }

        System.out.print(len);
    }

    public static void main(String[] args) {
	// write your code here
    }
}
