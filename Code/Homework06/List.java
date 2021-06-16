
public class List {
    private ListNode head;      // points the first element in the list
    private ListNode current;  // points the current element in the list
    private ListNode tail;    // points the last element in the list
    private int length;      // length of, or simply the # of elements in the list

    
    public List() {
        this.head = null;
        this.tail = null;
        this.current = head;
        this.length = 0;
    }


    public void append(int number) {
        ListNode newListNode = new ListNode(number);
        this.length++;

        // Special case empty list
        if (this.isEmpty()) {
            head = newListNode;
            tail = head;
            current = head;
            return;
        }

        newListNode.setPrev(tail);
        tail.setNext(newListNode);
        tail = tail.getNext();
    }

    // Removes the current element from the list
    public void remove() {
        // Special case 1
        if (current == null)
            return;

        // Special case 2
        if (head == current) {
            current = head = head.getNext();
            head.setPrev(null);
            this.length--;
            return;
        }

        // Special case 2
        if (tail == current) {
            current = tail = tail.getPrev();
            tail.setNext(null);
            this.length--;
            return;
        }

        // General case
        this.current.getPrev().setNext(this.current.getNext());
        this.current.getNext().setPrev(this.current.getPrev());
        this.current = this.current.getNext();
        this.length--;
    }

    // Removes all elements of the list
    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.current = head;
        this.length = 0;
    }

    // Returns true if list is empty
    public boolean isEmpty() {
        return this.head == null;
    }

    // Sets the current on the first element(head) of the list
    public void begin() {
        this.current = this.head;
    }

    // Sets the current on the lst element(tail) of the list
    public void end() {
        this.current = this.tail;
    }

    // Sets the current on the next element
    public void next() {
        if (this.current.getNext() != null) {
            this.current = this.current.getNext();
        }
    }

    // Sets the current on the previous element
    public void prev() {
        if (this.current.getPrev() != null) {
            this.current = this.current.getPrev();
        }
    }

    // Returns the value of the variable length
    public int getLength() {
        return this.length;
    }

    // Returns the value of the current
    public int getcurrent() {
        return this.current.getNumber();
    }

    // Prints all the data contained in the list
    public void print() {
        this.begin();
        int i = 0;

        while (i < this.length) {
            System.out.println("Value of list node [" + i + "] is: " + this.current.getNumber());
            i++;
            this.next();
        }

        System.out.println("\n");
    }
}