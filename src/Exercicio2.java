public class Exercicio2 {
    public static void main(String[] args) {
        // 2. Mostre passo a passo a árvore binária resultante das seguintes operações:
        BinaryTree binaryTree = new BinaryTree();
        
        // Inserção de 16, 98, 12, 2, 5, 103, 56, 74.
        binaryTree.insert(16, null);
        binaryTree.insert(98, null);
        binaryTree.insert(12, null);
        binaryTree.insert(2, null);
        binaryTree.insert(5, null);
        binaryTree.insert(103, null);
        binaryTree.insert(56, null);
        binaryTree.insert(74, null);

        // Mostre o percurso em pré-ordem, em ordem e pós-ordem.
        System.out.println("Pré-ordem:");
        binaryTree.preOrder();

        System.out.println("\n\nEm ordem:");
        binaryTree.inOrder();

        System.out.println("\n\nPós-ordem:");
        binaryTree.postOrder();

        // Remoção de 98 e 5.
        System.out.println("\n\nRemoção do 98...");
        binaryTree.delete(98);
        System.out.println("Remoção do 5...");
        binaryTree.delete(5);

        // Mostre o percuso em pré-ordem, em ordem e pós-ordem.
        System.out.println("\nPré-ordem:");
        binaryTree.preOrder();

        System.out.println("\n\nEm ordem:");
        binaryTree.inOrder();

        System.out.println("\n\nPós-ordem:");
        binaryTree.postOrder();
    }
}
