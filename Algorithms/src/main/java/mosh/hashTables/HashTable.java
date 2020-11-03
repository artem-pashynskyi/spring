package mosh.hashTables;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key , String value) {
        var index = hash(key);
        if(entries[index] == null)
            entries[index] = new LinkedList<>();

        for(var entry : entries[index]) {
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }

        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        if(entries[index] != null) {
            for(int i = 0  ; i < entries[index].size() ; i++)
                if(entries[index].get(i).key == key)
                    return entries[index].get(i).value;
        }
        return null;
    }

    public void remove(int key) {
       var index = hash(key);
       if(entries[index] == null)
           throw new IllegalStateException();
       for(int i = 0 ; i < entries[index].size() ; i++) {
           if(entries[index].get(i).key == key) {
               entries[index].remove(i);
               return;
           }
       }
       if(entries[index].isEmpty())
           entries[index] = null;
       throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }

}
