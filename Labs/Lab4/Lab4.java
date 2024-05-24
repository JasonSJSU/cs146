package Lab4;

// Solution class with invertTree method
public class Lab4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {}
    
        TreeNode(int val) { this.val = val; }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    //method to invert the tree starting from the root node
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //swap the left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //recursively apply to the rest of the tree
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // method to print a tree
    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        // test case tree
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node8 = new TreeNode(8, node5, node6);
        TreeNode root = new TreeNode(1, node2, node8);

        Lab4 solution = new Lab4();

        TreeNode invertedRoot = solution.invertTree(root);

        //output
        solution.printTree(invertedRoot);
    }
}
