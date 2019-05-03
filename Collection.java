

/**
 * This class represents a collection, it is meant to be used as "abstract" class.
 * @author Borna Majstorović
 *
 */

public class Collection extends Processor{
	
	/**
	 * Default constructor
	 */

	protected Collection() {

	}
	
	/**
	 * Method checks if collection is empty.
	 * @return True if is empty, false if not.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 *  
	 * @return size of collection in int
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Method adds object in collection
	 * @param value object that will be added in collection
	 */
	public void add(Object value) {

	}
	
	/**
	 * Method checks if collection adds object
	 * @param value object for which we are checking if it is in a collection
	 * @return true if it is, false otherwise
	 */
	public boolean contains(Object value) {
		return false;
	}
	
	/**
	 * Method removes object from collection
	 * @param value object that is being removed
	 * @return true if it is removed, false otherwise
	 */
	public boolean remove(Object value) {
		return false;
	}

	/**
	 * Method converts collection to Object array
	 * @return array representation of that collection
	 * @throws unsupportedOperationException
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method calls Processor for each element of collection
	 * @param processor processor that will be called
	 */
	public void forEach(Processor processor) {

	}
	
	/**
	 * Method adds all elements from one collection to the other
	 * @param collection Collection whose elements will be added
	 */
	public void addAll(Collection other) {

		if(other != null) {
			
			/**
			 * Class represents processor which is used for adding values to new collection
			 * @author Borna Majstorović
			 *
			 */
			class LocalProcessor extends Processor{

				@Override
				public void process(Object value) {
					add(value);
				}
			}

			LocalProcessor processor = new LocalProcessor();
			other.forEach(processor);
		}
	}
	
	/**
	 * Method is used for clearing all elements from collection
	 */
	public void clear() {

	}


}
