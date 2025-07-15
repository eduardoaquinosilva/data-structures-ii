package unidadeii.hashtable;

public class HashTable {
    private int m;
    private HashTableNode table[];

    public HashTable(int size)
    {
        this.m = size;
        this.table = new HashTableNode[m];
    }

    public HashTableNode[] getTable()
    {
        return this.table;
    }

    public void setTable(int position, HashTableNode value)
    {
        this.table[position] = value;
    }

    public int hash(int k)
    {
        return k % m;
    }

    public void insertBegin(int k)
    {
        int h = this.hash(k);
        HashTableNode node = this.getTable()[h];

        while (node != null) {
            if (node.getKey() == k) {
                break;
            }

            node = node.getNext();
        }

        if (node == null) {
            node = new HashTableNode(k, this.getTable()[h]);
            this.setTable(h, node);
        }
    }

    public void insertEnd(int k)
    {
        int c = this.hash(k);

        HashTableNode current = this.getTable()[c];
        HashTableNode previous = null;
    }
}
