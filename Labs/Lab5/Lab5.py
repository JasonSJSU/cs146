class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    # intial method call to start at the root
    def isValidBST(self, root):
        return self._isValidBST(root, float('-inf'), float('inf'))
    
    #helper method part for isValidBST(self, root)
    #checks BST property of the children of node variable
    def _isValidBST(self, node, lower, upper):
        # check for empty node
        if not node:
            return True
        # checks for BST property
        if node.val <= lower or node.val >= upper:
            return False

        if not self._isValidBST(node.right, node.val, upper):
            return False

        if not self._isValidBST(node.left, lower, node.val):
            return False
        # BST property is present
        return True

# Test cases
def test_isValidBST():
    solution = Solution()
    
    # test cast tree 1
    node1 = TreeNode(1)
    node3 = TreeNode(3)
    node5 = TreeNode(5)
    node9 = TreeNode(9)
    node8 = TreeNode(8, node5, node9)
    node4 = TreeNode(4, node3, node8)
    node3.left = node1
    assert solution.isValidBST(node4) == True
    
    # test cast tree 2
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)
    node8 = TreeNode(8, node5, node6)
    node2 = TreeNode(2, node3, node4)
    node1 = TreeNode(1, node2, node8)
    assert solution.isValidBST(node1) == False

    print("All test cases pass")

test_isValidBST()
