package Map;

import java.lang.constant.Constable;
import java.util.Arrays;

public class MyHashTable<K, V> implements MyMap<K, V> {

    Node[] values = new Node[16];
    //int n;
    Node[] valClon = new Node[size(provZapoln())];
    Node<K, V> nodeNull;
    String h;

    public class Node<K, V> {

        K key;
        V value;
        Node<K, V> next;
        final int hashcode;


        public Node(int hashcode) {

            this.hashcode = hashcode;
        }
    }

    public int provZapoln() {
        int zap = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                zap++;
            }
        }
        return zap;
    }

    public int size(int zap) { //увелич размера массива
        int n = values.length;
        int size = n;
        double procZap = values.length * 0.75;

        if (zap == procZap) {
            size = n * 2;
            return size;
        }
        return n;
    }

    public void putClon(K key, V value) {

        int ind = ind(key);
        int hash = key.hashCode();
        Node<K, V> node = new Node<>(hash);
        Node<K, V> vrem = valClon[ind];
        if (vrem == null) {  //если пустой индекс
            valClon[ind] = node;
            return;
        }
        while (vrem.next != null) {
            if (vrem.hashcode == node.hashcode) {
                if (vrem.key.equals(node.key)) {
                    vrem.value = node.value;
                    return;
                }
                vrem.next = node;
                return;
            }
        }
    }


    public void zapoln() {
       // Node[] valClon = new Node[n];

        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                continue;
            }
            Node<K, V> vrm = values[i];
            while (vrm != null) {
                   putClon(vrm.key,vrm.value);
                   vrm=vrm.next;
            }
        }

    }

    public int ind(K key) {  // узнаем индекс для записи в массив
        int ind;
        if (key == null) {
            ind = 0;
        } else {
            ind = key.hashCode() % values.length;
        }
        return ind;
    }


    @Override
    public void put(K key, V value) {
      if (provZapoln()>values.length*0.75){
          zapoln();
      }
        if (key == null) {//запись в 0 индекс
            int hash = 0;
            Node<K, V> node = new Node<>(hash);
            if (nodeNull == null) {
                nodeNull = node;
                return;
            }
        }
        int ind = ind(key);
        int hash = key.hashCode();
        Node<K, V> node = new Node<>(hash);
        Node<K, V> vrem = values[ind];
        if (vrem == null) {  //если пустой индекс
            values[ind] = node;
            return;
        }
        while (vrem.next != null) {
            if (vrem.hashcode == node.hashcode) {
                if (vrem.key.equals(node.key)) {
                    vrem.value = node.value;
                    return;
                }
                vrem.next = node;
                return;
            }
        }
    }


    @Override
    public String toString() {
        return "MyHashTable{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    @Override
    public V get(K key) {
        //  V elem = null;
        if (key == null) {
            // elem = nodeNull != null ? nodeNull.value : null;
            if (nodeNull != null) {
                return nodeNull.value;
            }
            return null;
        }
        int ind = ind(key);
        Node<K, V> vrem = values[ind];
        if (vrem != null) {
            while (vrem.next != null) {
                if (vrem.hashcode == key.hashCode()) {
                    return vrem.value;
                }
                vrem = vrem.next;
            }
            return vrem.value;
        }
        //  return elem;
        return null;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            Node<K, V> vrem = nodeNull;
            nodeNull = null;
            return (V) vrem;
        }
        if (key != null) {
            int ind = ind(key);
            Node<K, V> vrem = values[ind];
            Node<K, V> pred = null;
            if (vrem.next == null) {   //если один
                pred = vrem;
                vrem = null;
                return (V) pred;
            }
            while (vrem.next != null) {

                if (vrem.hashcode == key.hashCode()) {
                    pred.next = vrem.next;
                    return (V) vrem;
                }
                pred = vrem;
                vrem = vrem.next;
                if (vrem.next == null) {
                    pred = vrem;
                    vrem = null;
                    return (V) pred;
                }
            }
        }
        return null;
    }
}
