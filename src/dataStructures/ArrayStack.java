package dataStructures;

public class ArrayStack<E> implements Stack<E>{
    // Attributes
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size
    private int top; // Index for top element
    private E[] listArray; // Array holding stack

    // Constructor
    ArrayStack() {this(defaultSize);};
    @SuppressWarnings("unchecked") //Generic array allocation
    ArrayStack(int size) {
        maxSize = size;
        top = 0;
        listArray = (E[])new Object[size]; // Create listArray
    }

    // Methods
    public void clear() {
        top = 0;
    }

    public void push(E it) {
        assert top != maxSize : "Stack is full";
        listArray[top++] = it;
    }

    public E pop() {
        assert  top != 0 : "Stack if empty";
        return listArray[--top];
    }

    public E topValue() {
        assert top != 0 : "Stack is empty";
        return listArray[top-1];
    }

    public int length() {
        return top;
    }

}
