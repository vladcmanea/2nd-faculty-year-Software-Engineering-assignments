/**
 * Employee Class
 * - implements Serializable
 * 
 * @author Vlad Manea
 * @version 0.1
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Employee Class
 */
public class Employee implements Serializable {
	
	/**
	 * Data 
	 */
	private String name = "";	
	
	/**
	 * Constructor Method
	 */
	public Employee() {}
	
	/**
	 * Get Name Method
	 * @return name of Employee in String format
	 * @see String 
	 */
	public String getName() {
		
		String copyName = new String(name); // copy
		return copyName; // get
	}
	
	/**
	 * Set Name Method
	 * @param name name of this Employee to be set in String format
	 * @see String
	 */
	public void setName(String name) {
		
		this.name = new String(name); // set
	}
			
	/**
	 * Read Method
	 * @param in stream to be read from in ObjectInputStream format
	 * @param current type of current element in String format
	 * @param sub type of sub elements in String format
	 * @throws FileNotFoundException if file is not found
	 * @throws IOException if I/O exception is raised
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see ObjectInputStream
	 * @see FileNotFoundException
	 * @see IOException
	 * @see ClassNotFoundException
	 * @see InstantiationException
	 * @see IllegalAccessException
	 */
	public void read(ObjectInputStream in) throws FileNotFoundException, 
		IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String name = (String)in.readObject(); // read nane
		this.setName(name); // set name
	}
	
	/**
	 * Write Method
	 * @param out stream to be written to in ObjectOutputStream format
	 * @throws FileNotFoundException if file is not found
	 * @throws IOException if I/O exception is raised
	 * @see ObjectOutputStream
	 * @see FileNotFoundException
	 * @see IOException
	 */
	public void write(ObjectOutputStream out) throws FileNotFoundException, IOException {
		
		if (this.getClass() == Employee.class) {
			/* it is an object with the same type */
			this.print(); // to output
		}
		
		out.writeObject((String)this.getName()); // write name
		out.flush(); // flush
	}
	
	/**
	 * Print Method
	 */
	public void print() {
		
		System.out.println(this.getName()); // name
		System.out.println("-Employee"); // employee
	}
	
	/**
	 * Add Method
	 * @param employee employee to be added in Employee format
	 * @param length length of array in int format
	 * @param elements array of elements in int format
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see IllegalAccessException
	 * @see InstantiationException
	 * @see ClassNotFoundException 
	 */
	public void add(Employee employee, int length, int elements[]) throws 
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		// do nothing
	}
	
	/**
	 * Remove Method
	 * @param length length of array in int format
	 * @param elements array of elements in int format
	 */
	public Employee remove(int length, int elements[]) {
		
		return null; // null
	}	
}
