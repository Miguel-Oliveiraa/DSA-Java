package dataStructures;

public class ArrayList<E> implements List<E> {
    private static final int defaultSize = 10; // Default size
    private int maxSize; // Max size of list
    private int listSize; // Current number of list items
    private int curr; // Current element pos
    private E[] listArray; // Array holding list elements

    /* Create a list with the default size. */
    ArrayList() {this(defaultSize);};
    @SuppressWarnings("unchecked") // Generic array allocation
    ArrayList(int size) {
        maxSize= size;
        listSize = curr = 0;
        listArray = (E[])new Object[size]; // Create listArray
    }

    public void clear() {
        listSize = curr = 0; // Reinitialize  values
    }

    public void insert(E it) {
        assert listSize < maxSize : "List capacity exceeded";
        for (int i = listSize; i > curr; i--) {
            listArray[i] = listArray[i-1];
        }
        listArray[curr] = it;
        listSize++;
    }

    public void append(E it) {
        assert listSize < maxSize : "List capacity exceeded";
        listArray[listSize++] = it;
    }

    public E remove(){
        if ((curr<0) || (curr>=listSize))
            return null;
        E it = listArray[curr];
        for (int i = curr; i < listSize - 1; i++) {
            listArray[i] = listArray[i+1];
        }
        listSize--;
        return it;
    }

    public void moveToStart() {
        curr = 0;
    }
    public void moveToEnd() {
        curr = listSize;
    }

    public void prev() {
        if (curr != 0)
            curr--;
    }

    public void next() {
        if (curr < maxSize)
            curr ++;
    }

    public int length() {
        return listSize;
    }

    public int currPos() {
        return curr;
    }

    public void moveToPos(int pos) {
        assert (pos>=0) && (pos < listSize) : "Pos out of range";
        curr = pos;
    }

    public E getValue(){
        assert (curr>=0) && (curr < listSize) : "No current element";
        return listArray[curr];
    }
}
