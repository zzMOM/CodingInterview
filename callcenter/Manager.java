package callcenter;

public class Manager extends Employee{
	public Manager(String employeeID, String name, String jobTitle){
		super(employeeID, name, jobTitle);
		rank = Rank.Manager;
	}
}
