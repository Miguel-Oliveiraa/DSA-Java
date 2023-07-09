package dataStructures;

/** Node for linkedBased dataStructures **/
public class Link<E> {
    // Attributes
    private E element; // Value of this node
    private Link<E> next; // Pointer to next node

    // Constructors
    Link(E it, Link<E> nextVal) {
        element = it;
        next = nextVal;
    }
    Link(Link<E> nextVal) {
        next=nextVal;
    }

    // Methods
    Link<E> next() {
        return next; // Return next field
    }
    Link<E> setNext(Link<E> nextVal) {
        return next = nextVal; // Set next field
    }
    E element() {
        return element;  // Return element
    }
    E setElement(E it) {
        return element = it; // Set element field
    }
}
