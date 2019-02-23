public class Main {

    public static void moveZeroes(int[] nums) {

        if (nums==null || nums.length==0) return;

        int insertPos = 0;
        for(int num : nums){
            if (num!=0)
                nums[insertPos++] = num;

        }
        while(insertPos<nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int [] myArray= {1,2,6,0,0,1,2,8,0,7,8};
        moveZeroes(myArray);
        for(int num: myArray){
            System.out.print(num);
        }

    }
}
