package unidadeii.hashtable;

public class Pratica2 {
    public static void main(String[] args) throws Exception {
        System.out.println(hash(454, 5));
        System.out.println(hash((Integer) 27458, 3));
    }

    public static int hash(int key, int size)
    {
        return (key & 0x7FFFFFFF) % size;
    }

    public static int hashMultiplicative(int key, int size)
    {
        float a = 0.6180339887f;
        float temp = key * a;
        temp = temp - (int) temp;
        return (int) (size * temp);
    }

    public static Integer hash(Integer key, int size)
    {
        return (key.hashCode() & 0x7FFFFFFF) % size;
    }
}
