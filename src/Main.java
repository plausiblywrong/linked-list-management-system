import java.util.OptionalInt;
import java.util.Scanner;

/** Console user interface. The list classes contain all data-structure logic. */
public final class Main {
    private static final Scanner IN = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== LINKED LIST MANAGEMENT SYSTEM ===\n1. Singly Linked List\n2. Doubly Linked List\n3. Compare lists\n4. Exit");
            switch (number("Choose: ")) { case 1 -> singlyMenu(); case 2 -> doublyMenu(); case 3 -> compare(); case 4 -> running = false; default -> System.out.println("Choose 1-4."); }
        }
        System.out.println("Goodbye.");
    }
    private static void singlyMenu() { SinglyLinkedList list = new SinglyLinkedList(); boolean again = true; while (again) { printMenu("SINGLY LINKED LIST", false); int c=number("Choose: "); switch(c) {
        case 1 -> { list.insertBeginning(number("Value: ")); ok(); } case 2 -> { list.insertEnd(number("Value: ")); ok(); }
        case 3 -> result(list.insertAt(number("Position (1-based): "), number("Value: ")), "Invalid position.");
        case 4 -> result(list.insertAfter(number("Insert after value: "), number("New value: ")), "Value not found.");
        case 5 -> result(list.insertBefore(number("Insert before value: "), number("New value: ")), "Value not found.");
        case 6 -> result(list.deleteBeginning(), "List is empty."); case 7 -> result(list.deleteEnd(), "List is empty.");
        case 8 -> result(list.deleteAt(number("Position (1-based): ")), "Invalid position."); case 9 -> result(list.deleteValue(number("Value: ")), "Value not found.");
        case 10 -> searchResult(list.search(number("Value: "))); case 11 -> result(list.update(number("Old value: "), number("New value: ")), "Value not found.");
        case 12 -> System.out.println(list.display()); case 13 -> System.out.println("Nodes: " + list.count()); case 14 -> optional("Maximum", list.maximum()); case 15 -> optional("Minimum", list.minimum()); case 16 -> optional("Middle", list.middle());
        case 17 -> { list.reverse(); ok(); } case 18 -> { list.sort(); ok(); } case 19 -> System.out.println("Duplicates removed: " + list.removeDuplicates()); case 20 -> again=false; default -> System.out.println("Choose 1-20."); } } }
    private static void doublyMenu() { DoublyLinkedList list = new DoublyLinkedList(); boolean again = true; while (again) { printMenu("DOUBLY LINKED LIST", true); int c=number("Choose: "); switch(c) {
        case 1 -> { list.insertBeginning(number("Value: ")); ok(); } case 2 -> { list.insertEnd(number("Value: ")); ok(); }
        case 3 -> result(list.insertAt(number("Position (1-based): "), number("Value: ")), "Invalid position.");
        case 4 -> result(list.insertAfter(number("Insert after value: "), number("New value: ")), "Value not found."); case 5 -> result(list.insertBefore(number("Insert before value: "), number("New value: ")), "Value not found.");
        case 6 -> result(list.deleteBeginning(), "List is empty."); case 7 -> result(list.deleteEnd(), "List is empty."); case 8 -> result(list.deleteAt(number("Position (1-based): ")), "Invalid position."); case 9 -> result(list.deleteValue(number("Value: ")), "Value not found.");
        case 10 -> searchResult(list.search(number("Value: "))); case 11 -> result(list.update(number("Old value: "), number("New value: ")), "Value not found."); case 12 -> System.out.println(list.displayForward()); case 13 -> System.out.println(list.displayBackward());
        case 14 -> System.out.println("Nodes: " + list.count()); case 15 -> optional("Maximum", list.maximum()); case 16 -> optional("Minimum", list.minimum()); case 17 -> optional("Middle", list.middle()); case 18 -> { list.reverse(); ok(); } case 19 -> { list.sort(); ok(); } case 20 -> System.out.println("Duplicates removed: " + list.removeDuplicates()); case 21 -> again=false; default -> System.out.println("Choose 1-21."); } } }
    private static void printMenu(String title, boolean doubly) { System.out.println("\n--- " + title + " ---\n1. Insert at beginning\n2. Insert at end\n3. Insert at position\n4. Insert after a node\n5. Insert before a node\n6. Delete from beginning\n7. Delete from end\n8. Delete from position\n9. Delete by value\n10. Search\n11. Update\n12. Display " + (doubly ? "forward\n13. Display backward\n14. Count nodes\n15. Find maximum\n16. Find minimum\n17. Find middle\n18. Reverse\n19. Sort\n20. Remove duplicates\n21. Back" : "\n13. Count nodes\n14. Find maximum\n15. Find minimum\n16. Find middle\n17. Reverse\n18. Sort\n19. Remove duplicates\n20. Back")); }
    private static void compare() { System.out.println("\nSingly linked list: each node has data and next. It uses less memory, but backward traversal is impossible and deleting a known last node requires finding its predecessor.\nDoubly linked list: each node has prev and next. It uses more memory but supports backward traversal and O(1) tail deletion when a tail reference is kept."); }
    private static int number(String prompt) { while (true) { System.out.print(prompt); if (IN.hasNextInt()) return IN.nextInt(); System.out.println("Enter an integer."); IN.next(); } }
    private static void result(boolean success, String failure) { System.out.println(success ? "Operation completed." : failure); }
    private static void searchResult(int position) { System.out.println(position < 0 ? "Value not found." : "Found at position " + position + "."); }
    private static void optional(String label, OptionalInt value) { System.out.println(value.isPresent() ? label + ": " + value.getAsInt() : "List is empty."); }
    private static void ok() { System.out.println("Operation completed."); }
}
