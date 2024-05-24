package HW10;

import java.util.*;

public class HW10 {
    // given TreeNode class
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            // check for empty tree
            if (root == null) {
                return result;
            }
            
            // use queue to do bfs traversal of the tree level by level
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                //get current level
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();
                //add nodes of the current level to the list
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
                // returns list of levels on the current level
                result.add(currentLevel);
            }
            return result;
        }
    }

    // test cases
    public static void main(String[] args) {
        // test case tree
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node1, null);
        TreeNode node8 = new TreeNode(8, node5, node9);
        TreeNode root = new TreeNode(4, node3, node8);

        Solution solution = new Solution();

        // calling level order traversal
        List<List<Integer>> result = solution.levelOrder(root);

        // output
        System.out.println("Level Order Traversal: " + result);
    }
}
