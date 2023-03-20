package edu.greenriver.sdev333;

import java.util.Iterator;

public class SeparateChainingHashTable<KeyType extends Comparable<KeyType>> implements MathSet<KeyType>{

    //fields
    private int buckets; // m in book
    private SequentialSearchST<KeyType>[] st;

    //constructor
    public SeparateChainingHashTable() {
        this(997);
    }

    public SeparateChainingHashTable (int buckets) {
        this.buckets = buckets;
        st =  new SequentialSearchST[buckets];
        for (int i = 0; i < buckets; i++) {
            st[i] = new SequentialSearchST<KeyType>();
        }
    }

    //methods
    private int hash(KeyType key) {
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

    /**
     * Puts the specified key into the set.
     *
     * @param key key to be added into the set
     */
    @Override
    public void add(KeyType key) {
        int index = hash(key);
        st[index].put(key);
    }

    /**
     * Is the key in the set?
     *
     * @param key key to check
     * @return true if key is in the set, false otherwise
     */
    @Override
    public boolean contains(KeyType key) {
        return false;
    }

    /**
     * Is the set empty?
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    public int size() {
        //go through each bucket and add up each size
        int sum = 0;
        for (int i = 0; i < buckets; i++) {
            sum += st[i].size();
        }
        return sum;
    }

    /**
     * Determine the union of this set with another specified set.
     * Returns A union B, where A is this set, B is other set.
     * A union B = {key | A.contains(key) OR B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to union
     * @return the union of this set with other
     */
    @Override
    public MathSet<KeyType> union(MathSet<KeyType> other) {
        //make new set to hold results
        MathSet<KeyType> result = new BSTSet<>();
        //for each loop
        for(KeyType currentKey : this.keys()){
            result.add(currentKey);
        }
        for(KeyType currentKey : other.keys()){
            result.add(currentKey);
        }
        return result;
    }

    /**
     * Determine the intersection of this set with another specified set.
     * Returns A intersect B, where A is this set, B is other set.
     * A intersect B = {key | A.contains(key) AND B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to intersect
     * @return the intersection of this set with other
     */
    @Override
    public MathSet<KeyType> intersection(MathSet<KeyType> other) {
        //make new set to hold results
        MathSet<KeyType> result = new BSTSet<>();
        //loop
        for(KeyType currentKey : this.keys()){
            if(other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
    }

    /**
     * Determine the difference of this set with another specified set.
     * Returns A difference B, where A is this set, B is other set.
     * A difference B = {key | A.contains(key) AND !B.contains(key)}.
     * Does not change the contents of this set or the other set.
     *
     * @param other specified set to difference
     * @return the difference of this set with other
     */
    @Override
    public MathSet<KeyType> difference(MathSet<KeyType> other) {
        //make new set to hold results
        MathSet<KeyType> result = new BSTSet<KeyType>();
        //loop
        Iterable<KeyType> keys = this.keys();
        Iterator<KeyType> itr = keys.iterator();
        while (itr.hasNext()){
            KeyType currentKey = itr.next();
            if(!other.contains(currentKey)){
                result.add(currentKey);
            }
        }
        return result;
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
