// DoublyLinkedListDriver.java
import java.io.*;
import java.util.*;

public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java LinkedListDriver <input-file>");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String type = scanner.next();

        System.out.println("(i) - Insert Value\n(d) - Delete Value\n(p) - Print list\n(l) - Length");
        System.out.println("(t) - Print reverse\n(r) - Reverse list\n(b) - Delete Subsection");
        System.out.println("(s) - Swap Alternate\n(q) - Quit program");

        try {
            Scanner fileScanner = new Scanner(new File(args[0]));
            if (type.equals("i")) {
                DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
                while (fileScanner.hasNextInt()) {
                  list.insertItem(fileScanner.nextInt());
                }
                processCommands(scanner, list);
            } else if (type.equals("d")) {
                DoublyLinkedList<Double> list = new DoublyLinkedList<>();
                while (fileScanner.hasNextDouble()) {
                    list.insertItem(fileScanner.nextDouble());
                }
                processCommands(scanner, list);
            } else if (type.equals("s")) {
                DoublyLinkedList<String> list = new DoublyLinkedList<>();
                while (fileScanner.hasNext()) {
                    list.insertItem(fileScanner.next());
                }
                processCommands(scanner, list);
            }
            fileScanner.close();


        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    private static <T extends Comparable<T>> void processCommands(Scanner scanner, DoublyLinkedList<T> list) {
        while (true) {
            System.out.println("Enter a command:");
            String command = scanner.next();
            if (command.equals("q")) break;
            else if (command.equals("p")) list.print();
            else if (command.equals("t")) list.printReverse();
            else if (command.equals("l")) System.out.println("The length of the list is " + list.length());
            else if (command.equals("r")) list.reverseList();
            else if (command.equals("s")) list.swapAlt();
        }
    }
}
