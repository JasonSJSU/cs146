# given treenode class
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # check for empty tree
        if root is None:
            return None

        # if both p and q are smaller than root, LCA lies in left subtree
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)

        # if both p and q are greater than root, LCA lies in right subtree
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)

        # if one of p or q is on one side and the other is on the other side, root is the LCA
        return root

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

    # LCA of nodes 1 and 5
    lca = solution.lowestCommonAncestor(root, node1, node5)

    # output
    print("LCA of 1 and 5:", lca.val)
