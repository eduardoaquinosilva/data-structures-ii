package unidadeii;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(20);
        tree.insert(6);
        tree.insert(2);
        tree.insert(15);
        tree.insert(31);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(1);
        tree.insert(5);
        tree.insert(19);

        System.out.println(tree);
    }
}
