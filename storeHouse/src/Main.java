import java.util.Arrays;

public class Main {

    static int findMinimumDistance(int []store, int [] house){
        if (store.length==0 || house.length == 0 || store == null || house == null)
            return -1;

        int st = 0;
        int hs = 0;

        int minimumDist = Integer.MAX_VALUE;
        int currentDist = 0;

        Arrays.sort(house);
        Arrays.sort(store);
        while(st<store.length && hs< house.length){

            currentDist = Math.abs(store[st] - house[hs]);
            minimumDist = Math.min(currentDist, minimumDist);

            //Move smaller value
            if(store[st]<house[st]){
                st++;
            }
            else{
                hs++;
            }


        }
        return minimumDist;
    }

    public static void main(String[] args) {

        int [] house = {23 , 47, 54, 78 , 12 , 69, 88};
        int [] store = { 1, 285, 39 };
        int minimum = findMinimumDistance(store, house);
        System.out.print(minimum);
    }
}
