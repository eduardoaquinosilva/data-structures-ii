package unidadeii.hashtable;

public class Pratica1HashV1 {
    public static void main(String[] args) throws Exception {
        int[] keys = {
            212, 618, 302, 940, 702, 704, 612, 606,
            772, 510, 423, 650, 317, 907, 507, 304,
            714, 857, 801, 900, 413, 701, 418, 601
        };

        System.out.println("Resultados para m = 100:");
        Pratica1HashV1.countColisions(keys, 100);

        System.out.println("\nResultados para m = 101:");
        Pratica1HashV1.countColisions(keys, 101);
    }

    public static void countColisions(int[] keys, int m)
    {
        // Counter for each position access
        int[] hashCount = new int[m];

        // Stores the keys as texts for each position
        String[] hashKeys = new String[m];

        // Initializes the sinonimous keys' array
        for (int a = 0; a < m; ++a) {
            // Initially empty
            hashKeys[a] = "";
        }

        int totalColisions = 0;

        for (int k : keys) {
            int hash = k % m;

            if (hashCount[hash] > 0) totalColisions++;

            hashCount[hash]++;

            if (!hashKeys[hash].isEmpty()) {
                hashKeys[hash] += ", ";
            }
            hashKeys[hash] += k;
        }

        System.out.println("Colisões por posição:");
        for (int i = 0; i < m; i++) {
            if (hashCount[i] > 1) {
                System.out.println("Posição " + i + ": " + (hashCount[i] - 1) + " colisões - chaves: [" + hashKeys[i] + "]");
            }
        }

        System.out.println("Total de colisões: " + totalColisions);
    }
}
