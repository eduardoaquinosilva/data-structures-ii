package unidadeii;

public class RedBlackTree {
    private RedBlackTreeNode root;

    public RedBlackTree()
    {
        this.root = null;
    }

    public RedBlackTree(RedBlackTreeNode node)
    {
        this.root = node;
    }

    public void insert(int key)
    {
        RedBlackTreeNode newNode = new RedBlackTreeNode();
        newNode.setParent(null);
        newNode.setKey(key);
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setColor(1);  // Red.

        RedBlackTreeNode currentParent = null;
        RedBlackTreeNode current = this.root;

        // Search position to insert the new node.
        while (current != null) {
            currentParent = current;

            if (newNode.getKey() < current.getKey())
                current = current.getLeft();
            else current = current.getRight();
        }

        newNode.setParent(currentParent);  // Last value of current

        // Check in which subtree the new node will be
        if (currentParent == null)
            this.root = newNode;
        else if (newNode.getKey() < currentParent.getKey())
            currentParent.setLeft(newNode);
        else currentParent.setRight(newNode);

        // If the node's parent is null, it means that it is the root.
        // So, change the root's color to black.
        if (newNode.getParent() == null) {
            newNode.setColor(0);
            return;
        }

        // If the parent's parent is null, it means that the node is in a level above the root. Nothing to be fixed. Return.
        if (newNode.getParent().getParent() == null) return;

        this.fixInsert(newNode);
    }

    private void fixInsert(RedBlackTreeNode v)
    {
        RedBlackTreeNode u;

        while (v.getParent().getColor() == 1) {
            //System.out.println(v.getParent());
            //System.out.println(v.getParent().getParent());

            // w (parent) is a direct son of t (grandparent)
            if (v.getParent() == v.getParent().getParent().getRight()) {
                // Get the reference of uncle u
                u = v.getParent().getParent().getLeft();

                // If uncle u is red
                if (u != null && u.getColor() == 1) {
                    // Uncle u changes color to black
                    u.setColor(0);
                    // Parent w changes color to black
                    v.getParent().setColor(0);
                    // Grandparent t changes to red
                    v.getParent().getParent().setColor(1);
                    // New node v = t (grandparent)
                    v = v.getParent().getParent();
                }
                // if uncle u is black
                else {
                    // If v is at the left of w, applies a left-right rotate (case 2d)
                    if (v == v.getParent().getLeft()) {
                        v = v.getParent();

                        // right rotate in parent w
                        // v = right son of new node (w)
                        rightRotate(v);
                    }

                    // The node v is at the right of w. Applies a left rotate (case 2b)
                    // Parent changes to black
                    v.getParent().setColor(0);
                    // Grandparent changes to red
                    v.getParent().getParent().setColor(1);
                    // left rotate in the grandparent
                    leftRotate(v.getParent().getParent());
                }
            }
            // If w (parent) is a left son of t (grandparent)
            else {
                // Get the reference of uncle u
                u = v.getParent().getParent().getRight();

                // If the uncle u is red
                if (u != null && u.getColor() == 1) {
                    // Uncle changes to black
                    u.setColor(0);
                    // Parent w changes to black
                    v.getParent().setColor(0);
                    // Grandparent t changes to red
                    v.getParent().getParent().setColor(1);
                    // New node v = t (grandparent)
                    v = v.getParent().getParent();
                }
                // If uncle u is black
                else {
                    // If v is at the right of w, applies a right-left rotate (case 2c)
                    if (v == v.getParent().getRight()) {
                        v = v.getParent();
                        // Left rotate in parent w
                        // v = left son of new node (w)
                        leftRotate(v);
                    }

                    // The node v is at the left of w, applies a right rotate (case 2a)

                    // Parent changes to black
                    v.getParent().setColor(0);
                    // Grandparent changes to red
                    v.getParent().getParent().setColor(1);
                    // Right rotate in the grandparent
                    rightRotate(v.getParent().getParent());
                }
            }

            if (v == this.root) break;
        }

        this.root.setColor(0);
    }

    private void rightRotate(RedBlackTreeNode x)
    {
        // Saves the left son of x (called y). It will be promoted to the place of x.
        RedBlackTreeNode y = x.getLeft();

        // The right son of y becomes the new left son of x.
        x.setLeft(y.getRight());

        // If y's right subtree is not null, updates its parent to be x.
        if (y.getRight() != null) y.getRight().setParent(x);
        
        // The new parent of y becomes the original parent of x.
        y.setParent(x.getParent());

        // If x was the tree's root, y will now be the new root.
        if (x.getParent() == null)
            this.root = y;
        // Updates the link of x's parent to point now to y:
        // If x was a right son, the new right son is y.
        // If x was a left son, the new left son is y.
        else if (x == x.getParent().getRight())
            x.getParent().setRight(y);
        else x.getParent().setLeft(y);

        // The old node x becomes the right son of y.
        y.setRight(x);

        // Updates the parent of x to be y.
        x.setParent(y);
    }
    // After insert, y goes up in the tree and x goes down to the right of y.

    private void leftRotate(RedBlackTreeNode x)
    {
        // Saves the right son of x (called y). It will be promoted to the place of x.
        RedBlackTreeNode y = x.getRight();

        // The left son of y becomes the new right son of x.
        x.setRight(y.getLeft());

        // If the left subtree of y is not null, updates its parent to be x.
        if (y.getLeft() != null)
            y.getLeft().setParent(x);
        
        // The new parent of y becomes the original parent of x.
        y.setParent(x.getParent());

        // If x was the roor of the tree, y will now be the new root.
        if (x.getParent() == null)
            this.root = y;
        // Updates the link of x's parent to point now to y:
        // If x was a left son, the new left son is y.
        // If x was a right son, the new right son is y.
        else if (x == x.getParent().getLeft())
            x.getParent().setLeft(y);
        else x.getParent().setRight(y);

        // The old node x becomes the left son of y.
        y.setLeft(x);

        // Updates the parent of x to be y.
        x.setParent(y);
    }
    // After insert, y goes up in the tree and x goes down to the left of y.
}
