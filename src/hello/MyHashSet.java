package hello;

import java.util.ArrayList;

@SuppressWarnings("all")
public class MyHashSet {
    ArrayList set = null;

    public MyHashSet() {
        set = new ArrayList();
    }

    public void add(int key) {
        if (!set.contains(key)) {
            set.add(key);
        }
    }

    public void remove(int key) {
        if (set.contains(key)){
            set.remove(set.indexOf(key));
        }
    }

    public boolean contains(int key) {
        return set.contains(key);
    }

    @Override
    public String toString() {
        return set+"";
    }
}
