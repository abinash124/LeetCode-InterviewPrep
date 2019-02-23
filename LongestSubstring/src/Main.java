import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final int CHAR_RANGE = 128;

    public static void main(String[] args) {
        String str = "abcbdbdbbdcdabd";
        int k = 2;

        System.out.print(longestSubstring(str, k));    }

    public static String longestSubstring(String str, int k){
        //stores longest substring boundaries
        int end=0, begin = 0;

        //Set to store distinct characters in window
        Set<Character> window = new HashSet<>();

        //count hashmap to store frequency of characters in
        //current window

        HashMap<Character,Integer> freqCount = new HashMap<>();

        for (int low= 0, high=0; high< str.length(); high++){
            window.add(str.charAt(high));
            if(freqCount.get(str.charAt(high))==null){
                freqCount.put(str.charAt(high),1);
            }
            else {

                freqCount.put(str.charAt(high), freqCount.get(str.charAt(high)) + 1);
            }

            //if window size is greater than k
            while(window.size() > k){
                int value = freqCount.get(str.charAt(low)) == null ? 0: freqCount.get(str.charAt(low));
                freqCount.put(str.charAt(low),--value);
                if(value==0){

                    window.remove(str.charAt(low));

                }
            low++; //reduce the window size
            }

            //update window size if necessary
            if(end - begin < high - low){
                end = high;
                begin = low;
            }

        }

        return str.substring(begin,end+1);



    }
}
