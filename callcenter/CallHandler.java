package callcenter;

import java.util.ArrayList;

public class CallHandler {
	private static CallHandler instance;
	
	/*3 levels of employees*/
	private final int LEVELS = 3;
	/*
	 * level 0 - respondent
	 * level 1 - manager
	 * level 2 - director
	 */
	
	/*Initialize 10 respondents, 4 manager, 2 director*/
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGER = 4;
	private final int NUM_DIRECTOR = 2;
	
	/*queues for each call's rank*/
	ArrayList<ArrayList<Call>> callQueues;
	ArrayList<ArrayList<Employee>> employeeLevels;
	
	protected CallHandler(){}
	
	/*Get instance of singleton class*/
	public static CallHandler getInstance(){
		if(instance == null){
			instance = new CallHandler();
		}
		return instance;
	}
	
	/*Get the first employee who can handle this call*/
	public Employee getHandlerForCall(Call call){
		return null;
	}
	
	/*Routes the call to an available employee, 
	 * or saves in a queue if no employee available.
	 */
	public void dispatchCall(Caller caller){
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	public void dispatchCall(Call call){
		//Try to route the call to an employee with the minimal rank*/
		Employee emp = getHandlerForCall(call);
		if(emp != null){
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			//place the call into call queue according to its rank
			call.reply("Please wait for free employee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	
	/*An employee got free. Look for a waiting call that employee can serve
	 * Return true if assigned a call, false otherwise
	 */
	public boolean assignCall(Employee emp){ return false; }
}
