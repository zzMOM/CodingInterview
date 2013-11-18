package callcenter;

public class Respondent extends Employee {
	public Respondent(String employeeID, String name, String jobTitle){
		super(employeeID, name, jobTitle);
		rank = Rank.Respondent;
	}
}
