public class Main {

    public int characterReplacement(String s, int k){
        int len = s.length();

        int [] count = new int [26];
        int start = 0, maxCount = 0, maxLength = 0;
        //currLen = end - start
        for(int end =0; end<len ; end++){
            maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
            while(end - start +1 -maxCount >k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start +1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
