package callcenter;

import java.util.Random;

public class CallCustomerService implements Runnable{
	CallHandler callHandler;
	Thread t;
	
	CallCustomerService(CallHandler callHandler){
		this.callHandler = callHandler;
		t = new Thread(this);
		t.start();
	}


	@Override
	public void run() {
		Random random = new Random();
		int x = random.nextInt(50);
		String phoneNumber = Integer.toString(1000000000 + x * 1234567);
		System.out.println(phoneNumber + " is calling!");
		Caller caller = new Caller(phoneNumber);
		callHandler.dispatchCall(caller);
		
	}


}
