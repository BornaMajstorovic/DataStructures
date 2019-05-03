

/**
 * Class takes input string from comand line and
 * breaks it in parts, puts numbers in stack
 * then pops two of them and does operation and put them back in stack.
 * @author Borna Majstorović
 *
 */
public class StackDemo {

	/**
	 * Main method, this method is called first at the start of program
	 * @param args takes 1 argument form command line eg "8 -2 / -1 *"
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Number of arguments needs to be 1");
			System.exit(1);
		}

		Stack stack = new Stack();
		String[] elements = args[0].split("\\s+");

		for (String element : elements) {
			try {
			
				if(isInt(element)) {
					int number;
					try {
						number = Integer.parseInt(element);
						stack.push(number);
					} 
					catch(NumberFormatException e) {
						System.err.println("Bad input");
					}
					continue;
				} else {

					int object1 = (int)stack.pop();
					int object2 = (int)stack.pop();

					switch(element) {

					case "+" :
						stack.push(object1 + object2);
						break;
					case "-" :
						stack.push(object1 - object2);
						break;
					case "/" :
						if(object1 == 0) {
							System.err.println("You can't divide by zero");
							System.exit(1);
						}
						stack.push(object2 / object1);
						break;
					case "*" :
						stack.push(object1 * object2);
						break;
					case "%" :
						stack.push(object2 % object1);
						break;
					default :
						System.err.println(element + " isn't opertion or number ");
						return;
					}
				}
			} catch(EmptyStackException e) {
				System.err.println("Stack is empty");
			}
		}

		if(stack.size() != 1) {
			System.err.println("Expression isn't good");
		} else {
			System.out.println("Expression evaluates to " + stack.pop());
		}
	}

	/**
	 * Method checks if parsed string is int
	 * @param string
	 * @return true or false
	 */
	public static boolean isInt(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} 
		catch(NumberFormatException e) {
		}
		return false;
	}
}





