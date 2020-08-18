public class HashNode {

    String key;
    String value;

    HashNode next;

    public HashNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "[" + key + "," + value + "]";
    }

}
