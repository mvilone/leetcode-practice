package trees;

class DiameterOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int result = 0; // Tracks the maximum diameter found

    /**
     * Performs a depth-first traversal to compute the height of subtrees
     * and update the diameter of the binary tree.
     *
     * @param node the current node being visited
     * @return the height of the subtree rooted at the current node
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of null node is 0
        }

        // Recursively compute the height of the left and right subtrees
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // Update the diameter if the path through this node is larger
        result = Math.max(result, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Calculates the diameter of a binary tree.
     * The diameter is defined as the length of the longest path
     * between any two nodes in the tree, which may or may not pass through the root.
     *
     * @param root the root node of the binary tree
     * @return the diameter (maximum number of edges between two nodes)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root); // Start DFS traversal from the root
        return result; // Return the maximum diameter found
    }
}

