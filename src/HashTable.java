/*
HashTable.java
Zain Raza
This is a hashtable class with the following features (ArrayList of LinkedLists):
add - adds an object
remove - removes an object
contains - returns true if the item is in the list, false otherwise
getLoad - Return how full the hash table is as a number from 0-1, 0 being no elements in the array, and 1 being all spots in the array are full
setMaxLoad - sets the maximum load as a percent
setLoad - sets the load as a percent
toArray - returns an ArrayList of objects with no nulls in it.
 */

import java.util.*;

public class HashTable <T> {

    private ArrayList<LinkedList<T>>table; // Hash Table
    private int cSize;
    private double maxLoad = 0.7; // The max load is supposed to be 70%

    public HashTable() { // Constructor
        cSize = 0;
        clear(10);
    }

    private void clear(int n) { // Sets up empty Hash Table
        table = new ArrayList<LinkedList<T>>();
        for (int i = 0; i < n; i++) {
            table.add(null);
        }
    }

    public void add(T val) { // Adds an element
        int pos = Math.abs(val.hashCode() % table.size()); // Position of element
        LinkedList<T> lst = table.get(pos); // The linked list at pos
        if (lst == null) {
            lst = new LinkedList<T>();
            table.set(pos,lst);
        }
        lst.add(val);
        cSize++;
        if ((double)cSize / table.size() >= maxLoad) {
            resize();
        }
    }

    public void remove(T val) { // Removes an element
        LinkedList<T> lst = table.get(Math.abs(val.hashCode()) % table.size());
        if (lst != null) {
            lst.remove(val); // Uses the LinkedList remove
            if (lst.size()==0) {
                lst = null;
            }
        }
    }

    public boolean contains(T val) { // Checks if element is in table
        LinkedList<T> lst = table.get(Math.abs(val.hashCode()) % table.size());
        if (lst != null) {
            return lst.contains(val);
        }
        return false;
    }

    public double getLoad() { // Load getter
        double c = 0;
        for (LinkedList<T> lst : table) {
            c++; // haha get the joke? it's C++
        }
        return c/table.size();
    }

    public void setMaxLoad(double percent) { // Sets max load
        if ( 0.1 <= percent && percent <= 0.8) {
            maxLoad = percent;
        }
    }

    public void setLoad(double percent) { // Sets load provided less than max load
        if (percent >= 0.1 && percent <= 0.8){
            if (percent > maxLoad){
                return;
            }
            else{
                resize(percent); // Calls helper method to resize
            }
        }
    }

    public void resize() { // Resizes the hash table
        ArrayList<LinkedList<T>>tmp = table;
        cSize = 0;
        clear(table.size()*10);
        for (LinkedList<T>lst : tmp) {
            if (lst != null) {
                for (T val:lst) {
                    add(val);
                }
            }
        }
    }

    public void resize(double load) { // Helper method for setLoad() that resizes given the load value
        ArrayList<LinkedList<T>>tmp = table;
        cSize = 0;
        int n = (int)(cSize/load);
        clear(n);
        for (LinkedList<T>lst : tmp) {
            if (lst != null) {
                for (T val:lst) {
                    add(val);
                }
            }
        }
    }

    @Override
    public String toString() {
        String ans = "";
        for (LinkedList<T>lst : table) {
            if (lst != null) {
                for (T val : lst) {
                    ans += ", "+val;
                }
            }
        }
        if (ans != "") {
            ans = ans.substring(2);
        }
        return "<" + ans + ">";
    }

    public ArrayList<T> toArray() { // Converts HashTable to ArrayList
        ArrayList<T> hashlist = new ArrayList<T>();
        for (LinkedList<T> lst : table){
            if (lst!= null){
                for (T val : lst){
                    hashlist.add(val);
                }
            }
        }
        return hashlist;
    }
}
/*
Hash Tables are awesome because they have O(1) add/delete/access times.
No predictable order.
 */