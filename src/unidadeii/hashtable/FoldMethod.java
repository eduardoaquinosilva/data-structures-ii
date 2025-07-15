package unidadeii.hashtable;

public class FoldMethod {
    private int size;

    public FoldMethod(int size)
    {
        this.size = size;
    }

    // Hash method using the fold method
    public int hash(int key)
    {
        // Convert key's value to string
        String stringKey = String.valueOf(key);

        // Get the size of the key in characters
        int keySize = stringKey.length();

        // Fold to 2 digits
        int foldSize = 2;
        int hashValue = 0;

        // Run the key divinding it in pieces
        for (int i = 0; i < keySize; i += foldSize) {
            String piece;

            // Checks if the piece has the right size
            if (i + foldSize <= keySize)
                piece = stringKey.substring(i, i + foldSize);
            else
                piece = stringKey.substring(i);  // Last piece could be smaller
            
            // Convert the piece to integer and adds to the hash value
            hashValue += Integer.parseInt(piece);
        }

        // Returns the hash value, adjusting by the size of the table (module)
        return hashValue % this.size;
    }

    public int hash(int key, int size)
    {
        int nBits = 5;
        int part1 = key >> nBits;
        int part2 = key & (size - 1);
        return (part1 ^ part2);
    }

    public static void main(String[] args) {
        // Creates a table with 100 pieces
        FoldMethod hashTable = new FoldMethod(100);

        // int key = 123456789;
        int key = 813459;
        int index = hashTable.hash(key);
        System.out.println("O índice da chave " + key + " é: " + index);
    }
}
