import java.util.HashSet;
import java.util.Set;

class Node{
    int data;
    Node left = null;
    Node right = null;

    Node(int data){
        this.data = data;
    }

}
class BST {

    //Recursive function to insert key into Binary Tree

    public static Node insert(Node root, int key){

        //If the root is null, create a new node and return it
        if (root == null){
            return new Node(key);
        }

        //if given key is less than the root node, recurse for left subtree
        if (key < root.data){
            root.left = insert(root.left, key);
        }

        else{
            root.right = insert(root.right, key);
        }

        return root;
    }

    //function to find pairsum in given BST
    public static boolean  findPair(Node root, int sum, Set set){
        //base case
        if(root==null){
            return false;
        }

        //return true if pair is found in the left subtree else continue
        //processing the node

        if (findPair(root.left,sum,set)){
            return true;
        }

        //if pair is formed with current node, print pair and return the node
        if(set.contains(sum-root.data)){
            System.out.print("Pair found (" + (sum-root.data) + "," +root.data+ ")" );
            return true;
        }
        else {
            //insert current node value into the set
            set.add(root.data);
        }

        //search in right sub-tree
        return findPair(root.right,sum,set);



    }

    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;

        for (int key : keys) {
            root = insert(root, key);
        }

        // find pair with given sum
        int sum = 28;

        // create an empty set
        Set<Integer> set = new HashSet<>();

        if (!findPair(root, sum, set)) {
            System.out.print("Pair do not exists");
        }
    }
}
