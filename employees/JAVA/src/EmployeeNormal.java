/**
 * Normal Employee Class
 * - extends Employee
 * 
 * @author Vlad Manea
 * @version 0.1
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Normal Employee Class
 */
public class EmployeeNormal extends Employee {
	
	/**
	 * Constructor Method
	 */
	public EmployeeNormal() {
		
		super(); // call parent
	}
	
	/**
	 * Read Method
	 * @param in stream to be read from in ObjectInputStream format
	 * @throws FileNotFoundException if file is not found
	 * @throws IOException if I/O exception is raised
	 * @throws ClassNotFoundException if class name is not found
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @see ObjectInputStream
	 * @see FileNotFoundException
	 * @see IOException
	 * @see ClassNotFoundException
	 * @see IllegalAccessException
	 * @see InstantiationException
	 */
	public void read(ObjectInputStream in) throws FileNotFoundException,
			IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		super.read(in); // super
	}

	/**
	 * Write Method
	 * @param out stream to be written to in ObjectOutputStream format
	 * @throws IOException if I/O exception is raised
	 * @throws FileNotFoundException if file is not found
	 * @see ObjectOutputStream
	 * @see FileNotFoundException
	 * @see IOException
	 */
	public void write(ObjectOutputStream out) throws FileNotFoundException, IOException {
		
		if (this.getClass() == EmployeeNormal.class) {
			/* it is an object with the same type */
			this.print(); // to output
		}
		
		super.write(out); // super
		out.flush(); // flush
	}
	
	/**
	 * Print Method
	 */
	public void print() {
		
		super.print(); // to output
		System.out.println("--Employee Normal"); // team leader
	}
}
