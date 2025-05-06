import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " - " + node.getValue() + "; ");
            this.preOrder(node.getLeft());
            this.preOrder(node.getRight());
        }
    }

    public void iterativePreOrder() {
        if (this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.add(this.root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.getKey() + " - " + current.getValue() + "; ");

            if (current.getRight() != null) {
                stack.add(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.add(current.getLeft());
            }
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            this.inOrder(node.getLeft());
            System.out.print(node.getKey() + " - " + node.getValue() + "; ");
            this.inOrder(node.getRight());
        }
    }

    public void iterativeInOrder() {
        if (this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Node current = this.root;

        while (current != null || !stack.isEmpty()) {
            // Reaches the node that is most to the left in the tree.
            while (current != null) {
                stack.add(current);
                current = current.getLeft();
            }

            // Current is `null` at this point.
            current = stack.pop();

            // Visits the node.
            System.out.print(current.getKey() + " - " + current.getValue() + "; ");

            // Now, visits the subtree in the right.
            current = current.getRight();
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            this.postOrder(node.getLeft());
            this.postOrder(node.getRight());
            System.out.print(node.getKey() + " - " + node.getValue() + "; ");
        }
    }

    public void iterativePostOrder() {
        if (this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> outputStack = new Stack<Node>();
        stack.add(this.root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            outputStack.add(current);

            if (current.getLeft() != null) {
                stack.add(current.getLeft());
            }

            if (current.getRight() != null) {
                stack.add(current.getRight());
            }
        }

        // Desempilha os nós da pilha de saída
        while (!outputStack.isEmpty()) {
            Node current = outputStack.pop();
            System.out.print(current.getKey() + " - " + current.getValue() + "; ");
        }
    }

    public void levelOrder() {
        this.levelOrder(this.root);
    }

    private void levelOrder(Node node) {
        Node current = null;

        if (node != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);

            while (!queue.isEmpty()) {
                current = queue.remove();
                System.out.print(current.getKey() + " - " + current.getValue() + "; ");
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    private int getHeight(Node node) {
        int a, b;

        if (node == null) {
            return -1;
        }

        a = this.getHeight(node.getLeft());
        b = this.getHeight(node.getRight());

        if (a > b) {
            return a + 1;
        }

        return b + 1;
    }

    public Node search(int key) {
        return this.search(key, this.root);
    }

    private Node search(int key, Node node) {
        if (node == null) {
            return null;
        }

        if (key < node.getKey()) {
            return this.search(key, node.getLeft());
        }
        
        if (key > node.getKey()) {
            return this.search(key, node.getRight());
        }
        
        return node;
    }

    public void insert(int key, String value) {
        this.root = this.insert(this.root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) {
            node = new Node(key, value);
        } else if (key < node.getKey()) {
            node.setLeft(this.insert(node.getLeft(), key, value));
        } else if (key > node.getKey()) {
            node.setRight(this.insert(node.getRight(), key, value));
        }

        return node;
    }

    public Node delete(int key) {
        return this.delete(this.root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.getKey()) {
            node.setLeft(this.delete(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(this.delete(node.getRight(), key));
        } else {
            // Caso 1
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            }
            // Caso 2
            else if (node.getLeft() == null) {
                Node aux = node;
                node = aux.getRight();
                aux = null;
            } else if (node.getRight() == null) {
                Node aux = node;
                node = aux.getLeft();
                aux = null;
            }
            // Caso 3
            else {
                Node aux = node.getLeft();

                while (aux.getRight() != null) {
                    aux = aux.getRight();
                }

                node.setKey(aux.getKey());
                aux.setKey(key);
                Node r = this.delete(node.getLeft(), aux.getKey());
                node.setLeft(r);
            }
        }

        return node;
    }
}
