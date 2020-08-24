public class HashNode {

    String key;
    String value;

    HashNode next;

    public HashNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(String v) {
        value = v;
    }

    public String toString() {
        return "[" + key + "," + value + "]";
    }

}
