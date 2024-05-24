from typing import List, Optional
from collections import deque

# given treenode class
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        # check for empty tree
        if not root:
            return result

        queue = deque([root])

        while queue:
            # get current level
            level_size = len(queue)
            current_level = []
            # add nodes of current level to the list
            for _ in range(level_size):
                current_node = queue.popleft()
                current_level.append(current_node.val)

                if current_node.left:
                    queue.append(current_node.left)
                if current_node.right:
                    queue.append(current_node.right)
            # add nodes of the current level to the list
            result.append(current_level)
        
        return result

# test case execution
if __name__ == "__main__":
    # test case tree
    node1 = TreeNode(1)
    node5 = TreeNode(5)
    node9 = TreeNode(9)
    node3 = TreeNode(3, node1, None)
    node8 = TreeNode(8, node5, node9)
    root = TreeNode(4, node3, node8)

    # Solution instance
    solution = Solution()

    # call level order traversal
    result = solution.levelOrder(root)

    # ouput
    print("Level Order Traversal:", result)
