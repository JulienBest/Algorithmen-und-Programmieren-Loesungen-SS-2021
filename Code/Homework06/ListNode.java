
public class ListNode {

    private int number;      // data of the current object(int)
    private ListNode next;  // points the next object(ListNode)
    private ListNode prev; // points the previous object(ListNode)

    
    public ListNode() {
        this.number = 0;
        this.next = null;
        this.prev = null;
    }

    
    public ListNode(int inputnum) {
        this.number = inputnum;
        this.next = null;
        this.prev = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
}
