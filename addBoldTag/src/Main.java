public class Main {

        public static String addBoldTag(String s, String[] dict) {
            boolean[] bold =  new boolean[s.length()];

            for(int i =0, end=0; i<s.length(); i++){
                for(String word: dict){

                    //startsWith returns if the string starts with that substring at that specified index
                    if(s.startsWith(word,i)){
                        end = Math.max(end, i+word.length());
                        //even if the overlapping structure is found we mark all of them in overlapped structure as bold.
                    }
                }
                //bold will be updated until the end of the word is found for each char
                //because the value of end is stored at word length index away from current index
                //until we reach that index then all the char in that word are bold
                bold[i] = end > i ;

            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                //if it is not bold just append in the string builder and continue without any other operation
                if(!bold[i]){
                    sb.append(s.charAt(i));
                    continue;
                }
                //runner pointer to mark current bold char to end bold char
                int j = i;
                while(j < s.length() && bold[j] ) j++;

                //after that append in the string builder as suggested formatting
                sb.append("<b>"+ s.substring(i,j)+"</b>");
                i = j - 1;
            }


            return sb.toString();

        }


    public static void main(String[] args) {
        String[] dict = {"abc" , "123"};
        String s = "abcxyz123";
        String formatted = addBoldTag(s, dict);
        System.out.println("Hello World!");
    }
}
