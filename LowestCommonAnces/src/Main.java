public class Main {



      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

          while(root!=null){
              if(root.val > p. val && root.val >  q.val){
                  root = root.left;
              }

              else if (root.val < p.val && root.val < q.val){
                  root = root.right;
              }
              else {
                  return root;
              }
          }
          return null;
    }



    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
