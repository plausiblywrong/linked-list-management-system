import java.util.OptionalInt;

/** A linked list implemented from nodes; positions are one-based. */
public final class SinglyLinkedList {
    private static final class Node { int data; Node next; Node(int data) { this.data = data; } }
    private Node head;
    private int size;

    public void insertBeginning(int value) { Node n = new Node(value); n.next = head; head = n; size++; }
    public void insertEnd(int value) { Node n = new Node(value); if (head == null) { head = n; } else { Node p = head; while (p.next != null) p = p.next; p.next = n; } size++; }
    public boolean insertAt(int position, int value) { if (position < 1 || position > size + 1) return false; if (position == 1) { insertBeginning(value); return true; } Node p = head; for (int i = 1; i < position - 1; i++) p = p.next; Node n = new Node(value); n.next = p.next; p.next = n; size++; return true; }
    public boolean insertAfter(int target, int value) { Node p = findNode(target); if (p == null) return false; Node n = new Node(value); n.next = p.next; p.next = n; size++; return true; }
    public boolean insertBefore(int target, int value) { if (head == null) return false; if (head.data == target) { insertBeginning(value); return true; } Node p = head; while (p.next != null && p.next.data != target) p = p.next; if (p.next == null) return false; Node n = new Node(value); n.next = p.next; p.next = n; size++; return true; }
    public boolean deleteBeginning() { if (head == null) return false; head = head.next; size--; return true; }
    public boolean deleteEnd() { if (head == null) return false; if (head.next == null) return deleteBeginning(); Node p = head; while (p.next.next != null) p = p.next; p.next = null; size--; return true; }
    public boolean deleteAt(int position) { if (position < 1 || position > size) return false; if (position == 1) return deleteBeginning(); Node p = head; for (int i = 1; i < position - 1; i++) p = p.next; p.next = p.next.next; size--; return true; }
    public boolean deleteValue(int value) { if (head == null) return false; if (head.data == value) return deleteBeginning(); Node p = head; while (p.next != null && p.next.data != value) p = p.next; if (p.next == null) return false; p.next = p.next.next; size--; return true; }
    public int search(int value) { int pos = 1; for (Node p = head; p != null; p = p.next, pos++) if (p.data == value) return pos; return -1; }
    public boolean update(int oldValue, int newValue) { Node p = findNode(oldValue); if (p == null) return false; p.data = newValue; return true; }
    public String display() { if (head == null) return "NULL"; StringBuilder s = new StringBuilder(); for (Node p = head; p != null; p = p.next) s.append(p.data).append(" -> "); return s.append("NULL").toString(); }
    public int count() { return size; }
    public OptionalInt maximum() { if (head == null) return OptionalInt.empty(); int result = head.data; for (Node p = head.next; p != null; p = p.next) result = Math.max(result, p.data); return OptionalInt.of(result); }
    public OptionalInt minimum() { if (head == null) return OptionalInt.empty(); int result = head.data; for (Node p = head.next; p != null; p = p.next) result = Math.min(result, p.data); return OptionalInt.of(result); }
    /** For an even-sized list this returns the second middle element. */
    public OptionalInt middle() { if (head == null) return OptionalInt.empty(); Node slow = head, fast = head; while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; } return OptionalInt.of(slow.data); }
    public void reverse() { Node previous = null, current = head; while (current != null) { Node next = current.next; current.next = previous; previous = current; current = next; } head = previous; }
    public void sort() { if (head == null) return; for (Node end = null; end != head; end = lastBefore(end)) for (Node p = head; p.next != end; p = p.next) if (p.data > p.next.data) { int tmp = p.data; p.data = p.next.data; p.next.data = tmp; } }
    public int removeDuplicates() { int removed = 0; for (Node outer = head; outer != null; outer = outer.next) { Node p = outer; while (p.next != null) { if (p.next.data == outer.data) { p.next = p.next.next; size--; removed++; } else p = p.next; } } return removed; }
    public boolean isEmpty() { return head == null; }
    private Node findNode(int value) { for (Node p = head; p != null; p = p.next) if (p.data == value) return p; return null; }
    private Node lastBefore(Node end) { Node p = head; if (end == head) return head; while (p.next != end) p = p.next; return p; }
}
