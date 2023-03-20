package edu.greenriver.sdev333;

/**
 * Sequential search (unordered linked list implementation) of Symbol Table
 * Refer to p. 374-377 in Sedgewick and Wayne, Algorithms, 4th edition
 * @param <KeyType>
 */
public class SequentialSearchST<KeyType> {

    private Node first;
    private int count;

    private class Node {
        KeyType key;
        Node next;

        public Node (KeyType key, Node next) {
            this.key = key;
            this.next = next;
        }

        public void setNext(Node x) {
            this.next = x;
        }
    }

    public void put(KeyType key) {
        if(first == null) {
            first = new Node(key, null);
        }
        else {
            Node x = first;
            for(; x.next != null; x = x.next) {
                if(key.equals(x.key)) {
                    return;
                }
            }
            Node newNode = new Node(key, null);
            x.setNext(newNode);
        }
        count++;
    }

    public int size() {
        return count;
    }

    public Iterable<KeyType> keys() {
        Queue<KeyType> queue = new Queue<>();
        Node current = first;
        while (current !=null){
            queue.enQueue(current.key);
            current = current.next;
        }
        return queue;
    }
}
