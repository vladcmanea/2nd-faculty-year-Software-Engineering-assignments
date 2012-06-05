/**
 * Company Class
 * - must be used at static level
 * 
 * @author Vlad Manea
 * @version 0.1
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Company Class 
 */
public class Company {
	
	/**
	 * Data 
	 */
	private static Manager manager;
	
	/**
	 * Constructor Method
	 */
	private Company() {}
	
	/** 
	 * Read Method
	 * @param file name of file to be read from in String format
	 * @throws IOException if I/O exception is raised
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see String
	 * @see IOException
	 * @see ClassNotFoundException
	 * @see InstantiationException
	 * @see IllegalAccessException
	 */
	public static void read(String file) throws IOException, ClassNotFoundException, 
			InstantiationException, IllegalAccessException {
		
		FileInputStream fis = new FileInputStream(file); // create file input stream
		ObjectInputStream in = new ObjectInputStream(fis); // create object input stream
		
		manager = (Manager)Factory.getInstance(Manager.class.getName()); // create instance
		manager.read(in); // read to manager
		
		fis.close(); // close input file
	}
	
	/**
	 * Write Method
	 * @param file name of file to be written to in String format
	 * @throws IOException if I/O exception is raised
	 * @see String
	 * @see IOException
	 */
	public static void write(String file) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(file); // create file input stream
		ObjectOutputStream out = new ObjectOutputStream(fos); // create object input stream
		if (manager != null) {
			manager.write(out); // write from manager
		}
		
		fos.close(); // close input file
	}
	
	/**
	 * Add Method
	 * @param mgr Manager Object to be named
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see ClassNotFoundException
	 * @see InstantiationException
	 * @see IllegalAccessException
	 */
	public static void add(Employee employee, int length, int elements[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		if (length < 0) {
			/* must add manager */
			
			manager = (Manager)Factory.getInstance(Manager.class.getName());
			manager.setName(employee.getName());
		} else { 
			/* must add in the manager's subs */
			if (manager != null) {
				/* manager exists */
				manager.add(employee, length, elements);
			}
		}
	}
	
	/**
	 * Remove Method
	 * @param length length of array in int format
	 * @param elements array of elements in int format
	 * @returns employee removed
	 */
	public static Employee remove(int length, int elements[]) {
		
		if (length < 0) {
			/* must delete manager */
			Employee removed = manager;
			manager = null;
			return removed;
		} else { 
			if (manager != null) {
				return manager.remove(length, elements);
			}
		}
		
		/* nothing to do */
		return null;
	}
}
