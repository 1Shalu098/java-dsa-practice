import java.util.*;

public class Tree {
    static public class node {
    int data;
    node left;
    node right;
    node(int data){
        this.data = data;
        this.left = null;
        this.right = null;

    }
}
    static class binaryTree{
        static int idx = -1;
        public static node treeCreat(int nodes []){
            idx++;
            if (idx >= nodes.length|| nodes[idx] == -1) {
                return null;
            }
            node newnode = new node(nodes[idx]);
           newnode.left = treeCreat(nodes);
           newnode.right = treeCreat(nodes);
            return newnode;
        }
        public static void preoder(node root){
            if (root== null) {
                return;
            }
            System.out.print(root.data+" ");
            preoder(root.left);
            preoder(root.right);
        }
        public static void inorder(node root){
            if (root==null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(node root){
            if (root== null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOder(node root){
            if (root==null) {
                return;
            }
            Queue<node> q = new LinkedList <>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }if (currNode.right !=null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int heightOFtree(node root){
            if(root == null){
                return 0;
            }
            int lf = heightOFtree(root.left);
            int rt = heightOFtree(root.right);
            int mx = Math.max(lf, rt);
            return mx+1;
        }
        public static int counNode(node root){
            if(root==null){
                return 0;
            }
            int lfcount = counNode(root.left);
            int rtcount = counNode(root.right);
            return lfcount+rtcount+1;
        }
        public static int sum(node root){
            if(root==null){
                return 0;
            }
            int lfSum = sum(root.left);
            int rtSum = sum (root.right);
            return lfSum+rtSum+root.data;

        }

        public static int daimeter(node root){
            if(root== null){
                return 0;

            }
            int lfdiam = daimeter(root.left);
            int rtdiam = daimeter(root.right);
            int lfheight = heightOFtree(root.left);
            int rtheigt = heightOFtree(root.right);
            int  selfdiametr = lfheight+rtheigt+1;
            return Math.max( selfdiametr, Math.max(lfdiam, rtdiam));
        }
    }
    public static void main(String[] args) {
        int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
       //binaryTree tree = new binaryTree();s
      node root = binaryTree.treeCreat(nodes);
      //System.out.println(root.data);
      //binaryTree.preoder(root);
    //  binaryTree.inorder(root);
      //binaryTree.levelOder(root); 
      //System.out.println(binaryTree.heightOFtree(root));
      //System.out.println(binaryTree.counNode(root));
     // System.out.println(binaryTree.sum(root));
     System.out.println(binaryTree.daimeter(root));

    }

}
