public class Main {

        public void reverseWords(char[] str) {
            //1. Reverse the whole array
            reverse(str, 0, str.length -1);

            //2. Reverse each word

            int start = 0;
            int end = -1;
            for(int i =0; i <str.length ; i++){
                if(str[i]==' '){
                    reverse(str, start, i -1);
                    start = i + 1;
                }
            }
            //3. Reverse last word because there will be no space
            reverse(str, start, str.length-1);


        }

        public void reverse(char[] st, int start, int end ){
            while(start<end){
                char temp = st[start];
                st[start] = st[end];
                st[end] = temp;
                start++;
                end--;
            }
        }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
