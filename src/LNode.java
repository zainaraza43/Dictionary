public class LNode {
    private int val;
    private LNode next,prev;

    public LNode(LNode p, int v, LNode n) {
        val = v;
        next = n;
        prev = p;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int v) {
        val = v;
    }
    public LNode getNext() {
        return next;
    }
    public void setNext(LNode n) {
        next = n;
    }
    public LNode getPrev() {
        return prev;
    }
    public void setPrev(LNode p) {
        prev = p;
    }
    public String toString() {
        return "[" + val + "]";
    }
}