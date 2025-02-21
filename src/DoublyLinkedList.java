// DoublyLinkedList.java
import java.util.*;

public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    public DoublyLinkedList() {
        this.head = null;
    }

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
        print();
    }

    public void deleteItem(T item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
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
        print();
    }

    public int length() {
        int count = 0;
        NodeType<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void print() {
        System.out.print("The list is: ");
        NodeType<T> current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

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
            System.out.print(current.info + " ");
            current = current.back;
        }
        System.out.println();
    }

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

    public void reverseList() {
        NodeType<T> temp = null;
        NodeType<T> current = head;
        while (current != null) {
            temp = current.back;
            current.back = current.next;
            current.next = temp;
            current = current.back;
        }
        if (temp != null) head = temp.back;
        print();
    }

    public void swapAlt() {
        NodeType<T> current = head;
        while (current != null && current.next != null) {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;
            current = current.next.next;
        }
        print();
    }

    public NodeType<T> getFirst() {
        return head;
    }
}
