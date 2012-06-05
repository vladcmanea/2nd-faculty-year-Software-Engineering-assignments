import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Programmer C Class
 * - extends Programmer
 * 
 * @author Vlad Manea
 * @version 0.1
 */
public class ProgrammerC extends Programmer {

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
		
		if (this.getClass() == ProgrammerC.class) {
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
		System.out.println("----C/C++"); // type
	}
}
