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
		currentCall = call;
		Random r = new Random();
		int seconds = r.nextInt(100) * 1000;
		try {
		    Thread.sleep(seconds);
		    System.out.println(call.getCaller().getPhoneNumber() + " and " 
		    		+ call.getHandler().name + " title: " + call.getHandler().jobTitle + " conntected! ");
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		boolean isCompleted = isCallCompleted();
		if(isCompleted){
			System.out.println(call.getHandler().name + " title: " + call.getHandler().jobTitle + "solved the problems!");
		} else {
			System.out.println(call.getHandler().name + " title: " + call.getHandler().jobTitle + "can't solve the problems!");
			escalateAndReassign(call);
		}
	}
	
	/*the issue is resolved, finish the call*/
	private boolean isCallCompleted(){
		System.out.println("Solved or Not? Please enter 0 or 1, 0 - solved, 1 - not solved");
		Random r = new Random();
		int ans = r.nextInt(100) % 2;
		if(ans == 0){
			return true;
		} else {
			return false;
		}
	}
	
	/*The issue is not resolved. Escalate the call, and assign a new call to the employee*/
	public void escalateAndReassign(Call call){
		call.increaseRank();
		CallHandler ch = new CallHandler();
		ch.dispatchCall(call);
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
