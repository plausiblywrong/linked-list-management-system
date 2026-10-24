# Linked List Management System

## Objective

Build a menu-driven console application to practice linked-list data structures. The project implements both a singly linked list and a doubly linked list using custom `Node` classes and references - no array or Java collection is used as the underlying list.

## Language Used

Java (JDK 17 or newer)

## Features

Both lists support insert at beginning/end/position, insert before/after a value, delete from beginning/end/position/by value, search, update, count, minimum, maximum, middle, reverse, ascending bubble sort, and duplicate removal. The doubly linked list also displays in forward and backward directions.

Positions are one-based. Search, update, insert-before/after, and delete-by-value operate on the first matching value. For an even-length list, `middle` returns the second of the two middle values.

## Singly Linked List

Each node stores `data` and a `next` reference. The list supports forward traversal from `head` to `NULL`.

## Doubly Linked List

Each node stores `data`, `prev`, and `next` references. The list maintains both `head` and `tail`, so it can be displayed forward and backward.

## Operations

- Insert at beginning, end, or a one-based position
- Insert before or after the first matching value
- Delete from beginning, end, a position, or by value
- Search and update values
- Display, count, find minimum/maximum/middle
- Reverse, ascending bubble sort, and remove duplicates

## Project structure

```text
src/
  Main.java                 # Console menus and input validation
  SinglyLinkedList.java     # Node/reference implementation
  DoublyLinkedList.java     # Node/reference implementation
tests/
  LinkedListTests.java      # Edge-case regression tests
sample-output/
  output.txt
docs/
  project-report.pdf
```

## How to Run

Requirements: JDK 17 or newer.

```bash
javac -d out src/*.java
java -cp out Main
```

Run the automated tests:

```bash
javac -d out src/*.java tests/LinkedListTests.java
java -cp out LinkedListTests
```

## Complexity

| Operation | Typical time |
| --- | --- |
| Insert/delete at beginning | O(1) |
| Insert at end | O(n) singly, O(1) doubly (tail reference) |
| Search, display, min/max, count | O(n) |
| Reverse | O(n), O(1) extra space |
| Bubble sort / simple duplicate removal | O(n^2) |

## Edge Cases Tested

- Empty list operations
- One-node list insertion and deletion
- Insertion and deletion at position 1 and the last valid position
- Invalid and out-of-range positions
- Searching or deleting a value that is not present
- Duplicate, zero, and negative values
- Sorting and reversing empty or single-node lists

## Sample Output

A recorded console session is available in [`sample-output/output.txt`](sample-output/output.txt). It demonstrates insertion, display, sorting, and reversing.

## Project Report

An accompanying project report is available in [`docs/project-report.pdf`](docs/project-report.pdf). It describes the design, operations, complexity, testing, and execution steps.

## Author

Shahzaan Shabir Khan  
System ID: 2025278040  
Class: CSD  
Batch: Shikhar Batch 2029 - Batch 2
