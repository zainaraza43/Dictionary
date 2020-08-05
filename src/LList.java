public class LList { // The LList object

    private LNode head,tail; // head is the node at the start of the list, tail is the node at the bottom of the list

    public LList() { // constructor method to initialize head and tail
        head = null;
        tail = null;
    }

    public void insertAt(int position, LNode data) {
        LNode temp;
        if (position == 0) {
            data.setNext(head);
            head = data;
        }
        else {
            temp = head;
            while (--position > 0) {
                temp = temp.getNext();
            }
            data.setNext(temp.getNext());
            data.setPrev(temp);
        }
    }

    public void insertEnd(int v) { // takes a value to insert at the back of the list (at the tail)
        if (head == null) { // case where there is no head (empty list)
            head = new LNode(null,v,null);
            tail = head;
        }
        else { /// case where there's at least one element in the list
            LNode temp = new LNode(tail,v,null);
            tail.setNext(temp);
            tail = temp;
        }
    }

    public LNode deleteEnd() { // removes the last element in the list
        if (head == null) { // case where the list is empty
            return null;
        } else { // case where the list has at least an element
            LNode temp = tail;
            tail = temp.getPrev(); // deletes the last element
            return temp;
        }
    }

    public void delete(LNode node) { // deletes an element from its LNode reference
        if (node == head && node == tail) { // case if the list empty
            head = null;
            tail = null;
        }
        else if (node == tail) { // case if node in question is the tail node
            tail = node.getPrev();
            tail.setNext(null);
        }
        else if (node == head) { // case if node in question is the head node
            head = node.getNext();
            head.setPrev(null);
        }
        else { // case if the node in question is between the head and tail
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void delete(int n) { // deletes an element by its integer value
        LNode temp = head;
        while (temp != null) { // goes through the Linked List by each node
            if (temp.getVal() == n) { // if the value of the current node matches the integer passed through
                delete(temp);
                return; // ends method
            }
            temp = temp.getNext();
        }
    }

    public void deleteAt(int n) { // deletes an element at position 0-x
        LNode temp = head;
        for (int x = 0;x<n;x++) { // goes through all the elements in the list
            temp = temp.getNext();
        }
        delete(temp);
    }

    public int getSize() {
        LNode temp = head;
        int c = 0;
        while (temp != null) {
            temp = temp.getNext();
            c++;
        }
        return c;
    }

    @Override
    public String toString() { // Returns a string to visually represent the LList
        String ans = "";
        LNode temp = head;
        while (temp != null) {
            ans += temp+"-";
            temp = temp.getNext();
        }
        if (ans.length() != 0) {
            ans = ans.substring(0, ans.length()-1);
        }
        return ans;
    }
}