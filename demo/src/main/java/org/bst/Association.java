package org.bst;

public class Association<K, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.toString().compareTo(other.key.toString());
    }

}
