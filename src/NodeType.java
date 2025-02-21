// NodeType.java
/**
 * Represents a node in a doubly linked list
 * Written by David Uzor
 * @param <T> the type of element stored in the node, must implement Comparable
 */
public class NodeType<T extends Comparable<T>> {
    /** The data stored in this node */
    public T info;
    /** Reference to the next node */
    public NodeType<T> next;
    /** Reference to the previous node */
    public NodeType<T> back;

    /**
     * Creates a new node with the given data
     * @param info the data to store in this node
     */
    public NodeType(T info) {
        this.info = info;
        this.next = null;
        this.back = null;
    }
}
