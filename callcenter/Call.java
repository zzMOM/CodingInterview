package callcenter;

public class Call {

	private Rank rank;
	
	//person who is calling
	private Caller caller;
	
	//employee who is handling the call
	private Employee handler;
	
	public Call(Caller c){
		rank = Rank.Respondent;
		this.caller = c;
	}
	
	//set employee who is handling the call
	public void setHandler(Employee e){
		handler = e;
	}
	
	public Employee getHandler(){
		return handler;
	}
	
	public Caller getCaller(){
		return caller;
	}
	
	//employee responsor get the caller name first 
	public void setCallerName(String name){
		caller.setCallerName(name);
	}
	
	public void reply(String message){}
	public void disconnect(){}
	public Rank getRank(){ return null; }
	public void setRank(Rank r){ rank = r; }
	public void increaseRank(){
		if(rank == Rank.Respondent){
			rank = Rank.Manager;
		} else if(rank == Rank.Manager){
			rank = Rank.Director;
		} else {
			rank = null;
		}
	}
}
