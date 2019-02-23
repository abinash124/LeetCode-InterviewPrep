import java.util.List;
public class Main {

    public static boolean wordBreak(String s, List<String> dict){
        boolean []f = new boolean[s.length()+1];

        f[0] = true;

        for(int i =1; i <=s.length(); i++){
            for (String str: dict){
                if(str.length() <= i){
                    if(f[str.length() - i]){
                        if(str.substring(i-str.length(),i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[s.length()];

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
