package dataStructures;

public class LinkedList<E> implements List<E> {
    // Attributes
    private Link <E> head; // Pointer to list header
    private Link<E> tail; // Pointer to last element
    protected Link<E> curr; // Access to current element
    private int cnt; // Size of list

    // Constructors
    public LinkedList(int size) {this();}
    LinkedList() {
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    // Methods
    public void clear() {
        head.setNext(null);         // Drop access to links
        curr = tail = head = new Link<E>(null);
        cnt = 0;
    }

    public void insert(E it) {
        curr.setNext(new Link<>(it, curr.next()));
        if (tail==curr) tail=curr.next();
        cnt++;
    }

    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }

    public E remove() {
        if (curr.next() == null) return null; // Nothing to remove
        E it = curr.next().element();         // Remember value
        if (tail==curr.next()) tail = curr;   // Removed last
        curr.setNext(curr.next().next());     // Remove from list (remove pointer and set curr.next=removed.next)
        cnt--;                                // Decrement count
        return it;                            // Return value
    }

    public void moveToStart() {
        curr = head;
    }

    public void moveToEnd() {
        curr = tail;
    }

    public void prev() {
        if (curr == head) return; // No previous element
        Link<E> temp = head;
        while (temp.next() != curr) temp = temp.next(); // March up from head until we find the previous
        curr=temp;
    }

    public void next() {
        if (curr != tail) curr = curr.next();
    }

    public int length () {
        return cnt;
    }

    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=cnt) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
    }

    public E getValue() {
        if(curr.next() == null) return null;
        return curr.next().element();
    }

    public int count(E it) {
        int c = 0;
        Link<E> temp = head;
        while (temp.next() != null) {
            if (temp.next().element() == it) c++;
            temp = temp.next();
        }
        return c;
    }
}
