import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public
class Main {


    public static
    int findString(String big, String small) {
        HashMap<Character, Integer> map = new HashMap<>();

        int counter; //To check if the substring is valid
        int begin = 0;// Start of substring
        int end = 0;
        //End of substring
        int len = Integer.MAX_VALUE; //length of substring

        String substr = "";

        List<Integer> anagramIndex = new ArrayList<>();

        int min = big.length();

        //Hashmap to store count of all characters
        for (char c : small.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counter = map.size();
        while (end < small.length()) {

            if (map.containsKey(big.charAt(end))) {
                map.put(big.charAt(end), map.get(big.charAt(end)) - 1);

                if (map.get(big.charAt(end)) == 0) {
                    counter--;

                }
            }

            end++;

            //if counter == 0 then we have found out the solution
            //we try to trim the window by sliding the window to the right

            while (counter == 0) {

                //To find index of all possible anagrams
                if(end - begin == small.length()){
                    anagramIndex.add(begin);
                }


                //Store new answer than previously found
                if (end - begin < len) {
                    len = end - begin;
                    substr = big.substring(begin, end - begin);
                    min = Math.min(min, len);

                    char startChar = big.charAt(begin);
                    //if current char exists in the map then increase it counter
                    if (map.get(startChar) != null) {
                        map.put(startChar, map.get(startChar) + 1);
                        if (map.get(startChar) > 0)
                            counter++;


                    }

                }
                begin++;
            }
        }
        return min;
    }


    //Longest subsequence with most two chars

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if(s.length() < 1)
            return 0;


        HashMap<Character,Integer> lastSeen = new HashMap<Character, Integer>();

        int low = 0;
        int high = 0;

        int maxLen = 0;

        while(high < s.length()){
            if(lastSeen.size() <=2){
                char c = s.charAt(high);
                lastSeen.put(c, high);
                high++;
            }

            else{
                int leftMost = s.length();
                for(int i : lastSeen.values()){
                    leftMost = Math.min(leftMost, i);
                }

                char c = s.charAt(leftMost);
                lastSeen.remove(c);
                low = leftMost + 1;
            }
            maxLen = Math.max(maxLen, high- low);

        }
        return maxLen;




    }





    public static
    void main(String[] args) {
        System.out.println("Hello World!");
    }
}
