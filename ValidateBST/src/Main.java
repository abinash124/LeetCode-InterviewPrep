import java.util.Stack;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    boolean isValidBST(TreeNode root){

        //Check if inOrder returns sorted ascending order or not
        if(root==null) return true;

        TreeNode prev = null;

        Stack<TreeNode> s = new Stack<>();

        while(root!=null || !s.isEmpty()){
            while(root !=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();

            if(prev!=null && prev.val > root.val)
                return false;
            prev = root;
            root = root.right;

        }

        return true;




    }

    int kthSmallestBST(TreeNode root, int k){
        if(root==null) return 0;



        Stack<TreeNode> s = new Stack<>();

        while(root!=null || !s.isEmpty()){
            while(root !=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(--k == 0)
                return root.val;


            root = root.right;

        }

    return -1;

    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
