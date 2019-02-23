import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//Node represents

//BFS gives shortest path in this case because the weight distance is same in all the case
//So the first path to discover is the shortest one

class Entry{

    int x , y, dist;

    Entry(int x, int y,int dist){
        this.x = x;
        this.y = y;
        this.dist= dist;
    }

}
public class Util {

    // M X N matrix
    private static final int M = 10;
    private static final int N= 10;

    //Below arrays details all 4 possible movements from the cell
    private static final int row[] = {1,0,0,-1};
    private static final int col[] = {0,-1,1,0};

    //Check if the position is valid or not
    private static boolean isValid(int mat[][],boolean visited[][], int row, int col){
        return (row >=0 && col>=0 && row<M && col<N && !visited[row][col] && mat[row][col]==1);
    }

    //Function to find the shortest route
    private static void BFS(int mat[][], int i, int j, int x, int y){
        //Boolean matrix to keep track if the cell is already visited or not
        boolean[][] visited = new boolean[M][N];

        Queue<Entry> q = new ArrayDeque<>();

        //mark source cell as visited and enqueue source cell
        visited[i][j] = true;
        q.add(new Entry(i,j,0));

        //store minimum distance
        int min_dist = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Entry entry= q.poll();

            i = entry.x;
            j = entry.y;
            int dist= entry.dist;

            //if destination is reached find minimum distance and break
            if(i==x && j==y){
                min_dist = dist;
                break;
            }

            //check for all 4 movements from current cell.
            //enqueue each valid movement

            for(int k=0; k<4; k++){
                //check if it is possible to go to position
                //i + row[k], j+ col[k] from current position
                if(isValid(mat,visited,i+row[k], j+col[k])){
                    //mark that position as visited
                    //update distance
                    visited[i+row[k]][j+col[k]]= true;
                    q.add(new Entry(i+row[k],j+col[k], dist+1));
                }
            }

        }

        if(min_dist!= Integer.MAX_VALUE){
            System.out.println("The minimum distance from source to destination has length " + min_dist);
        }
        else{
            System.out.println("There is no path");
        }

    }


    public static void main(String[] args)
    {
        // input maze
        int[][] mat =
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
                };

        // Find shortest path from source (0, 0) to
        // destination (7, 5)
        BFS(mat, 0, 0, 7, 5);
    }
}
