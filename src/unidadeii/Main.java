package unidadeii;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        int[] valores = {20, 6, 2, 15, 31, 8, 17, 42, 1, 5, 19};

        for (int a : valores) {
            tree.insert(a);
        }

        System.out.print("Árvore em ordem: ");
        tree.inOrder();
    }
}
