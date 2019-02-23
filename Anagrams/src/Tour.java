import java.util.ArrayList;
import java.util.List;
class Node{
    int first,second;

    public Node(int first, int second){
        this.first =first;
        this.second = second;
    }

    @Override
    public boolean equals(Object ob){
        Node node = (Node)ob;
        return (first == node.first && second == node.second);
    }

    @Override
    public int hashCode(){
        return 31*first + second;
    }
}

public class Tour {

    //N*N matrix
    private static final int N = 10;

    // Below arrays are four possible movements from a cell
    private static final int row[] = {-1,0,0,1};
    private static final int col[] = {0,-1,1,0};

    //function to check if it is possible to go to position pt
    //from current position. The function returns false if pt
    //is not a valid position or it is already visited

    private static boolean isValid(List<Node> path, Node pt){

        return pt.first >= 0 && pt.second >=0 && pt.first< N && pt.second < N &&!path.contains(pt);
    }

    private static void printPath(List<Node> path){
        for (Node cell: path){
            System.out.println("(" + cell.first+ ", " + cell.second+")");
        }

    }

    private static boolean findPath(int mat[][], List<Node> path, Node curr){
        //include current vertex in the path
        path.add(curr);

        //if destination is found, return true
        if(curr.first==N-1 && curr.second==N-1)
            return true;

        //value of current cell
        int currVal = mat[curr.first][curr.second];

        //check all 4 possible movements from current cell
        //and recurse for valid movements

        for (int i = 0; i<4; i++){
            int x = curr.first + row[i]*currVal;
            int y= curr.second + row[i]*currVal;

            Node next = new Node(x,y);

            if(isValid(path,next) && findPath(mat,path,next))
                return true;
        }
        path.remove(path.size()-1);

        return false;
    }



    public static void main(String[] args) {
	// write your code here
        int mat[][] =
                {
                        { 7, 1, 3, 5, 3, 6, 1, 1, 7, 5 },
                        { 2, 3, 6, 1, 1, 6, 6, 6, 1, 2 },
                        { 6, 1, 7, 2, 1, 4, 7, 6, 6, 2 },
                        { 6, 6, 7, 1, 3, 3, 5, 1, 3, 4 },
                        { 5, 5, 6, 1, 5, 4, 6, 1, 7, 4 },
                        { 3, 5, 5, 2, 7, 5, 3, 4, 3, 6 },
                        { 4, 1, 4, 3, 6, 4, 5, 3, 2, 6 },
                        { 4, 4, 1, 7, 4, 3, 3, 1, 4, 2 },
                        { 4, 4, 5, 1, 5, 2, 3, 5, 3, 5 },
                        { 3, 6, 3, 5, 2, 2, 6, 4, 2, 1 }
                };

        List<Node> path = new ArrayList<>();
        Node source = new Node(0, 0);

        // Find route in a matrix mat from source cell (0, 0) to
        // destination cell (N-1, N-1)
        if (findPath(mat, path, source))
            printPath(path);
    }








}
