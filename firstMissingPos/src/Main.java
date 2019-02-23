public class Main {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i< nums.length; i++){
            if( nums[i]>0 && nums[i]<nums.length && nums[nums[i] -1] != nums[i] ){
                swap(nums[i],nums[nums[i]-1]);
            }
        }

        for (int i =0; i< nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }

        return nums.length + 1;

    }

    public static void swap(int a, int b){

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
