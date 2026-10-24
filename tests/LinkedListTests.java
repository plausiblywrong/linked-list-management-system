/** Dependency-free regression tests for required edge cases and link-sensitive operations. */
public final class LinkedListTests {
    public static void main(String[] args) {
        testSingly();
        testDoubly();
        System.out.println("All linked-list tests passed.");
    }

    private static void testSingly() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.reverse();
        list.sort();
        check(!list.deleteBeginning(), "empty-list deletion");
        check(list.display().equals("NULL"), "empty-list display");
        check(!list.insertAt(0, 99), "position zero is invalid");

        list.insertEnd(20);
        list.insertBeginning(10);
        check(list.insertAt(3, 30), "insert at last valid position");
        check(!list.insertAt(5, 0), "out-of-range insertion");
        check(list.insertBefore(20, 15), "insert before");
        check(list.insertAfter(20, 25), "insert after");
        check(list.search(25) == 4 && list.search(999) == -1, "search");
        check(list.update(25, 26) && !list.update(999, 0), "update");
        check(list.display().equals("10 -> 15 -> 20 -> 26 -> 30 -> NULL"), "order");
        check(list.middle().getAsInt() == 20, "odd middle");

        list.insertEnd(30);
        list.insertEnd(-5);
        check(list.minimum().getAsInt() == -5 && list.maximum().getAsInt() == 30, "minimum and maximum");
        check(list.removeDuplicates() == 1, "duplicate removal");
        list.reverse();
        check(list.display().equals("-5 -> 30 -> 26 -> 20 -> 15 -> 10 -> NULL"), "reverse");
        list.sort();
        check(list.display().equals("-5 -> 10 -> 15 -> 20 -> 26 -> 30 -> NULL"), "sort");
        check(list.deleteAt(1) && list.deleteEnd() && !list.deleteValue(999), "deletions");

        SinglyLinkedList zeroAndNegative = new SinglyLinkedList();
        zeroAndNegative.insertEnd(0);
        zeroAndNegative.insertEnd(-1);
        check(zeroAndNegative.minimum().getAsInt() == -1 && zeroAndNegative.maximum().getAsInt() == 0,
                "zero and negative values");
    }

    private static void testDoubly() {
        DoublyLinkedList list = new DoublyLinkedList();
        check(!list.deleteEnd(), "empty-list deletion");
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        check(list.insertAt(2, 15), "position insertion");
        check(list.insertBefore(10, 5), "insert before head");
        check(list.insertAfter(30, 30), "insert after tail");
        check(list.displayForward().equals("NULL <-> 5 <-> 10 <-> 15 <-> 20 <-> 30 <-> 30 <-> NULL"), "forward traversal");
        check(list.displayBackward().equals("NULL <-> 30 <-> 30 <-> 20 <-> 15 <-> 10 <-> 5 <-> NULL"), "backward traversal");
        check(list.search(20) == 4 && list.update(20, -20), "search and update");
        check(list.minimum().getAsInt() == -20 && list.maximum().getAsInt() == 30, "minimum and maximum");
        check(list.removeDuplicates() == 1, "duplicate removal");
        list.reverse();
        check(list.displayForward().equals("NULL <-> 30 <-> -20 <-> 15 <-> 10 <-> 5 <-> NULL"), "reverse links");
        list.sort();
        check(list.displayForward().equals("NULL <-> -20 <-> 5 <-> 10 <-> 15 <-> 30 <-> NULL"), "sort");
        check(list.deleteAt(1) && list.deleteBeginning() && list.deleteEnd() && !list.deleteValue(999), "deletions");
    }

    private static void check(boolean condition, String label) {
        if (!condition) throw new AssertionError("Failed: " + label);
    }
}
