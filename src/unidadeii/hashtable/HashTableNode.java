package unidadeii.hashtable;

public class HashTableNode {
    private int key;
    private HashTableNode next;

    public HashTableNode(int k, HashTableNode p)
    {
        this.key = k;
        this.next = p;
    }

    public int getKey()
    {
        return this.key;
    }

    public HashTableNode getNext()
    {
        return this.next;
    }
}
