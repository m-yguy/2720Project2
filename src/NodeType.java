// NodeType.java
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType(T info) {
        this.info = info;
        this.next = null;
        this.back = null;
    }
}
