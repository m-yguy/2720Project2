// DoublyLinkedList.java
import java.util.*;

/**
 * A generic doubly linked list implementation that stores comparable elements
 * @param <T> the type of elements stored in the list, must implement Comparable
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    /** Head node of the list */
    private NodeType<T> head;

    /**
     * Constructs an empty doubly linked list
     */
    public DoublyLinkedList() {
        this.head = null;
    }

    /**
     * Inserts an item into the list in sorted order
     * Written by Million Yohannes
     * @param item the item to insert
     * Time Complexity: O(n) where n is the number of nodes in the list
     */
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>(item);
        if (head == null || head.info.compareTo(item) > 0) {
            newNode.next = head;
            if (head != null) head.back = newNode;
            head = newNode;
        } else {
            NodeType<T> current = head;
            while (current.next != null && current.next.info.compareTo(item) < 0) {
                current = current.next;
            }
            if (current.info.equals(item)) {
                System.out.println("Item already exists");
                return;
            }
            newNode.next = current.next;
            if (current.next != null) current.next.back = newNode;
            current.next = newNode;
            newNode.back = current;
        }
    }

    /**
     * Deletes the first occurrence of an item from the list
     * Written by David Uzor
     * @param item the item to delete
     * Time Complexity: O(n) where n is the number of nodes in the list
     */
    public void deleteItem(T item) {
        if (head == null) {
            return;
        }
        NodeType<T> current = head;
        while (current != null && !current.info.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("The item is not present in the list");
            return;
        }
        if (current.back != null) current.back.next = current.next;
        if (current.next != null) current.next.back = current.back;
        if (current == head) head = current.next;
    }

    /**
     * Returns the number of elements in the list
     * @return the length of the list  
     * Written by Million Yohannes
     * Time Complexity: O(n) where n is the number of nodes
     */
    public int length() {
        int count = 0;
        NodeType<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Prints the list in forward order
     *  Written by David Uzor
     */
    public void print() {
        System.out.print("The list is: ");
        System.out.println(this);
    }

    
    /**
     * Prints the list in reverse order using the back pointers
     * Written by Million Yohannes
     */
    public void printReverse() {
        System.out.print("The reverse list: ");
        if (head == null) {
            System.out.println();
            return;
        }
        NodeType<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print( " " + current.info );
            current = current.back;
        }
        System.out.println();
    }

    /**
     * Deletes all elements between lower and upper bounds (inclusive)
     * @param lower the lower bound value
     * @param upper the upper bound value
     * Written by David Uzor
     * Time Complexity: O(n) where n is the number of nodes
     */
    public void deleteSubsection(T lower, T upper) {
        System.out.println("Enter the lower bound: " + lower);
        System.out.println("Enter the upper bound: " + upper);
        NodeType<T> current = head;
        while (current != null && current.info.compareTo(lower) < 0) {
            current = current.next;
        }
        while (current != null && current.info.compareTo(upper) <= 0) {
            NodeType<T> temp = current;
            current = current.next;
            deleteItem(temp.info);
        }
    }

    /**
     * Reverses the list by swapping next and back pointers
     * Written by Million Yohannes
     * Time Complexity: O(n) where n is the number of nodes
     */
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        NodeType<T> current = head;
        NodeType<T> temp = null;
        // Swap next and back pointers for all nodes
        while (current != null) {
            // Store the back pointer
            temp = current.back;
            
            // Swap the back and next pointers
            current.back = current.next;
            current.next = temp;
            
            // Move to the next node
            // (Using back because we just swapped pointers)
            current = current.back;
        }
        
        // Update the head to point to the last node
        if (temp != null) {
            head = temp.back;
        }
        
        
    }

    /**
     * Swaps alternate elements in the list
     * Written by David Uzor
     * Time Complexity: O(n) where n is the number of nodes
     */
    public void swapAlt() {
        NodeType<T> current = head;
        while (current != null && current.next != null) {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;
            current = current.next.next;
        }
    }

    /**
     * Returns the first node in the list
     * Written by Million Yohannes
     * @return the first node
     */ 
    public NodeType<T> getFirst() {
        return head;
    }

    /* Returns a string representation of the list 
     * by David Uzor
    */
    @Override
    public String toString() {
        String result = "";
        if (head == null) {
            return result;
        }
        NodeType<T> current = head;
        while (current != null) {
            result += current.info + " ";
            current = current.next;
        }
        return result;
    }
}