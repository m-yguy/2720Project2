Million Yohannes, mys69629@uga.edu
David Uzor, diu08919@uga.edu

NodeType.java - Defines the Node structure for the doubly linked list.
DoublyLinkedList.java - Implements the doubly linked list with required operations.
DoublyLinkedListDriver.java - Handles user input, reads files, and executes commands.


Compilation & Execution
Compile the Java files using:

javac -d bin src/*.java
Run the program with:

java -cp bin DoublyLinkedListDriver <input.txt>
Example:
java -cp bin DoublyLinkedListDriver int-input.txt

Delete Subsection Pseudocode:
Start at the head.
Traverse until current.info >= lower.
While current.info <= upper, delete nodes.
If the list is empty or out of bounds, do nothing.

Complexity:
Best case: O(1) (if the list is empty or no elements in range)
Worst case: O(n) (if many elements need deletion)

---

reverseList() Pseudocode:
Traverse the list, swapping next and back pointers for each node.
Update the head pointer to the last node.

Complexity:
Always O(n), as every node is visited once.

---

swapAlt() Pseudocode:
Traverse the list, swapping info of adjacent nodes.
Continue until all pairs are swapped.

Complexity:
Best case: O(1) (if the list has 0 or 1 element)
Worst case: O(n), as every node is processed once.