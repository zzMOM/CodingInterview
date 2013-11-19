package callcenter;

public class Director extends Employee{
	public Director(String employeeID, String name, String jobTitle){
		super(employeeID, name, jobTitle);
		rank = Rank.Director;
	}
}
