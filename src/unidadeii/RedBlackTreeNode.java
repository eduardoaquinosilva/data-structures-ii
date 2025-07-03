package unidadeii;

public class RedBlackTreeNode {
    private int key;
    private int color;  // 1 for red, 0 for black
    private RedBlackTreeNode parent, left, right;

    public RedBlackTreeNode() {}

    public RedBlackTreeNode(int key)
    {
        this.key = key;
        this.color = 1;  // New node is red in standard
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public RedBlackTreeNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public RedBlackTreeNode getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }
}
