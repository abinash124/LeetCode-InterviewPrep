public class Main {

    public int tap(int height[]){
        int n = height.length;
        int l = 0;
        int r = n -1;
        int water= 0;
        int minHeight =0;
        while(l<r){
            while(l<r && height[l]<=minHeight){
                water += minHeight - height[l++];
            }
            while(r>l && height[r]<=minHeight){
                water += minHeight - height[r--];
            }
            minHeight = Math.min(height[l],height[r]);
        }
        return minHeight;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
