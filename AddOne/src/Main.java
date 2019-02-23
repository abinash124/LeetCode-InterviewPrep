public class Main {

    public static int[] addOne(int digits[]){

        int n = digits.length;
        for (int index = n-1; index>=0;index--){
            if(digits[index]<9){
                digits[index]++;
                return digits;
            }
            digits[index]=0;
        }
        int newArray []= new int[n+1];
        newArray[0] = 1;
        return newArray;


    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int input[]= {9,9,9};
        int output[] = addOne(input);
        System.out.print(output[0]);

    }
}
