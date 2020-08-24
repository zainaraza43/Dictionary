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

public class HashTable {

    private HashNode[] table;
    private int size;

    public HashTable(int tableSize) {
        table = new HashNode[tableSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void Clear() {
        int len = table.length;
        table = new HashNode[len];
        size = 0;
    }

    public int Hash(String key) {
        int hVal = key.hashCode();
        return Math.abs(hVal % table.length);
    }

    public void Insert(String key, String value) {

        // Locating correct index number in array
        size++;
        int index = Hash(key);
        HashNode temp = new HashNode(key,value);
        //System.out.println("Inserting: ("+key+", "+value+")"+" @ index #"+index);
        if (table[index] != null) {
            temp.next = table[index];
        }
        table[index] = temp;

    }

    public boolean doesExist(String key) {
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode temp = table[index];
        return temp != null;
    }

    public String IndexDefinition(String key, int ind) {
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode start = table[index];
        String temp = start.value;
        int pos = 1;
        while (start != null) {
            pos++;
            if (ind == pos) {
                return start.value;
            }
            start = start.next;
        }
        return temp;
    }

    public void Edit(String key, String value, String newValue) {
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode start = table[index];

        while (start != null) {
            if (start.value.equals(value)) {
                start.setValue(newValue);
            }
            start = start.next;
        }

    }

    public void Remove(String key, String value) {
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode start = table[index];
        HashNode end = start;

        if (start.value.equals(value)) {
            size--;
            table[index] = start.next;
            return;
        }
        while (end.next != null && !(end.next.value.equals(value))) {
            end = end.next;
        }
        if (end.next == null) {
            System.out.println("Couldn't find the element!");
            return;
        }
        size--;
        if (end.next.next == null) {
            end.next = null;
            return;
        }
        end.next = end.next.next;
        table[index] = start;

    }

    public void Lookup(String key) {
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key), pos = 0;
        HashNode start = table[index];

        if (start == null) {
            System.out.println("No entries found for: "+key+"!");
            return;
        }

        System.out.println("Lookup for "+key+":");
        while (start != null) {
            pos++;
            System.out.println(pos+"."+start.value);
            start = start.next;
        }
    }

    public void Display() {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Index " + i + ":  ");
            HashNode start = table[i];
            while(start != null)
            {
                System.out.print("("+start.key +", "+start.value+") ");
                start = start.next;
            }
            System.out.println();
        }
    }

}
