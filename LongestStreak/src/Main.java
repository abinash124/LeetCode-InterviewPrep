import java.util.Set;
import java.util.HashSet;

public class Main {

    int longestStreak(int[] arr){
    Set<Integer> set = new HashSet<>();
    int max = 0;
    int x =0;
    for(int e : arr){
        set.add(e);

    }

    for (Integer e : set){
        if(set.contains(e-1)) continue;
        x= e +1;
        while(set.contains(x)) {
            x++;
        }

        max = Math.max(max, x -e);
    }
    return max;


    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
