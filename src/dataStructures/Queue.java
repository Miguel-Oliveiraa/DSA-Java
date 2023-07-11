package dataStructures;

public interface Queue<E> {
    public void clear(); // Remove all content from queue

    public void enqueue(E it); // Place an element at the rear of the queue

    public E dequeue(); // Remove the element at the front of the queue

    public E frontValue(); // Return the front element

    public int length(); // Return the number of elements in the queue
}
