package unidadeii.hashtable;

import java.util.ArrayList;
import java.util.List;

public class Pratica1HashV2 {
    public static void main(String[] args) throws Exception {
        int[] keys = {
            212, 618, 302, 940, 702, 704, 612, 606,
            772, 510, 423, 650, 317, 907, 507, 304,
            714, 857, 801, 900, 413, 701, 418, 601
        };

        System.out.println("Resultados para m = 100:");
        Pratica1HashV2.countColisions(keys, 100);

        System.out.println("\nResultados para m = 101:");
        Pratica1HashV2.countColisions(keys, 101);
    }

    public static void countColisions(int[] keys, int m)
    {
        // Table of lists to store the keys in each position
        @SuppressWarnings("unchecked")
        List<Integer>[] table = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            table[i] = new ArrayList<>();
        }

        int colisions = 0;

        for (int k: keys) {
            int hash = k % m;

            if (!table[hash].isEmpty()) {
                colisions++;
            }

            table[hash].add(k);
        }

        // Show the positions with colisions the keys in them
        for (int i = 0; i < m; i++) {
            if (table[i].size() > 1) {
                System.out.println("Posição " + i + ": " + (table[i].size() - 1) + " colisões - chaves " + table[i]);
            }
        }

        System.out.println("Total de colisões: " + colisions);
    }
}
