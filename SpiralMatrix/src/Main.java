import java.util.List;
import java.util.LinkedList;

public
class Main {


    public static
    List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        //Edge case:
        if (matrix == null || matrix.length == 0)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;

        int up = 0, bottom = row - 1;
        int left = 0, right = col - 1;

        //Insert until you have inserted all the elements from the matrix
        //i.e unless the size of list and matrix is the same

        while (result.size() < row * col) {

            //Going from top left to top right
            for (int curr = left; curr <= right && result.size() < row * col; curr++) {
                result.add(matrix[up][curr]);
            }

            //Going from top right to bottom right
            //Every vertical movement add one to the up and subtract one from bottom to cover for duplicates
            for (int curr = up + 1; curr <= bottom - 1 && result.size() < row * col; curr++) {
                result.add(matrix[curr][right]);
            }

            //Going from bottom right to bottom left
            for (int curr = right; curr >= left && result.size() < row * col; curr--) {
                result.add(matrix[bottom][curr]);
            }

            //Going from  bottom left to bottom right
            //Vertical movement same case
            for (int curr = bottom - 1; curr >= up + 1 && result.size() < row * col; curr--) {
                result.add(matrix[curr][left]);
            }
            left++;
            right--;
            up++;
            bottom--;

        }
        return result;

    }


    public static
    void main(String[] args) {

        int [][]input ={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> spiralOrder = spiralOrder(input);
        System.out.print(spiralOrder);

    }
}
