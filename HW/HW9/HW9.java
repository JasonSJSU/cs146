package HW9;

public class HW9 {
    // given treenode class
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

    public static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // check for empty tree
            if (root == null) {
                return null;
            }

            // if both p and q are smaller than root, LCA lies in left subtree
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

            // If both p and q are greater than root, LCA lies in right subtree
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }

            // If one of p or q is on one side and the other is on the other side, root is the LCA
            return root;
        }
    }

    public static void main(String[] args) {
        // test case tree
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node1, null);
        TreeNode node8 = new TreeNode(8, node5, node9);
        TreeNode root = new TreeNode(4, node3, node8);

        Solution solution = new Solution();

        // LCA of nodes 1 and 5
        TreeNode lca = solution.lowestCommonAncestor(root, node1, node5);

        // ouput
        System.out.println("LCA of 1 and 5: " + lca.val);
    }
}
