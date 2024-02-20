package bstmap;



import java.util.Iterator;
import java.util.Set;


public class BSTMap<K extends Comparable<K> ,V> implements Map61B<K, V>{

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

    }

    private Node root;
    private int size;

    public BSTMap(){
        this.clear();
    }


    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        Node p = root;

        while (p != null){

            if(p.key.compareTo(key) == 0){
                return true;
            }else if(p.key.compareTo(key) < 0){
                p = p.right;
            }else if(p.key.compareTo(key) > 0){
                p = p.left;
            }

        }

        return false;
    }

    @Override
    public V get(K key) {

        Node p = root;

        while (p != null){

            if(p.key.compareTo(key) == 0){
                return p.value;
            }else if(p.key.compareTo(key) < 0){
                p = p.right;
            }else if(p.key.compareTo(key) > 0){
                p = p.left;
            }

        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {

        Node newNode = new Node(key, value);

        if(root == null){
            root = newNode;
            size++;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp == 0) {
                current.value = newNode.value;
                return;
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
    }

    public void printInOrder(){
        Node p = root;

        while (p != null){

            System.out.print(p.value + " ");
            p = p.right;

        }

    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }


}
