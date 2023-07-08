package dataStructures;

public interface List<E> {
    public void clear(); // Remove all content from the list

    public void insert(E item); //Insert and element in the current location

    public void append(E item); //Append an element to the end of the list

    public E remove(); //Remove and return the current element

    public void moveToStart(); //Set current position to the start

    public void moveToEnd(); //Set current position to the end

    public void prev(); //Set current one step left

    public void next(); //Set Current one step right

    public int length(); //The number of elements in the list

    public int currPos(); //The position of the current element

    public void moveToPos(int pos); //Set the @param pos as the current position

    public E getValue(); //Return current element
}
