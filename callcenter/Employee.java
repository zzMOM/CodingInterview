package callcenter;

public abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	
	//common info
	private String employeeID, name, jobTitle;
	public Employee(String employeeID, String name, String jobTitle){
		this.employeeID = employeeID;
		this.name = name;
		this.jobTitle = jobTitle;
	}
	
	public String getJobTitle(){
		return jobTitle;
	}
	
	public String getEmployeeID(){
		return employeeID;
	}
	
	public String getName(){
		return name;
	}
	
	
	/*start the conversation*/
	public void receiveCall(Call call){
		
	}
	
	/*the issue is resolved, finish the call*/
	public void callCompleted(){
		
	}
	
	/*The issue is not resolved. Escalate the call, and assign a new call to the employee*/
	public void escalateAndReassign(){
		
	}
	
	/*Assign a new call to an employee, if the employee is free*/
	public boolean isFree(){
		return (currentCall == null);
	}
	
	/*get rank*/
	public Rank getRank(){
		return rank;
	}
}
