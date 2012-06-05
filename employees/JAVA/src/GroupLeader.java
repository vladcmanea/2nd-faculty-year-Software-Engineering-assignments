import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Group Leader Class
 * - extends Employee
 * 
 * @author Vlad Manea
 * @version 0.1
 */

/**
 * Group Leader Class
 */
public class GroupLeader extends EmployeeBoss {
	
	/**
	 * Constructor Method
	 */
	public GroupLeader() {
		
		super(); // call parent
	}
	
	/**
	 * Read Method
	 * @param in stream to be read from in ObjectInputStream format
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
	public void read(ObjectInputStream in) throws FileNotFoundException, IOException, 
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		super.read(in, TeamLeader.class.getName()); // super
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
	public void write(ObjectOutputStream out) throws IOException, FileNotFoundException {

		if (this.getClass() == GroupLeader.class) {
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
		System.out.println("---Group Leader"); // group leader
		System.out.println(this.subs.size()); // size
	}
	
	/**
	 * Append Method
	 * @param employee employee to be added in Employee format
	 * @throws ClassNotFoundException if class name is not found
	 * @throws InstantiationException if instance is not created
	 * @throws IllegalAccessException if access to instance is denied
	 * @see IllegalAccessException
	 * @see InstantiationException
	 * @see ClassNotFoundException 
	 */
	public void append(Employee employee) throws ClassNotFoundException, 
			InstantiationException, IllegalAccessException {
		
		this.subs.add((TeamLeader)Factory.getInstance(employee.getClass().getName())); // add sub
		this.subs.get(this.subs.size() - 1).setName(employee.getName()); // set name
	}
}
