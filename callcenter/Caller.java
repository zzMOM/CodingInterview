package callcenter;

public class Caller {
	private String phoneNumber, callerName;
	
	public Caller(String phoneNumber){
		this.phoneNumber = phoneNumber;
		this.callerName = null;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getCallerName(){
		return callerName;
	}
	
	public void setCallerName(String name){
		callerName = name;
	}
}
