package edu.greenriver.sdev333;

public class SeperateChainingHashST<KeyType, ValueType> implements SymbolTable<KeyType, ValueType>
{
    //fields
    private int buckets; // m in book
    private SequentialSearchST1<KeyType, ValueType>[] st;

    //constructor
    public SeperateChainingHashST() {
        this(997);
    }

    public SeperateChainingHashST (int buckets) {
        this.buckets = buckets;
        st =  new SequentialSearchST1[buckets];
        for (int i = 0; i < buckets; i++) {
            st[i] = new SequentialSearchST1<>();
        }
    }

    //methods
    private int hash(KeyType key) {
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

    public void put(KeyType key, ValueType val) {
        int index = hash(key);
        st[index].put(key, val);
    }

    public ValueType get(KeyType key) {
        int index = hash(key);
        return st[index].get(key);
    }

    public int size() {
        //go through each bucket and add up each size
        int sum = 0;
        for (int i = 0; i < buckets; i++) {
            sum += st[i].size();
        }
        return sum;
    }

    public Iterable<KeyType> keys() {
        Queue<KeyType> collector = new Queue<>();
        for (int i = 0; i < buckets; i++) {
            for (KeyType key : st[i].keys()) {
                collector.enQueue(key);
            }
        }
        return collector;
    }
}
