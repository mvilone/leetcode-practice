package trees;

class MaxDepthBinaryTree {
    //Definition for a binary tree node.
    private class TreeNode {
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
 
    /**
     * Calculates the maximum depth of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth (height) from root to the deepest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            // Base case: if the node is null, the depth is 0
            return 0;
        }

        // Recursively find the max depth of left and right subtrees,
        // then add 1 to account for the current root level
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
