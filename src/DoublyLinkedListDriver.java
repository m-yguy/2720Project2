import java.util.Scanner;

public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java DoublyLinkedListDriver <input-file>");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String type = scanner.next();

        DoublyLinkedList<?> list;
        if (type.equals("i")) {
            list = new DoublyLinkedList<Integer>();
        } else if (type.equals("d")) {
            list = new DoublyLinkedList<Double>();
        } else if (type.equals("s")) {
            list = new DoublyLinkedList<String>();
        } else {
            System.out.println("Invalid list type.");
            return;
        }

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete Subsection");
        System.out.println("(s) - Swap Alternate");
        System.out.println("(q) - Quit program");

        while (true) {
            System.out.println("Enter a command: ");
            String command = scanner.next();
            if (command.equals("q")) {
                System.out.println("Exiting the program...");
                break;
            } else if (command.equals("p")) list.print();
            else if (command.equals("l")) System.out.println("The length of the list is " + list.length());
            else if (command.equals("t")) list.printReverse();
            else if (command.equals("r")) list.reverseList();
            else if (command.equals("s")) list.swapAlt();
            else if (command.equals("i")) {
                System.out.println("Enter a value to insert: ");
                if (list instanceof DoublyLinkedList<Integer>) ((DoublyLinkedList<Integer>) list).insertItem(scanner.nextInt());
                else if (list instanceof DoublyLinkedList<Double>) ((DoublyLinkedList<Double>) list).insertItem(scanner.nextDouble());
                else ((DoublyLinkedList<String>) list).insertItem(scanner.next());
            } else if (command.equals("d")) {
                System.out.println("Enter a value to delete: ");
                if (list instanceof DoublyLinkedList<Integer>) ((DoublyLinkedList<Integer>) list).deleteItem(scanner.nextInt());
                else if (list instanceof DoublyLinkedList<Double>) ((DoublyLinkedList<Double>) list).deleteItem(scanner.nextDouble());
                else ((DoublyLinkedList<String>) list).deleteItem(scanner.next());
            }


            // Add handling for commands here
        }
    }
}
