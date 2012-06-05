/**
 * Factory Class
 * - must be used at static level
 * 
 * @author Vlad Manea
 * @version 0.1
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Factory Class 
 */
public class Factory {
	
	/**
	 * Data
	 */
	private static Set<String> types = new HashSet<String>();

	/**
	 * Constructor Method
	 */
	private Factory() {}
	
	/**
	 * Register Method 
	 * @param type type of Class to be registered in String format
	 * @see String
	 */
	public static void register(String type) {
		
		types.add(type); // add
	}
	
	/**
	 * Unregister Method
	 * @param type type of Class to be unregistered in String format
	 * @see String
	 */
	public static void unregister (String type) {
		
		types.remove(type); // remove
	}
	
	/**
	 * Instance Method
	 * @param type type of Class to be instanced in String format
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see String
	 * @see ClassNotFoundException
	 * @see InstantiationException
	 * @see IllegalAccessException
	 * @returns instance of type of Class, if possible; or null
	 */
	public static Employee getInstance(String type) throws ClassNotFoundException, 
			InstantiationException, IllegalAccessException {
		
		boolean b = types.contains(type); // type exists?
		if (b == true) {
			/* can be found */
			Class<Employee> forName = (Class<Employee>) Class.forName(type); // class object
			return (Employee)forName.newInstance(); // new instance of that class returned
		} else {
			/* cannot be found */
			return null; // nothing returned
		}
	}
	
	/**
	 * Write Method
	 */
	public static void write() {
		
		Iterator<String> it; // declare iterator
		for (it = types.iterator(); it.hasNext();) {
			/* for each type */
			Object element = it.next(); // go to next element
			System.out.println((String)element); // print current element
		}
	}
}
