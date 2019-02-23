public class Path {
    //Backtracking problem to find longest possible path in matrix


    //M X N matrix
    private static final int M = 10;
    private static final int N = 10;
    private static final int[] row = { 1,0,0,-1 };
    private static final int[] col = {0,-1,1,0 };


    //Check if it is possible to go to position (x,y) from
    //current position. The function returns false if the cell has
    //value 0 or is already visited and check if the position is valid or not

    public static boolean isValid(int x, int y,int mat[][], boolean visited[][]){
        return (x>=0 && y>=0 && x <M && y<N) && !(mat[x][y] == 0 || visited[x][y]);
    }


    public static int longestPath(int mat[][], boolean visited[][], int i, int j, int x, int y, int max_dist, int dist){
        //Base case:
        //If destination is found
        if (i==x && j== y){
            return Integer.max(dist, max_dist);
        }

        //set current position as visited
        visited[i][j] = true;
        for(int k=0;k<4;k++){
        if(isValid(i+row[k],j+col[k],mat,visited)){

            max_dist = longestPath(mat,visited,i+row[k],j+col[k],x,y,max_dist,dist+1);

            }
        }
        visited[i][j] = false;
        return max_dist;


    }
    public static void main(String[] args) {
        // input matrix
        int mat[][] =
                {
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
                };

        // construct a matrix to keep track of visited cells
        boolean[][] visited= new boolean[N][M];


        int max_dist = longestPath(mat, visited, 0, 0, 5, 7, 0, 0);

        System.out.println("Maximum length path is " + max_dist);

    }
}
