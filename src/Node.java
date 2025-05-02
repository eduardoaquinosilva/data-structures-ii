public class Node {
    private int key;
    private String value;
    private Node left, right;

    public Node() {}

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(int key, String value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
