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
	ArrayList<ArrayList<Call>> callQueues = new ArrayList<ArrayList<Call>>();
	ArrayList<ArrayList<Employee>> employeeLevels = new ArrayList<ArrayList<Employee>>();
	
	ArrayList<Employee> respondentList = new ArrayList<Employee>();
	ArrayList<Employee> managerList = new ArrayList<Employee>();
	ArrayList<Employee> directorList = new ArrayList<Employee>();
	ArrayList<Call> respondentCallList = new ArrayList<Call>();
	ArrayList<Call> managerCallList = new ArrayList<Call>();
	ArrayList<Call> directorCallList = new ArrayList<Call>();
	
	protected CallHandler(){}
	
	public void getEmloyeeLevelList(ArrayList<Employee> e){
		for(int i = 0; i < e.size(); i++){
			if(e.get(i).getRank().getValue() == 0){
				respondentList.add(e.get(i));
				//employeeLevels.get(0).add(e.get(i));
			} else if(e.get(i).getRank().getValue() == 1){
				managerList.add(e.get(i));
				//employeeLevels.get(1).add(e.get(i));
			} else if(e.get(i).getRank().getValue() == 2){
				directorList.add(e.get(i));
				//employeeLevels.get(3).add(e.get(i));
			}
		}
		employeeLevels.add(respondentList);
		employeeLevels.add(managerList);
		employeeLevels.add(directorList);
	}
	
	/*Get instance of singleton class*/
	public static CallHandler getInstance(){
		if(instance == null){
			instance = new CallHandler();
		}
		return instance;
	}
	
	/*Get the first employee who can handle this call*/
	public Employee getHandlerForCall(Call call){
		Employee emp = null;
		Rank r;
		r = call.getRank();
		if(r.getValue() == 0){
			emp = employeeLevels.get(0).get(0);
		} else if(r.getValue() == 1){
			emp = employeeLevels.get(1).get(0);
			if(emp == null){
				emp = employeeLevels.get(2).get(0);
			}
		} else if(r.getValue() == 2){
			emp = employeeLevels.get(2).get(0);
		}
		return emp;
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
			//move the current handler to the end of list, keep the available employee in the front of list
			employeeLevels.get(call.getRank().getValue()).add(emp);
			employeeLevels.get(call.getRank().getValue()).remove(0);
		} else {
			//place the call into call queue according to its rank
			call.reply("Please wait for free employee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	
	/*An employee got free. Look for a waiting call that employee can serve
	 * Return true if assigned a call, false otherwise
	 */
	public boolean assignCall(Employee emp){ 
		return (!emp.isFree());
	}
}
