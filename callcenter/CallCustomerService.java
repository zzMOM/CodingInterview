package callcenter;

public class CallCustomerService extends Thread{
	CallHandler callHandler;
	CallCustomerService(CallHandler callHandler){
		this.callHandler = callHandler;
	}
	
	public void Run(){
		//assume 20 calls coming in
		for(int i = 0; i < 20; i++){
			String phoneNumber = Integer.toString(1000000000 + (i + 12)*1234567);
			Caller caller = new Caller(phoneNumber);
			callHandler.dispatchCall(caller);
		}
	}
}
