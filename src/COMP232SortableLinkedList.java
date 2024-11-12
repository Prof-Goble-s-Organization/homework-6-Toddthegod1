/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	public void insertionSortList() {
		// Intentionally not implemented - see homework assignment.
		if (size <= 1) {
			return;
		}

		DLLNode<E> current = head.next.next;

		while (current != tail) {
			DLLNode next = current.next;
			DLLNode pos = current.prev;

			while (pos != head && ((Comparable<E>) pos.element).compareTo(current.element) > 0) {
				pos = pos.prev;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;

			current.next = pos.next;
			current.prev = pos;
			pos.next.prev = current;
			pos.next = current;

			current = next;
		}
	}
}
