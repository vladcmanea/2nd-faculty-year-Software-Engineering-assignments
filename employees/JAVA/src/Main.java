import java.io.IOException;

public class Main {

	/*
	 * Main Function
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

		Factory.register(Employee.class.getName());
		Factory.register(EmployeeBoss.class.getName());
		Factory.register(Manager.class.getName());
		Factory.register(GroupLeader.class.getName());
		Factory.register(TeamLeader.class.getName());
		Factory.register(EmployeeNormal.class.getName());
		Factory.register(Programmer.class.getName());
		Factory.register(Tester.class.getName());
		Factory.register(ProgrammerC.class.getName());
		Factory.register(ProgrammerJava.class.getName());
		Factory.register(TesterA.class.getName());
		Factory.register(TesterM.class.getName());
		
		Manager M = (Manager) Factory.getInstance(Manager.class.getName());
		M.setName("M Ma");

		GroupLeader G1 = (GroupLeader) Factory.getInstance(GroupLeader.class.getName());
		G1.setName("G1 Ga3");
		
		GroupLeader G2 = (GroupLeader) Factory.getInstance(GroupLeader.class.getName());
		G2.setName("G2 Ga4");
		
		TeamLeader T1 = (TeamLeader) Factory.getInstance(TeamLeader.class.getName());
		T1.setName("T1 Ta4");
		
		TeamLeader T2 = (TeamLeader) Factory.getInstance(TeamLeader.class.getName());
		T2.setName("T2 Ta5");
		
		TeamLeader T3 = (TeamLeader) Factory.getInstance(TeamLeader.class.getName());
		T3.setName("T3 Ta6");
		
		EmployeeNormal N1 = (EmployeeNormal) Factory.getInstance(EmployeeNormal.class.getName());
		N1.setName("N1 Na5");
		
		EmployeeNormal N2 = (EmployeeNormal) Factory.getInstance(EmployeeNormal.class.getName());
		N2.setName("N2 Na6");

		EmployeeNormal N3 = (EmployeeNormal) Factory.getInstance(EmployeeNormal.class.getName());
		N3.setName("N3 Na7");
		
		EmployeeNormal N4 = (EmployeeNormal) Factory.getInstance(EmployeeNormal.class.getName());
		N4.setName("N4 Na8");

		Tester N5 = (Tester) Factory.getInstance(Tester.class.getName());
		N5.setName("N5 Ta9");
		
		TesterA N6 = (TesterA) Factory.getInstance(TesterA.class.getName());
		N6.setName("N6 TAa10");
		
		TesterM N7 = (TesterM) Factory.getInstance(TesterM.class.getName());
		N7.setName("N7 TMa11");

		Programmer N8 = (Programmer) Factory.getInstance(Programmer.class.getName());
		N8.setName("N8 Ta9");
		
		ProgrammerJava N9 = (ProgrammerJava) Factory.getInstance(ProgrammerJava.class.getName());
		N9.setName("N9 TAa10");
		
		ProgrammerC N10 = (ProgrammerC) Factory.getInstance(ProgrammerC.class.getName());
		N10.setName("N10 TMa11");
		
		Company.read("in.txt");
		
//		int elementsM[] = {};
//		Company.add(M, -1, elementsM); // Add Manager
		
		int elementsG1[] = {};
		Company.add(G1, 0, elementsG1); // Add Group Leader
		
		int elementsG2[] = {};
		Company.add(G2, 0, elementsG2); // Add Group Leader
		
		int elementsT1[] = {0};
		Company.add(T1, 1, elementsT1); // Add Team Leader
		
		int elementsT2[] = {0};
		Company.add(T2, 1, elementsT2); // Add Team Leader
		
		int elementsT3[] = {1};
		Company.add(T3, 1, elementsT3); // Add Team Leader
		
		int elementsN1[] = {0, 0};
		Company.add(N1, 2, elementsN1); // Add Normal Employee
		
		int elementsN2[] = {0, 0};
		Company.add(N2, 2, elementsN2); // Add Normal Employee
		
		int elementsN3[] = {0, 0};
		Company.add(N3, 2, elementsN3); // Add Normal Employee
		
		int elementsN4[] = {0, 1};
		Company.add(N4, 2, elementsN4); // Add Normal Employee

		int elementsN5[] = {0, 1};
		Company.add(N5, 2, elementsN5); // Add Normal Employee

		int elementsN6[] = {0, 1};
		Company.add(N6, 2, elementsN6); // Add Normal Employee
		
		int elementsN7[] = {0, 1};
		Company.add(N7, 2, elementsN7); // Add Normal Employee

		int elementsN8[] = {1, 0};
		Company.add(N8, 2, elementsN8); // Add Normal Employee
		
		int elementsN9[] = {0, 1};
		Company.add(N9, 2, elementsN9); // Add Normal Employee
		
		int elementsN8R[] = {0, 1, 4};
		Company.remove(3, elementsN8R); // Remove Normal Employee

		int elementsN10[] = {1, 0};
		Company.add(N10, 2, elementsN10); // Add Normal Employee
		
		Company.write("out.txt");
	}
}
