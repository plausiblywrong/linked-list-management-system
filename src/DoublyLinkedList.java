import java.util.OptionalInt;

/** A doubly linked list with head and tail references; positions are one-based. */
public final class DoublyLinkedList {
    private static final class Node { int data; Node prev, next; Node(int data) { this.data = data; } }
    private Node head, tail;
    private int size;
    public void insertBeginning(int value) { Node n = new Node(value); n.next = head; if (head != null) head.prev = n; else tail = n; head = n; size++; }
    public void insertEnd(int value) { Node n = new Node(value); n.prev = tail; if (tail != null) tail.next = n; else head = n; tail = n; size++; }
    public boolean insertAt(int position, int value) { if (position < 1 || position > size + 1) return false; if (position == 1) { insertBeginning(value); return true; } if (position == size + 1) { insertEnd(value); return true; } Node after = nodeAt(position), n = new Node(value); n.prev = after.prev; n.next = after; after.prev.next = n; after.prev = n; size++; return true; }
    public boolean insertAfter(int target, int value) { Node p = findNode(target); if (p == null) return false; Node n = new Node(value); n.prev = p; n.next = p.next; if (p.next != null) p.next.prev = n; else tail = n; p.next = n; size++; return true; }
    public boolean insertBefore(int target, int value) { Node p = findNode(target); if (p == null) return false; if (p == head) { insertBeginning(value); return true; } Node n = new Node(value); n.prev = p.prev; n.next = p; p.prev.next = n; p.prev = n; size++; return true; }
    public boolean deleteBeginning() { if (head == null) return false; head = head.next; if (head != null) head.prev = null; else tail = null; size--; return true; }
    public boolean deleteEnd() { if (tail == null) return false; tail = tail.prev; if (tail != null) tail.next = null; else head = null; size--; return true; }
    public boolean deleteAt(int position) { Node p = nodeAt(position); if (p == null) return false; if (p == head) return deleteBeginning(); if (p == tail) return deleteEnd(); p.prev.next = p.next; p.next.prev = p.prev; size--; return true; }
    public boolean deleteValue(int value) { Node p = findNode(value); if (p == null) return false; return deleteAt(search(value)); }
    public int search(int value) { int pos = 1; for (Node p = head; p != null; p = p.next, pos++) if (p.data == value) return pos; return -1; }
    public boolean update(int oldValue, int newValue) { Node p = findNode(oldValue); if (p == null) return false; p.data = newValue; return true; }
    public String displayForward() { return display(true); } public String displayBackward() { return display(false); }
    private String display(boolean forward) { if (head == null) return "NULL"; StringBuilder s = new StringBuilder("NULL <-> "); for (Node p = forward ? head : tail; p != null; p = forward ? p.next : p.prev) s.append(p.data).append(" <-> "); return s.append("NULL").toString(); }
    public int count() { return size; }
    public OptionalInt maximum() { if (head == null) return OptionalInt.empty(); int r = head.data; for (Node p = head.next; p != null; p = p.next) r = Math.max(r,p.data); return OptionalInt.of(r); }
    public OptionalInt minimum() { if (head == null) return OptionalInt.empty(); int r = head.data; for (Node p = head.next; p != null; p = p.next) r = Math.min(r,p.data); return OptionalInt.of(r); }
    public OptionalInt middle() { if (head == null) return OptionalInt.empty(); Node slow=head, fast=head; while(fast != null && fast.next != null) { slow=slow.next; fast=fast.next.next; } return OptionalInt.of(slow.data); }
    public void reverse() { for (Node p = head; p != null;) { Node next = p.next; p.next = p.prev; p.prev = next; p = next; } Node temp=head; head=tail; tail=temp; }
    public void sort() { if (head == null) return; for(Node end=null; end != head; end=end == null ? tail : end.prev) for(Node p=head; p.next != end; p=p.next) if(p.data > p.next.data) { int t=p.data; p.data=p.next.data; p.next.data=t; } }
    public int removeDuplicates() { int removed=0; for(Node outer=head; outer != null; outer=outer.next) for(Node p=outer.next; p != null;) { Node next=p.next; if(p.data == outer.data) { if(p == tail) tail=p.prev; p.prev.next=p.next; if(p.next != null) p.next.prev=p.prev; size--; removed++; } p=next; } return removed; }
    public boolean isEmpty() { return head == null; }
    private Node findNode(int value) { for(Node p=head;p!=null;p=p.next) if(p.data==value) return p; return null; }
    private Node nodeAt(int position) { if(position < 1 || position > size) return null; if(position <= size/2) { Node p=head; for(int i=1;i<position;i++)p=p.next; return p; } Node p=tail; for(int i=size;i>position;i--)p=p.prev; return p; }
}
