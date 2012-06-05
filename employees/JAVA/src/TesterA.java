import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Tester Automatic Class
 * - extends Tester
 * 
 * @author Vlad Manea
 * @version 0.1
 */
public class TesterA extends Tester {

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
		
		if (this.getClass() == TesterA.class) {
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
		System.out.println("----Automatic"); // type
	}
}
