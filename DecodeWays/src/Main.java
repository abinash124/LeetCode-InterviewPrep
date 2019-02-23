public class Main {
    public static int numDecodings(String s){

        if(s==null || s.length()==0){
            return 0;
        }
        int n= s.length();
        //One large size to account for empty string
        int[] dp = new int[n+1];

        //dp[0] stores 0 because an empty string has 0 ways to decode itself
        dp[0] = 1;
        dp[1] = s.charAt(0)!= '0' ? 1 : 0;

        //Now start from second index
        for(int i = 2; i <= n; i++) {
            //if we take first as
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            if (first>=1 && first <=9){
                dp[i] += dp[i-1];

            }

            if (second>= 10 && second <= 26){
                dp[i] += dp[i-2];
            }


        }

        return dp[n];
    }

    public static void main(String[] args) {
        String input = "226";
        int ways = numDecodings(input);
        System.out.print(ways);
    }
}
