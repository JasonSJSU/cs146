package Lab5;

public class Lab5 {
    //given treenode class
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

    //intial method call to start at the root
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //private helper method for the public isValidBST()
    //checks BST property of the children of node variable
    private boolean isValidBST(TreeNode node, long lower, long upper) {
        //check for empty node
        if (node == null) {
            return true;
        }
        //checks for BST property
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        if (!isValidBST(node.right, node.val, upper)) {
            return false;
        }
        if (!isValidBST(node.left, lower, node.val)) {
            return false;
        }
        //BST property is present
        return true;
    }

    public static void main(String[] args) {
        Lab5 solution = new Lab5();

        //test case tree 1
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node5, node9);
        TreeNode node4 = new TreeNode(4, node3, node8);
        node3.left = node1;

        // Output
        System.out.println(solution.isValidBST(node4));  

        //test case tree 2
        TreeNode node2 = new TreeNode(2);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8_2 = new TreeNode(8, node5_2, node6);
        TreeNode node1_2 = new TreeNode(1, node2, node8_2);
        node2.left = node3_2;
        node2.right = node4_2;

        // Output
        System.out.println(solution.isValidBST(node1_2));
    }
}

