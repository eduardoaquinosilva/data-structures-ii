public class Exercicio1 {
    public static void main(String[] args) {
        // 1. Mostre passo a passo a árvore binária resultante das seguintes operações:
        BinaryTree binaryTree = new BinaryTree();
        
        // Inserção de 70, 80, 30, 40, 20, 10, 60, 50.
        binaryTree.insert(70, null);
        binaryTree.insert(80, null);
        binaryTree.insert(30, null);
        binaryTree.insert(40, null);
        binaryTree.insert(20, null);
        binaryTree.insert(10, null);
        binaryTree.insert(60, null);
        binaryTree.insert(50, null);

        // Mostre o percurso em pré-ordem, em ordem e pós-ordem.
        System.out.println("Pré-ordem:");
        binaryTree.preOrder();

        System.out.println("\n\nEm ordem:");
        binaryTree.inOrder();

        System.out.println("\n\nPós-ordem:");
        binaryTree.postOrder();

        // Remoção de 70 e 60.
        System.out.println("\n\nRemoção do 70...");
        binaryTree.delete(70);
        System.out.println("Remoção do 60...");
        binaryTree.delete(60);

        // Mostre o percuso em pré-ordem, em ordem e pós-ordem.
        System.out.println("\nPré-ordem:");
        binaryTree.preOrder();

        System.out.println("\n\nEm ordem:");
        binaryTree.inOrder();

        System.out.println("\n\nPós-ordem:");
        binaryTree.postOrder();
    }
}
