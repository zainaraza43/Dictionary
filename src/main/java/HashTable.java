/*
HashTable.java
Implementation of a HashTable with chaining as our collision handler of choice.
This HashTable implements an Array of LinkedLists (HashNode.java)
 */
public class HashTable {

    private HashNode[] table; // The actual HashTable
    private int size; // The current size of the HashTable

    public HashTable(int tableSize) { // Constructor requires the maximum capacity
        table = new HashNode[tableSize]; // Declares a new table of size the capacity
        size = 0; // Current size is 0
    }

    public boolean isEmpty() { // Returns true if HashTable is empty
        return size == 0;
    }

    public int getSize() { // Returns the number of elements in the hashtable
        return size;
    }

    public void Clear() { // Removes all elements from the HashTable
        int len = table.length;
        table = new HashNode[len];
        size = 0;
    }

    public int Hash(String key) { // Returns a Hash Code for the String entered
        int hVal = key.hashCode();
        return Math.abs(hVal % table.length);
    }

    public void Insert(String key, String value) { // Inserts an element into the HashTable (requires a key and value)

        size++;
        int index = Hash(key);
        HashNode temp = new HashNode(key,value);


        if (table[index] != null) { // If there already is a definition for the word
            temp.next = table[index];
        }

        table[index] = temp;

    }

    public boolean doesExist(String key) { // Returns true if a key has already been used
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode temp = table[index];
        return temp != null; // If the node is null then the key hasn't been used yet
    }

    public String IndexDefinition(String key, int ind) { // Given a definition number, returns the String of the actual definition
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode start = table[index];
        String temp = start.value;
        int pos = 1;
        while (start != null) { // Locating correct definition
            pos++;
            if (ind == pos) {
                return start.value;
            }
            start = start.next;
        }
        return temp; // If not found, return the first definition
    }

    public void Edit(String key, String value, String newValue) { // Will edit a definition of the user's choice
        key = Character.toString(key.charAt(0)).toUpperCase() + key.substring(1).toLowerCase() + " ";
        int index = Hash(key);
        HashNode start = table[index];

        while (start != null) {
            if (start.value.equals(value)) {
                start.setValue(newValue); // Changes the definition of the selected value
            }
            start = start.next;
        }

    }

    public void Remove(String key, String value) { // Removes an entry in the dictionary
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

    public void Lookup(String key) { // Displays a list of definitions for a word
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

    public void Display() { // Displays all elements of the Hash Table
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
