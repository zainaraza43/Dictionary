/*
HashNode.java
A linked list node for use in the HashTable (since the method used is chaining)
 */

public class HashNode {

    String key; // The key in this case is the word's name
    String value; // The value is the / one of definition of the same word

    HashNode next; // Points to the next node (for multiple definitions of the same word)

    public HashNode(String key, String value) { // Constructor requires an initial key and value
        this.key = key;
        this.value = value;
    }

    public void setValue(String v) { // setValue is generally used to edit existing node definition
        value = v;
    }

    public String toString() { // For printing purposes
        return "[" + key + "," + value + "]";
    }

}
