# given tree node class
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root):
        if root is None:
            return None

        # swap the left and right children
        root.left, root.right = root.right, root.left

        # recursively apply to the rest of the children
        self.invertTree(root.left)
        self.invertTree(root.right)

        return root

    # function to print the entire tree
    def printTree(self, root):
        if root is None:
            return
        print(root.val, end=" ")
        self.printTree(root.left)
        self.printTree(root.right)

if __name__ == "__main__":
    # test case tree
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)
    node2 = TreeNode(2, node3, node4)
    node8 = TreeNode(8, node5, node6)
    root = TreeNode(1, node2, node8)

    solution = Solution()
    
    invertedRoot = solution.invertTree(root)

    # output
    solution.printTree(invertedRoot)
