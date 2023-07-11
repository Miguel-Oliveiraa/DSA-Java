package dataStructures;

public class LinkedStack<E> implements Stack<E> {
    // Attributes
    private Link<E> top; // Pointer to first element
    private int size; // Number of element

    // Constructors
    public LinkedStack() {
        top = null; size = 0;
    }
    public LinkedStack(int size) {
        top = null; size = 0;
    }

    // Methods
    public void clear() {
        top = null; size = 0;
    }

    public void push(E it) {
        top = new Link<E>(it, top);
        size++;
    }

    public E pop() {
        assert top != null : "Stack is empty";
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }

    public E topValue() {
        assert top != null : "Stack is empty";
        return top.element();
    }

    public int length() {
        return size;
    }
}
