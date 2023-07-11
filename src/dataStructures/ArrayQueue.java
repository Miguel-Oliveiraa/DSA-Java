package dataStructures;

public class ArrayQueue<E> implements Queue<E>{
    // Attributes
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size
    private int front; // Index of front element
    private int rear; // Index of rear element
    private E[] listArray; // Array holding queue

    // Constructor
    ArrayQueue() {this(defaultSize);}
    @SuppressWarnings("unchecked") // Generic array
    ArrayQueue(int size) {
        maxSize = size+1; // One extra space for circular
        rear = 0; front = 1;
        listArray = (E[])new Object[maxSize]; // Create listArray
    }

    // Methods
    public void clear() {
        rear = 0; front = 1;
    }

    public void enqueue(E it) {
        assert ((rear+2)%maxSize) != front : "Queue is full";
        rear = (rear+1)%maxSize; // Circular increment
        listArray[rear] = it;
    }

    public E dequeue() {
        assert length() != 0 : "Queue is empty";
        E it = listArray[front];
        front = (front+1)%maxSize; // Circular increment
        return it;
    }

    public E frontValue() {
        assert length() != 0 : "Queue is empty";
        return listArray[front];
    }

    public int length() {
        return ((rear+maxSize)-front+1)%maxSize;
    }
}
