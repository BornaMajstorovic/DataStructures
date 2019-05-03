
import java.util.Arrays;

/**
 * Class represents implementation of doubly linked list with associated methods 
 * @author Borna Majstorović
 *
 */
public class LinkedListIndexedCollection extends Collection {
	/**
	 * Current size of collection
	 */
	private int size;

	/**
	 * First node of collection
	 */
	private ListNode first;

	/**
	 * Last node of collection
	 */
	private ListNode last;

	/**
	 * Class that represents one node of our linked list
	 * @author Borna Majstorović
	 *
	 */
	private static class ListNode{
		ListNode previous;
		ListNode next;
		Object value;
	}

	/**
	 * Default constructor for LinkedListIndexedCollection
	 */
	public LinkedListIndexedCollection() {
	}

	/**
	 * Constructor for LinkedListIndexedCollection
	 * @param collection collection from which we copy all elements
	 * 		  to our list
	 */
	public LinkedListIndexedCollection(Collection collection) {
		addAll(collection);
	}

	/**
	 * Check Collection documentation of this method
	 * @throw NullPointerException
	 */
	@Override
	public void add(Object value) {
		if(value == null) {
			throw new NullPointerException("Value can't be null");
		}

		ListNode newNode = new ListNode();
		newNode.value = value;

		if(first == null) {
			first = last = newNode;
		} else {
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	/**
	 * Method is used for getting node at given index
	 *
	 * @param index index at which element will be given
	 * @return node at given index
	 * @throw IndexOutOfBoundsException
	 */
	public Object get(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index can't be less then 0 or greater then size-1");
		}

		ListNode node;

		if(index < size/2) {
			node = first;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}

		} 
		else {
			node = last;
			for(int i = size-1; i > index; i--) {
				node = node.previous;
			}
		}
		return node.value;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public void clear() {
		first = last = null;
		size = 0;
	}

	/**
	 * Method is used for inserting node at given position. 
	 * Node that was at given position is shifted forward
	 *
	 * @param value node that will be inserted
	 * @param position position at which node will be inserted
	 * @throw IndexOutOfBoundsException
	 */
	public void insert(Object value, int position) {
		if(position < 0 || position > size) {
			throw new IndexOutOfBoundsException("Position can't be less then 0 or greater then size-1");
		}

		if(size == 0 || position == size) {
			add(value);
		}

		ListNode newNode = new ListNode();
		newNode.value = value;

		if(position == 0) {
			newNode.next = first;
			first.previous = newNode;
			first = newNode;
		}
		else {
			ListNode forNode = first;

			for(int i = 0; i < position; i++) {
				forNode = forNode.next;
			}

			newNode.next = forNode;
			newNode.previous = forNode.previous;
			forNode.previous.next = newNode;
			forNode.previous = newNode;	
		}
		size++;
	}

	/**
	 * Method  is used for finding index of object value
	 * @param value element of which index needs to be found
	 * @return index of object in list
	 */
	public int indexOf(Object value) {
		ListNode node = first;
		int index = 0;

		while(node != null) {
			if(node.value.equals(value)) {
				return index;

			}
			node = node.next;
			index++;

		}
		return -1;
	}

	/**
	 * Method removes object form given index in list
	 * @param index index of which element will be removed
	 * @throw IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index cant be less then 0 or greater then size-1");
		}

		if(size == 1) {
			first = last = null;
		} else if(index == 0 && size != 0) {
			first = first.next;
			first.next.previous = first;
		} else if(index == size-1) {
			last = last.previous;
			last.previous.next = last;
			last.next = null; 
		} else {
			ListNode node = first;
			for(int i = 0; index < i; i++) {
				node = node.next;
			}

			node.previous = node.next;
			node.next.previous = node.previous;
		}
		size--;

	}


	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public boolean contains(Object value) {
		for(ListNode node = first; node != null; node=node.next) {
			if(node.value.equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public boolean remove(Object value) {
		int index = indexOf(value);
		if(index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		ListNode node = first;

		for(int i = 0; i < size; i++) {
			array[i] = node.value;
			node = node.next;
		}
		return array;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public void forEach(Processor processor) {
		for(ListNode node = first; node != null; node = node.next) {
			processor.process(node.value);
		}
	}
}
