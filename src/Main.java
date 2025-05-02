public class Main {
    public static void main(String[] args) {
        /* Node node9 = new Node(16, "Cocada");
        Node node8 = new Node(10, "Chilito");
        Node node7 = new Node(7, "Copo");
        
        Node node6 = new Node(17, "Caneta", node9, null);
        Node node5 = new Node(9, "Corretivo", node7, node8);
        Node node4 = new Node(4, "Apontador");

        Node node3 = new Node(13, "Caderno", null, node6);
        Node node2 = new Node(6, "Borracha", node4, node5);
        
        Node node1 = new Node(11, "Lápis", node2, node3);

        BinaryTree binaryTree = new BinaryTree(node1); */
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(11, "Lápis");
        binaryTree.insert(6, "Borracha");
        binaryTree.insert(13, "Caderno");
        binaryTree.insert(4, "Apontador");
        binaryTree.insert(9, "Corretivo");
        binaryTree.insert(17, "Caneta");
        binaryTree.insert(7, "Copo");
        binaryTree.insert(10, "Chilito");
        binaryTree.insert(16, "Cocada");

        System.out.println("Percurso em pré-ordem:");
        binaryTree.preOrder();
        System.out.println();
        binaryTree.iterativePreOrder();
        
        System.out.println("\n\nPercurso em ordem:");
        binaryTree.inOrder();
        System.out.println();
        binaryTree.iterativeInOrder();
        
        System.out.println("\n\nPercuso em pós-ordem:");
        binaryTree.postOrder();
        System.out.println();
        binaryTree.iterativePostOrder();
        
        System.out.println("\n\nPercurso em nível:");
        binaryTree.levelOrder();

        System.out.println("\n\nAltura da árvore: " + binaryTree.getHeight());

        System.out.println("\nBusca pela chave 10:");
        Node searchNode = binaryTree.search(10);
        if (searchNode != null) {
            System.out.println("Chave encontrada: " + searchNode.getKey() + " - " + searchNode.getValue());
        } else {
            System.out.println("Chave não encontrada!");
        }

        System.out.println("\nBusca pela chave 99:");
        searchNode = binaryTree.search(99);
        if (searchNode != null) {
            System.out.println("Chave encontrada: " + searchNode.getKey() + " - " + searchNode.getValue());
        } else {
            System.out.println("Chave não encontrada!");
        }
    }
}
