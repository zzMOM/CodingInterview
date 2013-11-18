package callcenter;

public enum Rank {
	Respondent(0), Manager(1), Director(2);

	private int rank;
	private Rank(int rank){
		this.rank = rank;
	}
	
	public int getRank(){
		return rank;
	}
	
	/*set rank, 1-3, 1 is the highest rank
	public int getRank(String employeeType){
		int rank = 0;
		if(employeeType.equals("respondent")){
			rank = 3;;
		} else if(employeeType.equals("manager")){
			rank = 2;
		} else if(employeeType.equals("director")){
			rank = 1;
		}
		return rank;
	}*/
}
