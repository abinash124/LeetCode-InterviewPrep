public class Palindrome {

    //Helper function
    //expand in both directions of low and high to find
    //maximum length palindrome
    public static String expand(String str,int low, int high){
        int len = str.length();

        //expand in both directions
        while(low >= 0 && high<len && (str.charAt(low)==str.charAt(high))){
            low--;
            high++;
        }
        return str.substring(low + 1, high);
    }

    //function to find longest palindromic substring
    public static String LongestPalindromicSubstring(String str, int len){
        //max_str stores the maximum length palindromic substring
        //found so far

        String max_str = "", curr_str;

        int max_length = 0, curr_length;

        //consider every adjacent pairs of characters as midpoints
        //and expand in both directions to find maximum length palindrome

        for(int i = 0; i< len; i++){
            //find longest odd length palindrome with str[i] as midpoint
            curr_str = expand(str,i,i);
            curr_length = curr_str.length();
            if(curr_length>max_length){
                max_length = curr_length;
                max_str = curr_str;
            }

            //find longest even lenght palidrome with str[i] and
            //str[i+1] as mid points

            curr_str = expand(str, i , i+1);
            curr_length=curr_str.length();
            if(curr_length>max_length){
                max_length = curr_length;
                max_str = curr_str;
            }

        }
        return max_str;

    }

    public static void main(String[] args) {
        String str = "ABDCBCDBDCBBC";

        System.out.println("Longest Palindromic SubString of " + str + " is "
                + LongestPalindromicSubstring(str, str.length() - 1));    }


}
