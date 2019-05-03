
import java.util.Arrays;
/**
 * Class represents implementation of array collection with associated methods 
 * @author Borna Majstorović
 *
 */

public class ArrayIndexedCollection extends Collection{

	/**
	 * Size of capacity for default constructor
	 */
	public static final int capacity = 16;
	/**
	 * Current size of collection.
	 */
	private int size;

	/**
	 * Object array in which elements are stored.
	 */
	private Object[] elements;

	/**
	 * Default constructor for ArrayIndexedCollection
	 */
	public ArrayIndexedCollection() {
		this(capacity);
	}

	/**
	 * Constructor for ArrayIndexedCollection
	 * @param initialCapacity this will be capacity of our array
	 */
	public ArrayIndexedCollection(int initialCapacity) {
		if(initialCapacity < 1) {
			throw new IllegalArgumentException("Capacity can't be smaller then 1");
		}
		this.size = 0;
		this.elements = new Object[initialCapacity];
	}


	/**
	 * Constructor for ArrayIndexedCollection
	 * @param collection collection from which we copy all elements
	 * 		  to our array
	 */
	public ArrayIndexedCollection(Collection collection) {
		this(collection,16);
	}

	/**
	 * Constructor for ArrayIndexedCollection
	 * @param initialCapacity this will be capacity of our array
	 * @param collection collection from which we want to copy all elements
	 * 		  to our array
	 * @throw NullPointerException, IllegalArgumentException
	 */
	public ArrayIndexedCollection(Collection collection, int initialCapacity) {
		if(collection == null) {
			throw new NullPointerException("Collection can't be null");
		}
		if(initialCapacity < 1) {
			throw new IllegalArgumentException("Capacity can't be less then 1");
		}

		if(initialCapacity < collection.size()) {
			size = collection.size();
			Object[] elements = new Object[size];
		}
		else {
			size = initialCapacity;
			Object[] elements = new Object[size];
		}

		addAll(collection);

	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public void add(Object value) {
		if(value == null) {
			throw new NullPointerException("Value can't be null");
		}

		if(size == elements.length) {
			Object[] elementsNew = new Object[elements.length*2];
			for(int i = 0; i < size; i++) {
				elementsNew[i] = elements[i];
			}
			elements = elementsNew;
		}
		elements[size] = value;
		size++;
	}

	/**
	 * Method is used for getting element at given index.
	 *
	 * @param index index at which element will be given
	 * @return element at given index
	 */
	public Object get(int index) {
		if(index<0 || index > (size-1)) {
			throw new IndexOutOfBoundsException("Index can't be less then 0, or greater of size-1 ");
		}
		Object temp = 0;

		for(int i = 0;i < size; i++) {
			if(i == index) {
				temp = elements[i];
			}
		}
		return  temp;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public void clear() {
		for(int j = 0; j<size; j++) {
			elements[j] = null;
			size=0;
		}
	}

	/**
	 * Method is used for inserting element at given position. 
	 * Element that was at given position is shifted forward
	 *
	 * @param value element that will be inserted
	 * @param position position at which element will be inserted
	 */
	public void insert(Object value, int position) {
		if(position < 0 || position > size) {
			throw new IndexOutOfBoundsException("Index can't be smaller then 0 or higher then size");
		}

		if(position == elements.length) {
			Object[] elementsNew = new Object[elements.length*2];
			for(int i = 0; i < size-1; i++) {
				elementsNew[i] = elements[i];
			}
			elements = elementsNew;
		}
		size++;
		for(int i = position+1; i < size; i++) {
			elements[i] = elements[i-1];
		}
		elements[position] = value;

	}

	/**
	 * Method  is used for finding index of element value
	 * @param value element of which index needs to be found
	 * @return index of object in array
	 */
	public int indexOf(Object value) {

		for(int index = 0; index < size; index++) {
			if(elements[index].equals(value)) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Method removes object form given index in array
	 * @param index index of which element will be removed
	 * @throw IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index can't be that");
		}

		for(int j = 0; j < size; j++) {
			if(j == index) {
				for(int k = j; k < size; k++) {
					elements[k] = elements[k+1];
				}
			}
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
		if(value == null) {
			return false;
		}

		for(int j = 0; j < size(); j++) {
			if(value.equals(elements[j])) {

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
		if(contains(value)) {
			int index = indexOf(value);
			for(int i = index; i < size; i++) {
				elements[i] = elements[i+1];
			}
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public Object[] toArray() {
		Object[] array = Arrays.copyOf(elements, size);
		return array;

	}
	/**
	 * Check Collection documentation of this method
	 */
	@Override
	public void forEach(Processor processor) {
		for(int j=0; j<size; j++) {
			processor.process(elements[j]);
		}
	}
}
