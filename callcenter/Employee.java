package callcenter;

import java.util.Random;
import java.util.Scanner;

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
		
		Random r = new Random();
		int seconds = r.nextInt(50) * 100;
		try {
		    System.out.println(call.getCaller().getPhoneNumber() + " and " + call.getHandler().getName()
		    			+ " - " + call.getHandler().getJobTitle() + " conntected! ");
		    Thread.sleep(seconds);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	/*the issue is resolved, finish the call*/
	public boolean isCallCompleted(){
		//System.out.println("Solved or Not? Please enter 0 or 1, 0 - solved, 1 - not solved");
		//Random r = new Random();
		int ans = 1; //= r.nextInt(100) % 2;
		if(ans == 0){
			//complete set current employee free
			currentCall = null;
			return true;
		} else {
			return false;
		}
	}
	
	/*The issue is not resolved. Escalate the call, and assign a new call to the employee*/
	public void escalateAndReassign(Call call){
		call.increaseRank();
		//clear current handler for this call, and set current employee free
		currentCall = null;
		call.setHandler(null);
	}
	
	/*Assign a new call to an employee, if the employee is free*/
	public boolean isFree(){
		return (currentCall == null);
	}
	
	/*get rank*/
	public Rank getRank(){
		return rank;
	}
	
	public void setCurrentCall(Call call){
		currentCall = call;
	}
}
