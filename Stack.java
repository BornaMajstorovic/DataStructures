

/**
 * Class represents implementation of stack,
 * thorough ArrayIndexedCollection with associated methods 
 * @author Borna Majstorović
 *
 */
public class Stack {
	/**
	 * Private variable of ArrayIndexedCollection
	 */
	private ArrayIndexedCollection adaptee;

	/**
	 * Constructor for ObjectStack
	 */
	public Stack() {
		adaptee = new ArrayIndexedCollection();
	}

	/**
	 * Checks if stack is empty
	 * @return true if is, false otherwise
	 */
	public boolean isEmpty() {
		return adaptee.isEmpty();
	}

	/**
	 * Checks numbers of elements in stack
	 * @return size of stack
	 */
	public int size() {
		return adaptee.size();
	}

	/**
	 * Method pushes object on top of stack
	 * @param value object to be pushed
	 * @throws nullpointerexception
	 */
	public void push(Object value) {
		if(value == null) {
			throw new NullPointerException("You can't push null value on stack");
		}
		adaptee.add(value);
	}

	/**
	 * Method pops object from top of a stack
	 * @return  element that's poped 
	 * @throws EmptyStackException
	 */
	public Object pop() throws EmptyStackException {
		int size = adaptee.size();
		if (size == 0) {
			throw new EmptyStackException("You can't remove object from empty stack");
		}
		Object elementPop = adaptee.get(size - 1);
		adaptee.remove(elementPop);
		return elementPop;
	}

	/**
	 * Method checks which element is on top of stack
	 * @return element on top
	 * @throws EmptyStackException
	 */
	public Object peek() throws EmptyStackException {
		int size = adaptee.size();
		if (size == 0) {
			throw new EmptyStackException("You can't remove object from empty stack");
		}
		return adaptee.get(size - 1);
	}

	/**
	 * Method deletes all elements from stack
	 */
	public void clear() {
		adaptee.clear();
	}

}
