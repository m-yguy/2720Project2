// DoublyLinkedListDriver.java
import java.io.*;
import java.util.*;

public class DoublyLinkedListDriver {

    private static String listType;
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java LinkedListDriver <input-file>");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String type = scanner.next();

        listType = type;

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
            else if (command.equals("r")) {
                System.out.print("The original list: ");
                System.out.println(list);
                list.reverseList();
                System.out.print("The reversed list: ");
                System.out.println(list);
            }
            else if (command.equals("s")) {
                list.print();
                list.swapAlt();
                list.print();
                list.printReverse();
            }
            else if (command.equals("b")) {
                list.print();
                System.out.println("Enter lower bound: ");
                T lowerBound = parseInput(scanner, list.getFirst().info.getClass());
                System.out.println("Enter upper bound: ");
                T upperBound = parseInput(scanner, list.getFirst().info.getClass());
                list.deleteSubsection(lowerBound, upperBound);
                list.print();
                list.printReverse();
            }
            else if (command.equals("i")) {
                list.print();
                if (listType.equals("i")) {
                    System.out.println("Enter an number to insert: ");
                } else if (listType.equals("d")) {
                    System.out.println("Enter a number to insert: ");
                } else {
                    System.out.println("Enter a string to insert: ");
                }
                T item = parseInput(scanner, list.getFirst().info.getClass());
                list.insertItem(item);

                list.print();
                list.printReverse();
            }
            else if (command.equals("d")) {
                list.print();

                if (listType.equals("i")) {
                    System.out.println("Enter a number to delete: ");
                }
                if (listType.equals("d")) {
                    System.out.println("Enter a number to delete: ");
                }
                if (listType.equals("s")) {
                    System.out.println("Enter a string to delete: ");
                }
                T item = parseInput(scanner, list.getFirst().info.getClass());
                list.deleteItem(item);
                list.print();
                list.printReverse();
            }
            
            
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T parseInput(Scanner scanner, Class<?> type) {
        String input = scanner.next();
        if (type == Integer.class) {
            return (T) Integer.valueOf(input);
        } else if (type == Double.class) {
            return (T) Double.valueOf(input);
        } else {
            return (T) input;
        }
    }
}
