public
class Main {

    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
    (i, ai). n vertical lines are drawn such that the two endpoints of line i is at
    (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
     such that the container contains the most water.
     */

    /*
    Solution approach:
    Two pointers
    Store current area in max area
    Take the min height between two big heights as height because it can't the length will be minimunm one
    And increase the index of pointer with smaller height and recalculate
    and m
     */
    public static
    int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end])
                start = start + 1;
            else
                end = end - 1;
        }

        return maxArea;

    }


    public static
    void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.print(maxArea(input));
    }
}
