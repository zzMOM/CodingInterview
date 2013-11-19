package callcenter;

import java.util.ArrayList;

public class MainTest {
	
	public static void main(String[] args) {
		/*
		 * create employee information list
		 * 10-Respondent, 4-Manager, 2-Director
		 */
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		for(int i = 0; i < 16; i++){
			int id = 10000 + i;
			int name = 65 + i;
			if(i < 10){
				Respondent e = new Respondent(Integer.toString(id), (String)(Character.toString((char)name)), "Respondent");
				employeeList.add(e);
			} else if (i < 14){
				Manager e = new Manager(Integer.toString(id), (String)(Character.toString((char)name)), "Manager");
				employeeList.add(e);
			} else {
				Director e = new Director(Integer.toString(id), (String)(Character.toString((char)name)), "Director");
				employeeList.add(e);
			}
		}
		
		//create callHandler
		CallHandler callHandler = new CallHandler();
		callHandler.getEmloyeeLevelList(employeeList);
		//multithreading call service, assume 20 calls
		for(int i = 0; i < 3; i++){
			new CallCustomerService(callHandler);
		}
		
	}	
}
