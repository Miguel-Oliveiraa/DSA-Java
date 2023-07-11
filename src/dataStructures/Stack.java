package dataStructures;

public interface Stack<E>{
    public void clear(); // Remove all content from the stack

    public void push(E it);  // Push an element onto the top of the stack

    public E pop(); // Remove and return the element at the top of the stack

    public E topValue(); // Return a copy of the top element

    public int length(); // Return the number of elements in the stack.
}
