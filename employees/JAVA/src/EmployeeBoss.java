import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class EmployeeBoss extends Employee {

	/**
	 * Data
	 */
	protected List<Employee> subs = new ArrayList<Employee>();
	
	/**
	 * Constructor Method
	 */
	public EmployeeBoss() {
		
		super(); // call parent
	}
	
	/**
	 * Read Method
	 * @param in stream to be read from in ObjectInputStream format
	 * @param type type of sub in String format
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
	public void read(ObjectInputStream in, String type) throws FileNotFoundException, 
			IOException, ClassNotFoundException, InstantiationException, 
			IllegalAccessException {
		
		super.read(in); // super
		Integer length = (Integer)in.readObject(); // set length
		for (Integer i = 0; i < length; ++i) {
			/* iterate subs */
			this.subs.add(Factory.getInstance(type)); // add sub
			this.subs.get(i).read(in); // read sub
		}
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

		if (this.getClass() == EmployeeBoss.class) {
			/* it is an object with the same type */
			this.print(); // to output
		}
		
		super.write(out); // super
		out.writeObject((Integer)this.subs.size()); // write size
		for (Integer i = 0; i < this.subs.size(); ++i) {
			/* iterate subs */
			this.subs.get(i).write(out); // write sub
		}
		out.flush(); // flush
	}
	
	/**
	 * Print Method
	 */
	public void print() {
		
		super.print(); // to output
		System.out.println("--Employee Boss"); // team leader
	}
	
	/**
	 * Add Method
	 * <p>
	 * Parameter length must be length of parameter elements. In the elements must be put
	 * in order the path to the element to be removed, that is the index (started by 0) of
	 * the sub in the element.
	 * <p>
	 * For instance, if you send length = 3 and elements = {1,0,3}
	 * employee will be added to the 4th son of the 1st son of the 2nd son 
	 * of the Manager, if the Manager exists.
	 * <p>
	 * If length = 0, employee will be added to the current element.
	 *  
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
		
		if (length <= 0) {
			/* must add employee here */
			this.append(employee);
			//this.subs.add(Factory.getInstance(employee.getClass().getName())); // add sub
			//this.subs.get(this.subs.size() - 1).setName(employee.getName()); // set name
		} else { 
			/* must add in one of the sons */
			if ((length <= elements.length) && 
					(this.subs.size() > elements[elements.length - length])) {
				/* there exists such an element */
				this.subs.get(elements[elements.length - length]).add(employee, 
						length - 1, elements); // add recursively
			}
		}
	}
	
	/**
	 * Append Method
	 * <p>
	 * Appends employee to the current element.
	 * 
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
		
		this.subs.add(Factory.getInstance(employee.getClass().getName())); // add sub
		this.subs.get(this.subs.size() - 1).setName(employee.getName()); // set name
	}
	
	/**
	 * Remove Method
	 * <p>
	 * Parameter length must be length of parameter elements. In the elements must be put
	 * in order the path to the element to be removed, that is the index (started by 0) of
	 * the sub in the element.
	 * <p>
	 * For instance, if you send length = 3 and elements = {1,0,3}, the 4th son of the 1st son 
	 * of the 2nd son of the Manager will be removed, if Manager exists. 
	 * <p>
	 * If length = 1, the son of index elements[0] will be removed.
	 * 
	 * @param length length of array in int format
	 * @param elements array of elements in int format
	 * @return employee removed in Employee format
	 */
	public Employee remove(int length, int elements[]) {
		
		if (length == 1) {
			/* must delete one of the sons */
			if ((elements.length >= length) && 
					(this.subs.size() >= elements[elements.length - length])) {
				/* can delete that element */
				Employee removed = this.subs.get(elements.length - length);
				this.subs.remove(elements[elements.length - length]); // remove
				return removed;
			}
		} else if (length > 1) { 
			/* must remove from one of the sons */
			if ((elements.length >= length) && 
					(this.subs.size() > elements[elements.length - length])) {
				/* there exists such an element */
				return this.subs.get(elements[elements.length - length]).remove(length - 1, 
						elements); // add to sub
			}
		}
		
		/* nothing to be removed */
		return null;
	}
}
