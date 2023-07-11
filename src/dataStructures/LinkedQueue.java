package dataStructures;

public class LinkedQueue<E> implements Queue<E>{
    // Attributes
    private Link<E> front; // Pointer to the front
    private Link<E> rear; // Pointer to the rear
    private int size; // Numbers of elements

    // Constructor
    public LinkedQueue() {
        init();
    }
    public LinkedQueue(int size){
        init(); // Ignore size
    }

    // Methods
    private void init() {
        front = rear = new Link<E>(null);
        size = 0;
    }

    public void clear() {
        init();
    }

    public void enqueue(E it){
        rear.setNext(new Link<E>(it, null));
        rear = rear.next();
        size++;
    }

    public E dequeue() {
        assert size != 0 : "Queue is empty";
        E it = front.next().element(); // Store dequeue value
        front.setNext(front.next().next()); // Advance front
        if (front.next()==null) rear = front; // Last Object
        size--;
        return it;
    }

    public E frontValue() {
        assert size != 0 : "Queue is empty";
        return front.next().element();
    }

    public int length() {
        return size;
    }
}
