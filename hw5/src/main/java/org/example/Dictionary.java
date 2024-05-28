package org.example;

public class Dictionary<K, V> {
    private K[] keys = (K[]) new Object[100];
    private V[] values = (V[]) new Object[100];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean containsKey (K key) {
        boolean contains = false;
        if(key != null && keys != null) {
            for (Object current : keys) {
                if(current.equals(key)) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    public boolean containsValue (V value) {
        boolean contains = false;
        if(value != null) {
            for (Object current : values) {
                if (current.equals(value)) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    public V get (K key) {
        V value = null;
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)) value = values[i];
        }
        return value;
    }

    public boolean put (K key, V value) {
        boolean busy = false;
        for (int i = 0; i < size + 1; i++) {
            if(keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                busy = true;
                break;
            }
            if(keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
        if(!busy) size++;
        return busy;
    }

    public boolean remove (K key) {
        boolean isRemoved = false;
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key) && !isRemoved) isRemoved = true;
            if(isRemoved && i != size - 1) {
                keys[i] = keys[i++];
                values[i] = values[i++];
            }
        }
        if(isRemoved)size--;
        return isRemoved;
    }

    public boolean putAll (Dictionary<K, V> dictionary) {
        boolean updated = false;
        K[] keys = dictionary.keys();
        for (K key : keys) {
            V value = dictionary.get(key);
            boolean putted = put(key, value);
            if(putted) updated = true;
        }
        return updated;
    }

    public boolean clear() {
        if(isEmpty()) return false;

        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
        return true;
    }

    public K[] keys() {
        return keys;
    }

    public V[] values() {
        return values;
    }
}